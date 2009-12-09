package com.masprop.cluster1.privateclasses.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.masprop.cluster1.privateclasses.model.GameModeType;


/**
 * Dialog for instantiating start value
 * when player does it
 *  
 * @author Milovan Duric
 *
 */
public class ChooseValue extends JDialog  {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	private JLabel jLabel = null;
	
	private JButton jButton = null;
	private JButton jButton1 = null;

	
	
	Circle value[];
	private MyGUI myGUI;
	
	


	/**
	 * class constructor
	 * 
	 * @param owner
	 */
	public ChooseValue(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * class constructor
	 * 
	 * @param owner
	 */
	public ChooseValue(MyGUI owner) {
		super(owner);
		this.myGUI = owner;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 260);
		this.setTitle("Choose colors");
		this.setContentPane(getJContentPane());
		//jContentPane.add(new Circle(100,100,20,myGUI.guiManager,2));
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(70, 20, 160, 30));
			jLabel.setText("Please choose colors");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
			jContentPane.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
			
			jContentPane.add(jLabel, null);
			
			int xValue = 58;
	        int yValue = 46;

	        JPanel valuePanel = new JPanel();
	        valuePanel.setBounds(0, 44, 300, 100);
	        valuePanel.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
	        jContentPane.add(valuePanel);
	        
	        value = new Circle[4];
	        for(int i=0; i<4; i++){
	        	value[i] = new Circle(xValue + i*46, yValue, 18, myGUI.guiManager, 100, 100, 1, myGUI.getNewGameDialog().getLevelValue());
	        	valuePanel.add(value[i]);
	        }			
			
	        
	        
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
			jButton.setBounds(new Rectangle(40, 180, 100, 20));
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
			jButton1.setBounds(new Rectangle(160, 180, 100, 20));
			jButton1.setText("OK");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
	             public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	 OKEventActionPerformed(evt);
	             }
	         });
		}
		return jButton1;
	}

	/**
	 * closing the dialog and open another one
	 * for instantiating new game
	 *  
	 * @param evt
	 */
	private void cancelEventActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_newGameMenuItemActionPerformed
    	
		myGUI.getNewGameDialog().setVisible(true);
    	
		this.setVisible(false);
    }


	/**
	 * instantiate object game
	 * and start value
	 * if this is mode where player play
	 * against computer show that values on the
	 * screen else hide them
	 * 
	 * @param evt
	 */
	private void OKEventActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_newGameMenuItemActionPerformed
		int[] playerValue = new int[4];
        for(int i=0; i<4; i++){
			if(value[i].getColor()==1) return;
			playerValue[i] = value[i].getColor() - 2;
		}
        myGUI.guiManager.createNewGame(myGUI.getNewGameDialog().getLevel(), myGUI.getNewGameDialog().getMode());
        myGUI.guiManager.getMastermind().getMastermindStatus().setValue(playerValue);
        
        for(int i=0; i<4; i++) {
        	myGUI.value[i].setColor(value[i].getColor());
        	if(myGUI.getNewGameDialog().getMode() == GameModeType.COMPvsPLAYER) 
        		myGUI.value[i].setVisible(true);
        	myGUI.value[i].repaint();
        }
        
        for(int i=0; i<28; i++){
			myGUI.inputs[i].setColor(0);
			myGUI.inputs[i].repaint();
			myGUI.results[i].setColor(0);
			myGUI.results[i].repaint();
		}
		for(int i=0; i<6; i++){
			myGUI.line[i].setColor(Color.GRAY);
			myGUI.line[i].repaint();
		}
		for(int i=0; i<4; i++){
			myGUI.inputs[24 +i].setColor(1);
			myGUI.inputs[i].repaint();
		}
		myGUI.line[6].setColor(Color.WHITE);
		myGUI.line[6].repaint();
		this.setVisible(false);
		
    }


}
