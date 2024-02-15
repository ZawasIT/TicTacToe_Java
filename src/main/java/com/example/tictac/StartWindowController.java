package com.example.tictac;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class StartWindowController implements Initializable {

    @FXML
    private VBox startWindowVbox;

    @FXML
    private ToggleButton modeToggleButton;

    @FXML
    private ToggleButton languageToggleButton;

    @FXML
    private Label playerOLabel;

    @FXML
    private Label playerXLabel;

    @FXML
    private TextField playerOTextField;

    @FXML
    private TextField playerXTextField;

    @FXML
    private Button startButton;

    private Stage getStage() {
        return (Stage) startButton.getScene().getWindow();
    }
    @FXML
    void handleStartButton(ActionEvent event) throws IOException {

        if (playerOTextField.getText().isEmpty() || playerXTextField.getText().isEmpty()) {
            playerXTextField.setPromptText("Wymagane!");
            playerOTextField.setPromptText("Wymagane!");

            return;
        }
        Game.initializePlayer(playerXTextField.getText(), playerOTextField.getText());

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ticTacToe_main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setMinWidth(700);
        stage.setMinHeight(450);
        stage.setWidth(700);
        stage.setHeight(450);

        stage.setTitle("Tic Tac Toe Zawas");
        stage.getIcons().add(new Image(getClass().getResource("/img/logo.png").toExternalForm()));
        stage.setScene(scene);
        stage.show();

        getStage().close();
    }

    @FXML
    void handleToggleButton(ActionEvent event) {
        changeMode();
    }

    private void changeMode() {
        if (modeToggleButton.isSelected()) {
            startWindowVbox.getStylesheets().remove(String.valueOf(getClass().getResource("/css/global-colors-light" +
                    ".css")));
            startWindowVbox.getStylesheets().add(String.valueOf(getClass().getResource("/css/global-colors-dark.css")));
            modeToggleButton.setSelected(true);

        } else {
            startWindowVbox.getStylesheets().remove(String.valueOf(getClass().getResource("/css/global-colors-dark" +
                    ".css")));
            startWindowVbox.getStylesheets().add(String.valueOf(getClass().getResource("/css/global-colors-light.css")));
            modeToggleButton.setSelected(false);
        }
    }

    @FXML
    void changeLanguage(ActionEvent event) {
        if(languageToggleButton.isSelected()) {
            setLanguage("en");
        } else {
            setLanguage("pl");
        }
    }

    private void setLanguage(String language) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(language, Locale.getDefault());
        playerOLabel.setText(resourceBundle.getString("playerOLabelText"));
        playerXLabel.setText(resourceBundle.getString("playerXLabelText"));
        playerOTextField.setPromptText(resourceBundle.getString("playerOTextFieldText"));
        playerXTextField.setPromptText(resourceBundle.getString("playerXTextFieldText"));
        startButton.setText(resourceBundle.getString("startButtonText"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modeToggleButton.setSelected(true);
        languageToggleButton.setSelected(true);

    }
}
