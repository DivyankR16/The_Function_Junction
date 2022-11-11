package Database.TableView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Conference extends Event{
    private String seatingArrangement;
    private String wifiRequired;
    private static final Map<String,Integer> arrangeCost;
    static{
        arrangeCost=new HashMap<>();
        arrangeCost.put("UShape",100000);
        arrangeCost.put("HollowSquare",200000);
        arrangeCost.put("BoardroomStyle",300000);
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

    @Override
    double CalculateCost() {
        return 0;
    }
}
