/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impressao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 *
 * @author Marcel
 */
public class DuplaSena extends Volante {
    /**/
    private static final int MAX_DEZENAS = 50;
    private static final double ESPACAMENTO = 23;
    private static final double ESQUERDA = 10.9;
    private static final double TOPO = 5.9;
    
    public static int getMAX_DEZENAS() {
        return MAX_DEZENAS;
    }

    public DuplaSena(int JOGOS_POR_CARTAO) {
        super(JOGOS_POR_CARTAO);
    }

    public DuplaSena() {
        super(2);
    }

    public void geraVolantes(List<Set<Integer>> jogos) {
        super.geraVolantes(jogos, ESPACAMENTO, ESQUERDA, TOPO); 
    }
    
    
}
