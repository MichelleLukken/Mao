import java.util.ArrayList;

public class Laud {
    private Kaart viimaneKaart;  //Kaart, mis viimana lauale käidi.
    private ArrayList<Kaart> kaardidLaual = new ArrayList<>(); //Kaardid, mis on mõlema mängija poolt ära käidud.

    public Laud(Kaart viimaneKaart, ArrayList<Kaart> kaardidLaual) {
        this.viimaneKaart = viimaneKaart;
        this.kaardidLaual = kaardidLaual;
    }
    public Laud(){}

    public void setViimaneKaart(Kaart viimaneKaart) {
        this.viimaneKaart = viimaneKaart;
    }

    public Kaart getViimaneKaart() {
        return viimaneKaart;
    }

    public ArrayList<Kaart> getKaardidLaual() {
        return kaardidLaual;
    }

    public int saabKäia(Kaart a){ //Kontrollib, kas kaarti saab järgmisena lauale käia.

        String eelmine_mast = viimaneKaart.getMast();
        String eelmine_number = viimaneKaart.getNumber();
        if(a.getNumber() == eelmine_number || a.getMast() == eelmine_mast){
            kaardidLaual.add(a); //Lisame selle käidava kaardi ära käidud kaartide hulka.
            setViimaneKaart(a);
            return 1; //Laseme kaardi lauale käia
        }
        return  0;

    }
}
