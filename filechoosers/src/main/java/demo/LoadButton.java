package demo;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

class LoadButton extends Button {
  private final FileChooserDemo gui;

  LoadButton(FileChooserDemo gui) {
    super("Load");
    this.gui = gui;
    setOnAction(event -> onClick());
  }

  private void onClick() {
    try {
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Load File");
      File file = fileChooser.showOpenDialog(gui.getWindow());
      if (file != null) {
        String data = gui.readFile(file);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("File Loaded");
        alert.setContentText("First line is: " + data);
        alert.show();
      }
    } catch (IOException e) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle(e.getClass().getSimpleName());
      alert.setContentText(e.getMessage());
      alert.show();
    }
  }
}
