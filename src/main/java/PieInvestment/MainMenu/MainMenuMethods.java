package PieInvestment.MainMenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class MainMenuMethods {

    public Label welcomeText;

    // Main Menu where the user can decide to manage or create a new Profile
    @FXML
    protected static void mainMenu() throws IOException {

        // Load the select broker window
        FXMLLoader fxmlLoader = new FXMLLoader(MainCode.class.getResource("/fxmlFiles/main-menu.fxml"));
        Scene mainMenu = new Scene(fxmlLoader.load(), 800, 600);

        // Apply the same stylesheet
        mainMenu.getStylesheets().add(Objects.requireNonNull(MainMenuMethods.class.getResource("/css/style.css")).toExternalForm());

        // Set the new scene (main menu window) in the same stage
        Stage stage = new Stage();
        stage.setScene(mainMenu);
        stage.setTitle("Main Menu");
        stage.show();
    }

    // Back to the Main Menu
    @FXML
    protected void onProfileManagerClick(ActionEvent event) throws IOException {
        // Load the main menu FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(MainCode.class.getResource("/fxmlFiles/saved-pies-manager.fxml"));
        Scene mainMenu = new Scene(fxmlLoader.load(), 800, 600);

        // Apply the same stylesheet
        mainMenu.getStylesheets().add(Objects.requireNonNull(MainMenuMethods.class.getResource("/css/style.css")).toExternalForm());

        // Get the current stage (reuse the existing stage, don't create a new one)
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene (main menu window) in the same stage
        currentStage.setScene(mainMenu);
        currentStage.setTitle("Pie Manager");
    }

    // Create a new pie chart
    @FXML
    protected void onCreatePieChartClick(ActionEvent event) throws IOException {
        // Load the pie chart creator FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(MainCode.class.getResource("/fxmlFiles/pie-chart-creator.fxml"));
        Scene pieChartCreatorScene = new Scene(fxmlLoader.load(), 800, 600);

        // Apply the same stylesheet to the pie chart creator scene
        pieChartCreatorScene.getStylesheets().add(Objects.requireNonNull(MainMenuMethods.class.getResource("/css/style.css")).toExternalForm());

        // Get the current stage (reuse the existing stage, don't create a new one)
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene (pie chart creator window) in the same stage
        currentStage.setScene(pieChartCreatorScene);
        currentStage.setTitle("Pie Chart Creator");
    }


    // Back to the Main Menu
    @FXML
    protected void onReturnToMainMenuClick(ActionEvent event) throws IOException {
        // Load the main menu FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(MainCode.class.getResource("/fxmlFiles/main-menu.fxml"));
        Scene mainMenu = new Scene(fxmlLoader.load(), 800, 600);

        // Apply the same stylesheet
        mainMenu.getStylesheets().add(Objects.requireNonNull(MainMenuMethods.class.getResource("/css/style.css")).toExternalForm());

        // Get the current stage (reuse the existing stage, don't create a new one)
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene (main menu window) in the same stage
        currentStage.setScene(mainMenu);
        currentStage.setTitle("Main Menu");
    }
}
