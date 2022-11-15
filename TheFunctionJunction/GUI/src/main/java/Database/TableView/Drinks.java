package Database.TableView;

public class Drinks extends Menu {
    private int NumberOfGuests;
    private final int [] PricePerPlate = {0,100,150,250,500};
    private int myChoice;

    public int getNumberOfGuests() {
        return NumberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        NumberOfGuests = numberOfGuests;
    }

    public int[] getPricePerPlate() {
        return PricePerPlate;
    }

    public int getMyChoice() {
        return myChoice;
    }

    public void setMyChoice(int myChoice) {
        this.myChoice = myChoice;
    }
    @Override
    public float calculateCost() {
        return (float)(this.NumberOfGuests*this.PricePerPlate[this.getMyChoice()]);
    }
}
