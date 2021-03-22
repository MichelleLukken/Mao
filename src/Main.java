import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Kaardipakk kaartidePakk = new Kaardipakk();
        Laud laud = new Laud();
        Käsi käsi = new Käsi();
        Vastane vastane = new Vastane();

        kaartidePakk.kaartideTegemine();
        System.out.println(kaartidePakk);
        kaartidePakk.mänguAlustamine(käsi, vastane, kaartidePakk);
        System.out.println(käsi);
        System.out.println(vastane);
        System.out.println(kaartidePakk);

    }
}
