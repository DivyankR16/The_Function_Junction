package Database.TableView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Custom extends Event{
    private String customName;
    public Custom(){

    }
    public Custom(String seaArr){
        this.customName=seaArr;
    }
    public Custom(Date startDate, Date endDate, Venue venue, String bookingStatus, ArrayList<Menu> menus, String seaArr){
        super(startDate, endDate, venue, bookingStatus, menus);
        this.customName=seaArr;
    }

    @Override
    public double CalculateCost() {
        long gap=getEndDate().getTime()-getStartDate().getTime();
        double days= TimeUnit.DAYS.convert(gap, TimeUnit.MILLISECONDS)+1;
        return days*getVenue().getCost();
    }
}
