/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.exceptions;

/**
 *
 * @author Marcel
 */
public class TamanhoInvalidoException extends Exception {

    public TamanhoInvalidoException() {
        super("O Jogo informado não tem a quantidade de números corrta");
    }

    public TamanhoInvalidoException(String jogo) {
        super("O Jogo informado: [" + jogo + "] não tem a quantidade de números corrta");

    }

}
