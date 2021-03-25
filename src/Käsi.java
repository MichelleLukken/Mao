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
