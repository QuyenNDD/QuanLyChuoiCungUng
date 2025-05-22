module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires static lombok;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.dao;
    opens com.example.demo.dao to javafx.fxml;
}