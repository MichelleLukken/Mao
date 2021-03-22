public class Kaart {
    private String mast;
    private String number;
    private int ID;


    @Override
    public String toString() {
        return "Kaart{" +
                "mast='" + mast + '\'' +
                ", number='" + number + '\'' +
                ", ID=" + ID +
                '}';
    }

    public Kaart(int ID){
        this.ID = ID;
    }

    public Kaart(String mast, String number, int ID) {
        this.mast = mast;
        this.number = number;
        this.ID = ID;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
