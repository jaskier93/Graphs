package grahps;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.awt.*;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private void chartPattern(ActiveEvent event) {
        String pattern;
        if (factorA.equals("0") && factorC.equals("0")) {
            pattern = "f(x)=" + factorB;
        } else if (factorC.equals("0")) {
            pattern = "f(x)=" + factorA + "x+" + factorB;
        } else {
            pattern = "f(x)=" + factorC + "x^2" + factorA + "x+" + factorB;
        }
        label.setText(pattern);
    }

    @FXML //chart -fx:id wykresu w sample.fxml
            LineChart<Number, Number> chart;


    public void initialize(URL location, ResourceBundle resources) {
        XYChart.Series<Number, Number> series = new XYChart.Series();
        series.setName("Chart");
        //TODO: konwertować typ TextField na double'a, żeby w xAxis ustawić xMin oraz xMax podane przez usera
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setTickUnit(1);
        xAxis.setTickUnit(1);
        xAxis.setLabel("X Label");
        yAxis.setLabel("Y Label");
        final javafx.scene.chart.LineChart<Number, Number> lineChart = new javafx.scene.chart.LineChart<Number, Number>(xAxis, yAxis);


        //Parser text Fielda na double
        double xMax1 = Double.parseDouble(xMax.getText());

        double xMin1 = Double.parseDouble(xMin.getText());

        double a = Double.parseDouble(factorA.getText());
        double b = Double.parseDouble(factorB.getText());
        double c = Double.parseDouble(factorC.getText());


        //Dla wykresu liniowego, i++ można ewentualnie zmienić na i+TickUnit (jeśli jest inny niż 1)
        for (double i = xMin1; i <= xMax1; i++) {
            double y = a * i + b;
            series.getData().add(new XYChart.Data(i, y));
        }

        //Dla paraboli, i++ można ewentualnie zmienić na i+TickUnit (jeśli jest inny niż 1)
        for (double i = xMin1; i < xMax1; i++) {
            double y = a * i * i + b * i + c;
            series.getData().add(new XYChart.Data(i, y));
        }

    }

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


}
