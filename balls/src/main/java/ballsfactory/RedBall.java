package ballsfactory;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class RedBall extends Ball {
  @Override
  Circle shape(double x, double y) {
    Circle circle = new Circle(x, y, 20);
    circle.setFill(Color.RED);
    return circle;
  }
}
