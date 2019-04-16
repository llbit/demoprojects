package ballsfactory;

import balls.Animation;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

abstract public class BallFactory {
  abstract Ball makeBall();

  abstract public Animation makeAnimation(Pane canvas, Circle circle, long duration);
}
