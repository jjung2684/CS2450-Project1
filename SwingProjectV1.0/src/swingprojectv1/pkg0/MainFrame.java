/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingprojectv1.pkg0;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author barre
 */
public class MainFrame extends Frame implements WindowListener, ActionListener {

    SplashPanel sp;
    HomePanel hp;
    HangmanPanel hangmanPanel;
    EndScreenPanel endScreen;

    public MainFrame(String title) {
        addWindowListener(this);
        pack();
        setLocationRelativeTo(null);
        setTitle(title);

    }

    // Displays Splash screen 
    public void addSplashPanel() throws IOException {
        sp = new SplashPanel("..\\Assets\\Splash.jpg");
        sp.setForeground(Color.WHITE);
        sp.getPreferredSize();
        add(sp);
        sp.setVisible(true);

    }

    // Displays the home screen
    public void addHomePanel(Frame mainFrame) throws IOException {
        hp = new HomePanel("..\\Assets\\homeGif.gif", this);
        hp.getPreferredSize();
        add(hp);
        hp.setVisible(true);
        this.repaint();
        this.revalidate();
    }
    
    public void reAddHomePanel(Frame mainFrame) throws IOException {
        
        this.remove(hangmanPanel);
        this.addHomePanel(mainFrame);
        this.hangmanPanel = null;
    }
    
    public void addGameScreen() throws IOException {
        this.remove(hp);
       hangmanPanel = new HangmanPanel(null, this); // Add image path where null is
       hangmanPanel.getPreferredSize();
       add(hangmanPanel);
       hangmanPanel.setVisible(true);
       this.repaint();
       this.revalidate();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Active");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Deactived");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

class SplashPanel extends JPanel {

    private Image backgroundImg;

    public SplashPanel(String fileName) throws IOException {
        backgroundImg = ImageIO.read(new File(fileName));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set font
        Font titleFont = new Font("Sans-Serif", Font.BOLD, 50);
        Font creditsFont = new Font("Sans-Serif", Font.BOLD, 16);
        
        // Create Rectangles to 'house' Strings
        Rectangle titleRect = new Rectangle(200, 10, 200, 100);
        Rectangle creditsRect = new Rectangle(450, 300, 50, 25);

        g.drawImage(backgroundImg, 0, 0, 600, 400, this);
        drawCenteredString(g, "By: CPP GUI", creditsRect, creditsFont);
        drawCenteredString(g, "CS 2450 Project V1.0", titleRect, titleFont);

    }

    // Method to center string within rectangles
    public void drawCenteredString(Graphics g, String content, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(content)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(content, x, y);
    }
}

class HomePanel extends JPanel {

    private HangmanPanel gameScreen;
    private final MainFrame mainFrame;
    
    public HomePanel(String fileName, MainFrame mainFrame) {

        // CTS - needed so that future screens can access the main one without creating a new screen
        this.mainFrame = mainFrame;
        
        // Absolute positioning...
        setLayout(null);

        // Creating components
        ImageIcon imageIcon
                = new ImageIcon(fileName);
        JLabel imageLabel = new JLabel(imageIcon);
        JButton startButton = new JButton("Start");
        JButton highScoresButton = new JButton("Highscores");
        JButton creditsButton = new JButton("Credits");
        
        // CTS - Adding ActionListners to Buttons
        startButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent event) {
                onStartButtonClicked(event);
            }
        });

        // Location and sizing for components
        imageLabel.setBounds(0, 0, 600, 400);
        startButton.setBounds(475, 250, 100, 25);
        highScoresButton.setBounds(475, 280, 100, 25);
        creditsButton.setBounds(475, 310, 100, 25);

        add(startButton);
        add(highScoresButton);
        add(creditsButton);
        add(imageLabel);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    public void onStartButtonClicked(ActionEvent event) {
        try {
            // Add any ther options here, like maybe listen for a key press for secrets (:
            System.out.println("Clicked on Start button");
            mainFrame.addGameScreen();
        } catch (IOException ex) {
            Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /*
    // Displays the home screen
    public void addHomePanel() throws IOException {
        hp = new HomePanel(null);
        hp.getPreferredSize();
        add(hp);
        hp.setVisible(true);
    }
    
    
    public void addGameScreen() throws IOException {
        
       gameScreen = new HangmanPanel(null, this.mainFrame);
       gameScreen.getPreferredSize();
       add(gameScreen);
       gameScreen.setVisible(true);
    }*/
}
