package com.masprop.cluster1.privateclasses.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import java.awt.Rectangle;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;

import com.masprop.cluster1.privateclasses.model.GameModeType;
import com.masprop.cluster1.shared.model.GameLevelType;

public class NewGame extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JRadioButton jRadioButton = null;
	private JRadioButton jRadioButton1 = null;
	private JRadioButton jRadioButton2 = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	
	private JSeparator separator;
	private JRadioButton jRadioButton3 = null;
	private JRadioButton jRadioButton4 = null;
	private JRadioButton jRadioButton5 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel6 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	
	private ButtonGroup modeGroup;  //  @jve:decl-index=0:
	private ButtonGroup levelGroup;
	
	private GameModeType mode;
	private GameLevelType level;
	
	private MyGUI myGUI;
	
	


	/**
	 * @param owner
	 */
	public NewGame(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * 
	 * @param owner
	 */
	public NewGame(MyGUI owner) {
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
		this.setSize(300, 300);
		this.setTitle("New Game");
		modeGroup = new ButtonGroup();
		levelGroup = new ButtonGroup();
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(60, 210, 160, 21));
			jLabel6.setText("Difficult");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(60, 180, 160, 21));
			jLabel4.setText("Medium");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(60, 150, 160, 21));
			jLabel3.setText("Easy");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(60, 10, 160, 21));
			jLabel2.setText("Player Vs Computer");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(60, 40, 160, 21));
			jLabel1.setText("Player Vs Player");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(60, 70, 160, 21));
			jLabel.setText("Computer Vs Player");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
			jContentPane.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
			
			jContentPane.add(getJRadioButton(), null);
			jContentPane.add(getJRadioButton1(), null);
			jContentPane.add(getJRadioButton2(), null);
			modeGroup.add(jRadioButton);
			modeGroup.add(jRadioButton1);
			modeGroup.add(jRadioButton2);
			
			
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			separator = new JSeparator(JSeparator.HORIZONTAL);
			separator.setSize(260, 20);
			separator.setLocation(20, 120);
			separator.setBackground(Color.gray);
			jContentPane.add(separator);
			
			jContentPane.add(getJRadioButton3(), null);
			jContentPane.add(getJRadioButton4(), null);
			jContentPane.add(getJRadioButton5(), null);
			levelGroup.add(jRadioButton3);
			levelGroup.add(jRadioButton4);
			levelGroup.add(jRadioButton5);
			
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(getJButton(), null);
			
			
			jContentPane.add(getJButton1(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton("0", true);
			jRadioButton.setBounds(new Rectangle(30, 10, 21, 21));
			jRadioButton.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
		}
		return jRadioButton;
	}

	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton("1", false);
			jRadioButton1.setBounds(new Rectangle(30, 40, 21, 21));
			jRadioButton1.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
		}
		return jRadioButton1;
	}

	/**
	 * This method initializes jRadioButton2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton2() {
		if (jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton("2", false);
			jRadioButton2.setBounds(new Rectangle(30, 70, 21, 21));
			jRadioButton2.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
		}
		return jRadioButton2;
	}

	/**
	 * This method initializes jRadioButton3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton3() {
		if (jRadioButton3 == null) {
			jRadioButton3 = new JRadioButton("3", true);
			jRadioButton3.setBounds(new Rectangle(30, 150, 21, 21));
			jRadioButton3.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
		}
		return jRadioButton3;
	}

	/**
	 * This method initializes jRadioButton4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton4() {
		if (jRadioButton4 == null) {
			jRadioButton4 = new JRadioButton("4", false);
			jRadioButton4.setBounds(new Rectangle(30, 180, 21, 21));
			jRadioButton4.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
		}
		return jRadioButton4;
	}

	/**
	 * This method initializes jRadioButton5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton5() {
		if (jRadioButton5 == null) {
			jRadioButton5 = new JRadioButton("5", false);
			jRadioButton5.setBounds(new Rectangle(30, 210, 21, 21));
			jRadioButton5.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
		}
		return jRadioButton5;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(40, 245, 100, 20));
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
			jButton1.setBounds(new Rectangle(160, 245, 100, 20));
			jButton1.setText("OK");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
	             public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	 OKEventActionPerformed(evt);
	             }
	         });
		}
		return jButton1;
	}

	private void cancelEventActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_newGameMenuItemActionPerformed
    	
		jRadioButton.setSelected(true);
		jRadioButton3.setSelected(true);
    	
		this.setVisible(false);
    }


	private void OKEventActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_newGameMenuItemActionPerformed
    	
		if(jRadioButton.isSelected()) mode = GameModeType.PLAYERvsCOMP; 
		else if(jRadioButton1.isSelected()) mode = GameModeType.PLAYERvsPLAYER;
		else mode = GameModeType.COMPvsPLAYER;
		
		if(jRadioButton3.isSelected()) level = GameLevelType.EASY; 
		else if(jRadioButton4.isSelected()) level = GameLevelType.MEDIUM;
		else level = GameLevelType.DIFFICULT;
		
		jRadioButton.setSelected(true);
		jRadioButton3.setSelected(true);
    	
		
		if(mode == GameModeType.COMPvsPLAYER){ 
			myGUI.setChooseValueDialog(new ChooseValue(myGUI));
			myGUI.getChooseValueDialog().setVisible(true);
		}
		else if(mode == GameModeType.PLAYERvsPLAYER){
			myGUI.setChooseValueDialog(new ChooseValue(myGUI));
			myGUI.getChooseValueDialog().setVisible(true);
		}
		else{
			myGUI.guiManager.createNewGame(level, mode);
			
			
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
			
			
		}
		
		this.setVisible(false);
		
    }




	public GameModeType getMode() {
		return mode;
	}

	public void setMode(GameModeType mode) {
		this.mode = mode;
	}

	public GameLevelType getLevel() {
		return level;
	}

	public void setLevel(GameLevelType level) {
		this.level = level;
	}

	public int getLevelValue(){
		if(level == GameLevelType.EASY) return 4;
		else if(level == GameLevelType.MEDIUM) return 5;
		else return 6;
	}
	
	


}
