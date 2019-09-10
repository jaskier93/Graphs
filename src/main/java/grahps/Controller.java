package grahps;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
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

    @FXML //chart -fx:id wykresu w sample.fxml
            XYChart.Series<Number, Number> chart;

    //Parser text Fielda na double
    double xMax1 = Double.parseDouble(xMax.getText());
    double xMin1 = Double.parseDouble(xMin.getText());
    double a = Double.parseDouble(factorA.getText());
    double b = Double.parseDouble(factorB.getText());
    double c = Double.parseDouble(factorC.getText());

    /*
    @FXML
    private void chartPattern(ActiveEvent event) {
        String pattern;
        if (a == 0 && c == 0) {
            pattern = "f(x)=" + factorB;
        } else if (c == 0) {
            pattern = "f(x)=" + factorA + "x+" + factorB;
        } else {
            pattern = "f(x)=" + factorC + "x^2" + factorA + "x+" + factorB;
        }
        label.setText(pattern);
    }*/

    @FXML
    public void drawChart(Stage stage) {
        XYChart.Series<Number, Number> series = chart;
        series.setName("Chart");

        final NumberAxis xAxis = new NumberAxis(xMin1, xMax1, 1);
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setTickUnit(1);
        xAxis.setLabel("X Label");
        yAxis.setLabel("Y Label");
        final javafx.scene.chart.LineChart<Number, Number> lineChart = new javafx.scene.chart.LineChart<Number, Number>(xAxis, yAxis);
        double y;

        button.setName(label.getText());

                String pattern;
        if (a == 0 && c == 0) {
            pattern = "f(x)=" + factorB;
        } else if (c == 0) {
            pattern = "f(x)=" + factorA + "x+" + factorB;
            //Dla wykresu liniowego, i++ można ewentualnie zmienić na i+TickUnit (jeśli jest inny niż 1)
            for (double i = xMin1; i <= xMax1; i++) {
                y = a * i + b;
                series.getData().add(new XYChart.Data(i, y));
            }
        } else {
            pattern = "f(x)=" + factorC + "x^2" + factorA + "x+" + factorB;
            //Dla paraboli, i++ można ewentualnie zmienić na i+TickUnit (jeśli jest inny niż 1)
            for (double i = xMin1; i < xMax1; i++) {
                y = a * i * i + b * i + c;
                series.getData().add(new XYChart.Data(i, y));
            }
        }
        label.setText(pattern);

        Scene scene = new Scene(lineChart, 800, 800);
        lineChart.getData().add(series);
        stage.setScene(scene);
        stage.setResizable(false); //Stały rozmiar okienka
        stage.show();
    }

    public void initialize(URL location, ResourceBundle resources) {

    }
}
