package org.example.ownbroker.mainmenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Objects;

public class MainMenuMethods {

    public TextField profileName;
    public TextField apiKeyField;

    public Label selectYourBroker;
    public Label selectInvestCFD;
    public Label welcomeText;

    // Main Menu where the user can decide to manage or create a new Profile
    @FXML
    protected static void mainMenu() throws IOException {
        // Load the select broker window
        FXMLLoader fxmlLoader = new FXMLLoader(MainCode.class.getResource("/org/example/ownbroker/main-menu.fxml"));
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
    protected void onReturnToMainMenuClick(ActionEvent event) throws IOException {
        // Load the main menu FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(MainCode.class.getResource("/org/example/ownbroker/main-menu.fxml"));
        Scene mainMenu = new Scene(fxmlLoader.load(), 800, 600);

        // Apply the same stylesheet
        mainMenu.getStylesheets().add(Objects.requireNonNull(MainMenuMethods.class.getResource("/css/style.css")).toExternalForm());

        // Get the current stage (reuse the existing stage, don't create a new one)
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene (main menu window) in the same stage
        currentStage.setScene(mainMenu);
        currentStage.setTitle("Main Menu");
    }

    // Opens the saved Profiles
    @FXML
    protected void onManageProfileClick(ActionEvent event) throws IOException {
        // Load the select broker window
        FXMLLoader fxmlLoader = new FXMLLoader(MainCode.class.getResource("/org/example/ownbroker/profile-manager.fxml"));
        Scene profileManager = new Scene(fxmlLoader.load(), 800, 600);

        // Apply the same stylesheet
        profileManager.getStylesheets().add(Objects.requireNonNull(MainMenuMethods.class.getResource("/css/style.css")).toExternalForm());

        // Get the current stage
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene (main menu window) in the same stage
        currentStage.setScene(profileManager);
        currentStage.setTitle("Profile Manager");
    }

    // Prompt the user to select their broker
    @FXML
    protected void onCreateProfileClick(ActionEvent event) throws IOException {
        // Load the select broker window
        FXMLLoader fxmlLoader = new FXMLLoader(MainCode.class.getResource("/org/example/ownbroker/select-broker.fxml"));
        Scene mainMenu = new Scene(fxmlLoader.load(), 800, 600);

        // Apply the same stylesheet
        mainMenu.getStylesheets().add(Objects.requireNonNull(MainMenuMethods.class.getResource("/css/style.css")).toExternalForm());

        // Get the current stage
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene (main menu window) in the same stage
        currentStage.setScene(mainMenu);
        currentStage.setTitle("Select your Broker");
    }

    // When the user chooses Trading212
    @FXML
    protected void onTrading212Click(ActionEvent event) throws IOException {
        // Load the Invest window
        FXMLLoader fxmlLoader = new FXMLLoader(MainCode.class.getResource("/org/example/ownbroker/select-cfd-invest.fxml"));
        Scene trading212 = new Scene(fxmlLoader.load(), 800, 600);

        // Apply the same stylesheet
        trading212.getStylesheets().add(Objects.requireNonNull(MainMenuMethods.class.getResource("/css/style.css")).toExternalForm());

        // Get the current stage
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene (main menu window) in the same stage
        currentStage.setScene(trading212);
        currentStage.setTitle("Select Invest or CFD");
    }

    // Handle the event when the "Invest" button is clicked
    @FXML
    protected void onInvestButtonClick(ActionEvent event) throws IOException {
        // Load the Invest window
        FXMLLoader fxmlLoader = new FXMLLoader(MainCode.class.getResource("/org/example/ownbroker/type-user-api-key.fxml"));
        Scene investScene = new Scene(fxmlLoader.load(), 800, 600);

        // Apply the same stylesheet
        investScene.getStylesheets().add(Objects.requireNonNull(MainMenuMethods.class.getResource("/css/style.css")).toExternalForm());

        // Get the current stage
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene (Invest window) in the same stage
        currentStage.setScene(investScene);
        currentStage.setTitle("Invest Window");
    }

    // Handle the API key submission
    @FXML
    protected void onSubmitApiClick(ActionEvent event) throws IOException {
        String apiKey = apiKeyField.getText();  // Get the API key from the text field
        if (apiKey != null && !apiKey.isEmpty()) {
            // Save the API key
            saveApiKey(apiKey);

            // Transition to the main menu or invest window after submission
            FXMLLoader fxmlLoader = new FXMLLoader(MainCode.class.getResource("/org/example/ownbroker/type-user-name.fxml"));
            Scene mainMenuScene = new Scene(fxmlLoader.load(), 800, 600);

            // Apply the same stylesheet
            mainMenuScene.getStylesheets().add(Objects.requireNonNull(MainMenuMethods.class.getResource("/css/style.css")).toExternalForm());

            // Get the current stage and set the new scene
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(mainMenuScene);
            currentStage.setTitle("Enter your API Key");
        } else {
            // Show some error or prompt the user to enter a valid API key
            System.out.println("Please enter a valid API key.");
        }
    }

    // Handle the ProfileName submission
    @FXML
    protected void onSubmitNameClick(ActionEvent event) throws IOException {
        String profileNameText = profileName.getText();  // Get the Profile Name from the text field
        if (profileNameText != null && !profileNameText.isEmpty()) {
            // Save the API key
            saveApiKey(profileNameText);

            // Transition to the main menu or invest window after submission
            FXMLLoader fxmlLoader = new FXMLLoader(MainCode.class.getResource("/org/example/ownbroker/invest-window.fxml"));
            Scene mainMenuScene = new Scene(fxmlLoader.load(), 800, 600);

            // Apply the same stylesheet
            mainMenuScene.getStylesheets().add(Objects.requireNonNull(MainMenuMethods.class.getResource("/css/style.css")).toExternalForm());

            // Get the current stage and set the new scene
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(mainMenuScene);
            currentStage.setTitle("Enter a Profile Name");
        } else {
            // Show some error or prompt the user to enter a valid API key
            System.out.println("Please enter a valid API key.");
        }
    }

    // Save the user's API key
    private void saveApiKey(String apiKey) {
        // Here you can store the API key, e.g., write it to a file, database, or keep it in memory
        System.out.println("API Key saved: " + apiKey);
        // For example, saving to a file could be implemented here
    }
}
