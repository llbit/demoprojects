package demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

// Small template method demo.
public class FileChooserDemo extends Application {
  private Stage stage;

  public static void main(String[] args) {
    launch();
  }

  @Override public void start(Stage stage) {
    this.stage = stage;
    stage.setTitle("File Chooser Demo");
    VBox buttons = new VBox();
    buttons.setMinWidth(200);
    buttons.setMinHeight(200);
    buttons.setSpacing(10);
    buttons.setPadding(new Insets(10));
    buttons.getChildren().add(new SaveButton(this));
    buttons.getChildren().add(new LoadButton(this));
    Scene scene = new Scene(buttons);
    stage.setScene(scene);
    stage.show();
  }

  public Window getWindow() {
    return stage;
  }

  public void writeToFile(File file) throws IOException {
    try (FileOutputStream fout = new FileOutputStream(file);
         PrintStream out = new PrintStream(fout)) {
      out.println("Hello from FileChooserDemo!");
    }
  }

  public String readFile(File file) throws IOException {
    try (FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr)) {
      return reader.readLine();
    }
  }
}
