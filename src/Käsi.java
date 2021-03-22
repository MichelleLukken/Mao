import java.util.ArrayList;

public class Käsi {

    private ArrayList<Kaart> käes = new ArrayList<>();

    public boolean võtaKaart(Kaardipakk kaardipakk){
        käes.add(kaardipakk.suvalineKaart());
        return true;

    }
    public void käiKaart(){

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
        return "Käsi" + käes;
    }
}
