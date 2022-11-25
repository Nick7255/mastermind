package com.example.mastermind;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.IOException;



public class MainGame {

    @FXML
    public Circle circle11;
    @FXML
    public Rectangle white,blue,black,yellow,green,orange,purple,red;

    public Paint color;
    public void colorGetter (MouseEvent event){

        String pick = new String();
        pick = event.getPickResult().getIntersectedNode().getId();
        switch (pick) {
            case "white" -> color = white.getFill();
            case "blue" -> color = blue.getFill();
            case "black" -> color = black.getFill();
            case "yellow" -> color = yellow.getFill();
            case "green" -> color = green.getFill();
            case "orange" -> color = orange.getFill();
            case "purple" -> color = purple.getFill();
            case "red" -> color = red.getFill();
        }
    }

    public void colorPicker (MouseEvent event){
        String eventlogger = event.getPickResult().getIntersectedNode().getId();
        String selectedcircleId = eventlogger.replaceAll("[\\D]", "");
        int idx = Integer.parseInt(selectedcircleId);
        System.out.print(idx);
        circle11.setFill(color);
    }

    @FXML
    Label scoreText = new Label();
    Label roundText = new Label();
    int sum=0, count=0;

    String st1,st2;
                       //sum   count
    private void score(int a,int b){
        st1 = Integer.toString(a);
        st2 = Integer.toString(b);
        scoreText.setText(st1);
        roundText.setText(st2);
    }


}
