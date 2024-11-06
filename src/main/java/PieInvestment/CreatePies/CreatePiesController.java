package PieInvestment.CreatePies;

import PieInvestment.MainMenu.MainCode;
import PieInvestment.MainMenu.MainMenuMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

        VBox chartLayout = new VBox(pieChart);
        Stage newStage = new Stage();
        newStage.setScene(new Scene(chartLayout, 400, 400));
        newStage.show();
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

