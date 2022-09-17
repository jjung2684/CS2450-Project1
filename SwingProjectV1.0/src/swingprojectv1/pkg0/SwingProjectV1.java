/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingprojectv1.pkg0;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author barre
 */
public class SwingProjectV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Create Frame for game window
        MainFrame mf = new MainFrame("Hangman");
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

    }
}
