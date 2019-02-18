package demo;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

class SaveButton extends Button {
  private final FileChooserDemo gui;

  SaveButton(FileChooserDemo gui) {
    super("Save");
    this.gui = gui;
    setOnAction(event -> onClick());
  }

  private void onClick() {
    try {
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Save to File");
      File file = fileChooser.showSaveDialog(gui.getWindow());
      if (file != null) {
        gui.writeToFile(file);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("File Written");
        alert.setContentText("Finished writing to file: " + file.getName());
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
