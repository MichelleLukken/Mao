import java.util.ArrayList;
import java.util.List;

public class Kaardipakk {
    private ArrayList<Kaart> pakk = new ArrayList<>();


    public Kaardipakk() {
        this.pakk = pakk;
    }


    public void kaartideTegemine(){
        String[] mastid = {"ärtu", "ruutu", "risti", "poti"};
        String[] numbrid = {"äss", "2", "3", "4", "5", "6", "7", "8", "9", "10", "poiss", "emand", "kuninags"};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++){
                Kaart a = new Kaart(mastid[i], numbrid[j]);
                pakk.add(a);
            }
        }
    }

    public ArrayList<Kaart> getPakk(int i) {
        return pakk;
    }

    @Override
    public String toString() {
        return "Kaardipakk{" +
                "pakk=" + pakk +
                '}';
    }
    public Kaart suvalineKaart(){
        int a =  (int)Math.round(Math.random()* (pakk.size()-1));
        Kaart tagastatav = pakk.get(a);
        pakk.remove(a);
        return tagastatav;
    }

    public void mänguAlustamine(Käsi käsi, Vastane vastane, Kaardipakk kaardipakk, Laud laud){
        for (int i = 0, j = 51; i < 5; i++, j--) {
            käsi.võtaKaart(kaardipakk);
            vastane.võtaKaart(kaardipakk);
        }
        Kaart a = suvalineKaart();
        laud.setViimaneKaart(a);
    }

}
