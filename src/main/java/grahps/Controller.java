package grahps;

import javafx.fxml.FXML;

import java.awt.*;

public class Controller {

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
