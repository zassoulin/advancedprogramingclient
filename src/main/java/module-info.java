module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.advanceprograming.client to javafx.fxml;
    exports com.advanceprograming.client;
    exports com.advanceprograming.client.controller;
    opens com.advanceprograming.client.controller to javafx.fxml;
}