import java.util.ArrayList;

public class Käsi {

    private ArrayList<Kaart> käes = new ArrayList<>();

    public boolean võtaKaart(Kaardipakk kaardipakk){
        käes.add(kaardipakk.suvalineKaart());
        return true;

    }
    public void käiKaart(Laud laud, Kaart a){
        if (laud.saabKäia(a) == 1){
            this.käes.remove(a);
        }
        else if (laud.saabKäia(a) == 0){
            System.out.println("vale käik");
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
        return "Käsi" + käes;
    }
}
