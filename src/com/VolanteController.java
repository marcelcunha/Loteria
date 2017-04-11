/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.sun.javafx.print.PrintHelper;
import com.sun.javafx.print.Units;
import static java.lang.reflect.Array.set;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.collections.ObservableSet;
import javafx.print.Paper;

/**
 * FXML Controller class
 *
 * @author Marcel
 */
public class VolanteController implements Initializable {

    private static final int DEZ_QTD = 50;
    private static final double ESCALA = 3;
    private static final double RETANGULO_ALTURA = 2 * ESCALA;
    private static final double RETANGULO_LARGURA = 4 * ESCALA;
    private static final double DISTANCIA_X = (2 * ESCALA) + RETANGULO_LARGURA;
    private static final double DISTANCIA_Y = (ESCALA) + RETANGULO_ALTURA;

    // private static final int DEZ_QTD = 60;
    private boolean[] print = new boolean[DEZ_QTD];

    @FXML
    private Pane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 0; i < DEZ_QTD; i++) {
            print[i] = false;
        }

        print[5] = true;
        print[46] = true;
        print[45] = true;
        print[38] = true;
        print[9] = true;
        print[23] = true;

        preencheVolante(print);
        imprimirVolante();

    }

    private void imprimirVolante() {
        ObservableSet<Printer> set = Printer.getAllPrinters();
        List<Printer> lis = new ArrayList<>(set);

        Paper duplaSena = PrintHelper.createPaper("duplasena", 100, 150, Units.MM);
        Printer p = /*Printer.getDefaultPrinter();*/lis.get(1);
        PageLayout layout =   p.createPageLayout(duplaSena, PageOrientation.PORTRAIT,10.9*ESCALA, 9*ESCALA, 5.9*ESCALA, 10*ESCALA);
       

        /*System.out.println(pageLayout.toString());*/
        PrinterJob job = PrinterJob.createPrinterJob(p);
        if (job != null) {
            //job.showPrintDialog(null);
            
            boolean success = job.printPage(layout, pane);
            if (success) {
                job.endJob();
            }
        }
    }

    private void preencheVolante(double espacamento) {
        for (int i = 0, j = 0; i < DEZ_QTD; i++) {
            int mod = (i % 10);
            if (mod == 0) {
                j++;
            }
           // if (print[i]) {
                Rectangle r = new Rectangle(RETANGULO_LARGURA, RETANGULO_ALTURA, Color.BLACK);

                r.setLayoutX(DISTANCIA_X * mod);
                r.setLayoutY((DISTANCIA_Y+espacamento) * j);

                pane.getChildren().add(r);
           // }
        }
    }

}
