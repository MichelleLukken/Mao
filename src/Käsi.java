import java.util.ArrayList;

public class Käsi {

    private ArrayList<Kaart> käes;

    public boolean võtaKaart(Kaardipakk kaardipakk){
        kaardipakk.suvalineKaart();
        käes.add(kaardipakk.suvalineKaart());
        return true;

    }
    public void käiKaart(){

    }

    public Käsi(ArrayList<Kaart> käes) {
        this.käes = käes;
    }

    public ArrayList<Kaart> getKäes() {
        return käes;
    }
}
