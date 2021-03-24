import java.util.ArrayList;

public class Vastane extends Käsi{

    private ArrayList<Kaart> vastases = new ArrayList<>();

    public Vastane(ArrayList<Kaart> käes) {
        super(käes);
        this.vastases = vastases;
    }

    public Vastane() {
    }

    public boolean võtaKaart(Kaardipakk kaardipakk){
        vastases.add(kaardipakk.suvalineKaart());
        return true;
    }

    public void käiKaart(Laud laud, Kaart a){
        if (laud.saabKäia(a) == 1){
            this.vastases.remove(a);
        }
        else if (laud.saabKäia(a) == 0){
            System.out.println("vale käik");
        }
    }

    public void vastaseKäik (Kaardipakk kaardipakk, Laud laud){
        Kaart viimane = laud.getViimaneKaart();

        boolean poolean= false;
        for (int i = 0; i < vastases.size(); i++) {
            if (viimane.getMast().equals(vastases.get(i).getMast()) || viimane.getNumber().equals(vastases.get(i).getNumber())){
                käiKaart(laud, vastases.get(i));
                poolean = true;
                break;
            }
        }
        if(!poolean){
            võtaKaart(kaardipakk);
        }
    }

    @Override
    public String toString() {
        return "Vastane" + vastases;
    }
}
