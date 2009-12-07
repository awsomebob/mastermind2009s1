package com.masprop.cluster1.privateclasses.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Rectangle;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.masprop.cluster1.privateclasses.model.Score;



public class EndGame2 extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JTextArea jTextArea = null;
	
	private MyGUI myGUI;
	
	/**
	 * Constructor
	 * 
	 * @param owner
	 */
	public EndGame2(Frame owner){
		super(owner);
		initialize();
	}
	
	/**
	 * Constructor
	 * 
	 * @param owner
	 */
	public EndGame2(MyGUI owner){
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
		this.setSize(350, 210);
		this.setTitle("The End Game");
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
			jLabel.setBounds(new Rectangle(50, 10, 340, 21));
			jLabel.setText("You have finished game succesfull!");
			
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(50, 40, 340, 21));
			jLabel1.setText("");
			
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(50, 70, 340, 21));
			jLabel2.setText("");
			
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(50, 100, 100, 21));
			jLabel3.setText("Your name:");
			
			jTextArea = new JTextArea();
			jTextArea.setBounds(new Rectangle(170, 100, 150, 21));
			jTextArea.setText("player");
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
			
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			
			jContentPane.add(jTextArea, null);
			
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
			jButton.setBounds(new Rectangle(20, 145, 140, 20));
			jButton.setText("Cancel");
			jButton.addActionListener(new java.awt.event.ActionListener() {
	             public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	 cancelEventActionPerformed(evt);
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
			jButton1.setBounds(new Rectangle(180, 145, 140, 20));
			jButton1.setText("Save score");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
	             public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	 saveScoreEventActionPerformed(evt);
	             }
	         });
		}
		return jButton1;
	}
		
	public JLabel getJLabel2() {
		
		return jLabel2;
	}

	public void setJLabel2(JLabel jLabel2) {
		this.jLabel2 = jLabel2;
	}

	public JLabel getJLabel1() {
		return jLabel1;
	}

	public void setJLabel1(JLabel jLabel1) {
		this.jLabel1 = jLabel1;
	}

	private void cancelEventActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_newGameMenuItemActionPerformed
    		
		this.setVisible(false);	
    }


	private void saveScoreEventActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_newGameMenuItemActionPerformed
    	
		myGUI.getGuiManager().getMastermind().getScores().addScore(new Score(jTextArea.getText(), myGUI.getGuiManager().getMastermind().getScore()));
		myGUI.getGuiManager().getMastermind().getScoreParser().update(myGUI.getGuiManager().getMastermind().getGameLevelType().toString(), myGUI.getGuiManager().getMastermind().getScores());
		this.setVisible(false);
		myGUI.getNewGameDialog().setVisible(true);
    }

	
	
	
}


