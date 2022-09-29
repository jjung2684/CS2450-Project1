/***************************************************************  
*  file: AlphabetButtonHelper.class  
*  author: M. Geronimo  
*  class: CS   2450.01
*  
*  assignment: Project 1.1  
*  date last modified: 9/16/2022
*  
*  purpose: This class has methods to help do the hangman game logic,
* specifically, it helps manage whether buttons are enabled and adding letters
* to the player guess
*  
****************************************************************/  
package swingprojectv1.pkg0;

import java.awt.event.ActionEvent;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author wwwyv
 */
public class AlphabetButtonHelper {
    
    private String textField;
    private Map<Integer, JButton> buttonMap;
    private JButton[] disabledButtonMap;
    public JButton[] enabledButtons;
    private int buttonCounter = 0;
    
    public AlphabetButtonHelper(String textField) {
        this.textField = textField;
        this.disabledButtonMap = new JButton[26];
        this.enabledButtons = new JButton[26];
    }
    
    public AlphabetButtonHelper() {
        this.textField = "";
        this.disabledButtonMap = new JButton[26];
        this.enabledButtons = new JButton[26];
    }
    
    public void resetWordToGuess() {
        this.textField = "";
    }
    
    public void addLetterToString(java.awt.event.ActionEvent evt, JLabel textLabel) {
        if (evt.getSource() instanceof JButton) {
            JButton button = (JButton)evt.getSource();
            textLabel.setText(this.getTextField() + button.getText());
        }
    }
    
    public void addLetterToString(java.awt.event.ActionEvent evt, JLabel textLabel, String textField) {
        if (evt.getSource() instanceof JButton) {
               JButton button = (JButton)evt.getSource();
               textLabel.setText(textField + button.getText());   
        }
    }
    
    public void perfromBackspace(ActionEvent event, JLabel textLabel, String textField) {
        if (event.getSource() instanceof JButton) {
            String updatedTextField = textField;
            String stringToBuild = "";
            JButton backspace = (JButton)event.getSource();
            char[] charArray = updatedTextField.toCharArray();
            
            for (int i = 0; i < charArray.length - 1; i++) {
                stringToBuild = stringToBuild + charArray[i] + "";
                
            }
            textLabel.setText(stringToBuild);
        }
    }
    
    public void disableButton(JButton button) {
        button.setEnabled(false);
        disabledButtonMap[buttonCounter] = button;
        buttonCounter++;
    }
    
    public void reEnableButtons() {
        
        for (JButton button : disabledButtonMap) {
            if (button != null) button.setEnabled(true);
        }
        
    }
    
    public void disableAllButtons() {
        for (JButton enabledButtons : enabledButtons) {
            if (enabledButtons != null) enabledButtons.setEnabled(false);
        }
    }
    
    public boolean isDisabledButtonArrayEmpty() {
        int entries = 0;
        for (int i = 0; i < disabledButtonMap.length; i++) {
            if (disabledButtonMap[i] != null) entries++;
        }
        return entries >= 26 ? false : true;
    }
    
    
    public String getTextField() {
        return this.textField;
    }
    
    public void setTextField(String newTextField) {
        this.textField = newTextField;
    }
    
    
}
