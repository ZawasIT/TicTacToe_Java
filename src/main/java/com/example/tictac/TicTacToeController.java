package com.example.tictac;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;


public class TicTacToeController implements Initializable {

    @FXML
    private ToggleButton modeToggleButton;

    @FXML
    public ToggleButton languageToggleButton;

    @FXML
    private Label playerOLabel;

    @FXML
    private Label playerXLabel;

    @FXML
    private Label playerTurnLabel;

    @FXML
    private Label scoreLabel1;

    @FXML
    private Label scoreLabel2;

    @FXML
    private Label drawScoreLabel;

    @FXML
    private Label numberOfGamesLabel;

    @FXML
    private Label numberGamesLabel;
    @FXML
    private Label scoreOLabel;

    @FXML
    private Label scoreXLabel;
    @FXML
    private Label scoreDrawLabel;
    @FXML
    public ToggleButton toggleButton1;

    @FXML
    public ToggleButton toggleButton2;

    @FXML
    public ToggleButton toggleButton3;

    @FXML
    public ToggleButton toggleButton4;

    @FXML
    public ToggleButton toggleButton5;

    @FXML
    public ToggleButton toggleButton6;

    @FXML
    public ToggleButton toggleButton7;

    @FXML
    public ToggleButton toggleButton8;

    @FXML
    public ToggleButton toggleButton9;

    @FXML
    private Label playerLabel;

    @FXML
    private VBox ticTacToeVbox;
    @FXML
    private Label welcomeText;

    public Stage getStage() {
        return (Stage) ticTacToeVbox.getScene().getWindow();
    }

    @FXML
    void handleSelected(ActionEvent event) throws IOException {
        ToggleButton toggleButton = (ToggleButton) event.getSource();
        System.out.println(toggleButton.getId());
        System.out.println("klik");
        ImageView imageView = new ImageView();

        if (Game.player) {
            imageView.setImage(new Image(String.valueOf(getClass().getResource("/img/circle.png"))));
            Game.player = false;
            playerLabel.setText(Game.getPlayerX().getName());
            if(languageToggleButton.isSelected()) {
                ResourceBundle resourceBundle = ResourceBundle.getBundle("en", Locale.getDefault());
                playerTurnLabel.setText(resourceBundle.getString("playerXTurnLabelText"));
            } else {
                ResourceBundle resourceBundle = ResourceBundle.getBundle("pl", Locale.getDefault());
                playerTurnLabel.setText(resourceBundle.getString("playerXTurnLabelText"));
            }

            toggleButton.setId("O");
            toggleButton.setOnAction(null);
            Game.checkResult();
        } else {
            imageView.setImage(new Image(String.valueOf(getClass().getResource("/img/cross.png"))));
            Game.player = true;
            playerLabel.setText(Game.getPlayerO().getName());
            if(languageToggleButton.isSelected()) {
                ResourceBundle resourceBundle = ResourceBundle.getBundle("en", Locale.getDefault());
                playerTurnLabel.setText(resourceBundle.getString("playerOTurnLabelText"));
            } else {
                ResourceBundle resourceBundle = ResourceBundle.getBundle("pl", Locale.getDefault());
                playerTurnLabel.setText(resourceBundle.getString("playerOTurnLabelText"));
            }
            toggleButton.setId("X");
            toggleButton.setOnAction(null);
            Game.checkResult();
        }
        toggleButton.setGraphic(imageView);

        if(Game.checkResult() == 0) {
            Game.getPlayerX().increamentScore();
            Game.incrementNumberOfGames();
            scoreXLabel.setText(String.valueOf(Game.getPlayerX().getScore()));
            numberGamesLabel.setText(String.valueOf(Game.getNumberOfGames()));

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("alert.fxml"));
            VBox alertBox = fxmlLoader.load();
            if (modeToggleButton.isSelected()) {
                alertBox.getStylesheets().remove(String.valueOf(getClass().getResource("/css/global-colors-light" +
                        ".css")));
                alertBox.getStylesheets().add(String.valueOf(getClass().getResource("/css/global-colors-dark.css")));
            } else {
                alertBox.getStylesheets().remove(String.valueOf(getClass().getResource("/css/global-colors-dark" +
                        ".css")));
                alertBox.getStylesheets().add(String.valueOf(getClass().getResource("/css/global-colors-light.css")));
            }
            AlertController alertController = fxmlLoader.getController();

            Stage alertStage = new Stage();
            if(languageToggleButton.isSelected()){
                alertStage.setTitle("Winning " + Game.getPlayerX().getName());
                alertController.setPlayerLabel("Winning "+Game.getPlayerX().getName());

            } else {
                alertStage.setTitle("Wygrana " + Game.getPlayerX().getName());
                alertController.setPlayerLabel("Wygrywa "+Game.getPlayerX().getName());

            }
            alertStage.getIcons().add(new Image(getClass().getResource("/img/logo.png").toExternalForm()));
            alertStage.setScene(new Scene(alertBox));
            alertStage.initModality(Modality.WINDOW_MODAL);
            alertStage.initOwner(this.ticTacToeVbox.getScene().getWindow());
            alertStage.showAndWait();
        } else if (Game.checkResult() == 1) {
            Game.getPlayerO().increamentScore();
            Game.incrementNumberOfGames();
            scoreOLabel.setText(String.valueOf(Game.getPlayerO().getScore()));
            numberGamesLabel.setText(String.valueOf(Game.getNumberOfGames()));

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("alert.fxml"));
            VBox alertBox = fxmlLoader.load();
            if (modeToggleButton.isSelected()) {
                alertBox.getStylesheets().remove(String.valueOf(getClass().getResource("/css/global-colors-light" +
                        ".css")));
                alertBox.getStylesheets().add(String.valueOf(getClass().getResource("/css/global-colors-dark.css")));
            } else {
                alertBox.getStylesheets().remove(String.valueOf(getClass().getResource("/css/global-colors-dark" +
                        ".css")));
                alertBox.getStylesheets().add(String.valueOf(getClass().getResource("/css/global-colors-light.css")));
            }
            AlertController alertController = fxmlLoader.getController();
            Stage alertStage = new Stage();

