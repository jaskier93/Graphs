package grahps;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;


public class Main extends Application {
    private Scanner scanner = new Scanner(System.in);
    private LineChart lineChart = new LineChart();
    private Parabola parabola = new Parabola();


    @Override
    public void start(Stage stage) {
        System.out.printf("Wybierz rodzaj wykresu, który chcesz narysować: \n" +
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
        } while (choice != 1 || choice != 2);
    }


    public static void main(String[] args) {
        launch(args);
    }
}