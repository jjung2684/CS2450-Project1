/***************************************************************  
*  file: EndScreenPanel.class  
*  author: M. Geronimo & Co. 
*  class: CS   2450.01
*  
*  assignment: Project 1.0  
*  date last modified: 9/16/2022
*  
*  purpose: This class has the end screen for the main game,
* displaying the game score and redirecting the player to the home screen
*  
****************************************************************/  
package swingprojectv1.pkg0;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author wwwyv
 */
public class EndScreenPanel extends JPanel {
    
    private JButton nextGameButton;
    private JButton restartButton;
    private JLabel userScoreField;
    private JLabel gameOverField;
    private JLabel imageLabel;
    private ImageIcon backgroundIcon;
    private ColorGameScreen colorGame;
    
    private int score = 0;
    private String gameEndMessage = "Game Over!";
    private MainFrame mainFrame;
  
    public EndScreenPanel(String imageFile, MainFrame mainFrame, int playerScore, String message) throws IOException {
        this.mainFrame = mainFrame;
        this.score = playerScore;
        this.backgroundIcon = new ImageIcon(imageFile);
        this.gameEndMessage = message;
        this.initComponents();
    }
    
    private void initComponents() {
        this.nextGameButton = new JButton();
        this.restartButton = new JButton();
        this.userScoreField = new JLabel();
        this.gameOverField = new JLabel();
        this.imageLabel = new JLabel();
        //this.colorGame = new ColorGameScreen(this.mainFrame);
        
        // color game 
        this.colorGame = new ColorGameScreen(this.mainFrame);
        
        setLayout(null);
        
        imageLabel.setBounds(0, 0, 600, 400);
        add(imageLabel);
        
        gameOverField.setFont(new Font("Sans-Serif", Font.BOLD, 50));
        gameOverField.setText(this.gameEndMessage);
        add(gameOverField);
        gameOverField.setBounds(150, 60, 300, 60);
        
        userScoreField.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
        userScoreField.setText("Your Score: " + this.score);
        add(userScoreField);
        userScoreField.setBounds(210, 200, 300, 60);
        
        nextGameButton.setFont(new Font("Sans-Serif", Font.PLAIN, 35));
        nextGameButton.setText("Next Game");       
        nextGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                        nextGame();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        });
        add(nextGameButton);
        nextGameButton.setBounds(150, 275, 300, 60);
        
        //restartButton.setFont(mainFrame.hangmanPanel.getFont());
        //restartButton.setText("Restart");
        // add(restartButton);
        //restartButton.setBounds(240, 200, 140, 60);
        
    }
    
    private void returnToHomeScreen() throws IOException {
        mainFrame.remove(this);
        mainFrame.repaint();
        this.revalidate();
        this.mainFrame.reAddHomePanel(mainFrame);
    }
    
    private void nextGame() throws IOException {
        this.mainFrame.remove(this);
            
        this.mainFrame.add(colorGame);

        this.mainFrame.repaint();
        this.mainFrame.revalidate();
    }
}
