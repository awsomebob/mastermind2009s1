package com.masprop.cluster1.privateclasses.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class MyGUI extends javax.swing.JFrame {


	private static final long serialVersionUID = 1L;

	/*
	 * declaration components 
	 * for Mastermind graphics
	 */
	Circle inputs[];
	MyLine line[];
	Circle results[];
	Circle value[];
	
	JPanel basePanel;
	JImagePanel imagePanel;
	JPanel buttonPanel;
	JButton check;
	/*
	 * end declaration components
	 */
	
	
    /**
     * Initialization of all the components included in this JFrame.
     */
    public MyGUI() {

   	    super("Mastermind");
        createMenuComponents();
        createMastermindComponents(this,2);
      
    }
    
    
	 /**
	  * drawing Mastermind components in defined frame
	  * mode is for 1 or 2 player
	  * or player against computer  
	  */	
    public void createMastermindComponents(JFrame frame, int mode) { 
   	     //background image for center panel
	         BufferedImage loadImg = JImagePanel.loadImage("Mastermind-hiddenbox.png") ;
	         
	         frame.setBounds(0, 0, 480, 810);
	         frame.setResizable(false);
	         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         
	         //base panel contain image panel and button panel
	         //only because of layout
	         basePanel = new JPanel(new BorderLayout());
	         
	         
	         imagePanel = new JImagePanel(loadImg, 50, 38);
	         
	         buttonPanel = new JPanel();
	         buttonPanel.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
	         
	         
	         //components are placed in inverse order
	         //first physical row is with index i=7 
	         inputs = new Circle[28];
	         int xInput = 100;
	         int yInput = 96;
	         line = new MyLine[7];
	         
	         for(int i=0; i<7; i++){
	        	 for(int j=0; j<4; j++){
	        		 if(i==6)
	        			 inputs[i*4 + j] = new Circle(xInput + j*52, yInput + i*78, 20, 1, true, 1);
	        		 else
	        			 inputs[i*4 + j] = new Circle(xInput + j*52, yInput + i*78, 20, 1, true, 0);
	        		 imagePanel.add(inputs[i*4 + j]);
	        	 }
	        	 
	        	 //separator between rows
	        	 //also if separator is white row is edit able
	        	 if(i==6)
	        		 line [i] = new MyLine(xInput, yInput + (i+1)*78 - 28, 2, Color.white);
	        	 else 
	        		 line [i] = new MyLine(xInput, yInput + (i+1)*78 - 28, 2, Color.GRAY);
   		     imagePanel.add(line[i]);
	         }
	         
	         results = new Circle[28];
	         int xOutput = 320;
	         int yOutput = 92;
	         
	         for(int i=0; i<7; i++)
	        	 for(int j=0; j<2; j++)
	        		 for(int k=0; k<2; k++){
	        		 results[i*4 + j*2 + k] = new Circle(xOutput + j*26, yOutput + i*78 + k*26, 11, 1, false, 0);
	        		 imagePanel.add(results[i*4 + j*2 + k]);
	        	 }
	         
	         //this should be mode player against computer
	         int xValue = 144;
	         int yValue = 655;
	         if(mode==2){
	        	 value = new Circle[4];
	        	 for(int i=0; i<4; i++){
	        		 //FIXME here should instead of i+1 value that player defined
	        		 value[i] = new Circle(xValue + i*50, yValue, 20, 1, false, i+1);
	        		 imagePanel.add(value[i]);
	        	 }
	         }
	         
	         
	         
	         //This is button whit purpose of finishing guessing for current row
	         check = new JButton("Mastermind check");
	         check.setBackground(new Color(Integer.valueOf("b25b10", 16)));
	         check.setSize(20, 100);
	         check.addActionListener(new java.awt.event.ActionListener() {
	             public void actionPerformed(java.awt.event.ActionEvent evt) {
	                 checkMastermindEventActionPerformed(evt);
	             }
	         });
	         
	         
	         buttonPanel.add(check);
	         
	         basePanel.add(imagePanel, BorderLayout.CENTER);
	         basePanel.add(buttonPanel, BorderLayout.SOUTH);
	         
	         frame.add(basePanel);  
	         
	         frame.setVisible(true);  
	     }
    
    
    /**
	  * adding menu components  
	  */
    private void createMenuComponents() {

        aboutDialog = new javax.swing.JDialog();

 
        fileChooser = new javax.swing.JFileChooser();

        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newGameMenuItem = new javax.swing.JMenuItem();
        loadGameMenuItem = new javax.swing.JMenuItem();
        saveGameMenuItem = new javax.swing.JMenuItem();
        scoresMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        manualMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        aboutDialog.setTitle("About");
        aboutDialog.setIconImage(null);
        aboutDialog.setIconImages(null);
        aboutDialog.setMinimumSize(new java.awt.Dimension(400, 400));
        aboutDialog.setResizable(false);
        aboutDialog.setLocation(0,0);
        
        fileChooser.setBackground(new java.awt.Color(230, 215, 193));
        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });
        
    
        menuBar.setBackground(new java.awt.Color(230, 215, 193));

        fileMenu.setText("File");

        newGameMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newGameMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/masprop/cluster1/shared/view/graphics/menu_new_game.png"))); // NOI18N
        newGameMenuItem.setText("New game");
        fileMenu.add(newGameMenuItem);

        loadGameMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        loadGameMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/masprop/cluster1/shared/view/graphics/menu_load_game.png"))); // NOI18N
        loadGameMenuItem.setText("Load game");
        loadGameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGameMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadGameMenuItem);

        saveGameMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveGameMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/masprop/cluster1/shared/view/graphics/menu_save_game.png"))); // NOI18N
        saveGameMenuItem.setText("Save game");
        saveGameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGameMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveGameMenuItem);

        scoresMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        scoresMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/masprop/cluster1/shared/view/graphics/menu_scores.png"))); // NOI18N
        scoresMenuItem.setText("Scores");
        fileMenu.add(scoresMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/masprop/cluster1/shared/view/graphics/menu_exit.png"))); // NOI18N
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");

        manualMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/masprop/cluster1/shared/view/graphics/menu_manual.png"))); // NOI18N
        manualMenuItem.setText("Manual");
        helpMenu.add(manualMenuItem);

        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/masprop/cluster1/shared/view/graphics/menu_about.png"))); // NOI18N
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);


    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param evt GUI Event
     */
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        aboutDialog.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed


    private void loadGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGameMenuItemActionPerformed
        fileChooser.showOpenDialog(menuBar);
    }//GEN-LAST:event_loadGameMenuItemActionPerformed

    private void saveGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGameMenuItemActionPerformed
        fileChooser.showSaveDialog(menuBar);
    }//GEN-LAST:event_saveGameMenuItemActionPerformed

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed

        if(fileChooser.getDialogType() == JFileChooser.OPEN_DIALOG) {

        } else if(fileChooser.getDialogType() == JFileChooser.SAVE_DIALOG) {

        } else {
            throw new IllegalArgumentException("illegal fileChooser state");
        }

    }
    
    private void checkMastermindEventActionPerformed(java.awt.event.ActionEvent evt){
    	//Here should be check MastermindStatus and....
    	//This is only example
    	line[5].setColor(Color.WHITE);
    	line[5].repaint();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog aboutDialog;
    private javax.swing.JMenuItem aboutMenuItem;

    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu fileMenu;

    private javax.swing.JMenu helpMenu;

    private javax.swing.JMenuItem loadGameMenuItem;
    private javax.swing.JMenuItem manualMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newGameMenuItem;
    private javax.swing.JMenuItem saveGameMenuItem;
    private javax.swing.JMenuItem scoresMenuItem;

    // End of variables declaration//GEN-END:variables

    /*Getters and Setters*/
    /**
     * About menu item.
     * Story: User wants to read something about the application.
     * @return an about menu item.
     */
    public JMenuItem getAboutMenuItem() {
        return aboutMenuItem;
    }

    /**
     * About menu item.
     * Story: User wants to read something about the application.
     * @param aboutMenuItem
     */
    public void setAboutMenuItem(JMenuItem aboutMenuItem) {
        this.aboutMenuItem = aboutMenuItem;
    }

    /**
     * Exit menu item.
     * Story: User wishes to exit the application.
     * @return exit menu item
     */
    public JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    /**
     * Exit menu item.
     * Story: User wishes to exit the application.
     * @param exitMenuItem
     */
    public void setExitMenuItem(JMenuItem exitMenuItem) {
        this.exitMenuItem = exitMenuItem;
    }

    /**
     * File menu
     * Story: User wishes to perform one of the
     * initial use-cases.
     * @return file menu item
     */
    public JMenu getFileMenu() {
        return fileMenu;
    }

    /**
     * File menu
     * Story: User wishes to perform one of the
     * initial use-cases.
     * @param fileMenu
     */
    public void setFileMenu(JMenu fileMenu) {
        this.fileMenu = fileMenu;
    }

    /**
     * Help menu
     * Story: User wishes to know more about the application
     * or wants to access the help / manual.
     * @return help menu item.
     */
    public JMenu getHelpMenu() {
        return helpMenu;
    }

    /**
     * Help menu
     * Story: User wishes to know more about the application
     * or wants to access the help / manual.
     * @param helpMenu
     */
    public void setHelpMenu(JMenu helpMenu) {
        this.helpMenu = helpMenu;
    }

    /**
     * Load game menu item
     * Story: User wishes to load a game from the disk.
     * @return load game menu item
     */
    public JMenuItem getLoadGameMenuItem() {
        return loadGameMenuItem;
    }

    /**
     * Load game menu item
     * Story: User wishes to load a game from the disk.
     * @param loadGameMenuItem
     */
    public void setLoadGameMenuItem(JMenuItem loadGameMenuItem) {
        this.loadGameMenuItem = loadGameMenuItem;
    }

    /**
     * Manual menu item
     * Story: User wishes to read the manual.
     * @return manual menu item
     */
    public JMenuItem getManualMenuItem() {
        return manualMenuItem;
    }

    /**
     * Manual menu item
     * Story: User wishes to read the manual.
     * @param manualMenuItem
     */
    public void setManualMenuItem(JMenuItem manualMenuItem) {
        this.manualMenuItem = manualMenuItem;
    }

    /**
     * Main menu bar.
     * Story: User wishes to perform application control actions.
     * @return main menu bar item.
     */
    public JMenuBar getMainMenuBar() {
        return menuBar;
    }

    /**
     * Main menu bar.
     * Story: User wishes to perform application control actions.
     * @param menuBar
     */
    public void setMainMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    /**
     * New game menu item
     * Story: User wishes to start a new game.
     * @return
     */
    public JMenuItem getNewGameMenuItem() {
        return newGameMenuItem;
    }

    /**
     * New game menu item
     * Story: User wishes to start a new game.
     * @param newGameMenuItem
     */
    public void setNewGameMenuItem(JMenuItem newGameMenuItem) {
        this.newGameMenuItem = newGameMenuItem;
    }

    /**
     * Scores menu item
     * Story: User wishes to browse the score list.
     * @return scores menu item
     */
    public JMenuItem getScoresMenuItem() {
        return scoresMenuItem;
    }

    /**
     * Scores menu item
     * Story: User wishes to browse the score list.
     * @param scoresMenuItem
     */
    public void setScoresMenuItem(JMenuItem scoresMenuItem) {
        this.scoresMenuItem = scoresMenuItem;
    }
    
    
    
    public static void main(String[] args) {  

	     MyGUI gui = new MyGUI();
         gui.setVisible(true);
    }  
}