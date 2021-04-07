
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kaardipakk kaartidePakk = new Kaardipakk();  //Loome kaardipaki.
        Laud laud = new Laud(); //Loome laua
        Käsi käsi = new Käsi(); //Loome käe/kasutaja
        Käsi vastane = new Käsi();  //Loome vastase
        Scanner käekäik = new Scanner(System.in);  //Kasutame scannerit kasutajaga suhtlemiseks.

        System.out.println("Tere tulemast mängima mängu Mao.");
        System.out.println("Natuke infot sisestamisest");
        System.out.println("Võimalikud mastid on: ärtu, ruutu, risti ja poti.");
        System.out.println("Võimalikud numbrid on: äss, 2, 3, 4, 5, 6, 7, 8, 9, poiss, emand, kuningas.");
        System.out.println("Kaardi võtmiseks kirjuta 'võtan'.");
        System.out.println("Kaartide käimine kirjuta kujul 'ärtu äss'.");
        System.out.println("Kui soovid midagi öelda kirjuta see samale reale peale käimist-võtmist");
        System.out.println("Reeglid:");
        System.out.println("Sellel mängul on ainult 1 reegel");
        System.out.println("Ma just ütlesin selle");
        System.out.println("");

        kaartidePakk.kaartideTegemine();  //Lisame kaardid kaardipakki
        kaartidePakk.mänguAlustamine(käsi, vastane, kaartidePakk, laud); //Jagame kaardi mängijate vahel ära.

        boolean tõene = true; //näitab kelle käigu kord, mängija käigu ajal tõene
        boolean eiKäi = false;
        int pakiSuurus = 0; //muutuja mis tuvastab kui peale 7 käimist on keegi kaardi üles võtnud
        while (käsi.getKäes().size() > 0 && vastane.getKäes().size() > 0) {   //Mäng kestab kuni ühel mängijal saavad kaardid otsa.
            Kaart laual = laud.getViimaneKaart();
            ArrayList<Kaart> kaardidKäes = käsi.getKäes();
            System.out.println("Vastasel on " + vastane.getKäes().size() + " kaarti");
            System.out.println("Laual on " + laual);
            System.out.println("Sinu kaardid: " + kaardidKäes);

            while (tõene) {

                String käik = käekäik.nextLine();  //Küsime kasutajalt, mida ta tahab järgmisena teha.

                if(käik.toLowerCase().replace(" ", "").contains("mao")){
                    if(käsi.getKäes().size() != 1){
                        System.out.println("Meie (+1kaarti) juhi (+1kaarti) nime (+1kaarti) suhuvõtmise (+1kaarti) eest (+1kaarti)!"); //Mao tohib öelda ainult oma viimast kaarti käies, vastasel juhul järgneb trahv
                        for (int j = 0; j < 5; j++) {
                            käsi.võtaKaart(kaartidePakk);
                        }
                    }
                }
                if(käik.contains("?")){ //küsimuste küsimist mängu kohta trahvitakse kaartidega
                    System.out.println("Küsimus mängu kohta. +1 kaart");
                    käsi.võtaKaart(kaartidePakk);
                }

                if ((käik.contains("ärtu") || käik.contains("ruutu") || käik.contains("risti") || käik.contains("poti"))&& käik.split(" ").length > 1) {  //Kasutaja tahab kaarti käia.
                    String[] osadeks = käik.split(" ");
                    String mast = osadeks[0]; //sõne esimene osa on mast
                    String number = osadeks[1]; //sõne teine osa on number


                    boolean õigeKaart = false;
                    for (int j = 0; j < kaardidKäes.size(); j++) { //Kontrollitakse, kas kasutajal on seda kaarti, mida ta tahab käia.
                        Kaart elem = kaardidKäes.get(j);
                        if (elem.getMast().equals(mast) && elem.getNumber().equals(number)) {

                            if(käsi.getKäes().size() == 1 && !käik.toLowerCase().replace(" ", "").contains("mao")){ //viimast kaarti käies peab ütlema mao
                                System.out.println("Ei nimetanud meie juhi nime!");
                                for (int k = 0; k < 2; k++) {
                                    käsi.võtaKaart(kaartidePakk);
                                }
                            }
                            if(laud.getViimaneKaart().getNumber().equals("7")){
                                if (!(pakiSuurus == 0 || pakiSuurus > Kaardipakk.getPakk().size())) {
                                    if (!number.equals("7")) { //kui 7 peale käiakse midagi muud (enne kui keegi pole kaarti võtnud) tuleb range karistus
                                        System.out.println("Vale käik. Ei öelnud aitäh. (+1kaart) Ei võtnud kaarti. (+1kaart) Kaart mille pidid võtma. (+1kaart)");
                                        for (int k = 0; k < 3; k++) { //saab 3 kaarti juurde
                                            käsi.võtaKaart(kaartidePakk);
                                        }
                                        pakiSuurus = 0; //edaspidi saab normaalselt käike teha
                                        eiKäi = true; //kaarti käia ei saa
                                    }
                                    if (number.equals("7")) {

                                        if (käik.contains("päeva") && (käik.contains("väga") || käik.contains("kõige"))) { // 7 peale saab 7 käia aga siis tuleb öelda "väga head päeva" vms
                                            continue;
                                        } else if (!(käik.contains("väga")  || käik.contains("kõige"))) {
                                            System.out.println("Ei soovinud VÄGA head päeva! +1 kaart");
                                            käsi.võtaKaart(kaartidePakk);
                                            pakiSuurus -= 1; //muutuja peab püsima kuni ise kaardi võtmiseni selline
                                        } else {
                                            System.out.println("Niimoodi ei soovita väga head päeva. +1 kaart");
                                            käsi.võtaKaart(kaartidePakk);
                                            pakiSuurus -= 1; //kuna antakse kaart siis peab ka pakisuurust vähendama
                                        }
                                    }
                                }
                            }
                            if(!eiKäi){ //filter mis ei lase läbi kui üritatakse 7 peale midagi mittesobivat käia
                                käsi.käiKaart(laud, elem); //Kui tal on selline kaart, siis käiakse see lauale.
                                //System.out.println("Sina käisid: " + elem);

                            }
                            eiKäi = false;
                            õigeKaart = true;
                            if (!number.equals("äss")) { //ässaga jääb vastane vahele ehk muutuja muudetakse mängija käigukorrale vastavaks
                                tõene = false;
                            }
                            if (käsi.getKäes().size()==0) { //käigukord ei jõua enam vastaseni
                                tõene = false;
                            }
                            if (number.equals("7")){
                                pakiSuurus = kaartidePakk.getPakk().size();
                                if (!käik.contains("päeva")) { //7 puhul on vaja head päeva soovida
                                    System.out.println("Ei öelnud head päeva!");
                                    käsi.võtaKaart(kaartidePakk);
                                    pakiSuurus-=1; //kuna pakist võetakse kaart väheneb ka muutuja 1 võrra
                                }

                            }
                            if (number.equals("emand") || number.equals("10") || number.equals("kuningas")) {//nende kaartide puhul peab asju õnnistama
                                if (käik.contains("nnista")) {
                                    continue;
                                }
                                else if (number.equals("10")){
                                    System.out.println("Ei õnnistanud elusloodust!"); //10= eluslooduse õnnistamine
                                    käsi.võtaKaart(kaartidePakk);
                                }
                                else {
                                    System.out.println("Ei öelnud '" + number + " olgu õnnistatud'. +1 kaart");
                                    käsi.võtaKaart(kaartidePakk);
                                }
                            }
                        }
                    }
                    if (!õigeKaart) { //Kui tal ei ole sellist kaarti, siis peab uuesti käsu sisestama.
                        System.out.println("Sul ei ole sellist kaarti!");
                        System.out.println("Sinu kaardid: " + kaardidKäes);
                    }

                } else if (käik.contains("võta")) {
                    if (laud.getViimaneKaart().getNumber().equals("7")) { //kui laual on 7 peab kaarti võttes ültema aitäh
                        if (!(pakiSuurus == 0 || pakiSuurus > Kaardipakk.getPakk().size())) { //kui keegi on seda juba teinud ja muutujad vastavalt muudetud või kaarte kaardipakis vähem siis aitähi ütlemist ei kontrollita
                            if (!käik.toLowerCase().contains("aitäh")) { //aitäh ükskõik mis suurtähestusega
                                System.out.println("Ei öelnud aitäh! +1 kaart");
                                käsi.võtaKaart(kaartidePakk);
                            }
                            pakiSuurus = 0; //peale kaardi võtmist võib 7 peale jälle ükskõik mida käia
                        }
                    }
                    käsi.võtaKaart(kaartidePakk);  //Kui kasutajal sobivat kaarti ei ole, siis ta võtab kaardi.
                    tõene = false;

                } else {
                    System.out.println("Rääkimine vaba tahe.");
                    System.out.println("Sinu kaardid: " + kaardidKäes);
                }
            }

            System.out.println(" ");
            if (!tõene){
                tõene = vastane.vastaseKäik(kaartidePakk, laud, tõene, pakiSuurus); //Vastane teeb oma käigu.
            }
            //if (vastane.getKäes().size() == 1) {
                //System.out.println("Ettevaatust, vastasel on ainult 1 kaart!");
            //}
            if (kaartidePakk.getPakk().size() < 3) {   // Kui pakk, millest kaarte võetakse, jääb liiga väikeseks, lisatakse sellele kaardid, mis on juba maha läinud.
                while (laud.getKaardidLaual().size() > 1) {
                    Kaart parajasti = laud.getKaardidLaual().get(0);
                    kaartidePakk.getPakk().add(parajasti);
                    laud.getKaardidLaual().remove(0);
                }   // kaartidePakki lisati kaardid
            }
        }

        if (käsi.getKäes().size() == 0) {
            System.out.println("Sa oled võitja!");
        } else {
            System.out.println("Vastane: Mao!");
            System.out.println("Kahjuks võitis vastane, aga hea mäng!");
        }
    }
}
