/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingprojectv1.pkg0;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author spencer
 */
public class Paddle{

    private static int PADDLE_WIDTH = 20;
    private int x = 0;
    private int y = 0;
    private int xSpeed = 5;
    private int ySpeed = 5;
    private JPanel pongGame;
    Color color;

    public Paddle(JPanel pongGame, int x, int y, Color color) {
        this.pongGame = pongGame;
        this.color = color;
        this.x = x;
        this.y = y;
        
       
        pongGame.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });
        
        
    }
    
    public void move(Paddle paddle){
        
        
    }
    
     public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x, y, 10, PADDLE_WIDTH* 2);
       
    }
     
     public void addBindings(){
         InputMap inputMap = pongGame.getInputMap();
         KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_W, Event.KEY_PRESS);
         
     }
     
     public void addActions(){
         ActionMap actionMap = pongGame.getActionMap();         
     }
     
     

    

}
