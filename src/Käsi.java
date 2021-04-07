import java.util.ArrayList;

public class Käsi {

    private ArrayList<Kaart> käes = new ArrayList<>(); //Kaardid, mis on kasutajal hetkel käes.

    public boolean võtaKaart(Kaardipakk kaardipakk){
        käes.add(kaardipakk.suvalineKaart()); //Võetakse suvaline kaart ja asetatakse kasutaja kätte.
        return true;

    }
    public void käiKaart(Laud laud, Kaart a){
        if (laud.saabKäia(a) == 1){
            System.out.println("Sina käisid: " + a);
            this.käes.remove(a); //Kui saab kaarti käia, siis eemaldatakse see kaart käest.
        }
        else if (laud.saabKäia(a) == 0){
            System.out.println("Vale käik"); //Kui ei saa käia, siis öeldaks "Vale käik".
        }
    }


    public boolean  vastaseKäik (Kaardipakk kaardipakk, Laud laud, boolean tõene, int pakiSuurus){
        Kaart viimane = laud.getViimaneKaart(); //Viimane lauale käidud kaart.
        //Kui vastasel on käes kaart, millel on sama mast või number kui laual oleval kaardil, siis ta käib selle laual.
        if (laud.getViimaneKaart().getNumber().equals("7")) {
            if (!(pakiSuurus == 0 || pakiSuurus > kaardipakk.getPakk().size())) { //kontroll et keegi pole peale 7 kaarti võtnud
                for (int i = 0; i < käes.size(); i++) {
                    if (käes.get(i).getNumber().equals("7")) {
                        System.out.println("Vastane: Väga head päeva! :)"); //kui vastasel on 7 siis ta käib selle
                        käiKaart(laud, käes.get(i));
                        return true;
                    }
                }
                System.out.println("Vastane: Aitäh!"); //kui vastasel pole 7 siis ta võtab kaardi
                võtaKaart(kaardipakk);
                return true;
            }

        }
        for (int i = 0; i < käes.size(); i++) {
            if (viimane.getMast().equals(käes.get(i).getMast()) || viimane.getNumber().equals(käes.get(i).getNumber())){
                if(käes.get(i).getNumber().equals("7")){
                    System.out.println("Vastane: Head päeva!"); //kui sobiva kaardi number on seitse siis vastane ütleb head päeva
                }
                if(!käes.get(i).getNumber().equals("äss")){
                    tõene = true;
                }
                String number = käes.get(i).getNumber();
                if (number.equals("emand") || number.equals("kuningas")){ //kuningapere õnnistamine
                    System.out.println("Vastane: " + number + " olgu õnnistatud!");
                }
                if(number.equals("10")){
                    System.out.println("Vastane: Õnnistagem elusloodust!!!");//looduse õnnistamine
                }
                käiKaart(laud, käes.get(i)); //Käib kaardi lauale
                return tõene;
            }
        }

        võtaKaart(kaardipakk);
        return true;

    }


    public Käsi(ArrayList<Kaart> käes) {
        this.käes = käes;
    }
    public Käsi() {
        this.käes = käes;
    }

    public ArrayList<Kaart> getKäes() {
        return käes;
    }

    @Override
    public String toString() {
        return "Sinu kaardid: " + käes;
    }
}
