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
    requires com.google.gson;
    requires org.json;


    opens fxmlFiles to javafx.fxml;
    exports PieInvestment.MainMenu;
    opens PieInvestment.MainMenu to javafx.fxml;

    exports PieInvestment.CreatePies;
    opens PieInvestment.CreatePies to javafx.fxml;
}