package ballsfactory;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BlueBall extends Ball {
  @Override
  Circle shape(double x, double y) {
    Circle circle = new Circle(x, y, 40);
    circle.setFill(Color.BLUE);
    return circle;
  }
}
