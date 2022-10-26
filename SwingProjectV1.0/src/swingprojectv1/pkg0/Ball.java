/** *************************************************************
 *  file: Ball.class
 *  author: Jacob Jung & Co.
 *  class: CS   2450.01
 *
 *  assignment: Project 1.3
 *  date last modified: 10/21/2021
 *
 *  purpose: This class implements a ball for pong game.
 *
 *************************************************************** */
package swingprojectv1.pkg0;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Ball {

    private static final int RADIUS=10;
    private int x=0;
    private int y=0;
    private int xspeed=0;
    private int yspeed=0;
    private PongPanel game;
    Color color;
    private int xDirection;
    private int yDirection;
    Rectangle ball;
    int s1, s2;


    public Ball(PongPanel game, Color color, int x, int y) {
        this.game = game;
        this.color = color;
	this.x = x;
        this.y = y;
        s1 = game.ps.getP1();
        s2 = game.ps.getP2();

        
        Random rand = new Random(); //creats Random numbers  
        int randDirection = rand.nextInt(10);
        if (randDirection < 5) {
            xspeed -= 3;
        }else{
            xspeed = 3;
        }
//        setXDir(xspeed);
        int yRandDir = rand.nextInt(10);
        if (yRandDir > 5 ) {
            yspeed -= 3;
        }else{
            yspeed = 3;
        }
//        setYDir(yspeed);
	ball = new Rectangle(x, y, RADIUS*2, RADIUS*2);
        
    }

    public void setXDir(int xDir) {
        xDirection = xDir;
    }

    //for set the yDirection of the ball  
    public void setYDir(int yDir) {
        yDirection = yDir;
    }

    public void move() throws IOException {
	if (x+xspeed<150) {
            game.ps.setP2(s2 += 10);
            if(s2 == 100)
            {
                game.endGame(2, s2);
            }
            else{
                 game.resetGame();
            }
           
	}
	if (x+xspeed>435) {
            game.ps.setP1(s1 += 10);
            if(s1 == 100)
            {
                game.endGame(1, s1);
            }else{
		game.resetGame();
            }

        }
	if (y+yspeed<50) {
		yspeed=4;
	}
		
	if (y+yspeed>=285) {
		yspeed=-4;
	}
        
	if (isCollision()) {
		xspeed=-xspeed;
	}
	x=x+xspeed;
	y=y+yspeed;
    }

    	
    private boolean isCollision() {
        return game.paddle_1.getBounds().intersects(getBounds())
        || game.paddle_2.getBounds().intersects(getBounds());
    
    }
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x, y, 2*RADIUS, 2*RADIUS);
    }
    
    public Rectangle getBounds() {
	return new Rectangle(x, y, 2*RADIUS, 2*RADIUS);
    }

}