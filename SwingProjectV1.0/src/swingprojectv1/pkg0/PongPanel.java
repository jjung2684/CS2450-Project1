package swingprojectv1.pkg0;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private EndScreenPanel endScreen;
    private boolean startBool = false;
    private JLabel startLabel;
    Ball ball;
    Paddle paddle_1, paddle_2;
    Thread thread;
    

    public PongPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setFocusable(true);
        this.requestFocus();
        initComponents();
        setLayout(new BorderLayout());
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "Start");

        this.getActionMap().put("Start", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                startGame();
                startLabel.setVisible(false);
            }
        });

    }

    private void initComponents() {

        // create pong game panel
        pongGamePanel = new JPanel();
        pongGamePanel.setBounds(150, 50, 300, 250);
        System.out.println(pongGamePanel.getWidth());
        pongGamePanel.setBackground(Color.BLACK);
        add(pongGamePanel);
        ball = new Ball(this, 300, 175);
        paddle_1 = new Paddle(this, 160, 150, Color.WHITE);
        paddle_2 = new Paddle( this, 430, 150,Color.WHITE);
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
        thread = new Thread(this);

    }

//    public Dimension getPreferredSize() {
//        return new Dimension(600, 400);
//    }
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

    public void startGame() {
        thread.start();
    }

    public void quitGame() throws IOException {
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
        Graphics2D g2d = (Graphics2D) g;
        try {
            ball.draw(g2d);
        } catch (IOException ex) {
            Logger.getLogger(PongPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        paddle_1.draw(g2d);
        paddle_2.draw(g2d);

    }
    
    public void movePaddle_1(){
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_W,0),"UP");
        this.getActionMap().put("UP", new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
//                paddle_1.moveUp(paddle_1);
                paddle_1.setYDir(-2);
                                

                System.out.println("UP");
                
            }
        });
         this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_S,0),"DW");
        this.getActionMap().put("DW", new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
//                paddle_1.moveDW(paddle_1);
                paddle_1.setYDir(+2);
                
            }
        });
        paddle_1.move();

        
    }
    public void movePaddle_2(){
                 this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_UP,0),"UP_2");
        this.getActionMap().put("UP_2", new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
//                paddle_2.moveUp(paddle_2);
                paddle_2.setYDir(-2);
            }
        });
         this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0),"DW_2");
        this.getActionMap().put("DW", new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
//                paddle_2.moveDW(paddle_2);
                                paddle_2.setYDir(+2);

            }
        });
        paddle_2.move();
    }

    public void run() {
        System.out.println("Running");
        while (true) {
            ball.move();
            movePaddle_1();
            movePaddle_2();
            
//            paddle_1.move();
//            paddle_2.move();
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    
}
