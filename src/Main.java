import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Kaardipakk kaartidePakk = new Kaardipakk();
        kaartidePakk.kaartideTegemine();
        System.out.println(kaartidePakk);
        Käsi minuKäsi = new Käsi();
        Laud mänguLaud = new Laud();
        Kaart kaart = new Kaart();
        while(true) {
            minuKäsi.käiKaart(mänguLaud, kaart);
        }
        //System.out.println(Arrays.toString(new Kaardipakk[]{kaartidePakk}));
    }
}
