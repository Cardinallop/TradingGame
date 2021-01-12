/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m3.tradingGame.service;

/**
 *
 * @author brockpace
 */
public class UserDataValidationException extends Exception{
    
    public UserDataValidationException(String message) {
        super(message);
    }
    
    public UserDataValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
