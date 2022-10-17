package swingprojectv1.pkg0;

/***************************************************************  
*  file: SudokuBoardPanel.class  
*  author: Tommy James & Co.
*  class: CS   2450.01
*  
*  assignment: Project 1.2  
*  date last modified: 10/09/22
*  
*  purpose: This class builds the Sudoku game board.
*  
****************************************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.print.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author tommy
 */
public class SudokuPanel extends JPanel implements PropertyChangeListener, ActionListener {
    
    private JFrame frame;
    JFormattedTextField entryField1, entryField2, entryField3, entryField4,
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
    
    private JButton submitButton;
    private JButton quitButton;
    private JLabel clockLabel;
    private ArrayList<Integer> gameArray;
    private int[] solutionArray;
    
    public SudokuPanel(MainFrame frame){
        this.frame = frame;
        gameArray = new ArrayList<Integer>();
        createGameBoard();
        setLayout(new BorderLayout());
    }
    
    private void createGameBoard() {
        
        // create Sudoku entry panel
        JPanel entryPanel = new JPanel();
        entryPanel.setBounds(205, 75, 190, 220);
        entryPanel.setBackground(Color.gray);
        
        // <editor-fold defaultstate="collapsed" desc="create text fields">
        // row 1
        entryField1 = new JFormattedTextField();
        entryField1.setValue(8);
        entryField1.setColumns(1);
        entryField1.addPropertyChangeListener("value", this);
        
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
        
        entryField5 = new JFormattedTextField();
        entryField5.setColumns(1);
        entryField5.addPropertyChangeListener("value", this);
        
        entryField6 = new JFormattedTextField();
        entryField6.setValue(6);
        entryField6.setColumns(1);
        entryField6.addPropertyChangeListener("value", this);
        
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
        
        entryField26 = new JFormattedTextField();
        entryField26.setValue(5);
        entryField26.setColumns(1);
        entryField26.addPropertyChangeListener("value", this);
        
        entryField27 = new JFormattedTextField();
        entryField27.setColumns(1);
        entryField27.addPropertyChangeListener("value", this);
        
        // row 4
        entryField28 = new JFormattedTextField();
        entryField28.setValue(5);
        entryField28.setColumns(1);
        entryField28.addPropertyChangeListener("value", this);
        
        entryField29 = new JFormattedTextField();
        entryField29.setColumns(1);
        entryField29.addPropertyChangeListener("value", this);
        
        entryField30 = new JFormattedTextField();
        entryField30.setValue(9);
        entryField30.setColumns(1);
        entryField30.addPropertyChangeListener("value", this);
        
        entryField31 = new JFormattedTextField();
        entryField31.setColumns(1);
        entryField31.addPropertyChangeListener("value", this);
        
        entryField32 = new JFormattedTextField();
        entryField32.setValue(3);
        entryField32.setColumns(1);
        entryField32.addPropertyChangeListener("value", this);
        
        entryField33 = new JFormattedTextField();
        entryField33.setColumns(1);
        entryField33.addPropertyChangeListener("value", this);
        
        entryField34 = new JFormattedTextField();
        entryField34.setValue(7);
        entryField34.setColumns(1);
        entryField34.addPropertyChangeListener("value", this);
        
        entryField35 = new JFormattedTextField();
        entryField35.setValue(8);
        entryField35.setColumns(1);
        entryField35.addPropertyChangeListener("value", this);
        
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
        
        entryField48 = new JFormattedTextField();
        entryField48.setValue(8);
        entryField48.setColumns(1);
        entryField48.addPropertyChangeListener("value", this);
        
        entryField49 = new JFormattedTextField();
        entryField49.setColumns(1);
        entryField49.addPropertyChangeListener("value", this);
        
        entryField50 = new JFormattedTextField();
        entryField50.setValue(2);
        entryField50.setColumns(1);
        entryField50.addPropertyChangeListener("value", this);
        
        entryField51 = new JFormattedTextField();
        entryField51.setColumns(1);
        entryField51.addPropertyChangeListener("value", this);
        
        entryField52 = new JFormattedTextField();
        entryField52.setValue(1);
        entryField52.setColumns(1);
        entryField52.addPropertyChangeListener("value", this);
        
        entryField53 = new JFormattedTextField();
        entryField53.setColumns(1);
        entryField53.addPropertyChangeListener("value", this);
        
        entryField54 = new JFormattedTextField();
        entryField54.setValue(3);
        entryField54.setColumns(1);
        entryField54.addPropertyChangeListener("value", this);
        
        // row 7
        entryField55 = new JFormattedTextField();
        entryField55.setColumns(1);
        entryField55.addPropertyChangeListener("value", this);
        
        entryField56 = new JFormattedTextField();
        entryField56.setValue(5);
        entryField56.setColumns(1);
        entryField56.addPropertyChangeListener("value", this);
        
        entryField57 = new JFormattedTextField();
        entryField57.setValue(2);
        entryField57.setColumns(1);
        entryField57.addPropertyChangeListener("value", this);
        
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
        
        entryField77 = new JFormattedTextField();
        entryField77.setColumns(1);
        entryField77.addPropertyChangeListener("value", this);
        
        entryField78 = new JFormattedTextField();
        entryField78.setValue(2);
        entryField78.setColumns(1);
        entryField78.addPropertyChangeListener("value", this);
        
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
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Add text fields to panel">
        entryPanel.add(entryField1);
        entryPanel.add(entryField2);
        entryPanel.add(entryField3);
        entryPanel.add(entryField4);
        entryPanel.add(entryField5);
        entryPanel.add(entryField6);
        entryPanel.add(entryField7);
        entryPanel.add(entryField8);
        entryPanel.add(entryField9);
        entryPanel.add(entryField10);
        entryPanel.add(entryField11);
        entryPanel.add(entryField12);
        entryPanel.add(entryField13);
        entryPanel.add(entryField14);
        entryPanel.add(entryField15);
        entryPanel.add(entryField16);
        entryPanel.add(entryField17);
        entryPanel.add(entryField18);
        entryPanel.add(entryField19);
        entryPanel.add(entryField20);
        entryPanel.add(entryField21);
        entryPanel.add(entryField22);
        entryPanel.add(entryField23);
        entryPanel.add(entryField24);
        entryPanel.add(entryField25);
        entryPanel.add(entryField26);
        entryPanel.add(entryField27);
        entryPanel.add(entryField28);
        entryPanel.add(entryField29);
        entryPanel.add(entryField30);
        entryPanel.add(entryField31);
        entryPanel.add(entryField32);
        entryPanel.add(entryField33);
        entryPanel.add(entryField34);
        entryPanel.add(entryField35);
        entryPanel.add(entryField36);
        entryPanel.add(entryField37);
        entryPanel.add(entryField38);
        entryPanel.add(entryField39);
        entryPanel.add(entryField40);
        entryPanel.add(entryField41);
        entryPanel.add(entryField42);
        entryPanel.add(entryField43);
        entryPanel.add(entryField44);
        entryPanel.add(entryField45);
        entryPanel.add(entryField46);
        entryPanel.add(entryField47);
        entryPanel.add(entryField48);
        entryPanel.add(entryField49);
        entryPanel.add(entryField50);
        entryPanel.add(entryField51);
        entryPanel.add(entryField52);
        entryPanel.add(entryField53);
        entryPanel.add(entryField54);
        entryPanel.add(entryField55);
        entryPanel.add(entryField56);
        entryPanel.add(entryField57);
        entryPanel.add(entryField58);
        entryPanel.add(entryField59);
        entryPanel.add(entryField60);
        entryPanel.add(entryField61);
        entryPanel.add(entryField62);
        entryPanel.add(entryField63);
        entryPanel.add(entryField64);
        entryPanel.add(entryField65);
        entryPanel.add(entryField66);
        entryPanel.add(entryField67);
        entryPanel.add(entryField68);
        entryPanel.add(entryField69);
        entryPanel.add(entryField70);
        entryPanel.add(entryField71);
        entryPanel.add(entryField72);
        entryPanel.add(entryField73);
        entryPanel.add(entryField74);
        entryPanel.add(entryField75);
        entryPanel.add(entryField76);
        entryPanel.add(entryField77);
        entryPanel.add(entryField78);
        entryPanel.add(entryField79);
        entryPanel.add(entryField80);
        entryPanel.add(entryField81);
        // </editor-fold>
        
        // add sudoku entry panel to sudoku panel
        add(entryPanel);
        
        // add buttons
        submitButton = new JButton("Submit");
        submitButton.setBounds(40, 325, 80, 20);
        submitButton.addActionListener(this);
        add(submitButton);
        
        quitButton = new JButton("Quit");
        quitButton.setBounds(480, 325, 80, 20);
        quitButton.addActionListener(this);
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
    
    public void checkSolution(){
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
            if (solutionArray[i] != gameArray.get(i)){
                win = false;
            }
        }
        
        if (win){
            System.out.println("You won!");
        } else {
            System.out.println("You lost.");
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
        
        // 8 horizontal lines
//        g2.drawLine(100, 50, 500, 50);
//        g2.drawLine(100, 100, 500, 100);
//        g2.drawLine(100, 150, 500, 150);
//        g2.drawLine(100, 200, 500, 200);
//        g2.drawLine(100, 250, 500, 250);
//        g2.drawLine(100, 300, 500, 300);
//        g2.drawLine(100, 350, 500, 350);
//        g2.drawLine(100, 400, 500, 400);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
    
    private void time() {
        clockLabel.setText(DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM).format(new Date()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // <editor-fold defaultstate="collapsed" desc="Add user inputs to game array">
            
            // row 1
            gameArray.add(Integer.parseInt(entryField1.getText()));
            gameArray.add(Integer.parseInt(entryField2.getText()));
            gameArray.add(Integer.parseInt(entryField3.getText()));
            gameArray.add(Integer.parseInt(entryField4.getText()));
            gameArray.add(Integer.parseInt(entryField5.getText()));
            gameArray.add(Integer.parseInt(entryField6.getText()));
            gameArray.add(Integer.parseInt(entryField7.getText()));
            gameArray.add(Integer.parseInt(entryField8.getText()));
            gameArray.add(Integer.parseInt(entryField9.getText()));
            
            // row 2
            gameArray.add(Integer.parseInt(entryField10.getText()));
            gameArray.add(Integer.parseInt(entryField11.getText()));
            gameArray.add(Integer.parseInt(entryField12.getText()));
            gameArray.add(Integer.parseInt(entryField13.getText()));
            gameArray.add(Integer.parseInt(entryField14.getText()));
            gameArray.add(Integer.parseInt(entryField15.getText()));
            gameArray.add(Integer.parseInt(entryField16.getText()));
            gameArray.add(Integer.parseInt(entryField17.getText()));
            gameArray.add(Integer.parseInt(entryField18.getText()));
            
            // row 3
            gameArray.add(Integer.parseInt(entryField19.getText()));
            gameArray.add(Integer.parseInt(entryField20.getText()));
            gameArray.add(Integer.parseInt(entryField21.getText()));
            gameArray.add(Integer.parseInt(entryField22.getText()));
            gameArray.add(Integer.parseInt(entryField23.getText()));
            gameArray.add(Integer.parseInt(entryField24.getText()));
            gameArray.add(Integer.parseInt(entryField25.getText()));
            gameArray.add(Integer.parseInt(entryField26.getText()));
            gameArray.add(Integer.parseInt(entryField27.getText()));
            
            // row 4
            gameArray.add(Integer.parseInt(entryField28.getText()));
            gameArray.add(Integer.parseInt(entryField29.getText()));
            gameArray.add(Integer.parseInt(entryField30.getText()));
            gameArray.add(Integer.parseInt(entryField31.getText()));
            gameArray.add(Integer.parseInt(entryField32.getText()));
            gameArray.add(Integer.parseInt(entryField33.getText()));
            gameArray.add(Integer.parseInt(entryField34.getText()));
            gameArray.add(Integer.parseInt(entryField35.getText()));
            gameArray.add(Integer.parseInt(entryField36.getText()));
            
            // row 5
            gameArray.add(Integer.parseInt(entryField37.getText()));
            gameArray.add(Integer.parseInt(entryField38.getText()));
            gameArray.add(Integer.parseInt(entryField39.getText()));
            gameArray.add(Integer.parseInt(entryField40.getText()));
            gameArray.add(Integer.parseInt(entryField41.getText()));
            gameArray.add(Integer.parseInt(entryField42.getText()));
            gameArray.add(Integer.parseInt(entryField43.getText()));
            gameArray.add(Integer.parseInt(entryField44.getText()));
            gameArray.add(Integer.parseInt(entryField45.getText()));
            
            // row 6
            gameArray.add(Integer.parseInt(entryField46.getText()));
            gameArray.add(Integer.parseInt(entryField47.getText()));
            gameArray.add(Integer.parseInt(entryField48.getText()));
            gameArray.add(Integer.parseInt(entryField49.getText()));
            gameArray.add(Integer.parseInt(entryField50.getText()));
            gameArray.add(Integer.parseInt(entryField51.getText()));
            gameArray.add(Integer.parseInt(entryField52.getText()));
            gameArray.add(Integer.parseInt(entryField53.getText()));
            gameArray.add(Integer.parseInt(entryField54.getText()));
            
            // row 7
            gameArray.add(Integer.parseInt(entryField55.getText()));
            gameArray.add(Integer.parseInt(entryField56.getText()));
            gameArray.add(Integer.parseInt(entryField57.getText()));
            gameArray.add(Integer.parseInt(entryField58.getText()));
            gameArray.add(Integer.parseInt(entryField59.getText()));
            gameArray.add(Integer.parseInt(entryField60.getText()));
            gameArray.add(Integer.parseInt(entryField61.getText()));
            gameArray.add(Integer.parseInt(entryField62.getText()));
            gameArray.add(Integer.parseInt(entryField63.getText()));
            
            // row 8
            gameArray.add(Integer.parseInt(entryField64.getText()));
            gameArray.add(Integer.parseInt(entryField65.getText()));
            gameArray.add(Integer.parseInt(entryField66.getText()));
            gameArray.add(Integer.parseInt(entryField67.getText()));
            gameArray.add(Integer.parseInt(entryField68.getText()));
            gameArray.add(Integer.parseInt(entryField69.getText()));
            gameArray.add(Integer.parseInt(entryField70.getText()));
            gameArray.add(Integer.parseInt(entryField71.getText()));
            gameArray.add(Integer.parseInt(entryField72.getText()));
            
            // row 9
            gameArray.add(Integer.parseInt(entryField73.getText()));
            gameArray.add(Integer.parseInt(entryField74.getText()));
            gameArray.add(Integer.parseInt(entryField75.getText()));
            gameArray.add(Integer.parseInt(entryField76.getText()));
            gameArray.add(Integer.parseInt(entryField77.getText()));
            gameArray.add(Integer.parseInt(entryField78.getText()));
            gameArray.add(Integer.parseInt(entryField79.getText()));
            gameArray.add(Integer.parseInt(entryField80.getText()));
            gameArray.add(Integer.parseInt(entryField81.getText()));
            // </editor-fold>
            
            System.out.println(gameArray);
            checkSolution();
        }
    }
}
