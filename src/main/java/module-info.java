module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.advanceprograming.client to javafx.fxml;
    exports com.advanceprograming.client;
}