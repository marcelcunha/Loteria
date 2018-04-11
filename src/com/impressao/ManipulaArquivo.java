/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impressao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel
 */
public class ManipulaArquivo {

    private List<Set<Integer>> jogos = null;
    private int tamanho;

    public List<Set<Integer>> carregaLista(File file) {

        try (
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);) {
            jogos = new ArrayList<>();

            while (br.ready()) {
                jogos.add(
                        ajustaEvalidaJogo(
                                br.readLine()));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManipulaArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {

        }
        return jogos;
    }

    private Set<Integer> ajustaEvalidaJogo(String numeros) {
        Set<Integer> set = new TreeSet<>();
        
        for (String s : numeros.split(" ")) {
            Integer dezena = Integer.parseInt(s);

            set.add(dezena);
        }

        return set;
    }
    
   
}
