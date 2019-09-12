package grahps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.net.FileNameMap;
import java.net.URL;

public class Main extends Application {

    private Controller controller;//

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();

        File file = new File("src/main/resources/fxml");

        System.out.println(getClass().getResource("/fxml/sample.fxml").getPath());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sample.fxml"));
        loader.setController(controller);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        Scene scene = new Scene(root, 800, 800);
        //     controller.drawChart(stage);

        stage.setScene(scene);
    }


    public static void main(String[] args) {
        launch(args);
    }

}