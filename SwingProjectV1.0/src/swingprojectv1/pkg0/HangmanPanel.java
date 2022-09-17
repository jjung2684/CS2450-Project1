/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingprojectv1.pkg0;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author wwwyv
 */
public class HangmanPanel extends JPanel {
    
         // <editor-fold defaultstate="collapsed" desc="GUI Components Variables">
        private final MainFrame mainFrame;
        // Add background with lines
        
        private JPanel alphabetPanel;
        
        // Buttons All 26
        private JButton alphaButtonA;
        private JButton alphaButtonB;
        private JButton alphaButtonC;
        private JButton alphaButtonD;
        private JButton alphaButtonE;
        private JButton alphaButtonF;
        private JButton alphaButtonG;
        private JButton alphaButtonH;
        private JButton alphaButtonI;
        private JButton alphaButtonJ;
        private JButton alphaButtonK;
        private JButton alphaButtonL;
        private JButton alphaButtonM;
        private JButton alphaButtonN;
        private JButton alphaButtonO;
        private JButton alphaButtonP;
        private JButton alphaButtonQ;
        private JButton alphaButtonR;
        private JButton alphaButtonS;
        private JButton alphaButtonT;
        private JButton alphaButtonU;
        private JButton alphaButtonV;
        private JButton alphaButtonW;
        private JButton alphaButtonX;
        private JButton alphaButtonY;
        private JButton alphaButtonZ;
        
        private JButton alphaButtonBackspace;
        private JButton alphaButtonEnabler;
        private JButton skipButton;
        //private JButton clickButton;
        //private JLabel clickCounter;
        private JLabel dateLabel;
        private JLabel scoreDispay;
        //private JLabel playerNameFrame;
        //private JTextField playerNameInput;
       // private JButton playerNameSubmit;
        
        private JLabel saturnImage;
        
        private JLabel[] textSlots; // Array for text slots (the ones that hold letters)
        private JLabel[] textSlotIcons; // Array for the icons (The lines under the letters)
        private Map<String, JButton> buttonMap = new HashMap<String, JButton>(); // Map for all keyboard buttons
        
         // </editor-fold>  
        // Helper for button methods
        private AlphabetButtonHelper alphaHelper = new AlphabetButtonHelper();
        private EndScreenPanel endScreen;
        
        private String hangmanPlayerInputField; // The Text Slot
        private String wordToGuess; // The Word the player will guess
        private int alphaCounter = 0; // Counter for filling the keyboard buttons
        private int numOfSlotsSet = 0; // Number of Slots that have a letter filled
        private int numOfWrongGuesss = 0;
        private int playerScore = 100;
        
       
        
        public HangmanPanel(String imageFile, MainFrame mainFrame) throws IOException {
            this.mainFrame = mainFrame;
            startGameLogic();
            this.initComponents();
        }
        
        /**
         * Starts the game at any time, resetting any previously established vars to null or empty
         */
        public void startGameLogic() {
            System.out.println("Starting Game Logic");
            this.wordToGuess = this.randomWordGenerator();
            this.textSlots = new JLabel[this.wordToGuess.length() + 1];
            this.textSlotIcons = new JLabel[this.wordToGuess.length() + 1];
            this.numOfSlotsSet = 0;
            alphaHelper.resetWordToGuess();
            alphaHelper.reEnableButtons();
        }
        
