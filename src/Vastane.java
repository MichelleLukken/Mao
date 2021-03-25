import java.util.ArrayList;

public class Vastane extends Käsi{  //Vastane on klassi Käsi alamklass.

    private ArrayList<Kaart> vastases = new ArrayList<>(); //Siia kogutakse vastase käes olevaid kaarte.

    public Vastane(ArrayList<Kaart> käes) {
        super(käes);
        this.vastases = vastases;
    }

    public Vastane() {
    }

    public boolean võtaKaart(Kaardipakk kaardipakk){
        vastases.add(kaardipakk.suvalineKaart()); //Lisab suvalise kaardi vastase kätte.
        return true;
    }

    public void käiKaart(Laud laud, Kaart a){ //Kontrollib, kas saab kaarti käia või mitte.
        if (laud.saabKäia(a) == 1){
            this.vastases.remove(a);
        }
        else if (laud.saabKäia(a) == 0){
            System.out.println("vale käik");
        }
    }

    public void vastaseKäik (Kaardipakk kaardipakk, Laud laud){
        Kaart viimane = laud.getViimaneKaart(); //Viimane lauale käidud kaart.

        //Kui vastasel on käes kaart, millel on sama mast või number kui laual oleval kaardil, siis ta käib selle laual.
        boolean poolean= false;
        for (int i = 0; i < vastases.size(); i++) {
            if (viimane.getMast().equals(vastases.get(i).getMast()) || viimane.getNumber().equals(vastases.get(i).getNumber())){
                käiKaart(laud, vastases.get(i)); //Käib kaardi lauale
                poolean = true;
                break;
            }
        }
        if(!poolean){ //Kui tal sellist kaarti ei ole, siis ta võtab endale kaardi.
            võtaKaart(kaardipakk);
        }
    }

    @Override
    public String toString() {
        return "Vastase kaardid: " + vastases;
    }
}
