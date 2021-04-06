
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kaardipakk kaartidePakk = new Kaardipakk();  //Loome kaardipaki.
        Laud laud = new Laud(); //Loome laua
        Käsi käsi = new Käsi(); //Loome käe/kasutaja
        Käsi vastane = new Käsi();  //Loome vastase
        Scanner käekäik = new Scanner(System.in);  //Kasutame scannerit kasutajaga suhtlemiseks.

        System.out.println("Tere tulemast mängima kaardimängu Mao.");
        System.out.println("Sinu ülesandeks on käia kaart, millel on sama mast või number kui laual oleval kaardil.");
        System.out.println("Võimalikud mastid on: ärtu, ruutu, risti ja poti.");
        System.out.println("Võimalikud numbrid on: äss, 2, 3, 4, 5, 6, 7, 8, 9, poiss, emand, kuningas.");
        System.out.println("Kui sul ei ole sobivat kaarti, siis kirjuta 'võtan'. ");
        System.out.println("Kui sul on sobiv kaart, siis kirjuta käsk kujul 'käin ärtu äss'.");
        System.out.println("Põnevat mängimist!");
        System.out.println("");

        kaartidePakk.kaartideTegemine();  //Lisame kaardid kaardipakki
        kaartidePakk.mänguAlustamine(käsi, vastane, kaartidePakk, laud); //Jagame kaardi mängijate vahel ära.

        int i = 0;
        boolean tõene = true;
        while (käsi.getKäes().size() > 0 && vastane.getKäes().size() > 0) {   //Mäng kestab kuni ühel mängijal saavad kaardid otsa.
            Kaart laual = laud.getViimaneKaart();
            ArrayList<Kaart> kaardidKäes = käsi.getKäes();
            ArrayList<Kaart> kaardidKäes2 = vastane.getKäes();
            System.out.println("Laual on " + laual);
            System.out.println("Sinu kaardid: " + kaardidKäes);
            System.out.println("Vastane" + kaardidKäes2);

            while (tõene) {
                System.out.println("Sisesta käik: ");
                String käik = käekäik.nextLine();  //Küsime kasutajalt, mida ta tahab järgmisena teha.

                //Mao reegli kontrollimine

                if (käik.contains("võta")) {
                    käsi.võtaKaart(kaartidePakk);  //Kui kasutajal sobivat kaarti ei ole, siis ta võtab kaardi.
                    tõene = false;
                } else if (käik.contains("ärtu") || käik.contains("ruutu") || käik.contains("risti") || käik.contains("poti")) {  //Kasutaja tahab kaarti käia.
                    String[] osadeks = käik.split(" ");
                    String mast = osadeks[0];
                    String number = osadeks[1];


                    boolean õigeKaart = false;
                    for (int j = 0; j < kaardidKäes.size(); j++) { //Kontrollitakse, kas kasutajal on seda kaarti, mida ta tahab käia.
                        Kaart elem = kaardidKäes.get(j);
                        if (elem.getMast().equals(mast) && elem.getNumber().equals(number)) {

                            //Siia lisareeglid

                            käsi.käiKaart(laud, elem); //Kui tal on selline kaart, siis käiakse see lauale.
                            System.out.println("Sina käisid: " + elem);
                            õigeKaart = true;
                            if (!number.equals("äss")) {
                                tõene = false;
                            }
                        }
                    }
                    if (!õigeKaart) { //Kui tal ei ole sellist kaarti, siis peab uuesti käsu sisestama.
                        System.out.println("Sul ei ole sellist kaarti!");
                    }


                } else {
                    System.out.println("Rääkimine vaba tahe.");
                }
            }

            System.out.println(" ");
            if (!tõene){
                tõene = vastane.vastaseKäik(kaartidePakk, laud, tõene); //Vastane teeb oma käigu.
            }
            if (vastane.getKäes().size() == 1) {
                System.out.println("Ettevaatust, vastasel on ainult 1 kaart!");
            }
            if (kaartidePakk.getPakk().size() < 3) {   // Kui pakk, millest kaarte võetakse, jääb liiga väikeseks, lisatakse sellele kaardid, mis on juba maha läinud.
                while (laud.getKaardidLaual().size() > 1) {
                    Kaart parajasti = laud.getKaardidLaual().get(0);
                    kaartidePakk.getPakk().add(parajasti);
                    laud.getKaardidLaual().remove(0);
                }   // kaartidePakki lisati kaardid
            }
            i++;
        }

        if (käsi.getKäes().size() == 0) {
            System.out.println("Sa oled võitja!");
        } else {
            System.out.println("Kahjuks võitis vastane, aga hea mäng!");
        }
    }
}
