import java.util.ArrayList;

public class Käsi {

    private ArrayList<Kaart> käes = new ArrayList<>(); //Kaardid, mis on kasutajal hetkel käes.

    public boolean võtaKaart(Kaardipakk kaardipakk){
        käes.add(kaardipakk.suvalineKaart()); //Võetakse suvaline kaart ja asetatakse kasutaja kätte.
        return true;

    }
    public void käiKaart(Laud laud, Kaart a){
        if (laud.saabKäia(a) == 1){
            this.käes.remove(a); //Kui saab kaarti käia, siis eemaldatakse see kaart käest.
        }
        else if (laud.saabKäia(a) == 0){
            System.out.println("Vale käik"); //Kui ei saa käia, siis öeldaks "Vale käik".
        }
    }

    public void vastaseKäik (Kaardipakk kaardipakk, Laud laud){
        Kaart viimane = laud.getViimaneKaart(); //Viimane lauale käidud kaart.

        //Kui vastasel on käes kaart, millel on sama mast või number kui laual oleval kaardil, siis ta käib selle laual.
        boolean poolean= false;
        for (int i = 0; i < käes.size(); i++) {
            if (viimane.getMast().equals(käes.get(i).getMast()) || viimane.getNumber().equals(käes.get(i).getNumber())){
                käiKaart(laud, käes.get(i)); //Käib kaardi lauale
                poolean = true;
                break;
            }
        }
        if(!poolean){ //Kui tal sellist kaarti ei ole, siis ta võtab endale kaardi.
            võtaKaart(kaardipakk);
        }
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
