module org.example.ownbroker {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.json;
    requires com.google.gson;


    opens org.example.ownbroker to javafx.fxml;
    exports org.example.pieinvestment.mainmenu;
    opens org.example.pieinvestment.mainmenu to javafx.fxml;
}