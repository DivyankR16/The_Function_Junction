package Database.TableView;

public class Lunch extends Menu
{
    private int NumberOfGuests;
    private final int [] PricePerPlate = {0,200,350,500};
    private final String LN1 = "Lunch1";
    private final String LN2 = "Lunch2";
    private final String LN3 = "Lunch3";
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
    public String getLN1() {
        return LN1;
    }
    public String getLN2() {
        return LN2;
    }
    public String getLN3() {
        return LN3;
    }
//    public Float CostOfLunch()
//    {
//        return (float)(this.NumberOfGuests*this.PricePerPlate[this.getMyChoice()]);
//    }
    @Override
    public float calculateCost() {
        return (float)(this.NumberOfGuests*this.PricePerPlate[this.getMyChoice()]);
    }
}
