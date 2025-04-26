package java3;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.List;

public class Detyra2 extends Application {
    public void start(Stage stage){
        Pane pane = new Pane();
        List<Node> children = pane.getChildren();

        CustomRect1 rect1 = new CustomRect1(
                400, 400, 350, 480
        );
        rect1.setX(100);
        children.add(rect1);

        Scene scene = new Scene(pane, 700, 700);
        stage.setScene(scene);
        stage.show();
    }
}

//class CustomRect1 extends Pane {
//    private int width;
//    private int height;
//    public CustomRect1(int width, int height) {
//        this.width = width;
//        this.height = height;
//        this.init();
//    }
//
//    private void init() {
//        Rectangle rect1 =  this.initRectangle();
//        Triangle triangle1 = this.initTriangle1();
//        this.getChildren().addAll(rect1, triangle1);
//    }
//}
//
//private Rectangle initRectangle(){
//    Rectangle rectangle = new Rectangle(
//            this.x, this.y, this.width, this.height
//    );
//    rectangle.setFill(null);
//    rectangle.setStroke(null);
//    return rectangle;
//}
//
//
//    private Triangle initTriangle1(){
//    int x1 = ?;
//    int y1 = ?;
//    int x2 = ?;
//    int y2 = ?;
//    int x3 = ?;
//    int y3 = ?;
//}
//
//
//
//
//class Triangle extends Polygon {
//    Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
//        super(x1, y1, x2, y2, x3, y3);
//    }
//
//}

class CustomRect1 extends Pane {
    private int x;
    private int y;
    private int width;
    private int height;
    private int centerX;
    private int centerY;
    public CustomRect1(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
//        this.initCenterCoordinates();    // sosht mire me thirr ktu se nese e thirr metoden init apet,
        this.init();
    }

    private void initCenterCoordinates() {
        this.centerX = this.x + (int)(this.width * 0.5);
        this.centerY = this.y + (int)(this.height * 0.5);
    }

    private void init() {
        this.initCenterCoordinates();
        Node triangle1 = this.createTriangleWithRandomColor(
                x, y, x + width, y, centerX, centerY
        );
        Node triangle2 = this.createTriangleWithRandomColor(
                x + width, y, x + width, y + height, centerX, centerY
        );
        Node triangle3 = this.createTriangleWithRandomColor(
                x + width, y + height, x, y + height, centerX, centerY
        );
        Node triangle4 = this.createTriangleWithRandomColor(
                x, y + height, x, y, centerX, centerY
        );

        this.getChildren().clear();
        this.getChildren().addAll(
                triangle1,
                triangle2,
                triangle3,
                triangle4
        );
    }

    private Color getRandomColor() {
        return new Color(
                Math.random(), Math.random(), Math.random(), Math.random()
        );
    }

    private Polygon createTriangleWithRandomColor(
            int x0, int y0, int x1, int y1, int x2, int y2
    ){
        Polygon polygon = new Polygon(
                x0, y0, x1, y1, x2, y2
        );

        polygon.setFill(getRandomColor());
        return polygon;

    }

    public void setX (int x){
        this.x = x;
        this.init();
    }
}