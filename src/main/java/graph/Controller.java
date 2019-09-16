package graph;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Controller {
    @FXML
    TextField factorA;
    @FXML
    TextField factorB;
    @FXML
    TextField factorC;
    @FXML
    TextField xMin;
    @FXML
    TextField xMax;
    @FXML
    Label label;
    @FXML
    Button button;

    @FXML
    XYChart.Series<Number, Number> chart;

    //Parser Text Field -> double
    double xMax1 = Double.parseDouble(xMax.getText());
    double xMin1 = Double.parseDouble(xMin.getText());
    double a = Double.parseDouble(factorA.getText());
    double b = Double.parseDouble(factorB.getText());
    double c = Double.parseDouble(factorC.getText());


    public void drawChart(Stage stage) {
        XYChart.Series<Number, Number> series = chart;
        series.setName("Chart");
        double axisTick = 1;
        final NumberAxis xAxis = new NumberAxis(xMin1, xMax1, axisTick);
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setTickUnit(axisTick);
        xAxis.setLabel("X Label");
        yAxis.setLabel("Y Label");
        final javafx.scene.chart.LineChart<Number, Number> lineChart = new javafx.scene.chart.LineChart<Number, Number>(xAxis, yAxis);
        double y;

        String pattern;
        if (a == 0 && c == 0) {
            pattern = "f(x)=" + factorB;
            label.setText(pattern);
        } else if (c == 0) {
            pattern = "f(x)=" + factorA + "x+" + factorB;
            label.setText(pattern);
            for (double i = xMin1; i <= xMax1; i++) {
                y = a * i + b;
                series.getData().add(new XYChart.Data(i, y));
            }
        } else {
            pattern = "f(x)=" + factorC + "x^2" + factorA + "x+" + factorB;
            label.setText(pattern);
            for (double i = xMin1; i < xMax1; i++) {
                y = a * i * i + b * i + c;
                series.getData().add(new XYChart.Data(i, y));
            }
        }

        lineChart.getData().add(series);
        Scene scene = new Scene(lineChart, 800, 700);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
