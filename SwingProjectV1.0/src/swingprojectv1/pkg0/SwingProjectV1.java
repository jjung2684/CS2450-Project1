/***************************************************************  
*  file: SwingProjectV1.class  
*  author: S. Barret & Co.
*  class: CS   2450.01
*  
*  assignment: Project 1.0  
*  date last modified: 9/16/2022
*  
*  purpose: This class has the main method for this project. Has the timer for stalling
* the splash screen and initializes the splash, home, and game panels
*  
****************************************************************/  
package swingprojectv1.pkg0;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author barre
 */
public class SwingProjectV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            // Create Frame for game window
            MainFrame mf = new MainFrame("CPP GUI Games");
            mf.setSize(new Dimension(600, 400));
            mf.addSplashPanel();
            mf.setVisible(true);
            
            
            // Create a timer for displaying splash screen
            Timer timer = new Timer(3000, new ActionListener() {
                
                // After 3s change panels...
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    mf.sp.setVisible(false);
                    try {
                        mf.addHomePanel(mf);
                        mf.remove(mf.sp);
                    } catch (IOException ex) {
                        Logger.getLogger(SwingProjectV1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            timer.setRepeats(false);
            timer.start();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SwingProjectV1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SwingProjectV1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SwingProjectV1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SwingProjectV1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
