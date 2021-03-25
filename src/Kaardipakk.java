import java.util.ArrayList;

public class Kaardipakk {
    private ArrayList<Kaart> pakk = new ArrayList<>();  //Massiiv, kuhu hakkame koguma kõiki kaarte.


    public Kaardipakk() {
        this.pakk = pakk;
    } //konstruktor


    public void kaartideTegemine(){ //Meetod, millega luuakse 52 kaardiga kaardipakk
        String[] mastid = {"ärtu", "ruutu", "risti", "poti"};
        String[] numbrid = {"äss", "2", "3", "4", "5", "6", "7", "8", "9", "10", "poiss", "emand", "kuningas"};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++){
                Kaart a = new Kaart(mastid[i], numbrid[j]);
                pakk.add(a); //Kaart lisatakse kaardipakki.
            }
        }
    }

    public ArrayList<Kaart> getPakk() {
        return pakk;
    }

    @Override
    public String toString() {
        return "Kaardipakk : " + pakk;
    }
    public Kaart suvalineKaart(){ //Leiab kaardipakist suvalise kaardi.
        int a =  (int)Math.round(Math.random()* (pakk.size()-1));
        Kaart tagastatav = pakk.get(a);
        pakk.remove(a); //Eemaldab kaardi kaardipakist.
        return tagastatav; //Tagastab suvalise kaardi.
    }

    //Jagab mängijatele 5 kaarti ja paneb lauale ühe kaardi.
    public void mänguAlustamine(Käsi käsi, Vastane vastane, Kaardipakk kaardipakk, Laud laud){
        for (int i = 0, j = 51; i < 5; i++, j--) {
            käsi.võtaKaart(kaardipakk); //Käele 5 suvalist kaarti.
            vastane.võtaKaart(kaardipakk); //Vastasele 5 suvalist kaarti.
        }
        Kaart a = suvalineKaart();
        laud.setViimaneKaart(a); //Lauale panneks üks suvaline kaart.
    }

}

