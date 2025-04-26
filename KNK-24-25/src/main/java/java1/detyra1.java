package java1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class detyra1 extends Application {

    public void start(Stage stage){
        Pane pane = new Pane();
        Text text = new Text("Ushtrimi i pare ne JavaFX!");
        text.setX(10);
        text.setY(20);

        pane.getChildren().add(text);

        Scene scene = new Scene(pane, 500, 500);   // dimensionet jane me px

        stage.setScene(scene);
        stage.show();
    }

}
