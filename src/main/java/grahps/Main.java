package grahps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Controller controller;

    @Override
    public void start(Stage stage) throws Exception {
 /*       System.out.printf("Wybierz rodzaj wykresu, który chcesz narysować: \n" +
                "1. Wykres liniowy.\n" +
                "2. Parabola.\n");
        int choice;
        do {
            choice = scanner.nextInt();
            if (choice == 1) {
                lineChart.lineChartGraph(stage);
            } else if (choice == 2) {
                parabola.parabolaGraph(stage);
            } else {
                System.out.printf("Wybierz wykres wpisując 1 lub 2.");
            }
        } while (choice != 1 || choice != 2);*/

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        stage.setScene(new Scene(root, 800, 800));
        controller.drawChart(stage);
    }


    public static void main(String[] args) {
        launch(args);
    }

}