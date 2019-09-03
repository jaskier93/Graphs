package grahps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wartość współczynnika a");
        long a = scanner.nextLong();
        System.out.println("Podaj wartość współczynnika b");
        long b = scanner.nextLong();

        System.out.println("Podaj minamalną wartość X");
        long xMin = scanner.nextLong();
        long yMin = xMin * a + b;
        long xMax;
        do {
            System.out.println("Podaj maksymalną wartość X, pamiętaj, że musi być większe od x minimalnego!");
            xMax = scanner.nextLong();
        } while (xMax <= xMin);
        long yMax = xMax * a + b;
        stage.setTitle("Line Chart Sample");
        final NumberAxis xAxis = new NumberAxis(xMin, xMax, 1);
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setTickUnit(1);
        xAxis.setLabel("X Label");
        yAxis.setLabel("Y Label");
        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle("Line chart graph ");
        XYChart.Series series = new XYChart.Series();
        series.setName("Wzór Twojego równania to: y=" + a + "x+" + b);

        for (long i = xMin; i <= xMax; i++) {
            long y = a * i + b;
            series.getData().add(new XYChart.Data(i, y));
        }
        Scene scene = new Scene(lineChart, 600, 600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();


     /*   stage.setTitle("Parabola Sample");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Name of X Label");
        yAxis.setLabel("Name of Y Label");
        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle("Parabola");
        XYChart.Series series = new XYChart.Series();
        System.out.println("Podaj wartość współczynnika a");
        Long a = scanner.nextLong();
        System.out.println("Podaj wartość współczynnika b");
        Long b = scanner.nextLong();
        System.out.println("Podaj wartość współczynnika c");
        Long c = scanner.nextLong();
        System.out.println("Do jakiej wartości x chcesz narysować wykres?");
        Long x = scanner.nextLong();
        series.setName("Wzór Twojego równania to: y=" + a + "x^2+" + b + "x+" + c);
        for (int i = 0; i <= x; i++) {
            long y = a * i * i + b * i + c;
            series.getData().add(new XYChart.Data(i, y));
        }
        Scene scene = new Scene(lineChart, 600, 600);
        lineChart.getData().add(series);*/

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}