package com.masprop.cluster1.privateclasses.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Rectangle;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindGameFileParser;





public class OpenLastSavedGame extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JLabel jLabel = null;
	
	private MyGUI myGUI;
	
	/**
	 * Constructor
	 * 
	 * @param owner
	 */
	public OpenLastSavedGame(Frame owner){
		super(owner);
		initialize();
	}
	
	/**
	 * Constructor
	 * 
	 * @param owner
	 */
	public OpenLastSavedGame(MyGUI owner){
		super(owner);
		myGUI = owner;
		initialize();
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(610, 120);
		this.setTitle("Mastermin");
		this.setContentPane(getJContentPane());
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(10, 10, 600, 21));
			jLabel.setText("Are you sure you want to discard the game you are currently playing, and load your previously saved game?");
					
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
			
			jContentPane.add(jLabel, null);

			
			jContentPane.add(getJButton(), null);
						
			jContentPane.add(getJButton1(), null);
		}
		return jContentPane;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(200, 55, 80, 20));
			jButton.setText("No");
			jButton.addActionListener(new java.awt.event.ActionListener() {
	             public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	 noEventActionPerformed(evt);
	             }
	         });
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(300, 55, 80, 20));
			jButton1.setText("Yes");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
	             public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	 yesScoreEventActionPerformed(evt);
	             }
	         });
		}
		return jButton1;
	}
		

	private void noEventActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_newGameMenuItemActionPerformed
    		
		this.setVisible(false);	
    }


	private void yesScoreEventActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_newGameMenuItemActionPerformed
		MastermindGameFileParser gameParser = new MastermindGameFileParser(false);
		myGUI.getGuiManager().setMastermind(gameParser.getMastermindFromFile());
		int current = myGUI.getGuiManager().getMastermind().getMastermindStatus().getCurrentRow();
		for(int i=0; i<current; i++){
			myGUI.getGuiManager().getMastermind().getMastermindStatus().setCurrentRow(i);
			int numRight = myGUI.getGuiManager().numCorrectPosition();
			int numWrong = myGUI.getGuiManager().numWrongPosition();
			for(int j=0; j<4; j++){
				myGUI.getInputs()[(6-i)*4 + j].setColor(myGUI.getGuiManager().getMastermind().getMastermindStatus().getMatrixMastermind().getCellValue(i, j)+2);
				myGUI.getInputs()[(6-i)*4 + j].repaint();
			}
			for(int j=0; j<numRight; j++){
				myGUI.getResults()[(6-i)*4 + j].setColor(2);
				myGUI.getResults()[(6-i)*4 + j].repaint();
			}
			for(int j=0; j<numWrong; j++){
				myGUI.getResults()[(6-i)*4 + j + numRight].setColor(4);
				myGUI.getResults()[(6-i)*4 + j + numRight].repaint();
			}
			myGUI.getLine()[6-i].setColor(Color.white);
			myGUI.getLine()[6-i].repaint();
		}
		myGUI.getGuiManager().getMastermind().getMastermindStatus().setCurrentRow(current);
		for(int i=0; i<4; i++){
			myGUI.getGuiManager().getMastermind().getMastermindStatus().getMatrixMastermind().getCell(current,i).setEditable(true);
			myGUI.getInputs()[(6-current)*4 + i].setColor(1);
			myGUI.getInputs()[(6-current)*4 + i].repaint();				
		}
		myGUI.getLine()[6-current].setColor(Color.white);
		myGUI.getLine()[6-current].repaint();
		this.setVisible(false);
		
    }

	
	
	
}


