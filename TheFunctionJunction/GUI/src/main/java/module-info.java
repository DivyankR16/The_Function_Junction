module tfj_gui.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens tfj_gui.gui to javafx.fxml;
    exports tfj_gui.gui;
    opens Database.TableView to javafx.base;
    exports Login;
}