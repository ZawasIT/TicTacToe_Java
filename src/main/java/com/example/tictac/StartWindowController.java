package com.example.tictac;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StartWindowController {

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
        stage.setScene(scene);
        stage.show();

        getStage().close();
    }

}
