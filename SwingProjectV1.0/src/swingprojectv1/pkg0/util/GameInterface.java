package swingprojectv1.pkg0.util;

import java.io.IOException;

/**
 * An interface that specifies basic actions and features that every game screen/Panel
 * should have.
 * @author wwwyv
 */
public interface GameInterface {
 
    public void initComponents();
    
    public void skipGame();
    
    public void addEndGamePanel();
    
    public void addEnGamePanel(String message);
    
    public void updatePlayerScore();
    
    public int getPlayerScore();
}
