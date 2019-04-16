package builderballs;

import balls.BounceAnimation;
import balls.RealisticBounceAnimation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Balls extends Application {
  private static final int FRAME_DURATION = 33;
  private Timeline timeline = new Timeline();

  public static void main(String[] args) {
    launch();
  }

  @Override public void start(Stage stage) {
    stage.setTitle("Balls");
    Pane canvas = new Pane();
    canvas.setPrefHeight(600);
    canvas.setPrefWidth(800);
    canvas.setOnMousePressed(event -> {
      if (event.getButton() == MouseButton.PRIMARY) {
        canvas.getChildren().clear();
        final Circle circle = new Circle();
        circle.setCenterX(event.getX());
        circle.setCenterY(event.getY());
        circle.setRadius(20);
        circle.setFill(Color.RED);
        canvas.getChildren().add(circle);
        timeline.stop();
        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(FRAME_DURATION),
            new BounceAnimation(canvas, circle, FRAME_DURATION)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
      } else if (event.getButton() == MouseButton.SECONDARY) {
        canvas.getChildren().clear();
        final Circle circle = new Circle();
        circle.setCenterX(event.getX());
        circle.setCenterY(event.getY());
        circle.setRadius(40);
        circle.setFill(Color.BLUE);
        canvas.getChildren().add(circle);
        timeline.stop();
        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(FRAME_DURATION),
            new RealisticBounceAnimation(canvas, circle, FRAME_DURATION)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
      }
    });
    Scene scene = new Scene(canvas);
    stage.setScene(scene);
    stage.show();
  }
}
