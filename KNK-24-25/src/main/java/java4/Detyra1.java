package java4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Detyra1 extends Application {
    public void start(Stage stage){
        // 1. Krijimi i figures
        Circle circle = new Circle(100, 100, 100);

        // 2. Krijimi i logjikes se animacionit (event-it)
        EventHandler<ActionEvent> event = new CircleEventHandler(circle);

        // 3. Krijimi i keyFrame
        KeyFrame frame = new KeyFrame(Duration.millis(5), event);   // pas 1 sekondi, shkaktoje eventin

        // 4. Krijimi i animacionit
        Timeline animation = new Timeline(frame);   // si perioda psh, sa zgjat, ose sa cikle i kryn
        animation.setCycleCount(-1);   // nese e vendosim -1, eshte njejt si Animation.INDEFINITE se shkon pafundesisht her me ndrru
        animation.play();

        Pane pane = new Pane(circle);
        Scene scene = new Scene(pane, 600, 600);
        stage.setScene(scene);
        stage.show();
    }
}

//onClick = metoda();

class CircleEventHandler implements EventHandler<ActionEvent>{
    private Circle circle;
    private int stepX = 1;
    private int stepY = 0;
    private boolean clockwise = true;

    public CircleEventHandler(Circle circle){
        this.circle = circle;
    }

    public void handle(ActionEvent ae){
//        this.animation1();
//        this.animation2();
//        this.animation3();
//        this.animation4();
        this.animation5();
    }

    private void animation1(){
        this.circle.setFill(
                new Color(Math.random(), Math.random(), Math.random(), 1)
        );
    }


//    private void animation2(){
//        double x = this.circle.getCenterX();
//        double y = this.circle.getCenterY();
//        if(x > 500){
//            this.step = -1;
//        } else if(x <= 100){
//            this.step = 1;
//        }
//
//        this.circle.setCenterX(x + this.step);
//    }

//    private void animation3(){                 // prej A te B, B te C, C te A
//        double x = this.circle.getCenterX();
//        double y = this.circle.getCenterY();
//
//        if(x == 500 && y == 100){
//            this.stepX = 0;
//            this.stepY = 1;
//        } else if (x == 500 && y == 500){
//            this.stepX = -1;
//            this.stepY = -1;
//        } else if (x == 100 && y == 100){
//            this.stepX = 1;
//            this.stepY = 0;
//        }
//
//        this.circle.setCenterX(x + this.stepX);
//        this.circle.setCenterY(y + this.stepY);
//    }

//    private void animation4(){
//        double x = this.circle.getCenterX();
//        double y = this.circle.getCenterY();
//
//        if(x == 500 && y == 100){
//            this.stepX = 0;
//            this.stepY = 1;
//        } else if(x == 500 && y == 500){
//            this.stepX = -1;
//            this.stepY = 0;
//        } else if(x == 100 && y == 500){
//            this.stepX = 0;
//            this.stepY = -1;
//        } else if(x == 100 && y == 100){
//            this.stepX = 1;
//            this.stepY = 0;
//        }
//        this.circle.setCenterX(x + this.stepX);
//        this.circle.setCenterY(y + this.stepY);
//
//    }

    private void animation5(){

        double x = this.circle.getCenterX();
        double y = this.circle.getCenterY();


        if(clockwise){       // A - B - C - D - A - D - C - B - A
            if(x == 500 && y == 100){
            this.stepX = 0;
            this.stepY = 1;
            } else if(x == 500 && y == 500){
                this.stepX = -1;
                this.stepY = 0;
            } else if(x == 100 && y == 500){
                this.clockwise = false;
                this.stepX = 0;
                this.stepY = -1;
            } else if(x == 100 && y == 100){
                this.stepX = 1;
                this.stepY = 0;
            }
        } else {
            if(x == 500 && y == 100){
                this.clockwise = true;
                this.stepX = -1;
                this.stepY = 0;
            } else if(x == 500 && y == 500){
                this.stepX = 0;
                this.stepY = -1;
            } else if(x == 100 && y == 500){
                this.stepX = 1;
                this.stepY = 0;
            } else if(x == 100 && y == 100){
                this.stepX = 0;
                this.stepY = 1;
            }
        }

        this.circle.setCenterX(x + this.stepX);
        this.circle.setCenterY(y + this.stepY);

    }
}
