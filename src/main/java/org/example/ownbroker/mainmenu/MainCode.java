package org.example.ownbroker.mainmenu;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class MainCode extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load profiles when the application starts
        MainMenuMethods.loadProfiles();

        // Continue to the main menu
        MainMenuMethods.mainMenu();
    }

    public static void main(String[] args) {
        launch();
    }
}
