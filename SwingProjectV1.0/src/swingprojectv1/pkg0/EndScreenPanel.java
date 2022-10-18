/** *************************************************************
 *  file: EndScreenPanel.class
 *  author: M. Geronimo & Co.
 *  class: CS   2450.01
 *
 *  assignment: Project 1.1
 *  date last modified: 9/16/2022
 *
 *  purpose: This class has the end screen for the main game,
 * displaying the game score and redirecting the player to the home screen
 *
 *************************************************************** */
package swingprojectv1.pkg0;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private JButton skipGameButton;
    private JLabel userScoreField;
    private JLabel gameOverField;
    private JLabel imageLabel;
    private ImageIcon backgroundIcon;
    private ColorGameScreen colorGame;
    private SudokuPanel sudoku;

    private int score = 0;
    private String gameEndMessage = "Game Over!";
    private String nextGameButtonMessage = "Next Game";
    private MainFrame mainFrame;
    private String resetGameButtonMessage;
    private boolean dummy=false;

    public EndScreenPanel(String imageFile, MainFrame mainFrame, int playerScore, String gameOverMessage) throws IOException {
        this.mainFrame = mainFrame;
        this.score = playerScore;
        this.backgroundIcon = new ImageIcon(imageFile);
        this.gameEndMessage = gameOverMessage;
        this.initComponents();
    }

    public EndScreenPanel(String imageFile, MainFrame mainFrame, int playerScore, String gameOverMessage, String nextGameMessage) throws IOException {
        this(imageFile, mainFrame, playerScore, gameOverMessage);
        this.nextGameButtonMessage = nextGameMessage;
    }

    public EndScreenPanel(String imageFile, MainFrame mainFrame, int playerScore, String gameOverMessage, boolean dummy) throws IOException {
        this(imageFile, mainFrame, playerScore, gameOverMessage);
        this.dummy= dummy;
        this.resetGameButtonMessage = "Reset Game";
    }

    private void initComponents() {
        int adjustY = -100;
        this.nextGameButton = new JButton();
        this.restartButton = new JButton();
        this.skipGameButton = new JButton();
        this.userScoreField = new JLabel();
        this.gameOverField = new JLabel();
        this.imageLabel = new JLabel();
        //this.colorGame = new ColorGameScreen(this.mainFrame);

        // color game 
        this.colorGame = new ColorGameScreen(this.mainFrame);
        this.sudoku = new SudokuPanel(this.mainFrame);

        setLayout(null);

        imageLabel.setBounds(0, 0, 600, 400);
        add(imageLabel);

        gameOverField.setFont(new Font("Sans-Serif", Font.BOLD, 50));
        gameOverField.setText(this.gameEndMessage);
        add(gameOverField);
        gameOverField.setBounds(150, 150 + adjustY, 300, 60);

        userScoreField.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
        userScoreField.setText("Your Score: " + this.score);
        add(userScoreField);
        userScoreField.setBounds(210, 200 + adjustY, 300, 60);
        if (!dummy){

        nextGameButton.setFont(new Font("Sans-Serif", Font.PLAIN, 35));
        nextGameButton.setText(nextGameButtonMessage);
        nextGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("The current panel is " + ((JButton) event.getSource()).getParent());
                //nextGame();
            }
        });
        add(nextGameButton);
        nextGameButton.setBounds(150, 275 + adjustY, 300, 60);
        }else{
            restartButton.setText(this.resetGameButtonMessage);
         add(restartButton);
        restartButton.setBounds(150, 275 + adjustY, 300, 60);
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("The current panel is " + ((JButton) event.getSource()).getParent());
                try {
                    restartGame();
                } catch (IOException ex) {
                    Logger.getLogger(EndScreenPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        }

        skipGameButton.setFont(new Font("Sans-Serif", Font.PLAIN, 35));
        skipGameButton.setText("To Home");
        skipGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    returnToHomeScreen();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        add(skipGameButton);
        skipGameButton.setBounds(150, 335 + adjustY, 300, 60);

        //restartButton.setFont(mainFrame.hangmanPanel.getFont());
        restartButton.setText(this.resetGameButtonMessage);
         add(restartButton);
        restartButton.setBounds(150, 275 + adjustY, 300, 60);
    }

    private void returnToHomeScreen() throws IOException {
        mainFrame.remove(this);
        mainFrame.repaint();
        this.revalidate();
        this.mainFrame.reAddHomePanel(mainFrame);
    }
    
    private void restartGame() throws IOException {
        this.mainFrame.remove(this);
        this.mainFrame.add(sudoku);
        
        this.mainFrame.repaint();
        this.mainFrame.revalidate();
    }

    private void nextGame() throws IOException {
        this.mainFrame.remove(this);

        this.mainFrame.add(colorGame);

        this.mainFrame.repaint();
        this.mainFrame.revalidate();
    }
}
