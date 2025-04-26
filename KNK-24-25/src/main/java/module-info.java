module com.example.knk2425 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.xml.dom;
    requires java.sql;
    requires java.desktop;


    opens com.example.knk2425 to javafx.fxml;
    exports com.example.knk2425;

    opens java1 to javafx.fxml;
    opens java2 to javafx.fxml;
    opens java3 to javafx.fxml;
    opens java4 to javafx.fxml;
    opens java5 to javafx.fxml;
//    opens java6 to javafx.fxml;
    opens java8 to javafx.fxml;
    opens java9 to javafx.fxml;
    opens java10 to javafx.fxml;


    exports java1;
    exports java2;
    exports java3;
    exports java4;
    exports java5;
//    exports java6;
    exports java8;
    exports java9;
    exports java10;

    opens controllers to javafx.fxml;
    exports controllers;

}