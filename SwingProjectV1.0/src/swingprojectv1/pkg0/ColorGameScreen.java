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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.stream.*;
import java.util.stream.Collectors;

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
    private int numberOfEntries;
    private Color currentColorToGuess;
    private Color previousColor;

    private Rectangle[] keyComponentRects;
    private Rectangle[] ovalComponentRects;
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
        this.keyComponentRects = new Rectangle[4];
        this.ovalComponentRects = new Rectangle[5];
        this.previousColor = Color.BLACK;
        this.getPreferredSize();
        this.initComponents();
        this.setVisible(true);
        this.repaint();

    }

    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    private void initComponents() {
        // Init Initial rects for ovals
        yellowOvalRect = new Rectangle(50, 150, 100, 100);
        redOvalRect = new Rectangle(150, 150, 100, 100);
        greenOvalRect = new Rectangle(250, 250, 100, 100);
        blueOvalRect = new Rectangle(350, 250, 100, 100);
        pinkOvalRect = new Rectangle(450, 150, 100, 100);

        // Set bounds for the key components
        colorPromptRect = new Rectangle(250, 50, 100, 100);
        skipRect = new Rectangle(490, 25, 75, 22);
        scoreRect = new Rectangle(10, 5, 120, 16);

        // Create the Key Components
        scoreLabel = new JLabel();
        colorPrompt = new JLabel();
        skipButton = new JButton();

        this.fillKeyRectMap();
        // Set Label text
        colorPrompt.setText("Waiting...");
        scoreLabel.setText("Score: " + userScore);
        skipButton.setText("Skip");

        // Set font and initial color for text
        colorPrompt.setFont(new Font("Sans-Serif", Font.BOLD, 24));
        colorPrompt.setForeground(Color.BLACK);

        prepareNextRound(); // Updates the Rects and the text

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                try {
                    handlePlayerInteraction(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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

        // Add the key components
        this.add(colorPrompt);
        this.add(scoreLabel);
        this.add(skipButton);

        colorPrompt.setBounds(colorPromptRect);
        scoreLabel.setBounds(scoreRect);
        skipButton.setBounds(skipRect);

        // Randomize Pos
    }

    /**
     * Fills the Oval and Rect maps to track location and bounds
     */
    private void fillKeyRectMap() {
        this.keyComponentRects[0] = this.colorPromptRect;
        this.keyComponentRects[1] = this.scoreRect;
        this.keyComponentRects[2] = this.skipRect;
    }

    private void fillOvalRectMap() {
        this.ovalComponentRects[0] = this.blueOvalRect;
        this.ovalComponentRects[1] = this.greenOvalRect;
        this.ovalComponentRects[2] = this.pinkOvalRect;
        this.ovalComponentRects[3] = this.redOvalRect;
        this.ovalComponentRects[4] = this.yellowOvalRect;
        numberOfEntries = ovalComponentRects.length + 1;
    }

    private void resetOvalMap() {
        this.ovalComponentRects = new Rectangle[5];
        numberOfEntries = 0;
    }

    private boolean addRect(Rectangle[] rectArray, Rectangle rectIn) {
        boolean wasAdded = false;
        if (!(numberOfEntries == rectArray.length)) {
            rectArray[numberOfEntries] = rectIn;

            System.out.println("Added a rectangle to slot:" + numberOfEntries);
            numberOfEntries++;
            wasAdded = true;
        }
        return wasAdded;
    }

    /**
     * Update an oval using it's ID and passing it's updated rect
     *
     * @param id
     * @param updatedRect
     * @return
     * @throws IndexOutOfBoundsException
     */
    private void updateOval(int id, Rectangle updatedRect) throws IndexOutOfBoundsException {
        boolean result = false;
        this.keyComponentRects[id] = updatedRect;
    }

    /**
     * Update ovals by getting whatever rect they currently have. Also calls
     * repaint()
     */
    private void updateOval() {
        this.ovalComponentRects[0] = this.blueOvalRect;
        this.ovalComponentRects[1] = this.greenOvalRect;
        this.ovalComponentRects[2] = this.pinkOvalRect;
        this.ovalComponentRects[3] = this.redOvalRect;
        this.ovalComponentRects[4] = this.yellowOvalRect;
        numberOfEntries = 5;
        repaint();
    }

    /**
     * Adds the ovals
     *
     * @param g
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);

        // yellow cirlcle
        g2.setColor(Color.yellow);
        g2.fillOval((int) yellowOvalRect.getX(), (int) yellowOvalRect.getY(), (int) yellowOvalRect.getWidth(), (int) yellowOvalRect.getHeight());

        // red circle
        g2.setColor(Color.red);
        g2.fillOval((int) redOvalRect.getX(), (int) redOvalRect.getY(), (int) redOvalRect.getWidth(), (int) redOvalRect.getHeight());

        // green circle
        g2.setColor(Color.green);
        g2.fillOval((int) greenOvalRect.getX(), (int) greenOvalRect.getY(), (int) greenOvalRect.getWidth(), (int) greenOvalRect.getHeight());

        // blue circle
        g2.setColor(Color.blue);
        g2.fillOval((int) blueOvalRect.getX(), (int) blueOvalRect.getY(), (int) blueOvalRect.getWidth(), (int) blueOvalRect.getHeight());

        // pink circle
        g2.setColor(Color.pink);
        g2.fillOval((int) pinkOvalRect.getX(), (int) pinkOvalRect.getY(), (int) pinkOvalRect.getWidth(), (int) pinkOvalRect.getHeight());

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    }

    /**
     * Skip the current game (no matter the rounds) and go to the end screen
     *
     * @throws IOException
     */
    private void skipGame() throws IOException {
        this.mainFrame.remove(this);
        this.userScore = 0;
        addEndGamePanel();
        mainFrame.repaint();
        mainFrame.revalidate();

    }

    /**
     * Adds the end screen
     *
     * @throws IOException
     */
    private void addEndGamePanel() throws IOException {
        mainFrame.remove(this);

        compareHighScore();

        EndScreenPanel endScreen = new EndScreenPanel(null, mainFrame, userScore, "Game Over!", "Restart");
        mainFrame.add(endScreen);
        endScreen.setVisible(true);

        mainFrame.repaint();
        mainFrame.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    /**
     * Get the current color the player needs to click
     *
     * @return
     */
    private Color getCurrentColorPrompt() {
        return this.colorPrompt.getForeground();
    }

    /**
     * Returns a rectangle with a random X pos and a random Y pos Prerequisite:
     * The oval array is empty/null
     *
     * @param height
     * @param width
     * @return
     */
    private Rectangle getRandomRectangle(int width, int height) {
        // Game bounds: 400x600

        Rectangle temp = new Rectangle(colorPromptRect); // Forces do-while to execute once and guards against null pointer exception

        do {

            int randomX = random.nextInt(600); // limit potential x values to be between 0 to 400
            int randomY = random.nextInt(400);

            temp = new Rectangle(randomX, randomY, width, height);
        } while (isRectInKeyRects(temp) || isRectInOvalRects(temp) || !isRectInFrame(temp));
        // If the rect overlpas any of the key components or an existing oval rect, try again for a better position
        if (!addRect(ovalComponentRects, temp)) {
            System.err.println("Could not add the rect to the oval array. Array could have been full.");
        }
        return temp;
    }

    private boolean isRectInFrame(Rectangle rectIn) {
        double rectHeightYCheck = rectIn.getY() + rectIn.getHeight();
        double recWidthXCheck = rectIn.getX() + rectIn.getWidth();
        boolean isInFrame = true;
        if (rectHeightYCheck > mainFrame.getHeight() - 100 || rectHeightYCheck < 0) {
            isInFrame = false;
        }
        if (recWidthXCheck > mainFrame.getWidth() - 100 || recWidthXCheck < 0) {
            isInFrame = false;
        }
        return isInFrame;
    }

    /**
     * If rect is inside any of the key rect components, return true. Only
     * return false in none of the rects contain the one in the argument
     *
     * @param rectIn
     * @return
     */
    private boolean isRectInKeyRects(Rectangle rectIn) {
        int overlapCount = 0;
        for (int id = 0; id < this.keyComponentRects.length - 1; id++) {
            if (keyComponentRects[id] != null) {
                if (keyComponentRects[id].intersects(rectIn)) {
                    overlapCount++;
                }
            }
        }
        return overlapCount > 0;
    }

    /**
     * Returns true if rect overlaps an exisitng oval rect. The passed rect
     * should not already be in the list.
     *
     * @param rectIn
     * @return
     */
    private boolean isRectInOvalRects(Rectangle rectIn) {
        int overLapCount = 0;
        for (int id = 0; id < this.ovalComponentRects.length; id++) {
            if (ovalComponentRects[id] != null) { // If null entry, does not change the count
                if (ovalComponentRects[id].intersects(rectIn)) {
                    overLapCount++;
                }
            }
        }
        return overLapCount > 0;
    }

    /**
     * Updates the rects, their references in the array, the score, and picks
     * the next color prompt
     */
    private void prepareNextRound() {
        // Redefine ovals (not colors...)
        this.fillKeyRectMap();
        this.resetOvalMap();
        yellowOvalRect = getRandomRectangle(100, 100);
        redOvalRect = getRandomRectangle(100, 100);
        greenOvalRect = getRandomRectangle(100, 100);
        pinkOvalRect = getRandomRectangle(100, 100);
        blueOvalRect = getRandomRectangle(100, 100);
        fillOvalRectMap();
        // Update score
        updateScore();
        // Chose the nex color
        setNextColorPrompt();

    }

    /**
     * Randomly chooses a color from the color list and updates the text and
     * it's font color
     */
    private void setNextColorPrompt() {
        do {
            System.out.println("Choosing a color.");
            this.currentColorToGuess = COLOR_PROMPTS[random.nextInt(5)];
        } while (this.previousColor == currentColorToGuess);
        System.out.println("Chose a color.");
        this.colorPrompt.setText(COLOR_PROMPTS_TEXT[random.nextInt(5)]);
        this.colorPrompt.setForeground(currentColorToGuess);
        this.previousColor = currentColorToGuess;
    }

    /**
     * Update the player score visual
     */
    private void updateScore() {
        this.scoreLabel.setText("Score: " + this.userScore);
        repaint();
    }

    private void handlePlayerInteraction(MouseEvent event) throws IOException {
        if (getOvalRectForPrompt().contains(event.getPoint())) {
            System.out.println("Clicked on an oval that is the correct color.");
            userScore += 100;
            if (currentRound < MAX_ROUNDS) {
                currentRound++;
                prepareNextRound();
            } else {
                // At round 5...
                addEndGamePanel();
            }

        } else {
            for (int index = 0; index < ovalComponentRects.length; index++) {
                if (ovalComponentRects[index] != null) {
                    if (ovalComponentRects[index] != getOvalRectForPrompt()) {
                        if (ovalComponentRects[index].contains(event.getPoint())) {
                            System.out.println("Clicked on an oval that is not the correct color.");
                            wrongColor();
                        } else {
                            System.out.println("Clicked on an oval or someplace that is not the correct color.");
                        }
                    }
                }
            }
        }
    }

    private Rectangle getOvalRectForPrompt() {
        switch (this.currentColorToGuess.toString()) {
            case "java.awt.Color[r=255,g=0,b=0]": // Red
                return redOvalRect;
            case "java.awt.Color[r=255,g=255,b=0]": // Yellow
                return yellowOvalRect;
            case "java.awt.Color[r=0,g=255,b=0]": // Green
                return greenOvalRect;
            case "java.awt.Color[r=0,g=0,b=255]": // Blue
                return blueOvalRect;
            case "java.awt.Color[r=255,g=175,b=175]": // Pink
                return pinkOvalRect;
            default:
                System.out.println("Could not find a suitable rect for the " + currentColorToGuess.toString());
                return null;
        }

    }

    /**
     * will handle when a color is picked incorrectly
     *
     * @throws IOException
     */
    public void wrongColor() throws IOException {
        JOptionPane.showMessageDialog(mainFrame, "Wrong color!");
        if (this.currentRound >= MAX_ROUNDS) {
            this.addEndGamePanel();
        } else {
            userScore += 0;
            currentRound++;
            prepareNextRound();
        }
        this.repaint();
    }

    public void compareHighScore() throws FileNotFoundException, IOException {

        File file = new File("..\\score.txt");
        FileInputStream inFile = new FileInputStream(file);
        DataInputStream dInputStream = new DataInputStream(inFile);
        BufferedReader breader = new BufferedReader(new InputStreamReader(dInputStream));
        String userInitials = "";
        String initialToChange = "";
        Map<String, Integer> scores = new HashMap<>();

        boolean changed = false;
        int scoreToChange = 0;

        //Parses file for initials and scores and puts into a Map(Initials, Scores)
        for (int i = 0; i < 5; i++) {
            String line = breader.readLine();
            String num = line.replaceAll("[^0-9]", "");
            String initials = line.replaceAll("[^A-Z]", "");

            int score = Integer.parseInt(num);
            
            //If score higher than lowest score, replaces lowest score
            if ((userScore > score && i == 4) && !changed) {
               
                scoreToChange = score;
                score = userScore;
                initialToChange = initials;
                changed = true;
            }
            scores.put(initials, score);
        }

        // Display a message after comparing the scores. Nothing happens when the user score is lower than the lowest high score
        if (changed == true) {
            userInitials = JOptionPane.showInputDialog(mainFrame, "You set a new high score with " + userScore + " points!\nPlease enter in your intials below: ");
            scores.remove(initialToChange);
            scores.put(userInitials, userScore);
            HashMap<String, Integer> sorted = sortByValue(scores);
            System.out.println(sorted);
            // Get entry set of the TreeMap using entrySet
            // method
            Set<Map.Entry<String, Integer>> entrySet
                    = sorted.entrySet();

            // Convert entrySet to Array using toArray method
            Map.Entry<String, Integer>[] entryArray
                    = entrySet.toArray(
                            new Map.Entry[entrySet.size()]);
            
            //Write changes to file
            try {
                FileWriter fw = new FileWriter(file);
                for (int i = 4; i >= 0; i--) {
                    fw.write(entryArray[i].getValue() + " " + entryArray[i].getKey().toString() + "\n");
                }
                fw.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();

            }

        }

    }
    
    
    //Helper method to resort HashMap for rewrite
    public static HashMap<String, Integer>
    sortByValue(Map<String, Integer> hm)
    {
        HashMap<String, Integer> temp
            = hm.entrySet()
                  .stream()
                  .sorted((i1, i2)
                              -> i1.getValue().compareTo(
                                  i2.getValue()))
                  .collect(Collectors.toMap(
                      Map.Entry::getKey,
                      Map.Entry::getValue,
                      (e1, e2) -> e1, LinkedHashMap::new));
 
        return temp;
    }


}
