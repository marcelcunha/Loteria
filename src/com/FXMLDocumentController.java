/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Marcel
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private HBox titulo;

    @FXML
    private Pane dezenas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* Circle d1 = new Circle(8, Color.GRAY);
         Circle d2 = new Circle(8, Color.GRAY);
         Circle d3 = new Circle(8, Color.GRAY);
         Circle d4 = new Circle(8, Color.GRAY);
         Circle d5 = new Circle(8, Color.GRAY);
            
         dezenas.getChildren().addAll(d1,d2,d3,d4,d5);*/
       // ToggleGroup group = new ToggleGroup();
        
        for (int i = 0, j = 0; i < 60; i++) {
            if (i % 10 == 0) {
                j++;
            }

            ToggleButton button = new ToggleButton(Integer.toString(i + 1));
           // button.setToggleGroup(group);
            button.setLayoutX(50 * (i % 10));
            button.setLayoutY(50 * j);
            dezenas.getChildren().add(button);

            /*if(i%10==0)
             j++;
             StackPane sp = new StackPane();
             Circle dezena = new Circle(20, Color.LIGHTPINK);
             Label numero = new Label(Integer.toString(i+1));
            
            
            
             sp.getChildren().addAll(dezena, numero);
                  
             //numero.relocate(dezena.getCenterX(), dezena.getCenterY());
             dezenas.getChildren().add(sp);
            
             sp.setLayoutX((i%10)*50);
             sp.setLayoutY(j*50);*/
        }
    }

}
