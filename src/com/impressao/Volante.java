/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impressao;

import com.sun.javafx.print.PrintHelper;
import com.sun.javafx.print.Units;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Marcel
 */
public abstract class Volante {

    protected List<Set<Integer>> jogos;

    protected int QTD_DEZENAS;
    protected static final double ESCALA = 3;
    protected static final double RETANGULO_ALTURA = 2 * ESCALA;
    protected static final double RETANGULO_LARGURA = 4 * ESCALA;
    protected static final double DISTANCIA_X = (2 * ESCALA) + RETANGULO_LARGURA;
    protected static final double DISTANCIA_Y = (ESCALA) + RETANGULO_ALTURA;

    protected Pane pane = new Pane();

    public Volante(List<Set<Integer>> jogos) {
        this.jogos = jogos;
        this.QTD_DEZENAS = jogos.size();
    }

    protected void preencheVolante(double espacamento) {
        for (int i = 0, j = 0; i < QTD_DEZENAS; i++) {
            int mod = (i % 10);
            if (mod == 0) {
                j++;
            }
            
            Rectangle r = new Rectangle(RETANGULO_LARGURA, RETANGULO_ALTURA, Color.BLACK);

            r.setLayoutX(DISTANCIA_X * mod);
            r.setLayoutY((DISTANCIA_Y + espacamento) * j);

            pane.getChildren().add(r);
            // }
        }
    }

    protected void imprimeVolante(double esquerda, double topo) {

        List<Printer> list = new ArrayList<>(Printer.getAllPrinters());

        Paper foto = PrintHelper.createPaper("foto", 100, 150, Units.MM);
        Printer p = list.get(1);
        PageLayout layout = p.createPageLayout(foto, PageOrientation.PORTRAIT, esquerda * ESCALA, 9 * ESCALA, topo * ESCALA, 10 * ESCALA);


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

    protected abstract void criaVolante(int numJogos);
}
