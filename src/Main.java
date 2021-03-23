import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kaardipakk kaartidePakk = new Kaardipakk();
        Laud laud = new Laud();
        Käsi käsi = new Käsi();
        Vastane vastane = new Vastane();
        Scanner käekäik = new Scanner(System.in);

        kaartidePakk.kaartideTegemine();
        kaartidePakk.mänguAlustamine(käsi, vastane, kaartidePakk, laud);

        int i = 3;
        while(i < 3){
            String käik = JOptionPane.showInputDialog(null, "Sisesta midagi ", "Andmete sisestamine",
                    JOptionPane.QUESTION_MESSAGE);
            //String käik = käekäik.nextLine();
            if (käik.contains("võta")){
                käsi.võtaKaart(kaartidePakk);
            }
            if (käik.contains("käi")){
                String [] osadeks = käik.split(" ");
                String mast = osadeks[1];
                String number = osadeks[2];
                ArrayList<Kaart> kaardidKäes = käsi.getKäes();
                boolean õigeKaart = false;
                for (Kaart elem: kaardidKäes) {
                    if (elem.getMast().equals(mast) && elem.getNumber().equals(number)){
                        käsi.käiKaart(laud, elem);
                        õigeKaart = true;
                    }
                }
                if(!õigeKaart){
                    System.out.println("Sul ei ole sellist kaarti!");
                }
            }
            else {
                System.out.println("Rääkimine vaba tahe.");
            }
            i++;
        }

    }
}
