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
import javafx.scene.text.Text;

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
    public Button submitButton, setGameButton;
    public Paint color;
    public Object get_circle;
    public Circle circle;
    public Text secretcodetext;
    public ArrayList<Paint> circles = new ArrayList<Paint>();
    public ArrayList<Paint> hiddenCircles=new ArrayList<Paint>();

    public Circle[][] flags;


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
            circles.add(circle.getFill());
        }
        if (circles.size() == 4) {
            System.out.println("4 circles complete");
        }
        Label scoreText = new Label();
        Label roundText = new Label();
        int sum = 0, count = 0;

    }
    public static ArrayList getRandomNonRepeatingIntegers(int size, int min, int max) {
       ArrayList numbers = new ArrayList();
        Random random = new Random();
        while (numbers.size() < size) {
            int randomNumber = random.nextInt((max - min) + 1) + min;
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
            //doulevei tis perissoteres fores alla merikes vgazei out of bounds exception
    public void setGame(ActionEvent event) {

        ArrayList<Paint> colorsarray = new ArrayList<Paint>();
        ArrayList list = getRandomNonRepeatingIntegers(4, 0, 7);
        for (Rectangle rectangle : Arrays.asList(white, blue, black, yellow, green, orange, purple, red)) {
            colorsarray.add(rectangle.getFill());
        }
        int y = 0;
        Paint current = null;
        hiddenCircles.clear();

        flags= new Circle[][]{
                {flag1,flag2,flag3,flag4},
                {flag5,flag6,flag7,flag8},
                {flag9,flag10, flag11,flag12},
                {flag13,flag14,flag15,flag16},
                {flag17,flag18,flag19,flag20},
                {flag21,flag22,flag23,flag24},
                {flag25,flag26,flag27,flag28},
                {flag29,flag30, flag31,flag32},
                {flag33,flag34,flag35,flag36},
                {flag37,flag38,flag39,flag40}};

        for (Circle circleHidden : Arrays.asList(hiddenCircle1, hiddenCircle2, hiddenCircle3, hiddenCircle4)) {
            hiddenCircles.add(circleHidden.getFill());
            int num = (int) list.get(y);
            //System.out.println(num);
            current = colorsarray.get(num);
            //System.out.println(current);
            circleHidden.setFill(current);
            y = y+1;
            num = 0;
            screen.setOpacity(1);
            secretcodetext.setOpacity(1);
        }
        setGameButton.setOpacity(0);
    }


    public int round= 0;
    public int id=0;

    private void flagsSetUp(int colorExist,int idx){
        //System.out.println(flags);
        if (colorExist == 0){
            flags[round][idx].setFill(Color.WHITE);
        }
       if (colorExist == 1){
           flags[round][idx].setFill(Color.RED);
       }
    }


    //Gia kathe swsto xrwma deixnei white flag & Gia kathe xrwma poy exei mantepsei swsta thn thesi deixnei black flag

    // edw tsekarw an to array twn hidden circle einai global
    // gia to check twn hidden circle kane for loop opws exw kanei sthn function setGame. logika kati tetoio thelei

    //to provlima einai oti ta .get den tha einai pote isa giati o kathe kuklos exei to diko tou id
    //opote prepei na elegxoume me thn get fill ara prepei na tis metatrepsoume se object h arrays. to doulevw akoma
    //alla ws exei einai se stable katastash

    public void Submit (ActionEvent event) {
        for (int i=0; i<hiddenCircles.size(); i++){
            for (int j=0; j<circles.size(); j++){
                if (circles.get(i).equals(hiddenCircles.get(j))&& i==j){
                    //System.out.println("1");
                    //flag1.setFill(Color.RED);
                    flagsSetUp(1,i);
                } else if (circles.get(i).equals(hiddenCircles.get(j))) {
                    //System.out.println("0");
                    //flag1.setFill(Color.WHITE);
                    flagsSetUp(0,i);
                }
            }
        }
        circles.clear();
        round += 1;
    }
}
