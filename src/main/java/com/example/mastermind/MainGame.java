package com.example.mastermind;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;



public class MainGame {

    @FXML
    public Circle circle11;
    @FXML
    private Rectangle white,blue,black,yellow,green,orange,purple,red;

    public void colorGetter (MouseEvent event){
        
    }

    public void colorPicker (MouseEvent event){
        String colorPicked = new String();
        String eventlogger = event.getPickResult().getIntersectedNode().getId();
        String selectedcircleId = eventlogger.replaceAll("[\\D]", "");
        int idx = Integer.parseInt(selectedcircleId);
        System.out.print(idx);
        circle11.setFill(Paint.valueOf(colorPicked));
    }

}
