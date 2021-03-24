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

        int i = 0;
        while(i <= 3){
            Kaart laual = laud.getViimaneKaart();
            ArrayList<Kaart> kaardidKäes = käsi.getKäes();
            System.out.println(laual);
            System.out.println(kaardidKäes);

            System.out.println("Sisesta midagi: ");
            String käik = käekäik.nextLine();
            if (käik.contains("võta")){
                käsi.võtaKaart(kaartidePakk);
            }
            else if (käik.contains("käi")){
                String [] osadeks = käik.split(" ");
                String mast = osadeks[1];
                String number = osadeks[2];

                boolean õigeKaart = false;
                for (int j = 0; j < kaardidKäes.size(); j++) {
                    Kaart elem = kaardidKäes.get(j);
                    if (elem.getMast().equals(mast) && elem.getNumber().equals(number)){
                        käsi.käiKaart(laud, elem);
                        System.out.println(elem);
                        õigeKaart = true;
                    }
                }
                if(!õigeKaart){
                    System.out.println("Sul ei ole sellist kaarti!");
                }
            } else {
                System.out.println("Rääkimine vaba tahe.");
            }
            System.out.println("1");
            vastane.vastaseKäik(kaartidePakk, laud);
            i++;
        }



    }
}
