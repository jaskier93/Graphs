package graph;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

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
    LineChart<Number, Number> chart;
    @FXML
    NumberAxis xAxis;
    @FXML
    NumberAxis yAxis;

    @FXML
    public void updateChart() {
        XYChart.Series<Number, Number> series = getSeries();
        chart.getData().clear();
        chart.getData().add(series);
    }

    public void initialize() {
        initChartProperties();
        initInputControls();
        XYChart.Series<Number, Number> series = getSeries();
        chart.getData().add(series);
    }

    private XYChart.Series<Number, Number> getSeries() {

        double xMax1 = Double.parseDouble(xMax.getText());
        double xMin1 = Double.parseDouble(xMin.getText());
        double a = Double.parseDouble(factorA.getText());
        double b = Double.parseDouble(factorB.getText());
        double c = Double.parseDouble(factorC.getText());

        if ((xMin1 >= xMax1) && xMax1 != 0 && xMin1 != 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "xMax musi być większe od xMin!", ButtonType.OK);
            ButtonType result = alert.showAndWait().orElse(ButtonType.NO);
        }

        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        String pattern;
        if (a == 0 && c == 0) {
            for (double i = xMin1; i <= xMax1; i++) {
                double y = b;
                series.getData().add(new XYChart.Data<Number, Number>(i, y));
            }
            pattern = "f(x)=" + factorB.getText();
            label.setText(pattern);

        } else if (c == 0) {
            pattern = "f(x)=" + factorA.getText() + "x+" + factorB.getText();
            label.setText(pattern);
            for (double i = xMin1; i <= xMax1; i++) {
                double y = a * i + b;
                series.getData().add(new XYChart.Data<Number, Number>(i, y));
            }
        } else {
            pattern = "f(x)=" + factorA.getText() + "x^2+" + factorB.getText() + "x+" + factorC.getText();
            label.setText(pattern);
            for (double i = xMin1; i < xMax1; i++) {
                double y = a * i * i + b * i + c;
                series.getData().add(new XYChart.Data<Number, Number>(i, y));
            }
        }
        return series;
    }

    private void initChartProperties() {
        chart.setAnimated(false);
        xAxis.setLabel("X Label");
        yAxis.setLabel("Y Label");
    }

    private void initInputControls() {
        chart.setCreateSymbols(false);
        xMax.setText("0");
        xMin.setText("0");
        factorA.setText("0");
        factorB.setText("0");
        factorC.setText("0");
    }
}