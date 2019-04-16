package ballsfactory;

import balls.Animation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

// Using factory to create circle and animation.
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
      canvas.getChildren().clear();
      BallFactory factory = new RedBallFactory();
      if (event.getButton() == MouseButton.PRIMARY) {
        factory = new RedBallFactory();
      } else if (event.getButton() == MouseButton.SECONDARY) {
        factory = new BlueBallFactory();
      }
      Ball ball = factory.makeBall();
      Circle circle = ball.shape(event.getX(), event.getY());
      canvas.getChildren().add(circle);
      animate(canvas, circle, factory.makeAnimation(canvas, circle, FRAME_DURATION));
    });
    Scene scene = new Scene(canvas);
    stage.setScene(scene);
    stage.show();
  }

  private void animate(Pane canvas, Circle circle, Animation animation) {
    timeline.stop();
    timeline.getKeyFrames().clear();
    timeline.getKeyFrames().add(new KeyFrame(Duration.millis(FRAME_DURATION),
        animation));
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
  }
}
