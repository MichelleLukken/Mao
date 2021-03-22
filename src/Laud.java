import java.util.ArrayList;
import java.util.List;

public class Laud {

    private Kaardipakk käidudKaardid;

    public boolean mänguAlustamine(Kaardipakk kaardipakk){

        for (int i = 0, j = 51; i < 5; i++, j--) {
            int suvalineIndeks = (int) (Math.random()*j);
            ArrayList<Kaart> suvalineKaart = kaardipakk.getPakk(suvalineIndeks); //See väljastab kaardipaki
            System.out.println(suvalineIndeks);
            System.out.println(suvalineKaart);
            // add kaart kätte
            // eemalda kaart pakist?
            // jätab indeksid meelde, et need on pakist ära võetud
        }
        for (int i = 0, j = 46; i < 5; i++, j--) {
            int suvalineIndeks = (int) (Math.random()*j);
            ArrayList<Kaart> suvalineKaart = kaardipakk.getPakk(suvalineIndeks);
            System.out.println(suvalineIndeks);
            System.out.println(suvalineKaart);
            // add kaart vastasele
        }
        return true;
    }
}
