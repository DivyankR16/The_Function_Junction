package Database.TableView;

public class Dinner extends Menu
{
    private int NumberOfGuests;
    private final int [] PricePerPlate = {0,100,150,250};
    private final String DIN1 = "Dinner1";
    private final String DIN2 = "Dinner2";
    private final String DIN3 = "Dinner3";
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

    public String getDIN1() {
        return DIN1;
    }

    public String getDIN2() {
        return DIN2;
    }

    public String getDIN3() {
        return DIN3;
    }

//    public Float CostOFDinner()
//    {
//        return (float)(this.NumberOfGuests*this.PricePerPlate[this.getMyChoice()]);
//    }
    @Override
    float calculateCost() {
        return (float)(this.NumberOfGuests*this.PricePerPlate[this.getMyChoice()]);
    }
}
