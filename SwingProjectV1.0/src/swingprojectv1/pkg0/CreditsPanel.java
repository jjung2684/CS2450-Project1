/***************************************************************  
*  file: CreditsPanel.class  
*  author: Ly Hoang 
*  class: CS   2450.01
*  
*  assignment: Project 1.1  
*  date last modified: 9/16/2022
*  
*  purpose: This class has the credits panel for the hangman game,
* displaying our names and bronco IDS
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
public class CreditsPanel extends JPanel implements ActionListener {
    
    private final MainFrame mainFrame;
    private EndScreenPanel endScreenPanel;
    
    // Components
    private JButton backButton;
    private BufferedImage image;
    private Font font;
    private JLabel label;
    
    public CreditsPanel (MainFrame mainFrame) throws IOException {
        backButton = new JButton("Back");
        image = ImageIO.read(new URL("https://res.cloudinary.com/dt2autub1/image/upload/v1663640188/assets/Credit_vfg2k1.jpg"));
        //Image img = ImageIO.read(new File("background.jpg")
        this.mainFrame = mainFrame;
        this.setBackground(Color.white);
        this.setLayout(null);
        
        // Back to home button
        backButton = new JButton();
        
        backButton.setText("Back to Home");
        backButton.setToolTipText("Go back to main screen");
        backButton.setBounds(200, 300, 150, 40);
        backButton.addActionListener(this);
        
        this.add(backButton);
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }
    
    public void paintComponent(Graphics g) {
        font = new Font("Apple Casual", Font.BOLD, 22);
        
        // cast g as a Graphics2D object
        Graphics2D g2 = (Graphics2D) g;
        
        super.paintComponent(g);

        g2.setFont(font);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.black);
        
        // draw image
        g2.drawImage(image, 0, 0, null);

        // draw strings
        g2.drawString("Credits", 250, 50);
        g2.drawString("CarlTheSpiny, 123456789", 150, 120);
        g2.drawString("Jacob Jung, 010812009", 150, 150);
        g2.drawString("Ly Hoang Rivera, 014384968", 150, 180);
        g2.drawString("spencer barrett, 011727157", 150, 210);
        g2.drawString("Tommy James, 014478542", 150, 240);
        

        
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


