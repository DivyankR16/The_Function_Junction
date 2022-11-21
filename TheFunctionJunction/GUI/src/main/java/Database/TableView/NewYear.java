package Database.TableView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class NewYear extends Event{
    private String Crackers;
    private String Unknown;
    private String Choice;

    public String getCrackers() {
        return Crackers;
    }

    public void setCrackers(String crackers) {
        Crackers = crackers;
    }

    public String getUnknown() {
        return Unknown;
    }

    public void setUnknown(String unknown) {
        Unknown = unknown;
    }

    private static final Map<String,Integer> CrackersCost;
    static{
        CrackersCost=new HashMap<>();
        CrackersCost.put("PtaNahi",100);
        CrackersCost.put("PtaNahi1",200);
        CrackersCost.put("PtaNahi2",300);
    }
    public String getChoice() {
        return Choice;
    }

    public void setChoice(String choice) {
        Choice = choice;
    }
    public NewYear(){

    }
    public NewYear(String seaArr, String wifiReq){
        this.Crackers=seaArr;
        this.Unknown=wifiReq;
    }
    public NewYear(Date startDate, Date endDate, Venue venue, String bookingStatus, ArrayList<Menu> menus, String seaArr, String wifiReq){
        super(startDate, endDate, venue, bookingStatus, menus);
        this.Crackers=seaArr;
        this.Unknown=wifiReq;
    }

    int CrackersCostfun(){
        return CrackersCost.get(getChoice());
    }
    @Override
    public double CalculateCost() {
        long gap=getEndDate().getTime()-getStartDate().getTime();
        double days= TimeUnit.DAYS.convert(gap, TimeUnit.MILLISECONDS)+1;
        return this.CrackersCostfun()+days*getVenue().getCost();
    }
}
