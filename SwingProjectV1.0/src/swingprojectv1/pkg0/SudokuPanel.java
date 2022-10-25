package swingprojectv1.pkg0;

/**
 * *************************************************************
 * file: SudokuBoardPanel.class author: Tommy James & Co. class: CS 2450.01
 *
 * assignment: Project 1.2 date last modified: 10/09/22
 *
 * purpose: This class builds the Sudoku game board.
 *
 ***************************************************************
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.print.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;

/**
 *
 * @author tommy
 */
public class SudokuPanel extends JPanel implements PropertyChangeListener, ActionListener {

    private MainFrame frame;

    private JFormattedTextField entryField1, entryField2, entryField3, entryField4,
            entryField5, entryField6, entryField7, entryField8, entryField9,
            entryField10, entryField11, entryField12, entryField13,
            entryField14, entryField15, entryField16, entryField17, entryField18,
            entryField19, entryField20, entryField21, entryField22,
            entryField23, entryField24, entryField25, entryField26, entryField27,
            entryField28, entryField29, entryField30, entryField31,
            entryField32, entryField33, entryField34, entryField35, entryField36,
            entryField37, entryField38, entryField39, entryField40,
            entryField41, entryField42, entryField43, entryField44, entryField45,
            entryField46, entryField47, entryField48, entryField49,
            entryField50, entryField51, entryField52, entryField53, entryField54,
            entryField55, entryField56, entryField57, entryField58,
            entryField59, entryField60, entryField61, entryField62, entryField63,
            entryField64, entryField65, entryField66, entryField67,
            entryField68, entryField69, entryField70, entryField71, entryField72,
            entryField73, entryField74, entryField75, entryField76,
            entryField77, entryField78, entryField79, entryField80, entryField81;
    
    private JPanel entryPanel1, entryPanel2, entryPanel3, entryPanel4,
            entryPanel5, entryPanel6, entryPanel7, entryPanel8, entryPanel9;

    private JButton submitButton;
    private JButton quitButton;
    private JLabel clockLabel;
    private ArrayList<Integer> gameArray;
    private int[] solutionArray;
    private EndScreenPanel endScreen;
    private int userScore;

    public SudokuPanel(MainFrame frame) {
        this.frame = frame;
        gameArray = new ArrayList<Integer>();
        createGameBoard();
        setLayout(new BorderLayout());
        userScore = 540;
    }

