/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Marcel
 */
public class MainController implements Initializable {

    @FXML
    private TextField entradaTF;

    @FXML
    private Button arquivoBTN;

    @FXML
    private ChoiceBox<String> tipoCCB;

    @FXML
    private Button acaoBTN;
    
    private ObservableList<String> oList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       oList.addAll("Mega-Sena","Quina", "Dupla-Sena", "Lotomania", "Loteca", "Lotofacil" );
       
       tipoCCB.setItems(oList);
    }
}
