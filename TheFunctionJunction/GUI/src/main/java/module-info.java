module tfj_gui.gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens tfj_gui.gui to javafx.fxml;
    exports tfj_gui.gui;
}