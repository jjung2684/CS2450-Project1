/***************************************************************  
*  file: Ball.class 
*  author: Jacob Jung & Co.
*  class: CS   2450.01
*  
*  assignment: Project 1.3  
*  date last modified: 10/21/2021
*  
*  purpose: This class implements a ball for pong game.
*  
****************************************************************/  
package swingprojectv1.pkg0;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Ball {
    
    private static final int BALL_RADIUS = 5;
    private int x=0;
    private int y=0;
    private int xSpeed=5;
    private int ySpeed=5;
    private JPanel pongGame;
    Color color;
    
    public Ball (JPanel pongGame, int x, int y, Color color) {
        this.pongGame = pongGame;
        this.color = color;
        this.x = x;
        this.y = y;
    }
    
    public void move() {
        int pgWidth = pongGame.getWidth() + 150;
        int pgHeight = pongGame.getHeight() + 50;
        if (x + xSpeed < 150) {
            xSpeed = 5;
        }
        if (x + xSpeed > pgWidth - 2*BALL_RADIUS) {
            xSpeed = -5;
        }
		
        if (y + ySpeed < 50) {
            ySpeed = 5;
        }
		
        if (y + ySpeed > pgHeight - 2*BALL_RADIUS) {
            ySpeed = -5;
        }
        
        
      
        x = x + xSpeed;
        y = y + ySpeed;
    }
    
   
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x, y, 2*BALL_RADIUS, 2*BALL_RADIUS);
    }

}
