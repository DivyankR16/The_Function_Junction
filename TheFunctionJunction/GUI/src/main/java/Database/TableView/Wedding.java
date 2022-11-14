package Database.TableView;

import java.sql.Date;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Wedding extends Event{
    private String decorationType;
    private String receptionRequired;
    private static final Map<String,Integer>TypeCost;
    static{
        TypeCost=new HashMap<>();
        TypeCost.put("Basic",1000);
        TypeCost.put("Premium",2000);
        TypeCost.put("Royal",3000);

    }

    public String getChoice() {
        return Choice;
    }

    public void setChoice(String choice) {
        Choice = choice;
    }

    private String Choice;

    public Wedding(){}
    public Wedding(String dtype,String recepreq){
        this.decorationType=dtype;
        this.receptionRequired=recepreq;
    }
    public Wedding(java.sql.Date startDate, Date endDate, Venue venue, String bookingStatus, ArrayList<Menu> menus,String dtype,String recepreq){
        super(startDate, endDate, venue, bookingStatus, menus);
        this.decorationType=dtype;
        this.receptionRequired=recepreq;
    }
    public String getDecorationType() {
        return decorationType;
    }

    public void setDecorationType(String decorationType) {
        this.decorationType = decorationType;
    }

    public String getReceptionRequired() {
        return receptionRequired;
    }

    public void setReceptionRequired(String receptionRequired) {
        this.receptionRequired = receptionRequired;
    }
   int typeCostfun(){
        return TypeCost.get(getChoice());
   }
    @Override
    double CalculateCost() {
        long gap=getEndDate().getTime()-getStartDate().getTime();
        double days= TimeUnit.DAYS.convert(gap, TimeUnit.MILLISECONDS);
        return days*getVenue().getCost()+typeCostfun();
    }
}
