/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tombalaproject;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author GIGABYTE
 */
public class Bahar_Karakas_TombalaCard extends javax.swing.JFrame {

    /**
     * Creates new form TestForm
     */
    public Bahar_Karakas_TombalaCard() {
        initComponents();
    }
    
    
    public void setNumbers(Bahar_Karakas_TombalaLinkedList<Bahar_Karakas_TombalaNumber> list) {
        this.cardNumbers = list;
        
        
        Bahar_Karakas_LinkedNode<Bahar_Karakas_TombalaNumber> _currentNumber = this.cardNumbers.getHeadPointer();
        for(var i = 0; i < 27; i++) {
            
            Bahar_Karakas_CustomNumberButton button = new Bahar_Karakas_CustomNumberButton();
            
            button.setVisible(true);
            jPanel1.add(button);
            
            button.getButton().setText("");
            
  
            if(_currentNumber == null) {
                button.getButton().setEnabled(false);
                continue;
            }
            
            
            int indx = (i % 9)*10;
            
            if(_currentNumber.holdingData.number >= indx && _currentNumber.holdingData.number < indx+10) {
                button.getButton().setText(_currentNumber.holdingData.number + "");
                
                
                final Bahar_Karakas_TombalaNumber buttonNumber = _currentNumber.holdingData;
                buttonNumber.correspondingButton = button;
                _currentNumber = _currentNumber.next;
                
                button.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                if(!gameStarted || autoDraw) return;
                
                if(winner != null) {
                    JOptionPane.showMessageDialog(null, "This game has already ended, the winner is Player " + winner.name + ". To start a new game you must draw a new tombala card.");
                    return;
                }
                
                buttonNumber.correspondingButton.getButton().setBackground(Color.red);

                
                buttonNumber.correspondingButton = button;
                buttonNumber.isChecked = !buttonNumber.isChecked;
                
                checkStatus();
            }
        });
            } else {
                button.getButton().setEnabled(false);
                button.setSize(100, 100);
            }
        }
  
                
                GridLayout layout = new GridLayout(3, 9);
     
       jPanel1.setLayout(layout);
    }
    
    public boolean gameStarted, autoDraw;
    
    public int name;
    public void setPlayerName(int name ){
        this.name = name;
        jLabel1.setText("Player " + name);
    }
    
    public void onDraw(int number) {
        Bahar_Karakas_LinkedNode<Bahar_Karakas_TombalaNumber> head = cardNumbers.getHeadPointer();
        while(head.next != null && head.holdingData.number != number) {
               System.out.println(head.holdingData.number);
            head = head.next;
         
        }

        if(head.holdingData.number == number) {
            head.holdingData.isChecked = true;
            head.holdingData.correspondingButton.getButton().setBackground(Color.red);
            
            checkStatus();
        }
    }

   
    
    
    
    Bahar_Karakas_TombalaCard winner;
    
    public void setWinner(Bahar_Karakas_TombalaCard winner) {
        this.winner = winner;
        
        jLabel3.setText(winner.equals(this)?"You won!":("Player " + winner.name + " won this round."));
         
        
        if(winner.equals(this))JOptionPane.showMessageDialog(this, "Tombala! You won!");
    }
    
    public void checkStatus() {
        int cinkoCount = 0;
        
        Bahar_Karakas_LinkedNode<Bahar_Karakas_TombalaNumber> headNumber = cardNumbers.getHeadPointer();
        boolean foundNeeded = false;
        for(int i = 0; i < 15; i++) {
            System.out.println("Index: " + i + " is " + headNumber.holdingData.isChecked);
            if(!headNumber.holdingData.isChecked) foundNeeded = true;
            
            if((i+1) % 5 == 0) {
                
                
                Bahar_Karakas_LinkedNode<Bahar_Karakas_TombalaNumber> cinkoBack = headNumber;
                for(int x = 0; x < 5; x++) {
                    cinkoBack.holdingData.correspondingButton.getButton().setBackground(foundNeeded?(cinkoBack.holdingData.isChecked?Color.red:null):Color.yellow);
                    cinkoBack = cinkoBack.prev;
                }
                
                
                if(!foundNeeded) {
                cinkoCount++;
                
                
                } else foundNeeded = false;
            }
            
            headNumber = headNumber.next;
        }
        
        if(cinkoCount >= 3) {
            jLabel2.setText("Tombala!");
            
            onWinAction.onPlayerDispose();
        } else {
            jLabel2.setText(cinkoCount > 0?(cinkoCount + ". Çinko!"):"");
        } 
    }
    
    
    Bahar_Karakas_OnDispose disposeCallback;
    public void setDisposeCallback(Bahar_Karakas_OnDispose disposeCallback) {
           this.disposeCallback = disposeCallback;
    }
    
    public Bahar_Karakas_TombalaLinkedList<Bahar_Karakas_TombalaNumber> cardNumbers;

    @Override
    public void dispose() {
        super.dispose();
        
        disposeCallback.onPlayerDispose();
        
    }
    
    
    Bahar_Karakas_OnDispose onWinAction;
    public void setOnWinAction(Bahar_Karakas_OnDispose onWinAction) {
           this.onWinAction = onWinAction;
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(450, 238));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Oyuncu 1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(jLabel2)
                    .addContainerGap(246, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}



