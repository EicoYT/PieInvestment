package org.example.ownbroker.mainmenu;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class MainCode extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainMenuMethods.mainMenu();
    }

    public static void main(String[] args) {
        launch();
    }
}
