package demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;


public class BounceAnimation implements EventHandler<ActionEvent> {
  private final Bounds bounds;
  private final double radius;
  private double x, y, tdelta;
  private double vx, vy;
  private Circle circle;

  public BounceAnimation(Pane canvas, Circle circle, double delta) {
    this.circle = circle;
    x = circle.getCenterX();
    y = circle.getCenterY();
    vx = -90;
    vy = 0;
    this.tdelta = delta / 1000.0;
    bounds = canvas.getBoundsInLocal();
    radius = circle.getRadius();
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
    }
    if (y - radius < bounds.getMinY()) {
      y = 2 * (bounds.getMinY() + radius) - y;
      vy = -vy;
    }
    vy += 100 * tdelta;
    circle.setCenterX(x);
    circle.setCenterY(y);
  }
}
