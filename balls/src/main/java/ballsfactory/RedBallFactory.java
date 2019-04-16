package ballsfactory;

import balls.Animation;
import balls.BounceAnimation;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class RedBallFactory extends BallFactory {
  @Override
  Ball makeBall() {
    return new RedBall();
  }

  @Override
  public Animation makeAnimation(Pane canvas, Circle circle, long duration) {
    return new BounceAnimation(canvas, circle, duration);
  }
}
