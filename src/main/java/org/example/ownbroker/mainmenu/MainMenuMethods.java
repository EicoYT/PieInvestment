package org.example.ownbroker.mainmenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.util.Duration;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;
import org.json.JSONObject;

public class MainMenuMethods {

    // LineChart for stock prices
    @FXML
    private LineChart<Number, Number> stockChart;

    // Series for holding chart data points
    private XYChart.Series<Number, Number> series;

    // Counter for the time axis in the chart
    private int time = 0;

    // Finnhub API key and stock symbol
    private final String apiKey = "cs7gj59r01qtqcar4900cs7gj59r01qtqcar490g";
    private final String stockSymbol = "NVDA";  // Replace with your desired stock

    // Initialize method that gets called automatically after the FXML is loaded
    public void initialize() {
        // Initialize the series for chart data
        series = new XYChart.Series<>();
        stockChart.getData().add(series); // Add the series to the chart

        // Timeline for continuously fetching stock data
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            fetchStockPrice();  // Fetch stock price every 5 seconds
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);  // Repeat indefinitely
        timeline.play();  // Start the timeline
    }

    // Fetch the stock price from Finnhub API
    private void fetchStockPrice() {
        // Start a new thread to fetch data asynchronously
        new Thread(() -> {
            try {
                // Finnhub API URL for stock quote
                String urlString = "https://finnhub.io/api/v1/quote?symbol=" + stockSymbol + "&token=" + apiKey;
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                // Read the response from the API
                Scanner scanner = new Scanner(url.openStream());
                StringBuilder inline = new StringBuilder();
                while (scanner.hasNext()) {
                    inline.append(scanner.nextLine());
                }
                scanner.close();

                // Parse the JSON response to get the current price
                JSONObject data = new JSONObject(inline.toString());
                double currentPrice = data.getDouble("c");  // "c" is the current price in the API response

                // Update the chart on the JavaFX Application Thread
                Platform.runLater(() -> updateChart(currentPrice));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    // Method to update the chart with new stock price data
    private void updateChart(double price) {
        // Add the new data point (time, price) to the series
        series.getData().add(new XYChart.Data<>(time++, price));

        // Keep the chart data size to the last 30 points
        if (series.getData().size() > 30) {
            series.getData().remove(0);
        }
    }

    // Load the Main Menu
    @FXML
    protected static void mainMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainCode.class.getResource("/org/example/ownbroker/main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        scene.getStylesheets().add(Objects.requireNonNull(MainMenuMethods.class.getResource("/css/style.css")).toExternalForm());
        Stage stage = new Stage();
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }

    // Handle the event when the "Invest" button is clicked
    @FXML
    protected void onInvestButtonClick(ActionEvent event) throws IOException {
        // Load the Invest window
        FXMLLoader fxmlLoader = new FXMLLoader(MainCode.class.getResource("/org/example/ownbroker/invest-window.fxml"));
        Scene investScene = new Scene(fxmlLoader.load(), 800, 600);

        // Apply the same stylesheet
        investScene.getStylesheets().add(Objects.requireNonNull(MainMenuMethods.class.getResource("/css/style.css")).toExternalForm());

        // Get the current stage
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene (Invest window) in the same stage
        currentStage.setScene(investScene);
        currentStage.setTitle("Invest Window");
    }
}
