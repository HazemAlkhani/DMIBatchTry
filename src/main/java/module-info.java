module com.example.dmibatchtry {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dmibatchtry to javafx.fxml;
    exports com.example.dmibatchtry;
}