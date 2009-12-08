package com.masprop.cluster1.privateclasses.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.masprop.cluster1.privateclasses.model.GameModeType;
import com.masprop.cluster1.privateclasses.model.Score;
import com.masprop.cluster1.privateclasses.model.Scores;
import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindScoreFileParser;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 * GUI class which instantiate all graphics
 * components and handle all events for playing game
 * Also here is main class that run game
 * 
 * @see GameModeType
 * @see GameLevelType
 * @see Circle
 * @see MyLine
 * @see JImagePanel
 * @see GUIManager
 * 
 * @author Milovan Duric
 */
public class MyGUI extends javax.swing.JFrame {


	private static final long serialVersionUID = 1L;


	/**
	 * input circles where player
	 * guess value
	 */
	Circle inputs[];
	
	/**
	 * line separators
	 * from active and no active inputs
	 */
	MyLine line[];
	
	/**
	 * results circles for
	 * displaying information about
	 * player accuracy 
	 */
	Circle results[];
	
	/**
	 * only computer play 
	 * against human and displaying
	 * value that player defined
	 */
	Circle value[];
	
	
	/**
	 * panels for scheduling components 
	 */
	JPanel basePanel;
	JImagePanel imagePanel;
	JPanel buttonPanel;
	
	/**
	 * main button for comparing current row
	 * values with correct values
	 */
	private JButton check;
	/*
	 * end declaration components
	 */
	
	/**
	 * GUI manager for handling gui events and domain layer dates
	 */
	GUIManager guiManager;
	
