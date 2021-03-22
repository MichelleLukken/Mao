import java.util.ArrayList;

public class Vastane extends Käsi{
    public Vastane(ArrayList<Kaart> käes) {
        super(käes);
    }

    public Vastane() {
    }

    @Override
    public String toString() {
        return "Vastane" + getKäes();
    }
}
