package com.example.mastermind;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;

public class WinnerScene {
    private Object root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button Startgame;



    public void ThrowWinner(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WinnerScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene((Parent) root);

        stage.setWidth(550);
        stage.setHeight(700);

        stage.setScene(scene);
        stage.show();

    }
}
