public class Kaart {
    private String mast;
    private String number;


    @Override
    public String toString() {
        return "Kaart{" +
                "mast='" + mast + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public Kaart(String mast, String number) {
        this.mast = mast;
        this.number = number;
    }

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
