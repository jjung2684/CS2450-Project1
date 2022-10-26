/***************************************************************  
*  file: MainFrame.class  
*  author: S. Barrett & Co.
*  class: CS   2450.01
*  
*  assignment: Project 1.1  
*  date last modified: 9/28/2022
*  
*  purpose: This class creates the main frame, has the methods for adding the 
* splash and home screen, and their functionality (timer, buttons, backgrounds)
*  
****************************************************************/  
package swingprojectv1.pkg0;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author barre
 */
public class MainFrame extends JFrame implements WindowListener, ActionListener {

    SplashPanel sp;
    HomePanel hp;
    HangmanPanel hangmanPanel;
    EndScreenPanel endScreen;
    HighScoresPanel highScoresPanel;
    CreditsPanel creditsPanel;
    SudokuPanel sudokuPanel;
    PongPanel pongPanel;
    PongScore ps;
    

    public MainFrame(String title) {
        addWindowListener(this);
        pack();
        setLocationRelativeTo(null);
        setTitle(title);
        setResizable(false);

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); 
        getRootPane().getActionMap().put("Cancel", new AbstractAction()
        { 

            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "Popup"); 
        getRootPane().getActionMap().put("Popup", new AbstractAction()
                
        { 

            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "CS2450 Fall 2022 Java Swing Project\n"
                        + "\nMiguel Geronimo - 015323438, \nLy Hoang Rivera - 014384968,"
                        + "\nSpencer Barrett - 011727157,\nTommy James - 014478542,"
                        + "\nJacob Jung - 010812009");
                
            }
        });

    }

    // Displays Splash screen 
    public void addSplashPanel() throws IOException {
        sp = new SplashPanel("https://res.cloudinary.com/dt2autub1/image/upload/v1663638043/assets/Splash_x6te3l.jpg");
        sp.setForeground(Color.WHITE);
        sp.getPreferredSize();
        add(sp);
        sp.setVisible(true);

    }

    // Displays the home screen
    public void addHomePanel(Frame mainFrame) throws IOException {
        hp = new HomePanel(new URL("https://res.cloudinary.com/dt2autub1/image/upload/v1663639833/assets/ezgif.com-gif-maker_1_olgpkx.gif"), this);
        hp.getPreferredSize();
        add(hp);
        hp.setVisible(true);
        this.repaint();
        this.revalidate();
    }
    
    public void reAddHomePanel(Frame mainFrame, JPanel currentPanel) throws IOException {
        
        this.remove(currentPanel);
        this.addHomePanel(mainFrame);
        currentPanel = null;
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
    
    public void addHighScoresScreen() throws IOException {
        this.remove(hp);
        highScoresPanel = new HighScoresPanel(this);
        highScoresPanel.getPreferredSize();
        add(highScoresPanel);
        highScoresPanel.setVisible(true);
        this.repaint();
        this.revalidate();
    }
    
    public void addSudokuScreen() throws IOException {
        this.remove(hp);
        sudokuPanel = new SudokuPanel(this);
        sudokuPanel.getPreferredSize();
        add(sudokuPanel);
        sudokuPanel.setVisible(true);
        this.repaint();
        this.revalidate();
    }
    
    public void addCreditsScreen() throws IOException {
        this.remove(hp);
        creditsPanel = new CreditsPanel(this);
        creditsPanel.getPreferredSize();
        add(creditsPanel);
        creditsPanel.setVisible(true);
        this.repaint();
        this.revalidate();
    }
    
    public void addPongScreen() throws IOException {
        this.remove(hp);
        ps= new PongScore(0, 0);
        pongPanel = new PongPanel(this, ps);
        pongPanel.getPreferredSize();
        add(pongPanel);
        pongPanel.setVisible(true);
        this.repaint();
        this.revalidate();
    }
    
//    public void resetPong()  {
//        this.remove(pongPanel);
//        add(pongPanel);
//         pongPanel = new PongPanel(this);
//        pongPanel.getPreferredSize();
//        add(pongPanel);
//        pongPanel.setVisible(true);
//        this.repaint();
//        this.revalidate();
//    }

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
        backgroundImg = ImageIO.read(new URL(fileName));
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
        drawCenteredString(g, "CS 2450 Project V1.3", titleRect, titleFont);

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

class HomePanel extends JPanel implements ActionListener {

    private final MainFrame mainFrame;
    
    // Components
    ImageIcon imageIcon;
    JLabel imageLabel;
    JButton startButton = new JButton();
    JButton highScoresButton = new JButton();
    JButton creditsButton = new JButton();
    JButton playPongButton;
    
    public HomePanel(URL url, MainFrame mainFrame) {

        // CTS - needed so that future screens can access the main one without creating a new screen
        this.mainFrame = mainFrame;
        
        // Initialize components
//        imageIcon = new ImageIcon(fileName);
        imageLabel = new JLabel(new ImageIcon(url));
        startButton = new JButton("Start");
        startButton.setToolTipText("Start a hangman game");
        highScoresButton = new JButton("High Scores");
        highScoresButton.setToolTipText("Display high scores");
        creditsButton = new JButton("Credits");
        creditsButton.setToolTipText("Display credits screen");
        playPongButton = new JButton("Play Pong");
        playPongButton.setToolTipText("Start a Pong game");
        
        // Absolute positioning...
        setLayout(null);
        
        // CTS - Adding ActionListners to Buttons
        startButton.addActionListener(this);
        highScoresButton.addActionListener(this);
        creditsButton.addActionListener(this);
        playPongButton.addActionListener(this);

        // Location and sizing for components
        imageLabel.setBounds(0, 0, 600, 400);
        startButton.setBounds(450, 230, 125, 25);
        highScoresButton.setBounds(450, 260, 125, 25);
        creditsButton.setBounds(450, 290, 125, 25);
        playPongButton.setBounds(450, 320, 125, 25);

        add(startButton);
        add(highScoresButton);
        add(creditsButton);
        add(playPongButton);
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
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == startButton) {
            onStartButtonClicked(event); // start button clicked
        } else if (event.getSource() == highScoresButton){
            onHighScoresButtonClicked(event); // high scores button clicked
        } else if (event.getSource() == creditsButton){
            onCreditsButtonClicked(event); // credits button clicked
        } else if (event.getSource() == playPongButton) {
            onPlayPongButtonClicked(event); // play pong button clicked
        }
    }
    
    public void onStartButtonClicked(ActionEvent event) {
        try {
            // Add any other options here, like maybe listen for a key press for secrets (:
            System.out.println("Clicked on Start button");
            mainFrame.addGameScreen();
        } catch (IOException ex) {
            Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    public void onHighScoresButtonClicked(ActionEvent event) {
        try {
            // Add any other options here, like maybe listen for a key press for secrets (:
            System.out.println("Clicked on High Scores button");
            mainFrame.addHighScoresScreen();
        } catch (IOException ex) {
            Logger.getLogger(HighScoresPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onCreditsButtonClicked(ActionEvent event) {
        try {
            // Add any other options here, like maybe listen for a key press for secrets (:
            System.out.println("Clicked on Credits button");
            mainFrame.addCreditsScreen();
        } catch (IOException ex) {
            Logger.getLogger(CreditsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onPlayPongButtonClicked(ActionEvent event){
        try {
            // Add any other options here, like maybe listen for a key press for secrets (:
            System.out.println("Clicked on Credits button");
            mainFrame.addPongScreen();
        } catch (IOException ex) {
            Logger.getLogger(CreditsPanel.class.getName()).log(Level.SEVERE, null, ex);
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