    private void createGameBoard() {        

        // <editor-fold defaultstate="collapsed" desc="create Sudoku panels">
        entryPanel1 = new JPanel();
        entryPanel1.setBounds(170, 55, 85, 85);
        entryPanel1.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        entryPanel1.setBackground(Color.white);
        
        entryPanel2 = new JPanel();
        entryPanel2.setBounds(255, 55, 85, 85);
        entryPanel2.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        entryPanel2.setBackground(Color.white);
        
        entryPanel3 = new JPanel();
        entryPanel3.setBounds(340, 55, 85, 85);
        entryPanel3.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        entryPanel3.setBackground(Color.white);
        
        entryPanel4 = new JPanel();
        entryPanel4.setBounds(170, 140, 85, 85);
        entryPanel4.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        entryPanel4.setBackground(Color.white);
        
        entryPanel5 = new JPanel();
        entryPanel5.setBounds(255, 140, 85, 85);
        entryPanel5.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        entryPanel5.setBackground(Color.white);
        
        entryPanel6 = new JPanel();
        entryPanel6.setBounds(340, 140, 85, 85);
        entryPanel6.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        entryPanel6.setBackground(Color.white);
        
        entryPanel7 = new JPanel();
        entryPanel7.setBounds(170, 225, 85, 85);
        entryPanel7.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        entryPanel7.setBackground(Color.white);
        
        entryPanel8 = new JPanel();
        entryPanel8.setBounds(255, 225, 85, 85);
        entryPanel8.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        entryPanel8.setBackground(Color.white);
        
        entryPanel9 = new JPanel();
        entryPanel9.setBounds(340, 225, 85, 85);
        entryPanel9.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        entryPanel9.setBackground(Color.white);
        
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="create text fields">
        // row 1
        entryField1 = new JFormattedTextField();
        entryField1.setValue(8);
        entryField1.setColumns(1);
        entryField1.addPropertyChangeListener("value", this);
        entryField1.setEditable(false);
        entryField1.setForeground(new Color(255, 0, 0));
        

        entryField2 = new JFormattedTextField();
        entryField2.setColumns(1);
        entryField2.addPropertyChangeListener("value", this);

        entryField3 = new JFormattedTextField();
        entryField3.setColumns(1);
        entryField3.addPropertyChangeListener("value", this);

        entryField4 = new JFormattedTextField();
        entryField4.setValue(4);
        entryField4.setColumns(1);
        entryField4.addPropertyChangeListener("value", this);
        entryField4.setEditable(false);
        entryField4.setForeground(new Color(255, 0, 0));

        entryField5 = new JFormattedTextField();
        entryField5.setColumns(1);
        entryField5.addPropertyChangeListener("value", this);

        entryField6 = new JFormattedTextField();
        entryField6.setValue(6);
        entryField6.setColumns(1);
        entryField6.addPropertyChangeListener("value", this);
        entryField6.setEditable(false);
        entryField6.setForeground(new Color(255, 0, 0));

        entryField7 = new JFormattedTextField();
        entryField7.setColumns(1);
        entryField7.addPropertyChangeListener("value", this);

        entryField8 = new JFormattedTextField();
        entryField8.setColumns(1);
        entryField8.addPropertyChangeListener("value", this);

        entryField9 = new JFormattedTextField();
        entryField9.setValue(7);
        entryField9.setColumns(1);
        entryField9.addPropertyChangeListener("value", this);
        entryField9.setEditable(false);
        entryField9.setForeground(new Color(255, 0, 0));

        // row 2
        entryField10 = new JFormattedTextField();
        entryField10.setColumns(1);
        entryField10.addPropertyChangeListener("value", this);

        entryField11 = new JFormattedTextField();
        entryField11.setColumns(1);
        entryField11.addPropertyChangeListener("value", this);

        entryField12 = new JFormattedTextField();
        entryField12.setColumns(1);
        entryField12.addPropertyChangeListener("value", this);

        entryField13 = new JFormattedTextField();
        entryField13.setColumns(1);
        entryField13.addPropertyChangeListener("value", this);

        entryField14 = new JFormattedTextField();
        entryField14.setColumns(1);
        entryField14.addPropertyChangeListener("value", this);

        entryField15 = new JFormattedTextField();
        entryField15.setColumns(1);
        entryField15.addPropertyChangeListener("value", this);

        entryField16 = new JFormattedTextField();
        entryField16.setValue(4);
        entryField16.setColumns(1);
        entryField16.addPropertyChangeListener("value", this);
        entryField16.setEditable(false);
        entryField16.setForeground(new Color(255, 0, 0));

        entryField17 = new JFormattedTextField();
        entryField17.setColumns(1);
        entryField17.addPropertyChangeListener("value", this);

        entryField18 = new JFormattedTextField();
        entryField18.setColumns(1);
        entryField18.addPropertyChangeListener("value", this);

        // row 3
        entryField19 = new JFormattedTextField();
        entryField19.setColumns(1);
        entryField19.addPropertyChangeListener("value", this);

        entryField20 = new JFormattedTextField();
        entryField20.setValue(1);
        entryField20.setColumns(1);
        entryField20.addPropertyChangeListener("value", this);
        entryField20.setEditable(false);
        entryField20.setForeground(new Color(255, 0, 0));

        entryField21 = new JFormattedTextField();
        entryField21.setColumns(1);
        entryField21.addPropertyChangeListener("value", this);

        entryField22 = new JFormattedTextField();
        entryField22.setColumns(1);
        entryField22.addPropertyChangeListener("value", this);

        entryField23 = new JFormattedTextField();
        entryField23.setColumns(1);
        entryField23.addPropertyChangeListener("value", this);

        entryField24 = new JFormattedTextField();
        entryField24.setColumns(1);
        entryField24.addPropertyChangeListener("value", this);

        entryField25 = new JFormattedTextField();
        entryField25.setValue(6);
        entryField25.setColumns(1);
        entryField25.addPropertyChangeListener("value", this);
        entryField25.setEditable(false);
        entryField25.setForeground(new Color(255, 0, 0));

        entryField26 = new JFormattedTextField();
        entryField26.setValue(5);
        entryField26.setColumns(1);
        entryField26.addPropertyChangeListener("value", this);
        entryField26.setEditable(false);
        entryField26.setForeground(new Color(255, 0, 0));

        entryField27 = new JFormattedTextField();
        entryField27.setColumns(1);
        entryField27.addPropertyChangeListener("value", this);

        // row 4
        entryField28 = new JFormattedTextField();
        entryField28.setValue(5);
        entryField28.setColumns(1);
        entryField28.addPropertyChangeListener("value", this);
        entryField28.setEditable(false);
        entryField28.setForeground(new Color(255, 0, 0));

        entryField29 = new JFormattedTextField();
        entryField29.setColumns(1);
        entryField29.addPropertyChangeListener("value", this);

        entryField30 = new JFormattedTextField();
        entryField30.setValue(9);
        entryField30.setColumns(1);
        entryField30.addPropertyChangeListener("value", this);
        entryField30.setEditable(false);
        entryField30.setForeground(new Color(255, 0, 0));

        entryField31 = new JFormattedTextField();
        entryField31.setColumns(1);
        entryField31.addPropertyChangeListener("value", this);

        entryField32 = new JFormattedTextField();
        entryField32.setValue(3);
        entryField32.setColumns(1);
        entryField32.addPropertyChangeListener("value", this);
        entryField32.setEditable(false);
        entryField32.setForeground(new Color(255, 0, 0));

        entryField33 = new JFormattedTextField();
        entryField33.setColumns(1);
        entryField33.addPropertyChangeListener("value", this);

        entryField34 = new JFormattedTextField();
        entryField34.setValue(7);
        entryField34.setColumns(1);
        entryField34.addPropertyChangeListener("value", this);
        entryField34.setEditable(false);
        entryField34.setForeground(new Color(255, 0, 0));

        entryField35 = new JFormattedTextField();
        entryField35.setValue(8);
        entryField35.setColumns(1);
        entryField35.addPropertyChangeListener("value", this);
        entryField35.setEditable(false);
        entryField35.setForeground(new Color(255, 0, 0));

        entryField36 = new JFormattedTextField();
        entryField36.setColumns(1);
        entryField36.addPropertyChangeListener("value", this);

        // row 5
        entryField37 = new JFormattedTextField();
        entryField37.setColumns(1);
        entryField37.addPropertyChangeListener("value", this);

        entryField38 = new JFormattedTextField();
        entryField38.setColumns(1);
        entryField38.addPropertyChangeListener("value", this);

        entryField39 = new JFormattedTextField();
        entryField39.setColumns(1);
        entryField39.addPropertyChangeListener("value", this);

        entryField40 = new JFormattedTextField();
        entryField40.setColumns(1);
        entryField40.addPropertyChangeListener("value", this);

        entryField41 = new JFormattedTextField();
        entryField41.setValue(7);
        entryField41.setColumns(1);
        entryField41.addPropertyChangeListener("value", this);
        entryField41.setEditable(false);
        entryField41.setForeground(new Color(255, 0, 0));

        entryField42 = new JFormattedTextField();
        entryField42.setColumns(1);
        entryField42.addPropertyChangeListener("value", this);

        entryField43 = new JFormattedTextField();
        entryField43.setColumns(1);
        entryField43.addPropertyChangeListener("value", this);

        entryField44 = new JFormattedTextField();
        entryField44.setColumns(1);
        entryField44.addPropertyChangeListener("value", this);

        entryField45 = new JFormattedTextField();
        entryField45.setColumns(1);
        entryField45.addPropertyChangeListener("value", this);

        // row 6
        entryField46 = new JFormattedTextField();
        entryField46.setColumns(1);
        entryField46.addPropertyChangeListener("value", this);

        entryField47 = new JFormattedTextField();
        entryField47.setValue(4);
        entryField47.setColumns(1);
        entryField47.addPropertyChangeListener("value", this);
        entryField47.setEditable(false);
        entryField47.setForeground(new Color(255, 0, 0));

        entryField48 = new JFormattedTextField();
        entryField48.setValue(8);
        entryField48.setColumns(1);
        entryField48.addPropertyChangeListener("value", this);
        entryField48.setEditable(false);
        entryField48.setForeground(new Color(255, 0, 0));

        entryField49 = new JFormattedTextField();
        entryField49.setColumns(1);
        entryField49.addPropertyChangeListener("value", this);

        entryField50 = new JFormattedTextField();
        entryField50.setValue(2);
        entryField50.setColumns(1);
        entryField50.addPropertyChangeListener("value", this);
        entryField50.setEditable(false);
        entryField50.setForeground(new Color(255, 0, 0));

        entryField51 = new JFormattedTextField();
        entryField51.setColumns(1);
        entryField51.addPropertyChangeListener("value", this);

        entryField52 = new JFormattedTextField();
        entryField52.setValue(1);
        entryField52.setColumns(1);
        entryField52.addPropertyChangeListener("value", this);
        entryField52.setEditable(false);
        entryField52.setForeground(new Color(255, 0, 0));

        entryField53 = new JFormattedTextField();
        entryField53.setColumns(1);
        entryField53.addPropertyChangeListener("value", this);

        entryField54 = new JFormattedTextField();
        entryField54.setValue(3);
        entryField54.setColumns(1);
        entryField54.addPropertyChangeListener("value", this);
        entryField54.setEditable(false);
        entryField54.setForeground(new Color(255, 0, 0));

        // row 7
        entryField55 = new JFormattedTextField();
        entryField55.setColumns(1);
        entryField55.addPropertyChangeListener("value", this);

        entryField56 = new JFormattedTextField();
        entryField56.setValue(5);
        entryField56.setColumns(1);
        entryField56.addPropertyChangeListener("value", this);
        entryField56.setEditable(false);
        entryField56.setForeground(new Color(255, 0, 0));

        entryField57 = new JFormattedTextField();
        entryField57.setValue(2);
        entryField57.setColumns(1);
        entryField57.addPropertyChangeListener("value", this);
        entryField57.setEditable(false);
        entryField57.setForeground(new Color(255, 0, 0));

        entryField58 = new JFormattedTextField();
        entryField58.setColumns(1);
        entryField58.addPropertyChangeListener("value", this);

        entryField59 = new JFormattedTextField();
        entryField59.setColumns(1);
        entryField59.addPropertyChangeListener("value", this);

        entryField60 = new JFormattedTextField();
        entryField60.setColumns(1);
        entryField60.addPropertyChangeListener("value", this);

        entryField61 = new JFormattedTextField();
        entryField61.setColumns(1);
        entryField61.addPropertyChangeListener("value", this);

        entryField62 = new JFormattedTextField();
        entryField62.setValue(9);
        entryField62.setColumns(1);
        entryField62.addPropertyChangeListener("value", this);
        entryField62.setEditable(false);
        entryField62.setForeground(new Color(255, 0, 0));

        entryField63 = new JFormattedTextField();
        entryField63.setColumns(1);
        entryField63.addPropertyChangeListener("value", this);

        // row 8
        entryField64 = new JFormattedTextField();
        entryField64.setColumns(1);
        entryField64.addPropertyChangeListener("value", this);

        entryField65 = new JFormattedTextField();
        entryField65.setColumns(1);
        entryField65.addPropertyChangeListener("value", this);

        entryField66 = new JFormattedTextField();
        entryField66.setValue(1);
        entryField66.setColumns(1);
        entryField66.addPropertyChangeListener("value", this);
        entryField66.setEditable(false);
        entryField66.setForeground(new Color(255, 0, 0));

        entryField67 = new JFormattedTextField();
        entryField67.setColumns(1);
        entryField67.addPropertyChangeListener("value", this);

        entryField68 = new JFormattedTextField();
        entryField68.setColumns(1);
        entryField68.addPropertyChangeListener("value", this);

        entryField69 = new JFormattedTextField();
        entryField69.setColumns(1);
        entryField69.addPropertyChangeListener("value", this);

        entryField70 = new JFormattedTextField();
        entryField70.setColumns(1);
        entryField70.addPropertyChangeListener("value", this);

        entryField71 = new JFormattedTextField();
        entryField71.setColumns(1);
        entryField71.addPropertyChangeListener("value", this);

        entryField72 = new JFormattedTextField();
        entryField72.setColumns(1);
        entryField72.addPropertyChangeListener("value", this);

        // row 9
        entryField73 = new JFormattedTextField();
        entryField73.setValue(3);
        entryField73.setColumns(1);
        entryField73.addPropertyChangeListener("value", this);
        entryField73.setEditable(false);
        entryField73.setForeground(new Color(255, 0, 0));

        entryField74 = new JFormattedTextField();
        entryField74.setColumns(1);
        entryField74.addPropertyChangeListener("value", this);

        entryField75 = new JFormattedTextField();
        entryField75.setColumns(1);
        entryField75.addPropertyChangeListener("value", this);

        entryField76 = new JFormattedTextField();
        entryField76.setValue(9);
        entryField76.setColumns(1);
        entryField76.addPropertyChangeListener("value", this);
        entryField76.setEditable(false);
        entryField76.setForeground(new Color(255, 0, 0));

        entryField77 = new JFormattedTextField();
        entryField77.setColumns(1);
        entryField77.addPropertyChangeListener("value", this);

        entryField78 = new JFormattedTextField();
        entryField78.setValue(2);
        entryField78.setColumns(1);
        entryField78.addPropertyChangeListener("value", this);
        entryField78.setEditable(false);
        entryField78.setForeground(new Color(255, 0, 0));

        entryField79 = new JFormattedTextField();
        entryField79.setColumns(1);
        entryField79.addPropertyChangeListener("value", this);

        entryField80 = new JFormattedTextField();
        entryField80.setColumns(1);
        entryField80.addPropertyChangeListener("value", this);

        entryField81 = new JFormattedTextField();
        entryField81.setValue(5);
        entryField81.setColumns(1);
        entryField81.addPropertyChangeListener("value", this);
        entryField81.setEditable(false);
        entryField81.setForeground(new Color(255, 0, 0));
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Add text fields to panel">
        
        entryPanel1.add(entryField1);
        entryPanel1.add(entryField2);
        entryPanel1.add(entryField3);
        entryPanel1.add(entryField10);
        entryPanel1.add(entryField11);
        entryPanel1.add(entryField12);
        entryPanel1.add(entryField19);
        entryPanel1.add(entryField20);
        entryPanel1.add(entryField21);
        
        entryPanel2.add(entryField4);
        entryPanel2.add(entryField5);
        entryPanel2.add(entryField6);
        entryPanel2.add(entryField13);
        entryPanel2.add(entryField14);
        entryPanel2.add(entryField15);
        entryPanel2.add(entryField22);
        entryPanel2.add(entryField23);
        entryPanel2.add(entryField24);
        
        entryPanel3.add(entryField7);
        entryPanel3.add(entryField8);
        entryPanel3.add(entryField9);
        entryPanel3.add(entryField16);
        entryPanel3.add(entryField17);
        entryPanel3.add(entryField18);
        entryPanel3.add(entryField25);
        entryPanel3.add(entryField26);
        entryPanel3.add(entryField27);
        
        entryPanel4.add(entryField28);
        entryPanel4.add(entryField29);
        entryPanel4.add(entryField30);
        entryPanel4.add(entryField37);
        entryPanel4.add(entryField38);
        entryPanel4.add(entryField39);
        entryPanel4.add(entryField46);
        entryPanel4.add(entryField47);
        entryPanel4.add(entryField48);
        
        entryPanel5.add(entryField31);
        entryPanel5.add(entryField32);
        entryPanel5.add(entryField33);
        entryPanel5.add(entryField40);
        entryPanel5.add(entryField41);
        entryPanel5.add(entryField42);
        entryPanel5.add(entryField49);
        entryPanel5.add(entryField50);
        entryPanel5.add(entryField51);
        
        entryPanel6.add(entryField34);
        entryPanel6.add(entryField35);
        entryPanel6.add(entryField36);
        entryPanel6.add(entryField43);
        entryPanel6.add(entryField44);
        entryPanel6.add(entryField45);
        entryPanel6.add(entryField52);
        entryPanel6.add(entryField53);
        entryPanel6.add(entryField54);
        
        entryPanel7.add(entryField55);
        entryPanel7.add(entryField56);
        entryPanel7.add(entryField57);
        entryPanel7.add(entryField64);
        entryPanel7.add(entryField65);
        entryPanel7.add(entryField66);
        entryPanel7.add(entryField73);
        entryPanel7.add(entryField74);
        entryPanel7.add(entryField75);
        
        entryPanel8.add(entryField58);
        entryPanel8.add(entryField59);
        entryPanel8.add(entryField60);
        entryPanel8.add(entryField67);
        entryPanel8.add(entryField68);
        entryPanel8.add(entryField69);
        entryPanel8.add(entryField76);
        entryPanel8.add(entryField77);
        entryPanel8.add(entryField78);
        
        entryPanel9.add(entryField61);
        entryPanel9.add(entryField62);
        entryPanel9.add(entryField63);
        entryPanel9.add(entryField70);
        entryPanel9.add(entryField71);
        entryPanel9.add(entryField72);
        entryPanel9.add(entryField79);
        entryPanel9.add(entryField80);
        entryPanel9.add(entryField81);
        
        // </editor-fold>

        // add sudoku entry panel to sudoku panel
        add(entryPanel1);
        add(entryPanel2);
        add(entryPanel3);
        add(entryPanel4);
        add(entryPanel5);
        add(entryPanel6);
        add(entryPanel7);
        add(entryPanel8);
        add(entryPanel9);

        // add buttons
        submitButton = new JButton("Submit");
        submitButton.setBounds(40, 325, 80, 20);
        submitButton.addActionListener(this);
        submitButton.setToolTipText("Submit Game and check for correct solution.");
        add(submitButton);

        quitButton = new JButton("Quit");
        quitButton.setBounds(480, 325, 80, 20);
        quitButton.setToolTipText("Quit game and go back to home screen.");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    quitGame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        add(quitButton);

        // add clock
        Timer timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                time();
            }
        });

        clockLabel = new JLabel();
        clockLabel.setBounds(390, 5, 250, 22);
        add(clockLabel);

        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();

        time();
    }

    public void SubmitGame() throws IOException {
        this.frame.remove(this);
        this.endScreen = new EndScreenPanel(null, this.frame, userScore, "Congrats!", true);
        this.frame.add(this.endScreen);
        this.endScreen.setVisible(true);

        this.frame.repaint();
        this.frame.revalidate();

    }

    public void quitGame() throws IOException {
        this.frame.remove(this);
        this.endScreen = new EndScreenPanel(null, this.frame, 0, "Game Over!");
        this.frame.add(this.endScreen);
        this.endScreen.setVisible(true);

        this.frame.repaint();
        this.frame.revalidate();

    }

    public void checkSolution() throws IOException {
        Boolean win = true;
        int[] solutionArray = {
            8, 3, 5, 4, 1, 6, 9, 2, 7,
            2, 9, 6, 8, 5, 7, 4, 3, 1,
            4, 1, 7, 2, 9, 3, 6, 5, 8,
            5, 6, 9, 1, 3, 4, 7, 8, 2,
            1, 2, 3, 6, 7, 8, 5, 4, 9,
            7, 4, 8, 5, 2, 9, 1, 6, 3,
            6, 5, 2, 7, 8, 1, 3, 9, 4,
            9, 8, 1, 3, 4, 5, 2, 7, 6,
            3, 7, 4, 9, 6, 2, 8, 1, 5};

        for (int i = 0; i < solutionArray.length; i++) {
            if (solutionArray[i] != gameArray.get(i)) {
                win = false;

                userScore -= 10;
            }
        }

        if (win) {
            System.out.println("You won!");
            SubmitGame();
            compareHighScore();
        } else {
            System.out.println("You lost.");
            gameArray.clear();
            JDialog wrongD = new JDialog(this.frame, "Error");
            JLabel message = new JLabel("Incorrect solution, try again", JLabel.CENTER);
            wrongD.add(message);
            wrongD.setSize(250, 150);
            wrongD.setLocationRelativeTo(null);
            wrongD.setVisible(true);

        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    public void paintComponent(Graphics g) {

        int x = 150;
        int y = 50;
        JFormattedTextField textField = new JFormattedTextField(1);

        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);

        g2.setFont(new Font("Brush Script MT", Font.BOLD, 36));
        g2.setColor(Color.red);
        g2.drawString("Sudoku", 10, 30);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

    private void time() {
        clockLabel.setText(DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM).format(new Date()));
    }

    public void emptyBoxDialog(int numberOfEmpties) {
        JDialog empty = new JDialog(this.frame, "Error");
        JLabel message = new JLabel("Error, there are " + numberOfEmpties + " empty boxes", JLabel.CENTER);
        empty.add(message);
//        this.add(empty);
        empty.setSize(250, 150);
        empty.setLocationRelativeTo(null);
        empty.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean empty = false;
        int numberOfEmpties = 0;
        ArrayList<JFormattedTextField> entryFields = new ArrayList<>(Arrays.asList(entryField1, entryField2, entryField3, entryField4,
                entryField5, entryField6, entryField7, entryField8, entryField9,
                entryField10, entryField11, entryField12, entryField13,
                entryField14, entryField15, entryField16, entryField17, entryField18,
                entryField19, entryField20, entryField21, entryField22,
                entryField23, entryField24, entryField25, entryField26, entryField27,
                entryField28, entryField29, entryField30, entryField31,
                entryField32, entryField33, entryField34, entryField35, entryField36,
                entryField37, entryField38, entryField39, entryField40,
                entryField41, entryField42, entryField43, entryField44, entryField45,
                entryField46, entryField47, entryField48, entryField49,
                entryField50, entryField51, entryField52, entryField53, entryField54,
                entryField55, entryField56, entryField57, entryField58,
                entryField59, entryField60, entryField61, entryField62, entryField63,
                entryField64, entryField65, entryField66, entryField67,
                entryField68, entryField69, entryField70, entryField71, entryField72,
                entryField73, entryField74, entryField75, entryField76,
                entryField77, entryField78, entryField79, entryField80, entryField81));
        if (e.getSource() == submitButton) {

            // <editor-fold defaultstate="collapsed" desc="Add user inputs to game array">
            for (int i = 0; i < 81; i++) {
                if ((entryFields.get(i).getText()).isEmpty()) {
                    System.out.println("not an Int");
                    empty = true;
                    numberOfEmpties++;
                }
            }
            if (!empty) {

                for (int i = 0; i < 81; i++) {
                    gameArray.add(Integer.parseInt(entryFields.get(i).getText()));
                }

                // </editor-fold>
                System.out.println(gameArray);
                try {
                    checkSolution();
                } catch (IOException ex) {
                    Logger.getLogger(SudokuPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("error, empty box");
                emptyBoxDialog(numberOfEmpties);
            }
        }
    }
    
      public void compareHighScore() throws FileNotFoundException, IOException {

        File file = new File(".." + System.getProperty("file.separator") + "score.txt");
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
            userInitials = JOptionPane.showInputDialog(this.frame, "You set a new high score with " + userScore + " points!\nPlease enter in your intials below: ");
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
