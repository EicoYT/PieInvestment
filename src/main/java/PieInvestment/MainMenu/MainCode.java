package PieInvestment.MainMenu;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class MainCode extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // Continue to the main menu
        MainMenuMethods.mainMenu();
    }

    public static void main(String[] args) {
        launch();
    }
}
