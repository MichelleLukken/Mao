import java.util.ArrayList;

public class Laud {
    private Kaart viimaneKaart;
    private ArrayList<Kaart> kaardidLaual = new ArrayList<>();

    public void setViimaneKaart(Kaart viimaneKaart) {
        this.viimaneKaart = viimaneKaart;

    }


    public int saabKäia(Kaart a){ //mis kaarte saab järgmisena lauale käia

        String eelmine_mast = viimaneKaart.getMast();
        String eelmine_number = viimaneKaart.getNumber();
        if(a.getNumber() == eelmine_number || a.getMast() == eelmine_mast){
            kaardidLaual.add(a);
            setViimaneKaart(a);
            return 1; //laseme kaardi lauale käia
        }
        return  0;

    }
}
