/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingprojectv1.pkg0;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private int yDirection = 0;
    Rectangle paddle;

    public Paddle(JPanel pongGame, int x, int y,Color color) {
        this.x = x;
        this.y = y;
        paddle= new Rectangle(x, y, 10,40);




    }
    


    
    public void move()
    {
        paddle.y += yDirection;
          if (this.y <= 50) {
            //do nothing
            this.y = 50;
          }
          if ( this.y>= 260)
          {
              this.y = 260;
          }

    }
//
//    public void moveUp(Paddle paddle) {
//        if (paddle.y <= 50) {
//            //do
//            paddle.y = 50;
//
//        } else {
//            paddle.y -= 5;
//        }
//
//    }
//    public void moveDW(Paddle paddle) {
//        if (paddle.y >= 260) {
//            //do nothing
//
//        } else {
//            paddle.y += 5;
//        }
//
//    }
//    
    public void setYDir(int dir){
        yDirection = dir;
    }
//    

    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.draw(paddle);
//        g.fillRect(x, y, 10, PADDLE_WIDTH * 2);

    }

 


  

}

