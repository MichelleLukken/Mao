
public class Kaart {
    private String mast;  //Määrab kaardi masti
    private String number;  //Määrab kaardi numbri või 'tähe'.


    @Override
    public String toString() {
        return "Kaart{" +
                "mast='" + mast + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public Kaart(String mast, String number) {  //Konstruktor
        this.mast = mast;
        this.number = number;
    }

    //Get- ja set-meetodid
    public String getMast() {
        return mast;
    }

    public void setMast(String mast) {
        this.mast = mast;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
