package swingprojectv1.pkg0;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 * *************************************************************
 * file: PingPongPanel.class author: Tommy James & Co. class: CS 2450.01
 *
 * assignment: Project 1.2 date last modified: 10/09/22
 *
 * purpose: This class creates the panel for Ping Pong
 *
 ***************************************************************
 */
public class PongPanel extends JPanel implements Runnable {

    private MainFrame mainFrame;
    private JButton quitButton;
    private JButton startButton;
    private JLabel clockLabel;
    private JPanel pongGamePanel;
    private boolean exit;
    private PongPanel pong;
    private EndScreenPanel endScreen;
    private boolean startBool = false;
    private JLabel startLabel;
    Ball ball;
    Paddle paddle_1, paddle_2;
    Thread thread;
    PongScore ps;

    public PongPanel(MainFrame mainFrame, PongScore ps) {
        this.mainFrame = mainFrame;
        this.ps = ps;

        this.setFocusable(true);

        initComponents();
        setLayout(new BorderLayout());
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "Start");
        
        this.getActionMap().put("Start", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(!startBool){
                startGame();
                startLabel.setVisible(false);
                
                }
                
                
            }
        });
        
        
        this.addKeyListener(new AL());

    }

    private void initComponents() {

        // create pong game panel
        pongGamePanel = new JPanel();
        pongGamePanel.setBounds(150, 50, 300, 250);
        pongGamePanel.setBackground(Color.BLACK);
        add(pongGamePanel);

        ball = new Ball(this, Color.WHITE, 300, 175);
        paddle_1 = new Paddle(this, 150, 150, Color.CYAN, 1);
        paddle_2 = new Paddle(this, 430, 150, Color.RED, 2);

        // add buttons
        quitButton = new JButton("Quit");
        startLabel = new JLabel("Press Space to start!");
        startLabel.setBounds(250, 325, 200, 25);
        add(startLabel);
        quitButton.setBounds(480, 325, 80, 20);
        quitButton.setToolTipText("Quit game and go back to home screen.");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    quitGame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        add(quitButton);

        // add clock
        Timer timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                time();
            }
        });

        clockLabel = new JLabel();
        clockLabel.setBounds(390, 5, 250, 22);
        add(clockLabel);

        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();

        time();

        this.requestFocusInWindow();
        exit = false;

        thread = new Thread(this);
        this.requestFocusInWindow();

    }

  
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);

        g2.setFont(new Font("Brush Script MT", Font.BOLD, 36));
        g2.setColor(Color.orange);
        g2.drawString("Pong", 10, 30);

        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.setColor(Color.black);
        g2.drawString("Player 1 Score: ", 10, 100);

        g2.setFont(new Font("Arial", Font.BOLD, 25));
        g2.drawString(Integer.toString(ps.getP1()), 60, 140);
        g2.drawString(Integer.toString(ps.getP2()), 520, 140);

        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.setColor(Color.black);
        g2.drawString("Player 2 Score: ", 470, 100);
    }

    private void time() {
        clockLabel.setText(DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM).format(new Date()));
    }

    public void startGame() {
        thread.start();
        startBool = true;
        
    }

    public void quitGame() throws IOException {
        mainFrame.remove(this);
        mainFrame.repaint();
        this.revalidate();
        this.mainFrame.reAddHomePanel(mainFrame, this);

    }

    public void resetGame() {
        exit = true;
        System.out.println("Player 1 score: " + ps.getP1() + "\nPlayer 2 score: " + ps.getP2());
        this.mainFrame.remove(this);
        this.pong = new PongPanel(this.mainFrame, ps);
        this.mainFrame.add(pong);

        this.mainFrame.repaint();
        this.mainFrame.revalidate();

    }

    
    public void endGame(int winnerID, int winnerScore) throws IOException
    {
        exit = true;
        this.mainFrame.remove(this);
        this.endScreen = new EndScreenPanel(this.mainFrame, winnerScore, winnerID, "Congrats!");
        this.mainFrame.add(this.endScreen);
        this.mainFrame.repaint();
        this.mainFrame.revalidate();
        
        
    }

    private void move() throws IOException {
        ball.move();
        paddle_1.move();
        paddle_2.move();

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        ball.draw(g2d);
        paddle_1.draw(g2d);
        paddle_2.draw(g2d);

    }

    public void run() {
        System.out.println("Running");
        while (!exit) {
            try {
                move();                
                repaint();
               
            } catch (IOException ex) {
                Logger.getLogger(PongPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public class AL extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            paddle_1.keyPressed(e);
            paddle_2.keyPressed(e);

        }

        public void keyReleased(KeyEvent e) {
            paddle_1.keyReleased(e);
            paddle_2.keyReleased(e);

        }
    }

}
