/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.impressao.ManipulaArquivo;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.stage.FileChooser;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Marcel
 */
public class ImpressaoController implements Initializable {

    @FXML
    private TextField pathTF;

    @FXML
    private Button srcBTN;

    @FXML
    private ListView<Set<Integer>> jogosLV;
    
    @FXML
    private CheckBox selecTodosCKB;

    private ObservableList<Set<Integer>> oList;

    private List<Set<Integer>> escolhidos;

    @FXML
    void cancelarButtonAction(ActionEvent event) {

    }

    @FXML
    void carregaArquivoButtonAction(ActionEvent event) {
        FileChooser fc = new FileChooser();
        ManipulaArquivo ma = new ManipulaArquivo();

        fc.getExtensionFilters().addAll(getEFilter());
        File file = fc.showOpenDialog(null);

        if (file != null) {

            pathTF.setText(file.getPath());
            oList = FXCollections.observableList(
                    ma.carregaLista(file));
        }

        jogosLV.setItems(oList);
        selecTodosCKB.setDisable(false);
         jogosLV.getSelectionModel().selectAll();
    }

    @FXML
    void imprimirButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        escolhidos = new LinkedList<>();
        jogosLV.setCellFactory(
                CheckBoxListCell.forListView(geraListCell()));
        
        
         
        selecTodosCKB.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(oldValue)
                    jogosLV.getSelectionModel().clearSelection();
                else
                    jogosLV.getSelectionModel().selectAll();
            }
        });
    }

    private List<FileChooser.ExtensionFilter> getEFilter() {
        List<FileChooser.ExtensionFilter> list = new LinkedList<>();

        list.add(new FileChooser.ExtensionFilter("Arquivo de Texto", "*.txt"));
        list.add(new FileChooser.ExtensionFilter("Todos Arquivos", "*.*"));

        return list;
    }

    private Callback<Set<Integer>, ObservableValue<Boolean>> geraListCell() {
        return (Set<Integer> param) -> {
            BooleanProperty property = new SimpleBooleanProperty();
            
            property.addListener(
                    (ObservableValue<? extends Boolean> observable1, Boolean oldValue, Boolean newValue) -> {
                        if (newValue == true) {
                            escolhidos.add(param);
                        } else {
                            escolhidos.remove(param);
                        }
                    });
            return property;
        };
    }

}