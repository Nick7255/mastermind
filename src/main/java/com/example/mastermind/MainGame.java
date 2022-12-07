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
    public ArrayList<Color> circles = new ArrayList<Color>();
    public ArrayList<Color> hiddenCircles=new ArrayList<Color>();

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
        if (circles.size() < 4) {
            circle.setFill(color);
            circle.setDisable(true);
            circles.add((Color) circle.getFill());
        }
        if (circles.size() == 4) {
            System.out.println("4 circles complete");
        }
        Label scoreText = new Label();
        Label roundText = new Label();
        int sum = 0, count = 0;

    }
    public static ArrayList getRandomNonRepeatingIntegers(int size, int min, int max) {
       ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random random = new Random();
        while (numbers.size() < size) {
            int randomNumber = random.nextInt((max - min) + 1) + min;
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
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
                {flag9,flag10,flag11,flag12},
                {flag13,flag14,flag15,flag16},
                {flag17,flag18,flag19,flag20},
                {flag21,flag22,flag23,flag24},
                {flag25,flag26,flag27,flag28},
                {flag29,flag30,flag31,flag32},
                {flag33,flag34,flag35,flag36},
                {flag37,flag38,flag39,flag40}};

        for (Circle circleHidden : Arrays.asList(hiddenCircle1, hiddenCircle2, hiddenCircle3, hiddenCircle4)) {
            int num = (int) list.get(y);
            current = colorsarray.get(num);
            circleHidden.setFill(current);
            hiddenCircles.add((Color) circleHidden.getFill());
            y = y+1;
            num = 0;
            screen.setOpacity(1);
            secretcodetext.setOpacity(1);
        }
        setGameButton.setOpacity(0);
    }


    public int round= 0;

    private void flagsSetUp(int colorExist,int idx){
        if (colorExist == 0){
            flags[round][idx].setFill(Color.WHITE);
        }
       if (colorExist == 1){
           flags[round][idx].setFill(Color.RED);
       }
    }


    //ta flags doulevoun pleon alla o paixtis prepei na vazei xrwma stous kuklous anagkastika me thn seira alliws sto array mpainoun mperdemena
    //px an kserw oti to kitrino einai deutero kai valw prwta auto kai meta allaksw xrwma ston prwto kyklo tote sto array tha mpei
    //oti o prwtos kyklos einai kitrinos anti na mpei oti prwta einai o mple kai meta o kitrinos

    public void Submit (ActionEvent event) {
        System.out.println(hiddenCircles+"    "+circles);
        int idx = 0;
        for (int i=0; i<circles.size(); i++){
            for (int j=0; j<hiddenCircles.size(); j++) {
                if (circles.get(i) == hiddenCircles.get(j) && i == j) {
                    flagsSetUp(1, idx);
                    idx = idx + 1;
                } else if (circles.get(i) == hiddenCircles.get(j)){
                    flagsSetUp(0, idx);
                    idx = idx + 1;
                } else System.out.println("nothing");
            }
        }
        circles.clear();
        round += 1;
    }
}
