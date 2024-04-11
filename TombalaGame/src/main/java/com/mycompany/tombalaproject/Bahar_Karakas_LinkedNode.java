/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tombalaproject;

import java.awt.Point;

/**
 *
 * @author GIGABYTE
 */
public class Bahar_Karakas_LinkedNode<T> {

    Bahar_Karakas_LinkedNode<T> prev;
    
    LinkedNode<T> next, down;
    T holdingData;

    public Bahar_Karakas_LinkedNode(T holdingData) {
        this.holdingData = holdingData;
    }
}