            if(languageToggleButton.isSelected()){
                alertStage.setTitle("Winning " + Game.getPlayerO().getName());
                alertController.setPlayerLabel("Winning "+Game.getPlayerO().getName());

            } else {
                alertStage.setTitle("Wygrana " + Game.getPlayerO().getName());
                alertController.setPlayerLabel("Wygrana "+Game.getPlayerO().getName());

            }
            alertStage.getIcons().add(new Image(getClass().getResource("/img/logo.png").toExternalForm()));
            alertStage.setScene(new Scene(alertBox));
            alertStage.initModality(Modality.WINDOW_MODAL);
            alertStage.initOwner(this.ticTacToeVbox.getScene().getWindow());
            alertStage.showAndWait();
        }


        if(Game.checkDraw()) {
            Game.incrementScoreDraw();
            Game.incrementNumberOfGames();

            scoreDrawLabel.setText(String.valueOf(Game.getScoreDraw()));
            numberGamesLabel.setText(String.valueOf(Game.getNumberOfGames()));

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("alert.fxml"));
            VBox alertBox = fxmlLoader.load(); // Wczytaj VBox z pliku FXML
            if (modeToggleButton.isSelected()) {
                alertBox.getStylesheets().remove(String.valueOf(getClass().getResource("/css/global-colors-light" +
                        ".css")));
                alertBox.getStylesheets().add(String.valueOf(getClass().getResource("/css/global-colors-dark.css")));
            } else {
                alertBox.getStylesheets().remove(String.valueOf(getClass().getResource("/css/global-colors-dark" +
                        ".css")));
                alertBox.getStylesheets().add(String.valueOf(getClass().getResource("/css/global-colors-light.css")));
            }
            AlertController alertController = fxmlLoader.getController();

            Stage alertStage = new Stage();
            if(languageToggleButton.isSelected()){
                alertStage.setTitle("Draw Tic Tac Toe");
                alertController.setPlayerLabel("Draw!!!");

            } else {
                alertStage.setTitle("Remis Tic Tac Toe");
                alertController.setPlayerLabel("Remis!!!");
            }
            alertStage.getIcons().add(new Image(getClass().getResource("/img/logo.png").toExternalForm()));
            alertStage.setScene(new Scene(alertBox));
            alertStage.initModality(Modality.WINDOW_MODAL);
            alertStage.showAndWait();
        }
    }


    @FXML
    void handleToggleButton(ActionEvent event) {
        changeMode();
    }

    private void changeMode() {
        if (modeToggleButton.isSelected()) {
            ticTacToeVbox.getStylesheets().remove(String.valueOf(getClass().getResource("/css/global-colors-light" +
                    ".css")));
            ticTacToeVbox.getStylesheets().add(String.valueOf(getClass().getResource("/css/global-colors-dark.css")));
            modeToggleButton.setSelected(true);

        } else {
            ticTacToeVbox.getStylesheets().remove(String.valueOf(getClass().getResource("/css/global-colors-dark" +
                    ".css")));
            ticTacToeVbox.getStylesheets().add(String.valueOf(getClass().getResource("/css/global-colors-light.css")));
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
        playerXLabel.setText(resourceBundle.getString("playerXLabelText"));
        playerOLabel.setText(resourceBundle.getString("playerOLabelText"));
        scoreLabel1.setText(resourceBundle.getString("scoreLabel1Text"));
        scoreLabel2.setText(resourceBundle.getString("scoreLabel2Text"));
        drawScoreLabel.setText(resourceBundle.getString("drawScoreLabelText"));
        numberOfGamesLabel.setText(resourceBundle.getString("numberOfGamesLabelText"));

        if(Game.player) {
            playerTurnLabel.setText(resourceBundle.getString("playerOTurnLabelText"));
        } else {
            playerTurnLabel.setText(resourceBundle.getString("playerXTurnLabelText"));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Game.setTicTacToeController(this);
        GlobalVar.setLanguageToggleButton(languageToggleButton);
        modeToggleButton.setSelected(true);
        if(Game.player) {
            playerLabel.setText(Game.getPlayerO().getName());
        } else {
            playerLabel.setText(Game.getPlayerX().getName());
        }

        languageToggleButton.setSelected(true);
    }
}