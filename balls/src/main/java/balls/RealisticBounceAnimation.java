package balls;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;


public class RealisticBounceAnimation extends BounceAnimation {
  public RealisticBounceAnimation(Pane canvas, Circle circle, double delta) {
    super(canvas, circle, delta);
  }

  @Override public void handle(ActionEvent event) {
    y += vy * tdelta;
    x += vx * tdelta;
    if (x + radius > bounds.getMaxX()) {
      vx = -vx;
      x = 2 * (bounds.getMaxX() - radius) - x ;
    }
    if (x - radius < bounds.getMinX()) {
      vx = -vx;
      x = 2 * (bounds.getMinX() + radius) - x;
    }
    if (y + radius > bounds.getMaxY()) {
      y = 2 * (bounds.getMaxY() - radius) - y;
      vy = -vy;
      vy *= 0.9;
    }
    if (y - radius < bounds.getMinY()) {
      y = 2 * (bounds.getMinY() + radius) - y;
      vy = -vy;
      vy *= 0.9;
    }
    vy += BounceAnimation.ACCEL * tdelta;
    circle.setCenterX(x);
    circle.setCenterY(y);
  }
}
