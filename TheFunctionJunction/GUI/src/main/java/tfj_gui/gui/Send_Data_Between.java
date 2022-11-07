package tfj_gui.gui;

import Login.*;

public final class Send_Data_Between {
    private Customer customer;
    private Manager manager;
    private int check;
    private static final Send_Data_Between instance = new Send_Data_Between();
    private Send_Data_Between(){}

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public static Send_Data_Between getInstance(){
        return instance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
