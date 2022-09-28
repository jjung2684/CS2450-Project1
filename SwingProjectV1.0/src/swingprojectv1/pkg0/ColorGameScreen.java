/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingprojectv1.pkg0;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tommy
 */
public class ColorGameScreen extends JPanel implements ActionListener {
    private final MainFrame mainFrame;
    private JPanel gamePanel;
    private JLabel colorPrompt;
    private JButton skipButton;
    private JLabel scoreLabel;
    
    private Rectangle colorPromptRect;
    private Rectangle scoreRect;
    private Rectangle skipRect;
    
    private Rectangle yellowOvalRect;
    private Rectangle redOvalRect;
    private Rectangle greenOvalRect;
    private Rectangle blueOvalRect;
    private Rectangle pinkOvalRect;
    
    private int userScore;
    private int currentRound;
    private Rectangle[] compontntRect;
    private final String[] COLOR_PROMPTS_TEXT = {"Red", "Green", "Yellow", "Pink", "Blue"};
    private final Color[] COLOR_PROMPTS = {Color.RED, Color.GREEN, Color.YELLOW, Color.PINK, Color.BLUE};
    private final int MAX_ROUNDS = 5;
    private Random random = new Random();
        
    public ColorGameScreen(MainFrame mainFrame) {
        
        // initialize mainFrame
        this.mainFrame = mainFrame;
        this.setBackground(Color.white);
        this.setLayout(null);
        addColorGamePanel();
    }
    
    public void addColorGamePanel() {
            // remove current panel
            
            // initialize color game 
            this.compontntRect = new Rectangle[10];
            this.getPreferredSize();
            this.initComponents();
            this.setVisible(true);
            
            
        }
    
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }
    
    private void initComponents() {
        yellowOvalRect = getRandomRectangle(100, 100);
        redOvalRect = new Rectangle(150, 150, 100, 100);
        greenOvalRect = new Rectangle(250, 250, 100, 100);
        blueOvalRect = new Rectangle(350, 250, 100, 100);
        pinkOvalRect = new Rectangle(450, 150, 100, 100);
        
        
        colorPromptRect = new Rectangle(250, 50, 100, 100);
        skipRect = new Rectangle(490, 25, 75, 22);
        scoreRect = new Rectangle(10, 5, 120, 16);
        
        scoreLabel = new JLabel();
        colorPrompt = new JLabel();
        skipButton = new JButton();
        
        colorPrompt.setText("Waiting...");
        prepareNextRound(); // Updates the Rects
        scoreLabel.setText("Score: " + userScore);
        skipButton.setText("Skip");
        
        colorPrompt.setFont(new Font("Sans-Serif", Font.BOLD, 24));
        colorPrompt.setForeground(Color.BLACK);
        
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    addEndGamePanel();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        
        this.add(colorPrompt);
        this.add(scoreLabel);
        this.add(skipButton);
        
        colorPrompt.setBounds(colorPromptRect);
        
        
        // Randomize Pos
        
    }
    
    private void fillRectMap() {
        this.compontntRect[0] = this.colorPromptRect;
        this.compontntRect[1] = this.scoreRect;
        this.compontntRect[2] = this.skipRect;
        this.compontntRect[3] = this.blueOvalRect;
        this.compontntRect[4] = this.greenOvalRect;
        this.compontntRect[5] = this.pinkOvalRect;
        this.compontntRect[6] = this.redOvalRect;
        this.compontntRect[7] = this.yellowOvalRect;
    }
    
    private boolean updateOval(int id, Rectangle updatedRect) throws IndexOutOfBoundsException {
        boolean result = false;
        this.compontntRect[id] = updatedRect;
        return result;
    }
    
    /**
     * Adds the circles
     * @param g 
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        
        // yellow cirlcle
        g2.setColor(Color.yellow);
        g2.fillOval((int)yellowOvalRect.getX(), (int)yellowOvalRect.getY(), (int)yellowOvalRect.getWidth(), (int)yellowOvalRect.getHeight());
        
        // red circle
        g2.setColor(Color.red);
        g2.fillOval((int)redOvalRect.getX(), (int)redOvalRect.getY(), (int)redOvalRect.getWidth(), (int)redOvalRect.getHeight());
        
        // green circle
        g2.setColor(Color.green);
        g2.fillOval((int)greenOvalRect.getX(), (int)greenOvalRect.getY(), (int)greenOvalRect.getWidth(), (int)greenOvalRect.getHeight());
        
        // blue circle
        g2.setColor(Color.blue);
        g2.fillOval((int)blueOvalRect.getX(), (int)blueOvalRect.getY(), (int)blueOvalRect.getWidth(), (int)blueOvalRect.getHeight());
        
        // pink circle
        g2.setColor(Color.pink);
        g2.fillOval((int)pinkOvalRect.getX(), (int)pinkOvalRect.getY(), (int)pinkOvalRect.getWidth(), (int)pinkOvalRect.getHeight());
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    }
    
    /**
     * Reinitializes the game components: ovals, text, and rounds
     */
    private void reInitGameComponents() {
        
    }
    
    private void skipGame() throws IOException {
        this.mainFrame.remove(this);
        
        
        mainFrame.repaint();
        mainFrame.revalidate();
        
    }
    
    private void addEndGamePanel() throws IOException {
        mainFrame.remove(this);
        
        EndScreenPanel endScreen = new EndScreenPanel(null, mainFrame, userScore, "Game Over!");
        mainFrame.add(endScreen);
        endScreen.setVisible(true);
        
        mainFrame.repaint();
        mainFrame.revalidate();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    private void onPlayerClickedOval(Rectangle ovalRect) {
        
    }
    
    private Color getCurrentColorPrompt() {
        return this.colorPrompt.getForeground();
    }
    
    /**
     * Returns a rectangle with a random X pos and a random Y pos
     * @param rectangle
     * @return 
     */
    private Rectangle getRandomRectangle(int width, int height) {
        // Game bounds: 400x600
        
        Rectangle temp = new Rectangle(colorPromptRect); // Forces do-while to execute once and guards against null pointer exception
        
        do {
            
            int randomX = random.nextInt(600); // limit potential x values to be between 0 to 400
            int randomY = random.nextInt(400);
            
            temp = new Rectangle(randomX, randomY, width, height);
        } while (this.colorPromptRect.contains(temp) || this.skipRect.contains(temp) || this.scoreRect.contains(temp));
        
        return temp;
    }
    
    private boolean isRectInRect(Rectangle rectIn) {
        b
        for (int id = 0; id < this.compontntRect.length; id++) {
            if (compontntRect[id] != null) {
                return compontntRect[id].contains(rectIn);
            }
        }
    }
    
    private void prepareNextRound() {
        // Redefine ovals (not colors...)
        yellowOvalRect = getRandomRectangle(100, 100);
        redOvalRect = getRandomRectangle(100, 100);
        greenOvalRect = getRandomRectangle(100, 100);
        pinkOvalRect = getRandomRectangle(100, 100);
        blueOvalRect = getRandomRectangle(100, 100);
        
        setNextColorPrompt();
        
    }
    
    private void setNextColorPrompt() {
        this.colorPrompt.setText(COLOR_PROMPTS_TEXT[random.nextInt(0, 4)]);
        this.colorPrompt.setForeground(COLOR_PROMPTS[random.nextInt(0, 4)]);
    }
    
    private void updateScore() {
        this.scoreLabel.setText("Score: " + this.userScore);
    }
    
    public void wrongColor() throws IOException {
        if (this.currentRound >= 5)
            this.addEndGamePanel();
        this.repaint();
    }
    
}
