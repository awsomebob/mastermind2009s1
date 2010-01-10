package com.masprop.cluster1.privateclasses.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Rectangle;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Dialog for successful finished game, but result is not in top 10.
 * 
 * @author Milan Stanic
 *
 */

public class EndGame1 extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	
	private MyGUI myGUI;
	
	/**
	 * Constructor
	 * 
	 * @param owner
	 */
	public EndGame1(Frame owner){
		super(owner);
		initialize();
	}
	
	/**
	 * Constructor
	 * 
	 * @param owner
	 */
	public EndGame1(MyGUI owner){
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
		this.setSize(350, 180);
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
			jLabel.setText("You have finished game successful!");
			
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(50, 40, 340, 21));
			jLabel1.setText("Sorry, you are not in top 10!");
			
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(50, 70, 340, 21));
			jLabel2.setText("");
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
			
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			
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
			jButton.setBounds(new Rectangle(20, 115, 140, 20));
			jButton.setText("Close game");
			jButton.addActionListener(new java.awt.event.ActionListener() {
	             public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	 closeGameEventActionPerformed(evt);
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
			jButton1.setBounds(new Rectangle(180, 115, 140, 20));
			jButton1.setText("Start new game");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
	             public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	 startNewGameEventActionPerformed(evt);
	             }
	         });
		}
		return jButton1;
	}
	
	/**
	 * This method returns jLabel2
	 * 
	 * @return javax.swing.JLabel
	 */
	public JLabel getJLabel2() {
		return jLabel2;
	}

	/**
	 * This method sets jLabel2
	 * 
	 * @param jLabel2
	 */
	public void setJLabel2(JLabel jLabel2) {
		this.jLabel2 = jLabel2;
	}

	/**
 	* Closing application
 	*/
	private void closeGameEventActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_newGameMenuItemActionPerformed
    		
		System.exit(0);	
    }

	/**
	 * Opening dialog for new game
	 */
	private void startNewGameEventActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_newGameMenuItemActionPerformed
    	
		myGUI.getNewGameDialog().setVisible(true);
		
		this.setVisible(false);
    }

	
	
	
}

