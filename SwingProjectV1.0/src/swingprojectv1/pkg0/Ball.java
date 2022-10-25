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

    private static final int BALL_RADIUS = 5;
    Rectangle ball;
    private int x = 0;
    private int y = 0;
    

    private JPanel pongGame;
    Paddle paddle_1 = new Paddle(pongGame, 160, 150,Color.WHITE);
    Paddle paddle_2 = new Paddle(pongGame, 430, 150, Color.WHITE);
    Image ballImg;
    Color color;
    private int xDirection;
    private int yDirection;

    public Ball(JPanel pongGame, int x, int y) {
        this.pongGame = pongGame;
        this.color = color;
        this.x = x;
        this.y = y;
        Random rand = new Random(); //creats Random numbers  
        int randDirection = rand.nextInt(1);
        if (randDirection == 0) {
            randDirection -= 2;
        }
        setXDir(randDirection);
        int yRandDir = rand.nextInt(1);
        if (yRandDir == 0) {
            yRandDir -= 2;
        }
        setYDir(yRandDir);
        ball = new Rectangle(x, y, 15, 15);
    }

    public void setXDir(int xDir) {
        xDirection = xDir;
    }

    //for set the yDirection of the ball  
    public void setYDir(int yDir) {
        yDirection = yDir;
    }

    public void move() {
        PaddleCollision();
//       
        ball.x += xDirection;
        ball.y += yDirection;
        //Bounce the ball when edge is detected  
        if (ball.x < 150) {
            setXDir(+2);
        }
        if (ball.x > 435) {
            setXDir(-2);
        }
        if (ball.y < 50) {
            setYDir(+2);
        }
        if (ball.y > 285) {
            setYDir(-2);
        }
    }

    public void PaddleCollision() {
        if (ball.intersects(paddle_2.paddle))
        {
            setXDir(-2);
        }
        if(ball.intersects(paddle_1.paddle))
        {
            setXDir(+2);
        }
    }

    public void draw(Graphics2D g) throws MalformedURLException, IOException {
        URL urlBall = new URL("https://res.cloudinary.com/dt2autub1/image/upload/v1666675995/assets/ball_f77fzi.png"); //get ball image from the project folder  
        ballImg = ImageIO.read(urlBall);
        g.setColor(color);
        g.drawImage(ballImg, this.ball.x, this.ball.y, null);
    }

}
