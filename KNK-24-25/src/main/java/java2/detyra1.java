package java2;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/*
* Shape:
*  - Circle
*  - Line
*  - Rectangle
*  - Polygon
*  - Polyline
*  - Arc
*
* Layout:
*  - Pane
*  - StackPane                  - i vendos krejta ne mes (kqyr rreshtin 36 me pa qysh ish perdor
*  - FlowPane                   - i vendos elementet 1 nga 1 (ne menyre horizontale by default), nese s'ka hapsire, i vendos ne rresht te ri
*  - VBox                       - i vendos te gjitha elementet ne menyre vertikale, kurr si vendos ne rresht te ri
*  - HBox                       - --||-- ne menyre horizontale, --||--
*  - BorderPane                 - krijon nje layout te aplikacionit (e ndan faqen e aplikacionit ne 5 hapesira: header, footer, left & right side, center
*/

public class detyra1 extends Application {

    public void start(Stage stage){
        Pane pane = new Pane();  // nese kishim dasht mi pas krejt figurat qe i krijojm, ne MES, e perdorim \\ Pane pane = new StackPane(); \\
        List<Node> children = pane.getChildren();

        Circle circle = new Circle();    // Circle dhe te tjerat, trashegohen prej klases Shape qe ka logjike te jete abstrakte
        circle.setCenterX(100);
        circle.setCenterY(100);      // mundesi per me i vendos te dhenat per rreth (po mujm edhe te konstruktori i Circle) - x, y, r
        circle.setRadius(50);
        circle.setFill(null);
        circle.setStroke(Color.GREEN);
        circle.setStrokeWidth(3);
//        circle.setRotate();   // kjo te rrethi ska kuptim se sa dush mu kon kendi i rrotullimit, del njejt
        children.add(circle);        // permes ksaj, po e shtojm rrethin ne panel


        Line line = new Line(100, 100, 100, 300);   // (x1, y1, x2, y2)
        line.setStroke(Color.GRAY);
        children.add(line);

        Rectangle rect = new Rectangle(200, 200, 250, 500);   // (x, y, width, height), ku x, y jane koordinatat e pikes se pare te drejtkendeshit
        rect.setFill(null);
        rect.setStroke(Color.BLACK);
        children.add(rect);

        Polygon polygon = new Polygon();
        List<Double> points = new ArrayList<>();
        points.add(250.0);
        points.add(250.0);  // cdo 2 vlera e paraqesin nje koordinate (nje pike)

        points.add(330.0);
        points.add(370.0);
        points.add(400.0);
        points.add(220.0);
        polygon.getPoints().addAll(points);
        polygon.getPoints().addAll(150.0, 120.0, 50.0, 300.0);  // menyre me e shpejte me i paraqit koordinatat e poligonit
        children.add(polygon);


        Polyline polyline = new Polyline(
                400, 400, 500, 625, 390, 620, 250
        );
        polyline.setFill(null);
        polyline.setStroke(Color.BROWN);
        polyline.setStrokeWidth(5);  // 5px
        children.add(polyline);


        Arc arc = new Arc();
        arc.setCenterX(500);
        arc.setCenterY(200);
        arc.setRadiusX(100);
        arc.setRadiusY(100);
        arc.setStartAngle(0);
        arc.setLength(90);   // double 90 (kendi 90 shkalle) - kjo reprezenton 1/4 e rrethit
        arc.setType(ArcType.ROUND);   // ROUND - e mbyllur; OPEN - e hapur; CHORD - mbyllet te dy pikat e qoshit
        arc.setFill(null);
        arc.setStroke(Color.RED);
        children.add(arc);


        Triangle triangle = new Triangle(500, 500, 700, 500, 600, 600);  // ska klase te gatshme Triangle, kshtuqe e krijum vet (ez)
        triangle.setFill(null);
        triangle.setStroke(Color.BLUE);
        children.add(triangle);


        Scene scene = new Scene(pane, 700, 700);

        stage.setScene(scene);
        stage.show();


    }

}

class Triangle extends Polygon {
    Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        super(x1, y1, x2, y2, x3, y3);
    }

    Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        super(x1, y1, x2, y2, x3, y3);
    }
}
