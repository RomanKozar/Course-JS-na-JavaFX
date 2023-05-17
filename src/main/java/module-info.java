module com.example.app {
    requires javafx.web;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires javafx.media;
    requires charm.glisten;
    requires java.desktop;


    opens com.example.app to javafx.fxml;
    exports com.example.app;
    exports com.example.app.BaseData;
    opens com.example.app.BaseData to javafx.fxml;
    exports com.example.app.animation;
    opens com.example.app.animation to javafx.fxml;


}