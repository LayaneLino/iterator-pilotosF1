module org.pilotosf1iterator {
    requires javafx.controls;
    requires javafx.fxml;

    exports org.pilotosf1iterator;

    opens org.pilotosf1iterator.Controller to javafx.fxml;
    opens org.pilotosf1iterator.Model to javafx.base;

    opens org.pilotosf1iterator to javafx.fxml;

}