    /**
     * Initialization of all the components included in this JFrame.
     */
    public MyGUI() {
   	    super("Mastermind");
   	    guiManager = new GUIManager();
        createMenuComponents();
        createMastermindComponents(this,2);
      
    }
    

    
    /**
     * Drawing Mastermind components in defined frame
     * mode is param for 1, 2 player
	 * or player against computer 
     */
    public void createMastermindComponents(JFrame frame, int mode) { 
   	     //background image for center panel
	         BufferedImage loadImg = JImagePanel.loadImage("Mastermind-hiddenbox.png") ;
	         
	         frame.setBounds(0, 0, 356, 680);
	         frame.setResizable(false);
	         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         
	         //base panel contain image panel and button panel
	         //only because of layout
	         basePanel = new JPanel(new BorderLayout());
	         
	         
	         imagePanel = new JImagePanel(loadImg, 16, 0);
	         
	         buttonPanel = new JPanel();
	         buttonPanel.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
	         
	         
	         //components are placed in inverse order
	         //first physical row is with index i=7 
	         inputs = new Circle[28];
	         int xInput = 40;
	         int yInput = 30;
	         line = new MyLine[7];
	         
	         for(int i=0; i<7; i++){
	        	 for(int j=0; j<4; j++){
	        	     inputs[i*4 + j] = new Circle(xInput + j*52, yInput + i*70, 20, guiManager, 6-i, j, 0);
	        		 imagePanel.add(inputs[i*4 + j]);
	        	 }
	        	 
	        	 //separator between rows
	        	 //also if separator is white row is edit able

	         line [i] = new MyLine(xInput, yInput + (i+1)*70 - 28, 2, Color.GRAY);
   		     imagePanel.add(line[i]);
	         }
	         
	         results = new Circle[28];
	         int xOutput = 265;
	         int yOutput = 32;
	         
	         for(int i=0; i<7; i++)
	        	 for(int j=0; j<2; j++)
	        		 for(int k=0; k<2; k++){
	        		 results[i*4 + j*2 + k] = new Circle(xOutput + j*24, yOutput + i*70 + k*20, 9, guiManager, 0);
	        		 imagePanel.add(results[i*4 + j*2 + k]);
	        	 }
	         
	         //this should be mode player against computer
	         int xValue = 90;
	         int yValue = 528;
	         if(mode==2){
	        	 value = new Circle[4];
	        	 for(int i=0; i<4; i++){
	        		 //FIXME here should instead of i+1 value that player defined
	        		 value[i] = new Circle(xValue + i*46, yValue, 18, guiManager, i+1);
	        		 value[i].setVisible(false);
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
        newGameDialog = new NewGame(this);    
        endGameDialog = new EndGame(this);
        endGameDialog1 = new EndGame1(this);
        endGameDialog2 = new EndGame2(this);
        guiScore = new GUIScore(this);
        saveGame = new SaveGame(this);
        openGame = new OpenLastSavedGame(this);

 
  //      fileChooser = new javax.swing.JFileChooser();

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
        aboutPanel = new JPanel();
        aboutPanel.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
        aboutDialog.add(aboutPanel);
        aboutDialog.setMinimumSize(new java.awt.Dimension(300, 300));
        aboutDialog.setResizable(false);
        aboutDialog.setLocation(0,0);
        

        
        
    /*    
        fileChooser.setBackground(new java.awt.Color(230, 215, 193));
        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });
    */    
    
        menuBar.setBackground(new java.awt.Color(230, 215, 193));

        fileMenu.setText("File");

        newGameMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newGameMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/masprop/cluster1/shared/view/graphics/menu_new_game.png"))); // NOI18N
        newGameMenuItem.setText("New game");
        newGameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameMenuItemActionPerformed(evt);
            }
        });
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
        scoresMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoresMenuItemActionPerformed(evt);
            }
        });
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


	public Circle[] getInputs() {
		return inputs;
	}



	public void setInputs(Circle[] inputs) {
		this.inputs = inputs;
	}



	public MyLine[] getLine() {
		return line;
	}



	public void setLine(MyLine[] line) {
		this.line = line;
	}



	public Circle[] getResults() {
		return results;
	}



	public void setResults(Circle[] results) {
		this.results = results;
	}



	public Circle[] getValue() {
		return value;
	}



	public void setValue(Circle[] value) {
		this.value = value;
	}



	public GUIManager getGuiManager() {
		return guiManager;
	}



	public void setGuiManager(GUIManager guiManager) {
		this.guiManager = guiManager;
	}



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
       openGame.setVisible(true);
    }//GEN-LAST:event_loadGameMenuItemActionPerformed

    private void saveGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGameMenuItemActionPerformed
        saveGame.setVisible(true);
    }//GEN-LAST:event_saveGameMenuItemActionPerformed
    
    private void newGameMenuItemActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_newGameMenuItemActionPerformed
    	//guiManager.createNewGame(gameLevelType, gameModeType)
    	newGameDialog.setVisible(true);
    }
    
    private void scoresMenuItemActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_newGameMenuItemActionPerformed
    	MastermindScoreFileParser parser = new MastermindScoreFileParser();
    	Scores scores = parser.getScoreFromFile(GameLevelType.DIFFICULT);
    	for(Score s : scores.getScores()){
    		guiScore.getNames()[scores.getScores().indexOf(s)].setText(s.getName());
    		guiScore.getScores()[scores.getScores().indexOf(s)].setText(String.valueOf(s.getScore()));
    	}	
    	guiScore.setVisible(true);
    }

    
    /*
    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed

        if(fileChooser.getDialogType() == JFileChooser.OPEN_DIALOG) {

        } else if(fileChooser.getDialogType() == JFileChooser.SAVE_DIALOG) {

        } else {
            throw new IllegalArgumentException("illegal fileChooser state");
        }

    }
    */
    
    /**
     * this method handle action event of button
     * for checking values for current row whether
     * they are correct or wrong and  also set result 
     * on circles for displaying it. If user correctly 
     * fill all fields game is finished, otherwise 
     * just make next row as editable  
     */
    private void checkMastermindEventActionPerformed(java.awt.event.ActionEvent evt){
    	//Here should be check MastermindStatus and....
    	//This is only example
    	boolean result = guiManager.check();
    	int currRow = guiManager.currentRow();
    	int numRight = guiManager.numCorrectPosition();
		int numWrong = guiManager.numWrongPosition();
    	if(result){
    		if(guiManager.isResolved()){
    			//open dialog that show score, etc...
    			for(int i=0; i<4; i++){
    				results[(6-currRow)*4 + i].setColor(2);
    				results[(6-currRow)*4 + i].repaint();
    			}
    			
    			guiManager.getMastermind().setScore(guiManager.getGameManager().score(currRow, guiManager.getMastermind().getGameLevelType())) ;
    			int position = guiManager.getMastermind().getScores().getScore(guiManager.getMastermind().getScore()) + 1;
    			//System.out.println("Tvoj skor je " + guiManager.getMastermind().getScore() + " i pozicija " + position + " !");
    			if(position < 1){
    				endGameDialog1.getJLabel2().setText("Your score is: " + getGuiManager().getMastermind().getScore() + " !");
    				endGameDialog1.setVisible(true);
    			}else{
    				endGameDialog2.getJLabel1().setText("You are in top 10 and your position is " + position + " !");
    				endGameDialog2.getJLabel2().setText("Your score is: " + getGuiManager().getMastermind().getScore() + " !");
    				endGameDialog2.setVisible(true);
    			}
    			
    		}else if(currRow == 6){
    			for(int i=0; i<numRight; i++){
    				results[(6-currRow)*4 + i].setColor(2);
    				results[(6-currRow)*4 + i].repaint();
    			}
    			//System.out.println("broj tacnih " + numRight);
    			for(int i=0; i<numWrong; i++){
    				results[(6-currRow)*4 + i + numRight].setColor(4);
    				results[(6-currRow)*4 + i + numRight].repaint();
    			}
    			for(int i=0; i<4; i++)
    				guiManager.getMastermind().getMastermindStatus().getMatrixMastermind().getCell(currRow,i).setEditable(false);
    			
    			//System.out.println("broj pogresnih " + numWrong);
    			endGameDialog.setVisible(true);
    		}else
    		{
    			for(int i=0; i<numRight; i++){
    				results[(6-currRow)*4 + i].setColor(2);
    				results[(6-currRow)*4 + i].repaint();
    			}
    			//System.out.println("broj tacnih " + numRight);
    			for(int i=0; i<numWrong; i++){
    				results[(6-currRow)*4 + i + numRight].setColor(4);
    				results[(6-currRow)*4 + i + numRight].repaint();
    			}
    			//System.out.println("broj pogresnih " + numWrong);
    			if(currRow<6){
    				guiManager.getMastermind().getMastermindStatus().setCurrentRow(currRow+1);
    				for(int i=0; i<4; i++){
    					guiManager.getMastermind().getMastermindStatus().getMatrixMastermind().getCell(currRow+1,i).setEditable(true);
    					guiManager.getMastermind().getMastermindStatus().getMatrixMastermind().getCell(currRow,i).setEditable(false);
    					inputs[(6-currRow-1)*4 + i].setColor(1);
    					inputs[(6-currRow-1)*4 + i].repaint();				
    				}
    				line[6-currRow-1].setColor(Color.white);
    				line[6-currRow-1].repaint();
    			}
    		}
    	}
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog aboutDialog;
    private JPanel aboutPanel;
    private javax.swing.JMenuItem aboutMenuItem;
    

    private javax.swing.JMenuItem exitMenuItem;
  //  private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu fileMenu;

    private javax.swing.JMenu helpMenu;

    private javax.swing.JMenuItem loadGameMenuItem;
    private javax.swing.JMenuItem manualMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newGameMenuItem;
    private javax.swing.JMenuItem saveGameMenuItem;
    private javax.swing.JMenuItem scoresMenuItem;
    
    private NewGame newGameDialog;
    
    private EndGame endGameDialog;
    
    private EndGame1 endGameDialog1;
    
    private EndGame2 endGameDialog2;
    
    private GUIScore guiScore;
    
    private SaveGame saveGame;
    
    private OpenLastSavedGame openGame;

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
    
    
    
    public NewGame getNewGameDialog() {
		return newGameDialog;
	}



	public void setNewGameDialog(NewGame newGameDialog) {
		this.newGameDialog = newGameDialog;
	}



	/**
     * 
     * @param args
     * This is main that will create 
     * graphics components and other object 
     * necessary for the playing game
     */
    public static void main(String[] args) {  

	     MyGUI gui = new MyGUI();
	     
         gui.setVisible(true);
    }  
}
