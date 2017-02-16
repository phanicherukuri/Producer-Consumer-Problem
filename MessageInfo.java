/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package producerconsumer;

import java.io.Serializable;

/**
 *
 * @author Phani
 */
public class MessageInfo implements Serializable{
    public static volatile String operation; 
    public static volatile int value;   
    //variables is declare as volatile because they need to be changed by two threads

}
