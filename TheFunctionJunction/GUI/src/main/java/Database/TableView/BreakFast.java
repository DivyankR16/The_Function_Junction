package Database.TableView;

public class BreakFast extends Menu
{
    private int NumberOfGuests;
    private final int [] PricePerPlate = {0,100,200,300};
    private final String BF1 = "Breakfast1";
    private final String BF2 = "Breakfast2";
    private final String BF3 = "Breakfast3";
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

    public String getBF1() {
        return BF1;
    }

    public String getBF2() {
        return BF2;
    }

    public String getBF3() {
        return BF3;
    }
    public float CostOfBreakFast()
    {
        return (float)(this.NumberOfGuests*this.PricePerPlate[this.getMyChoice()]);
    }
}
