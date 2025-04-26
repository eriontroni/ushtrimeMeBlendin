package java3;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;

import java.util.List;

public class Detyra1 {
    public void start(Stage stage){
        Pane pane = new Pane();
        List<Node> children = pane.getChildren();  // e rujna kto me ni variabel qe mos me perdor gjith pane.getChildren(najsen);

        CustomRect rect = new CustomRect(10, 10, 250, 300);
        children.add(rect);

        Scene scene = new Scene(pane, 700, 700);
        stage.setScene(scene);
        stage.show();
    }
}


class CustomRect extends Pane {
    private int x;
    private int y;
    private int width;
    private int height;
    public CustomRect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.init();
    }

    private void init(){
        Rectangle rect = this.initRectangle();
        Line line1 = this.initFirstLine();
        Line line2 = this.initSecondLine();
        this.getChildren().addAll(rect, line1, line2);
    }

    private Rectangle initRectangle(){
        Rectangle rectangle = new Rectangle(
                this.x, this.y, this.width, this.height
        );
        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);
        return rectangle;
    }

    private Line initFirstLine(){
        return new Line(
                this.x + this.width, this.y, this.x, this.y + this.height
        );
    }

    private Line initSecondLine(){
        double x0 = this.x + this.width * 0.5;   // koordinatat e pikes ne qender te drejtkendeshit
        double y0 = this.y + this.height + 0.5;
        int x1 = this.x + this.width;
        int y1 = this.y + this.height;
        return new Line(x0, y0, x1, y1);
    }


}