        /**
         * Initialize the buttons and labels, set properties, and add them to the screen
         */
        private void initComponents() {
            System.out.println("Staring init process");
                        
             // <editor-fold defaultstate="collapsed" desc="Keyboard Buttons">
            this.alphabetPanel = new JPanel();
            this.alphaButtonA = new JButton();
            this.alphaButtonB = new JButton();
            this.alphaButtonC = new JButton();
            this.alphaButtonD = new JButton();
            this.alphaButtonE = new JButton();
            this.alphaButtonF = new JButton();
            this.alphaButtonG = new JButton();
            this.alphaButtonH = new JButton();
            this.alphaButtonI = new JButton();
            this.alphaButtonJ = new JButton();
            this.alphaButtonK = new JButton();
            this.alphaButtonL = new JButton();
            this.alphaButtonM = new JButton();
            this.alphaButtonN = new JButton();
            this.alphaButtonO = new JButton();
            this.alphaButtonP = new JButton();
            this.alphaButtonQ = new JButton();
            this.alphaButtonR = new JButton();
            this.alphaButtonS = new JButton();
            this.alphaButtonT = new JButton();
            this.alphaButtonU = new JButton();
            this.alphaButtonV = new JButton();
            this.alphaButtonW = new JButton();
            this.alphaButtonX = new JButton();
            this.alphaButtonY = new JButton();
            this.alphaButtonZ = new JButton();
            
            this.alphaButtonBackspace = new JButton();
            this.alphaButtonEnabler = new JButton();
            // </editor-fold>  
            
            this.skipButton = new JButton();
            this.dateLabel = new JLabel();
            this.scoreDispay = new JLabel();
            
            // Window Things
            setLayout(null);
            
            
            this.fillButtonMap(); // Make sure all buttons are initialized
            this.fillTextSlots(); // Make sure the word has been set
            this.fillTextSlotIcons(); // Make sure the word has been set
            
             // <editor-fold defaultstate="collapsed" desc="Keyboard Buttons Setup">
            // Set the Text, Font, and attach events for the keyboard Buttons
            for (String buttonKey : this.buttonMap.keySet()) {
                this.buttonMap.get(buttonKey).setText(buttonKey);
                this.buttonMap.get(buttonKey).setFont(new Font("Segoe UI", 0, 14));
                alphabetPanel.add(this.buttonMap.get(buttonKey));
                
                this.buttonMap.get(buttonKey).addActionListener((ActionEvent event) -> {
                    addLetterToGuess(event);
                });
            }
            // </editor-fold>  
            
             // <editor-fold defaultstate="collapsed" desc="Text Slot and Icon Setup">
            int xPosForText = 130 - (this.textSlots.length * 10);
            int universalY = 180;
            int widthForIcon = 5;
            
            for (JLabel label: this.textSlots) {
                if (label != null) {
                    
                    label.setText("");
                    label.setFont(new Font("Segoe UI", 0, 36));
                    label.setHorizontalTextPosition(SwingConstants.CENTER);
                    this.add(label);
                    label.setBounds(xPosForText, universalY, 40, 50);
                    xPosForText += 60 + 5;
                }
            }
            
            int xPosForIcon = 125 - (this.textSlots.length * 10);
            for (JLabel label: this.textSlotIcons) {
                if (label != null) {
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swingprojectv1/pkg0/debug/resources/HangManTextLine.png"))); // NOI18N
                    label.setFocusable(false);
                    label.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                    this.add(label);
                    label.setBounds(xPosForIcon, universalY + 60, 30, 2);
                    xPosForIcon += 60 + 5;
                }
            }
            // </editor-fold>  
            
            ////////////////////////////////////////////////////////////////////
            
            // Set text for each button
            skipButton.setText("Skip");
            alphaButtonEnabler.setText("Re-Enable Buttons");
            
            alphaButtonBackspace.setEnabled(false);
            
            // Event Handlers for Non-AlphaButtons
            alphaButtonBackspace.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    addLetterToGuess(event);
                }
            });
           
            alphaButtonEnabler.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    alphaHelper.reEnableButtons();
                }
            });
           
            skipButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    try {
                        skipGame();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
           
            // Add remaining buttons to panel
            // alphabetPanel.add(alphaButtonBackspace);
            // alphabetPanel.add(alphaButtonEnabler);

            this.add(skipButton);
            skipButton.setBounds(490, 25, 75, 22);

            
            dateLabel.setText("Put Date here"); // TODO: Add date
            add(dateLabel);
            dateLabel.setBounds(447, 10, 120, 16);

            scoreDispay.setText("Score: " + playerScore);
            add(scoreDispay);
            scoreDispay.setBounds(10, 10, 120, 16);
            
            // Mouse Things
            this.add(alphabetPanel);
            alphabetPanel.setBounds(50, universalY + 75, 500, 125);           
        }

        // Frame Things
        /**
         * Set Window size for this instance
         * @return 
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 400);
        }

        /**
         * Set Font for this frame
         * @param g 
         */
        @Override
        public void paintComponent(Graphics g) {
            // From MainFrame.SplashPanel
            super.paintComponent(g);
            Font gameFont = new Font("Sans-Serif", Font.PLAIN, 16);
            
            // Rect to hold alphabet
          
        }
        
        /**
         * Fill the text slot array for this game instance
         */
        private void fillTextSlots() {
            int buttonsToMake = this.wordToGuess.length();
            for (int i = 0; i < buttonsToMake; i++) {
                this.textSlots[i] = new JLabel();
            }
        }
        
        /**
         * Fill this text slot icon array
         */
        private void fillTextSlotIcons() {
            int buttonsToMake = this.wordToGuess.length();
            for (int i = 0; i < buttonsToMake; i++) {
                this.textSlotIcons[i] = new JLabel();
            }
        }
        
        /**
         * Fill the keyboard button map
         */
        private void fillButtonMap() {
            this.buttonMap.put("A", alphaButtonA);
            this.buttonMap.put("B", alphaButtonB);
            this.buttonMap.put("C", alphaButtonC);
            this.buttonMap.put("D", alphaButtonD);
            this.buttonMap.put("E", alphaButtonE);
            this.buttonMap.put("F", alphaButtonF);
            this.buttonMap.put("G", alphaButtonG);
            this.buttonMap.put("H", alphaButtonH);
            this.buttonMap.put("I", alphaButtonI);
            this.buttonMap.put("J", alphaButtonJ);
            this.buttonMap.put("K", alphaButtonK);
            this.buttonMap.put("L", alphaButtonL);
            this.buttonMap.put("M", alphaButtonM);
            this.buttonMap.put("N", alphaButtonN);
            this.buttonMap.put("O", alphaButtonO);
            this.buttonMap.put("P", alphaButtonP);
            this.buttonMap.put("Q", alphaButtonQ);
            this.buttonMap.put("R", alphaButtonR);
            this.buttonMap.put("S", alphaButtonS);
            this.buttonMap.put("T", alphaButtonT);
            this.buttonMap.put("U", alphaButtonU);
            this.buttonMap.put("V", alphaButtonV);
            this.buttonMap.put("W", alphaButtonW);
            this.buttonMap.put("X", alphaButtonX);
            this.buttonMap.put("Y", alphaButtonY);
            this.buttonMap.put("Z", alphaButtonZ);
            
            // this.buttonMap.put("Backspace", alphaButtonBackspace);
            // this.buttonMap.put("Enable Buttons", alphaButtonEnabler);
        }
        
        /**
         * Use this event to handle adding a letter to the hangman guess.
         * Only works with buttons with text.
         * @param event 
         */
        private void addLetterToGuess(ActionEvent event) {
            if (event.getSource() instanceof JButton) {
                JButton button = (JButton)event.getSource();
                
                if (button == alphaButtonBackspace) {
                    System.err.println("Deprceated. No longer works");
                   // alphaHelper.perfromBackspace(event, this.textSlots[numOfSlotsSet], this.textSlots[numOfSlotsSet].getText());
                    //numOfSlotsSet--;
                } else {
                    // Must be a letter button
                    if (numOfSlotsSet < this.wordToGuess.length()) {
                        this.fillAllLetterOccurences(button);
                        // this.textSlots[numOfSlotsSet].setText(this.textSlots[numOfSlotsSet].getText() + button.getText());
                        // this.hangmanGuessSlot1.setText(hangmanGuessSlot1.getText() + button.getText());

                        // numOfSlotsSet++;
                        alphaHelper.disableButton(button);
                        System.out.println("The number of slots set is now " + this.numOfSlotsSet);
                    } else {
                        System.out.println("No more letter slots, all filled in. The Word was " + this.wordToGuess + "(With length of + " + this.wordToGuess.length() + ". Number of slots set: " + this.numOfSlotsSet);
                    }
                    
                }
            }
        }
        
        /**
         * Ends the game and returns to the home screen
         * @throws IOException 
         */
        private void skipGame() throws IOException {
            this.playerScore = 0;
            this.addEndGamePanel();
        }
        
        /**
         * Adds the end panel and unloads this panel
         * @throws IOException 
         */
        private void addEndGamePanel() throws IOException {
            mainFrame.remove(this.mainFrame.hangmanPanel);
            
            this.endScreen = new EndScreenPanel(null, mainFrame, playerScore, "Game Over!");
            this.endScreen.getPreferredSize();
            this.mainFrame.add(this.endScreen);
            this.endScreen.setVisible(true);
            
            mainFrame.repaint();
            mainFrame.revalidate();
        }
        
        private void addEndGamePanel(String mesaage) throws IOException {
            mainFrame.remove(this.mainFrame.hangmanPanel);
            
            this.endScreen = new EndScreenPanel(null, mainFrame, playerScore, "You Won!");
            this.endScreen.getPreferredSize();
            this.mainFrame.add(this.endScreen);
            this.endScreen.setVisible(true);
            
            mainFrame.repaint();
            mainFrame.revalidate();
        }
        
        /**
         * Picks a random word from a predefined set of 10
         * @return 
         */
        private String randomWordGenerator() {
            String[] wordBank = new String[10];
            /*
            abstract, cemetery, nurse, 
pharmacy, climbing
            */
            wordBank[0] = "ABSTRACT";
            wordBank[1] = "CEMENTERY";
            wordBank[2] = "NURSE";
            wordBank[3] = "PHARMACY";
            wordBank[4] = "CLIMBING";
            wordBank[5] = "BRONCO";
            wordBank[6] = "POMONA";
            wordBank[7] = "SWING";
            wordBank[8] = "JAVA";
            wordBank[9] = "SANS";
            int randomInt = (int)(Math.random() * 10);
            if (!(randomInt > 10 || randomInt < 0)) {
                System.out.println("Chose " + wordBank[randomInt] + " as the word");
                return wordBank[randomInt];
            } else {
                System.out.println("Chose " + wordBank[randomInt - 1] + " as the word");
                return wordBank[randomInt - 1];
            }
        }
        
        /**
         * Checks if the label has a letter already
         * @param button
         * @return True if the slot has a letter; False if Empty
         */
        private boolean hasLetterInSlot(JLabel labelToCheck) {
            // arrays start empty, position 0 means there is atleast one entry. +1 to make comparison easy
            if (labelToCheck.getText().toCharArray().length + 1 > 1) { 
                return true; // slot has a letter already
            } else return false;
        }
        
        /**
         * Fills the enabled button map in AlphabetHelper to keep track of
         * buttons that are currently active
         */
        public void fillEnabledButtonsArray() {
            Component[] componentList = this.getComponents();
            for (Component iterable$component: componentList) {
                if (iterable$component instanceof JButton) {
                    JButton iterable$button = (JButton)iterable$component;
                    if (iterable$button.getParent().equals(this.alphabetPanel)) {
                        alphaHelper.enabledButtons[alphaCounter] = iterable$button;
                        alphaCounter++;
                    }
                }
            }
        }
        
        /**
         * Get the current guess for the word
         * @return 
         */
        private String getHangmanGuess() {
            return this.hangmanPlayerInputField;
        }
        
        /**
         * Set the guess field to something else. Should only really
         * be used to update the field with a new letter
         * @param newGuess 
         */
        private void setHangmanGuess(String newGuess) {
            this.hangmanPlayerInputField = newGuess;
        }
        
        // Fills in all occurences of the passed letter to the right slot
        private void fillAllLetterOccurences(JButton alphaButton) {
            String guessCopy = this.wordToGuess;
            boolean letterNotIncluded = false;
            int numOfLettersAdded = 0;
            char[] wordToGuessArray = new char[this.wordToGuess.length()];
            wordToGuessArray = this.wordToGuess.toCharArray();
            for (int i = 0; i < this.wordToGuess.length(); i++) {
                if (wordToGuessArray[i] == alphaButton.getText().charAt(0)) {
                    this.textSlots[i].setText(alphaButton.getText());
                    numOfSlotsSet++;
                    numOfLettersAdded++;
                }
            }
            if (numOfLettersAdded <= 0) {
                this.numOfWrongGuesss++;
                try {
                    wrongLetterGuessed();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            if (numOfSlotsSet == this.wordToGuess.length()) {
                try {
                   this.addEndGamePanel();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        private void updatePlayerScore() {
            this.scoreDispay.setText("Score: " + this.playerScore);
        }
        
        public int getPlayerScore() {
            return this.playerScore;
        }
        
        public void wrongLetterGuessed() throws IOException {
            // Guess has been updated already
            // Use this to handle what happens when a letter is incorrectly guessed
            this.playerScore= this.playerScore - 10;
            updatePlayerScore();
            if (this.numOfWrongGuesss >= 6) {
                this.addEndGamePanel();
                // this.mainFrame.addEndScreen();
            }
        }
        
        public int getNumberOfWrongGuess() {
            return this.numOfWrongGuesss;
        } 
    }