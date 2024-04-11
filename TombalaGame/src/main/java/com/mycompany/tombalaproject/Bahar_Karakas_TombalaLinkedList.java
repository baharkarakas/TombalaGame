/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tombalaproject;

/**
 *
 * @author GIGABYTE
 */
public class Bahar_Karakas_TombalaLinkedList<T> {
     private Bahar_Karakas_LinkedNode<T> headPointer;
    private int currentSize;

    public int getSize() {
        return currentSize;
    }
    
    public Bahar_Karakas_LinkedNode<T> getHeadPointer() {
        return headPointer;
    }

    public void pushToTop(T dataToPush) {
        Bahar_Karakas_LinkedNode<T> incNode = new Bahar_Karakas_LinkedNode<>(dataToPush);
        if (currentSize == 0) headPointer = incNode;
        else {
            incNode.next = headPointer;
            headPointer.prev = incNode;
            headPointer = incNode;
        }
        
        currentSize++;
    }

    public void addToList(T dataToAdd) {

        Bahar_Karakas_LinkedNode<T> newNode = new Bahar_Karakas_LinkedNode<>(dataToAdd);
        if (currentSize == 0) {
            headPointer = newNode;
            currentSize++;
            return;
        }

        Bahar_Karakas_LinkedNode<T> _currentPointer = headPointer;
        while (_currentPointer.next != null) _currentPointer = _currentPointer.next;
        

        _currentPointer.next = newNode;
        newNode.prev = _currentPointer;
        currentSize++;
    }

    public T getLastElement() {

        if (currentSize == 0) return null;

        Bahar_Karakas_LinkedNode<T> _currPointer = headPointer;
        while (_currPointer.next != null) {
            _currPointer = _currPointer.next;
        }

        return _currPointer.holdingData;
    }

  

    public T getAt(int index) {

        if (index < 0 || currentSize-1 < index) throw new IndexOutOfBoundsException();
        

        Bahar_Karakas_LinkedNode<T> _currPointer = headPointer;
        for (int i = 0; i < index; i++) {
            _currPointer = _currPointer.next;
        }

        return _currPointer.holdingData;
    }
    
    public void replaceElement(int index, T data) {
        if (index < 0 || currentSize-1 < index) throw new IndexOutOfBoundsException();
        

        Bahar_Karakas_LinkedNode<T> _currPointer = headPointer;
        for (int i = 0; i < index; i++) {
            _currPointer = _currPointer.next;
        }

        
        _currPointer.holdingData = data;
    }
    
    public void removeFromList(T element) {
        Bahar_Karakas_LinkedNode<T> _currPointer = headPointer;
        while(_currPointer.next != null && !_currPointer.holdingData.equals(element)) {
            _currPointer = _currPointer.next;
        }
        
        
        if(_currPointer.holdingData.equals(element)) {
            
            if(headPointer.equals(_currPointer)) {
                headPointer = _currPointer;
            }
            
            if(_currPointer.next != null) _currPointer.next.prev = _currPointer.prev;
            if(_currPointer.prev != null) _currPointer.prev.next = _currPointer.next;
            
            currentSize--;
        }
    }

  
    public boolean contains(T data) {
        Bahar_Karakas_LinkedNode<T> _currPointer = headPointer;
        while (_currPointer != null) {
            if (_currPointer.holdingData.equals(data)) {
                return true;
            }
            _currPointer = _currPointer.next;
        }
        return false;
    }

}
