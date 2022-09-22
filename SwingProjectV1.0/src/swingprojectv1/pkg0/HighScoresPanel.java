/***************************************************************  
*  file: HighScoresPanel.class  
*  author: Tommy James
*  class: CS   2450.01
*  
*  assignment: Project 1.0  
*  date last modified: 9/16/2022
*  
*  purpose: This class shows the high scores of the players. The scores in this
*  version are hard coded and not actual scores.
*  
****************************************************************/  
package swingprojectv1.pkg0;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tommy
 */
public class HighScoresPanel extends JPanel implements ActionListener {
    
    private final MainFrame mainFrame;
    private EndScreenPanel endScreenPanel;
    
    // Components
    private JButton backButton;
    private BufferedImage image;
    private Font font;
    private JLabel label;
    
    public HighScoresPanel (MainFrame mainFrame) throws IOException {
        backButton = new JButton("Back");
        image = ImageIO.read(new URL("https://res.cloudinary.com/dt2autub1/image/upload/v1663640334/assets/Hangman-0_yrs3l0.png"));
        
        this.mainFrame = mainFrame;
        this.setBackground(Color.white);
        this.setLayout(null);
        
        // Back to home button
        backButton = new JButton();
        
        backButton.setText("Back to Home");
        backButton.setBounds(325, 300, 150, 25);
        backButton.addActionListener(this);
        
        this.add(backButton);
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }
    
    public void paintComponent(Graphics g) {
        font = new Font("Tahoma", Font.BOLD, 18);
        
        // cast g as a Graphics2D object
        Graphics2D g2 = (Graphics2D) g;
        
        super.paintComponent(g);

        g2.setFont(font);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.red);

        // draw strings
        g2.drawString("High Scores", 350, 50);
        g2.drawString("CarlTheSpiny: 500", 300, 120);
        g2.drawString("Jacob J: 460", 300, 150);
        g2.drawString("Cat9: 420", 300, 180);
        g2.drawString("sbvrr: 390", 300, 210);
        g2.drawString("apollo: 380", 300, 240);
        
        // draw image
        g2.drawImage(image, 0, 0, 250, 300, this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton){
            try {
                this.returnToHome();
            } catch (IOException ex) {
            }
        }
    }
    
    public void returnToHome() throws IOException {
        mainFrame.remove(this);
        mainFrame.repaint();
        this.revalidate();
        this.mainFrame.addHomePanel(mainFrame);
    }
    
    
}


