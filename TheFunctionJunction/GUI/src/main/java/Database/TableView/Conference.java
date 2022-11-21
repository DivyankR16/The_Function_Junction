package Database.TableView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Conference extends Event{
    private String seatingArrangement;
    private String wifiRequired;
    private String Choice;
    private static final Map<String,Integer> arrangeCost;
    static{
        arrangeCost=new HashMap<>();
        arrangeCost.put("UShape",100);
        arrangeCost.put("HollowSquare",200);
        arrangeCost.put("BoardroomStyle",300);
    }
    public String getChoice() {
        return Choice;
    }

    public void setChoice(String choice) {
        Choice = choice;
    }
    public Conference(){

    }
    public Conference(String seaArr,String wifiReq){
        this.seatingArrangement=seaArr;
        this.wifiRequired=wifiReq;
    }
    public Conference(Date startDate, Date endDate, Venue venue, String bookingStatus, ArrayList<Menu> menus,String seaArr,String wifiReq){
        super(startDate, endDate, venue, bookingStatus, menus);
        this.seatingArrangement=seaArr;
        this.wifiRequired=wifiReq;
    }

    public String getSeatingArrangement() {
        return seatingArrangement;
    }

    public void setSeatingArrangement(String seatingArrangement) {
        this.seatingArrangement = seatingArrangement;
    }

    public String getWifiRequired() {
        return wifiRequired;
    }

    public void setWifiRequired(String wifiRequired) {
        this.wifiRequired = wifiRequired;
    }
    int seatingArrangementCost(String selectedType){
        return arrangeCost.get(selectedType);
    }
    int arrangeCostfun(){
        return arrangeCost.get(getChoice());
    }
    @Override
    public double CalculateCost() {
        long gap=getEndDate().getTime()-getStartDate().getTime();
        double days= TimeUnit.DAYS.convert(gap, TimeUnit.MILLISECONDS)+1;
        return this.arrangeCostfun()+days*getVenue().getCost();
    }
}
