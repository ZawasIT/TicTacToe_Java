package com.example.tictac;

import javafx.scene.control.ToggleButton;

import java.io.IOException;

public class Game {

    private static TicTacToeController ticTacToeController;
    private static Player playerO;
    private static Player playerX;


    private static Integer scoreDraw = 0;
    public static void incrementScoreDraw() {
        Game.scoreDraw += 1;
    }
    public static Integer getScoreDraw() {
        return scoreDraw;
    }

    public static void initializePlayer(String nameX, String nameO) {
        playerX = new Player(nameX);
        playerO = new Player(nameO);
    }
    public static Player getPlayerX() {
        return playerX;
    }

    public static Player getPlayerO() {
        return playerO;
    }

    public static TicTacToeController getTicTacToeController() {
        return ticTacToeController;
    }

    public static void setTicTacToeController(TicTacToeController ticTacToeController) {
        Game.ticTacToeController = ticTacToeController;
    }

    public static void initBoard() {
        scoreDraw = 0;
        ticTacToeController.toggleButton1.setGraphic(null);
        ticTacToeController.toggleButton1.setId("toggleButton1");
        ticTacToeController.toggleButton1.setOnAction(event -> {
            try {
                ticTacToeController.handleSelected(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        ticTacToeController.toggleButton2.setGraphic(null);
        ticTacToeController.toggleButton2.setId("toggleButton2");
        ticTacToeController.toggleButton2.setOnAction(event -> {
            try {
                ticTacToeController.handleSelected(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        ticTacToeController.toggleButton3.setGraphic(null);
        ticTacToeController.toggleButton3.setId("toggleButton3");
        ticTacToeController.toggleButton3.setOnAction(event -> {
            try {
                ticTacToeController.handleSelected(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        ticTacToeController.toggleButton4.setGraphic(null);
        ticTacToeController.toggleButton4.setId("toggleButton4");
        ticTacToeController.toggleButton4.setOnAction(event -> {
            try {
                ticTacToeController.handleSelected(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        ticTacToeController.toggleButton5.setGraphic(null);
        ticTacToeController.toggleButton5.setId("toggleButton5");
        ticTacToeController.toggleButton5.setOnAction(event -> {
            try {
                ticTacToeController.handleSelected(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        ticTacToeController.toggleButton6.setGraphic(null);
        ticTacToeController.toggleButton6.setId("toggleButton6");
        ticTacToeController.toggleButton6.setOnAction(event -> {
            try {
                ticTacToeController.handleSelected(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        ticTacToeController.toggleButton7.setGraphic(null);
        ticTacToeController.toggleButton7.setId("toggleButton7");
        ticTacToeController.toggleButton7.setOnAction(event -> {
            try {
                ticTacToeController.handleSelected(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        ticTacToeController.toggleButton8.setGraphic(null);
        ticTacToeController.toggleButton8.setId("toggleButton8");
        ticTacToeController.toggleButton8.setOnAction(event -> {
            try {
                ticTacToeController.handleSelected(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        ticTacToeController.toggleButton9.setGraphic(null);
        ticTacToeController.toggleButton9.setId("toggleButton9");
        ticTacToeController.toggleButton9.setOnAction(event -> {
            try {
                ticTacToeController.handleSelected(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static boolean checkDraw() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (!toggleButton(row, col).getId().equals("X") && !toggleButton(row, col).getId().equals("O")) {
                    return false;
                }
            }
        }
        return true;
    }
    public static int checkResult() {
        for (int row = 0; row < 3; row++) {
            if (checkRow(row, "X")) {
                System.out.println("Wygrana X");
                return 0;
            } else if (checkRow(row, "O")) {
                System.out.println("Wygrana O");
                return 1;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (checkColumn(col, "X")) {
                System.out.println("Wygrana X");
                return 0;
            } else if (checkColumn(col, "O")) {
                System.out.println("Wygrana O");
                return 1;
            }
        }

        if (checkDiagonal("X")) {
            System.out.println("Wygrana X");
            return 0;
        } else if (checkDiagonal("O")) {
            System.out.println("Wygrana O");
            return 1;
        }

        return 2;
    }

    private static boolean checkRow(int row, String player) {
        return toggleButton(row, 0).getId().equals(player) &&
                toggleButton(row, 1).getId().equals(player) &&
                toggleButton(row, 2).getId().equals(player);
    }

    private static boolean checkColumn(int col, String player) {
        return toggleButton(0, col).getId().equals(player) &&
                toggleButton(1, col).getId().equals(player) &&
                toggleButton(2, col).getId().equals(player);
    }

    private static boolean checkDiagonal(String player) {
        return toggleButton(0, 0).getId().equals(player) &&
                toggleButton(1, 1).getId().equals(player) &&
                toggleButton(2, 2).getId().equals(player) ||
                toggleButton(0, 2).getId().equals(player) &&
                        toggleButton(1, 1).getId().equals(player) &&
                        toggleButton(2, 0).getId().equals(player);
    }

    private static ToggleButton toggleButton(int row, int col) {
        switch (row * 3 + col) {
            case 0: return ticTacToeController.toggleButton1;
            case 1: return ticTacToeController.toggleButton2;
            case 2: return ticTacToeController.toggleButton3;
            case 3: return ticTacToeController.toggleButton4;
            case 4: return ticTacToeController.toggleButton5;
            case 5: return ticTacToeController.toggleButton6;
            case 6: return ticTacToeController.toggleButton7;
            case 7: return ticTacToeController.toggleButton8;
            case 8: return ticTacToeController.toggleButton9;
            default: throw new IllegalArgumentException("Nieprawidłowe indeksy row i col");
        }
    }
    public static boolean player = true;


}
