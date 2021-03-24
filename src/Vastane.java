import java.util.ArrayList;

public class Vastane extends Käsi{

    private ArrayList<Kaart> vastases = new ArrayList<>();

    public Vastane(ArrayList<Kaart> käes) {
        super(käes);
        this.vastases = vastases;
    }

    public Vastane() {
    }

    public void vastaseKäik (Kaardipakk kaardipakk, Laud laud){
        Kaart viimane = laud.getViimaneKaart();
        boolean poolean= false;
        for (int i = 0; i < vastases.size(); i++) {
            if (viimane.getMast().equals(vastases.get(i).getMast()) || viimane.getNumber().equals(vastases.get(i).getNumber())){
                käiKaart(laud, vastases.get(i));
                System.out.println(vastases.get(i));
                poolean = true;
            }
        }
        if(!poolean){
            võtaKaart(kaardipakk);
        }
    }

    @Override
    public String toString() {
        return "Vastane" + getKäes();
    }
}
