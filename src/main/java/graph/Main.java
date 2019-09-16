package graph;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class Main extends Application {

    private Controller controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sample.fxml"));
        //loader.setController(controller);
        //controller.drawChart();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        Scene scene = new Scene(root, 800, 700);
        stage.setResizable(false);
        stage.setScene(scene);

        Platform.runLater(() -> {
            controller.drawChart(stage);
        });


    }
}