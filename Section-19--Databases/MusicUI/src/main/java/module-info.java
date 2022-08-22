module com.example.musicui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.sample.model;
    opens com.sample to javafx.fxml;
    exports com.sample;
}
