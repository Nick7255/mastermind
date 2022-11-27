package com.example.mastermind;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.*;


public class MainGame {

    @FXML
    public Circle circle1, circle2, circle3, circle4, circle5, circle6, circle7, circle8,
            circle9, circle10, circle11, circle12, circle13, circle14, circle15, circle16,
            circle17, circle18, circle19, circle20, circle21, circle22, circle23, circle24, circle25,
            circle26, circle27, circle28, circle29, circle30, circle31, circle32, circle33,
            circle34, circle35, circle36, circle37, circle38, circle39, circle40, hiddenCircle1, hiddenCircle2, hiddenCircle3, hiddenCircle4;

    @FXML
    public Circle flag1,flag2,flag3,flag4,flag5,flag6,flag7,flag8,flag9,flag10,
            flag11,flag12,flag13,flag14,flag15,flag16,flag17,flag18,flag19,flag20,
            flag21,flag22,flag23,flag24,flag25,flag26,flag27,flag28,flag29,flag30,
            flag31,flag32,flag33,flag34,flag35,flag36,flag37,flag38,flag39,flag40;


    @FXML
    public Rectangle white, blue, black, yellow, green, orange, purple, red, screen;
    private Button submitButton, setGame;

    public Paint color;

    public Object get_circle;
    public Circle circle;

    public ArrayList<Object> circles = new ArrayList<Object>();

//System.out.println(randNum);

    public void colorGetter(MouseEvent event) {

        String pick;
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

    public void colorPicker(MouseEvent event) {
        get_circle = event.getSource();
        circle = (Circle) event.getSource();
        if (circle.equals(get_circle) && circles.size() < 4) {
            circle.setFill(color);
            circle.setDisable(true);
            circles.add(circle);

        }
        if (circles.size() == 4) {
            System.out.println("4 circles complete");
        }


        Label scoreText = new Label();
        Label roundText = new Label();
        int sum = 0, count = 0;

    }

    public int randNum() {
        Random rand = new Random();
        return rand.nextInt(9);
    }


    public void setGame(ActionEvent event){
         ArrayList<Paint> colorsarray = new ArrayList<Paint>();

        for (Rectangle rectangle : Arrays.asList(white, blue, black, yellow, green, orange, purple, red)) {
            colorsarray.add(rectangle.getFill());
        }

        for (Circle circleHidden : Arrays.asList(hiddenCircle1, hiddenCircle2, hiddenCircle3, hiddenCircle4)) {
            String i = String.valueOf(randNum());
            System.out.println(i);
           circleHidden.setFill(colorsarray.get(randNum()));
           circleHidden.setDisable(true);
           circleHidden.setVisible(false);
        }
    }

    public Circle[][] hint= new Circle[][]{
            {flag1,flag2,flag3,flag4},
            {flag5,flag6,flag7,flag8},
            {flag9,flag10,flag11,flag12},
            {flag13,flag14,flag15,flag16},
            {flag17,flag18,flag19,flag20},
            {flag21,flag22,flag23,flag24},
            {flag25,flag26,flag27,flag28},
            {flag29,flag30,flag31,flag32},
            {flag33,flag34,flag35,flag36},
            {flag37,flag38,flag39,flag40},
    };

    int round= 0;
    int id=0;

    private void flagsSetUp(int colorExist,int idx){
        if (colorExist == 0){
            hint[round][idx].setFill(Color.WHITE);
        }
        if (colorExist == 1){
            hint[round][idx].setFill(Color.BLACK);
        }
    }


    //Gia kathe swsto xrwma deixnei white flag & Gia kathe xrwma poy exei mantepsei swsta thn thesi deixnei black flag

    public void Submit (ActionEvent event) {

        for (int idx=0;idx>=circles.size();idx++){
            for (int idy=0; idy>=circles.size();idy++){
                if(circles.get(idx) ==circleHidden.get(idy) && idx==idy){
                    id=idy;
                    flagsSetUp(1,id);
                } else if (circles.get(idx)==circleHidden.get(idy) && idx!=idy) {
                    id=idy;
                    flagsSetUp(0,id);
                }
            }
        }

        circles.clear();
        System.out.println(circles);
    }
}
