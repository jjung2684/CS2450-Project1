package swingprojectv1.pkg0;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    private JLabel clockLabel;
    private JPanel pongGamePanel;
    private EndScreenPanel endScreen;
    Ball ball;
    Thread thread;
    
    public PongPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        setLayout(new BorderLayout());
        
    }
    
    private void initComponents() {
        ball = new Ball(this, 300, 175, Color.WHITE);
        // create pong game panel
        pongGamePanel = new JPanel();
        pongGamePanel.setBounds(150, 50, 300, 250);
        pongGamePanel.setBackground(Color.BLACK);
        add(pongGamePanel);
        
        // add buttons
        quitButton = new JButton("Quit");
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
        thread = new Thread(this);
        thread.start();
    }

    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
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
        
        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.setColor(Color.black);
        g2.drawString("Player 2 Score: ", 470, 100);
    }
    
    private void time() {
        clockLabel.setText(DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM).format(new Date()));
    }
    
    public void quitGame() throws IOException {
//        this.mainFrame.remove(this);
//        this.endScreen = new EndScreenPanel(null, this.mainFrame, 0, "Game Over!");
//        this.mainFrame.add(this.endScreen);
//        this.endScreen.setVisible(true);
//
//        this.mainFrame.repaint();
//        this.mainFrame.revalidate();

        mainFrame.remove(this);
        mainFrame.repaint();
        this.revalidate();
        this.mainFrame.reAddHomePanel(mainFrame, this);
        
    }

    private void move() {
	    ball.move();
        
    }
	
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;
        ball.draw(g2d);
        
    }

    public void run() {
        while(true) {
            ball.move();
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}