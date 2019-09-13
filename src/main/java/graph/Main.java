package graph;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    // private Controller controller;//

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sample.fxml"));
        //loader.setController(controller);
        //controller.drawChart(stage);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}