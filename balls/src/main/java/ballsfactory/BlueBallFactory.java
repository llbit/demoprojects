package ballsfactory;

import balls.Animation;
import balls.RealisticBounceAnimation;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class BlueBallFactory extends BallFactory {
  @Override
  Ball makeBall() {
    return new BlueBall();
  }

  @Override
  public Animation makeAnimation(Pane canvas, Circle circle, long duration) {
    return new RealisticBounceAnimation(canvas, circle, duration);
  }

}
