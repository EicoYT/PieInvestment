package PieInvestment.CreatePies;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CreatePiesController {
    @FXML
    private VBox stockContainer;  // Container to hold dynamically added stocks

    private final List<TextField> stockNames = new ArrayList<>();
    private final List<Slider> stockSliders = new ArrayList<>();

    // Method to add a stock entry
    @FXML
    public void addStock() {
        TextField stockName = new TextField("Stock #" + (stockNames.size() + 1));
        Slider stockSlider = new Slider(0, 100, 10);
        stockSlider.setShowTickLabels(false);
        stockSlider.setShowTickMarks(false);
        Label sliderLabel = new Label("10%");
        stockSlider.valueProperty().addListener((obs, oldVal, newVal) -> sliderLabel.setText(newVal.intValue() + "%"));

        HBox stockRow = new HBox(10, stockName, stockSlider, sliderLabel);
        stockNames.add(stockName);
        stockSliders.add(stockSlider);

        stockContainer.getChildren().add(stockRow);  // Add the new row to the container
    }

    // Method to remove the last stock entry
    @FXML
    public void removeStock() {
        if (!stockNames.isEmpty()) {
            stockNames.remove(stockNames.size() - 1);
            stockSliders.remove(stockSliders.size() - 1);
            stockContainer.getChildren().remove(stockContainer.getChildren().size() - 1);  // Remove the last row
        }
    }

    // Method to display the pie chart
    @FXML
    public void showPieChart() {
        PieChart pieChart = new PieChart();

        for (int i = 0; i < stockNames.size(); i++) {
            String stock = stockNames.get(i).getText();
            double percentage = stockSliders.get(i).getValue();
            pieChart.getData().add(new PieChart.Data(stock, percentage));
        }

        Stage chartStage = new Stage();
        VBox chartLayout = new VBox(pieChart);
        Stage newStage = new Stage();
        newStage.setScene(new Scene(chartLayout, 400, 400));
        newStage.show();
    }

    // Go back to the main menu
    @FXML
    public void goBackToMainMenu() {
        try {
            // Load the main menu
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/investmentpiefxml/main_menu.fxml"));
            VBox mainMenuRoot = fxmlLoader.load();

            // Get the current stage (the window) and set the new scene
            Stage stage = (Stage) stockContainer.getScene().getWindow();  // Get the current stage
            Scene mainMenuScene = new Scene(mainMenuRoot);
            // Create the scene and apply CSS
            mainMenuScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm());
            stage.setScene(mainMenuScene);  // Set the new scene
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

