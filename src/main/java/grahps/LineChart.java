package grahps;

import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.Scanner;

class LineChart {

    void lineChartGraph(Stage stage) {
        Scanner scanner = new Scanner(System.in);
        String title = "Line Chart Sample";
        System.out.println("Podaj wartość współczynnika a");
        BigDecimal a = scanner.nextBigDecimal();
        System.out.println("Podaj wartość współczynnika b");
        BigDecimal b = scanner.nextBigDecimal();

        System.out.println("Podaj minamalną wartość X");
        double xMin = scanner.nextDouble();
        double xMax;
        do {
            System.out.println("Podaj maksymalną wartość X, pamiętaj, że musi być większe od x minimalnego!");
            xMax = scanner.nextDouble();
        } while (xMax <= xMin);
        stage.setTitle(title);
        final NumberAxis xAxis = new NumberAxis(xMin, xMax, 1);
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setTickUnit(1);
        xAxis.setLabel("X Label");
        yAxis.setLabel("Y Label");
        final javafx.scene.chart.LineChart<Number, Number> lineChart = new javafx.scene.chart.LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle(title);
        XYChart.Series series = new XYChart.Series();
        series.setName("Wzór Twojego równania to: y=" + a + "x + " + b);

        for (double i = xMin; i <= xMax; i++) {
            BigDecimal counter = new BigDecimal(i);
            BigDecimal y = a.multiply(counter).add(b);
            series.getData().add(new XYChart.Data(i, y));
        }

        System.out.println("Podaj rozmiary okna, zalecane to 800x800 ");
        System.out.println("Podaj szerokość okna");
        int width = scanner.nextInt();
        System.out.println("Podaj wysokość okna");
        int height = scanner.nextInt();
        Scene scene = new Scene(lineChart, width, height);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }
}
