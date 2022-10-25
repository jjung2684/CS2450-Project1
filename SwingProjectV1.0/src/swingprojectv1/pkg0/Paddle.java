
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

    private static final int PADDLE_WIDTH = 20;
    private static final int PADDLE_HEIGHT=80;
    private int x = 0;
    private int y = 0;
    private int xSpeed = 5;
    private int ySpeed = 5;
    private PongPanel pongGame;
    private int yDirection = 0;
    Rectangle paddle;
    private final int userID;

    public Paddle(PongPanel pongGame, int x, int y,Color color, int userID) {
        this.x = x;
        this.y = y;
        //paddle= new Rectangle(x, y, 10,40);
        this.pongGame = pongGame;
        this.userID = userID;

    }
    public void move(){
	if (y+ySpeed>0&&y+ySpeed<pongGame.getHeight()-PADDLE_HEIGHT) {
            y=y+ySpeed;
        }
    
    }

    /*
    public void move()
    {
        paddle.y += yDirection;
          if (paddle.y <= 50) {
            //do nothing
            paddle.y = 50;
          }
          if ( paddle.y>= 260)
          {
              paddle.y = 260;
          }

    }*/
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
        //g.draw(paddle);
       g.fillRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);

    }
    
    public void keyPressed(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_W && userID == 1) {
            ySpeed=-6; // goes up
                        
	}
	if (e.getKeyCode() == KeyEvent.VK_S && userID == 1) {
            ySpeed=6;// goes down
                        
	}
	if (e.getKeyCode() == KeyEvent.VK_UP && userID == 2){
            ySpeed=-6; // goes up
                        
	}
	if (e.getKeyCode() == KeyEvent.VK_DOWN && userID == 2) {
            ySpeed=6; // goes down
                        
	}
    }
    public void keyReleased(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_W){
            ySpeed=0; // stops moving
                        
	}
	if (e.getKeyCode() == KeyEvent.VK_S){
            ySpeed=0;  // stops moving
                        
	}
	if (e.getKeyCode() == KeyEvent.VK_UP){
            ySpeed=0;  // stops moving
                        
	}
	if (e.getKeyCode() == KeyEvent.VK_DOWN){
            ySpeed=0;  // stops moving
                       
            }
    }

 
    public Rectangle getBounds() {
        return new Rectangle(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

  

}

