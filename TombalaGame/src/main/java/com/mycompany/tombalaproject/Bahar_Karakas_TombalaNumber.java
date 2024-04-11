/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tombalaproject;

import java.awt.Point;
import javax.swing.JButton;

/**
 *
 * @author GIGABYTE
 */
public class Bahar_Karakas_TombalaNumber {
    
    public int number;
    public Bahar_Karakas_CustomNumberButton correspondingButton;
    public boolean isChecked;
    
    public Bahar_Karakas_TombalaNumber(int number) {
        this.number = number;
    }
    
    
     @Override
    public boolean equals(Object obj) {
        if(obj instanceof Integer)
            return ((int)obj) == number;
        
        if(obj instanceof Bahar_Karakas_TombalaNumber)
            return ((Bahar_Karakas_TombalaNumber)obj).number == number;
        
        return super.equals(obj);
        
    }
   
}
