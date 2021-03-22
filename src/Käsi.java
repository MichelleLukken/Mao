import java.util.ArrayList;

public class Käsi {

    private ArrayList<Kaart> käes;

    public boolean võtaKaart(Kaardipakk kaardipakk){
        kaardipakk.suvalineKaart();
        käes.add(kaardipakk.suvalineKaart());
        return true;

    }
    public void käiKaart(Laud laud, Kaart a){
        if (laud.saabKäia(a) == 1){
            käes.remove(new Kaart(a));
        }
        else if (laud.saabKäia(a) == 0){
            System.out.println("vale käik");
        }
    }
}
