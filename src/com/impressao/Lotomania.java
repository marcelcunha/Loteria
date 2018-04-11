/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impressao;

import java.util.List;
import java.util.Set;

/**
 *
 * @author Marcel
 */
public class Lotomania extends Volante{
     private static final int MAX_DEZENAS = 100;
    private static final double ESPACAMENTO = 23;
    private static final double ESQUERDA = 10.9;
    private static final double TOPO = 5.9;
    
    public static int getMAX_DEZENAS() {
        return MAX_DEZENAS;
    }

    public Lotomania() {
        super(1);
    }

    public void geraVolantes(List<Set<Integer>> jogos) {
        super.geraVolantes(jogos, ESPACAMENTO, ESQUERDA, TOPO); 
    }
}
