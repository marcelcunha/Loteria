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
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Marcel
 */
public abstract class Volante {

    /*Número de equivalencia entre milímetros e a unidade de medida da API*/
    protected static final double ESCALA = 3;
    
    /*Altura do retangulo para marcação no bilhete*/
    protected static final double RETANGULO_ALTURA = 2 * ESCALA;
    
    /*Largura do retangulo para marcação no bilhete*/
    protected static final double RETANGULO_LARGURA = 4 * ESCALA;
    
    /*Distância horizontal entre um retângulo e outro*/
    protected static final double DISTANCIA_X = (2 * ESCALA) + RETANGULO_LARGURA;
   
    /*Distância vertival entre um retângulo e outro*/
    protected static final double DISTANCIA_Y = (ESCALA) + RETANGULO_ALTURA;
    
    /*Quantidade de jogos que pode ser feita por bilhete*/
    protected int JOGOS_POR_BILHETE;

    public Volante(int JOGOS_POR_CARTAO) {
        this.JOGOS_POR_BILHETE = JOGOS_POR_CARTAO;
    }
    
    /**
     * Preenche o pane com retangulos nas marcações indicadas, 
     * simulando o prrenchimento de um bilhete de loteria 
     * @param set
     * @param espacamento
     * @param pane 
     */
    private void preencheVolante(Set<Integer> set, double espacamento, Pane pane) {
        for (Integer i : set) {

            Rectangle r = new Rectangle(RETANGULO_LARGURA, RETANGULO_ALTURA, Color.BLACK);

            r.setLayoutX(DISTANCIA_X * (i % 10));
            r.setLayoutY((DISTANCIA_Y * Math.floor(i / 10)) + ESCALA * espacamento);

            pane.getChildren().add(r);
            // }
        }
    }
    
    /**
     * Envia para impressão 
     * @param esquerda
     * @param topo
     * @param pages 
     */
    private void imprimeVolante(double esquerda, double topo, List<Node> pages) {

        List<Printer> list = new ArrayList<>(Printer.getAllPrinters());

        Paper foto = PrintHelper.createPaper("foto", 100, 150, Units.MM);
        Printer p = list.get(1);

        PageLayout layout = p.createPageLayout(foto, PageOrientation.PORTRAIT, esquerda * ESCALA, 9 * ESCALA, topo * ESCALA, 10 * ESCALA);


        /*System.out.println(pageLayout.toString());*/
        PrinterJob job = PrinterJob.createPrinterJob(p);
        if (job != null) {
            //job.showPrintDialog(null);

            for (Node n : pages) {
                job.printPage(layout, n);
            }

            job.endJob();
        }
    }

    
    protected void geraVolantes(List<Set<Integer>> jogos, double espacamento, double esquerda, double topo) {
        List<Node> imprimir = new ArrayList<>();
        

        for (int i = 0; i < jogos.size(); i = i + JOGOS_POR_BILHETE) {
           Pane pane = new Pane();
           
           List<Set<Integer>> volante = jogos.subList(i,(i+1) == jogos.size()-JOGOS_POR_BILHETE?jogos.size()-1:i+JOGOS_POR_BILHETE );

            geraVolante(volante, espacamento, pane);

            imprimir.add(pane);
        }
        imprimeVolante(esquerda, topo, imprimir);
    }
    
    private void geraVolante(List<Set<Integer>> jogos, double espacamento, Pane pane){
        for(int i=0 ; i<JOGOS_POR_BILHETE; i++){
            preencheVolante(jogos.get(i), i * espacamento, pane);
        }
    }
}
