package java9;  // pathi ku osht qikjo klase, duhet mu kon i njejt edhe per te dizajni (create_user.fxml) - pra dyjat te package java9 (njona n'java, tjetra n'resources)

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public void start(Stage stage) throws IOException {
//        Pane pane = ...;
        FXMLLoader fxmlLoader = new FXMLLoader(
                Main.class.getResource("create_user.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
