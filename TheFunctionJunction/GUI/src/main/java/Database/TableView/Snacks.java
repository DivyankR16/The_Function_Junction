package Database.TableView;

public class Snacks extends Menu
{
    private int NumberOfGuests;
    private final int [] PricePerPlate = {0,100,150,250};
    private final String SNC1 = "Snacks1";
    private final String SNC2 = "Snacks2";
    private final String SNC3 = "Snacks3";
    private int myChoice;

    public int getMyChoice() {
        return myChoice;
    }

    public void setMyChoice(int myChoice) {
        this.myChoice = myChoice;
    }

    public int getNumberOfGuests() {
        return NumberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        NumberOfGuests = numberOfGuests;
    }

    public int[] getPricePerPlate() {
        return PricePerPlate;
    }

    public String getSNC1() {
        return SNC1;
    }

    public String getSNC2() {
        return SNC2;
    }

    public String getSNC3() {
        return SNC3;
    }

    public Float CostOfSnacks()
    {
        return (float)(this.NumberOfGuests*this.PricePerPlate[this.getMyChoice()]);
    }
}
