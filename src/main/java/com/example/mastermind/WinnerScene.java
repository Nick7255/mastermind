package com.example.mastermind;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;
import java.security.PrivilegedAction;

public class WinnerScene {
    private Object root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Label ScoreText;
    @FXML
    public Label winPrompt;



    public void ThrowWinner(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WinnerScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene((Parent) root);

        stage.setWidth(600);
        stage.setHeight(400);

        stage.setScene(scene);
        stage.show();

    }

    public void setScore(String sum, int rounds){
        ScoreText.setText(sum);
        String rawText = winPrompt.getText();
        if (rounds==1){
            rawText = rawText.replace("S"," ");
        }
        String s=Integer.toString(rounds);
        winPrompt.setText(rawText.replace("X",s));
    }
}
