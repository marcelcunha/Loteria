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
public class MyException extends Exception {
    String msg;

    public MyException(String msg) {
     super(msg);
      this.msg = msg;
    }
    
    @Override
    public String getMessage(){
      return msg;
    }
    
    
}
