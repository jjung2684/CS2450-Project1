/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingprojectv1.pkg0;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JPanel;

/**
 *
 * @author tommy
 */
public class ColorGameScreen extends JPanel implements ActionListener {
    private final MainFrame mainFrame;
    private JPanel gamePanel;
    
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
            this.getPreferredSize();
            this.setVisible(true);
            
            
        }
    
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        super.paintComponent(g);
        
        // yellow cirlcle
        g2.setColor(Color.yellow);
        g2.fillOval(50, 150, 100, 100);
        
        // red circle
        g2.setColor(Color.red);
        g2.fillOval(150, 250, 100, 100);
        
        // green circle
        g2.setColor(Color.green);
        g2.fillOval(250, 150, 100, 100);
        
        // blue circle
        g2.setColor(Color.blue);
        g2.fillOval(350, 250, 100, 100);
        
        // pink circle
        g2.setColor(Color.pink);
        g2.fillOval(450, 150, 100, 100);
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
