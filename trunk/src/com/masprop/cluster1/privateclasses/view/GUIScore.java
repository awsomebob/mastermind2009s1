package com.masprop.cluster1.privateclasses.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.masprop.cluster1.privateclasses.model.Score;
import com.masprop.cluster1.privateclasses.model.Scores;
import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindScoreFileParser;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 * Dialog for showing score for each difficulty level
 * 
 * @author Milan Stanic
 * 
 */

public class GUIScore extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButton = null;

	private JButton jButton1 = null;

	private JButton jButton2 = null;

	private JButton jButton3 = null;

	private JButton jButton4 = null;

	private JLabel[] names = new JLabel[10];

	private JLabel[] positions = new JLabel[10];

	private JLabel[] scores = new JLabel[10];

	private JLabel jLabel1 = null;

	private JLabel jLabel2 = null;

	private JLabel jLabel3 = null;

	/**
	 * Constructor
	 * 
	 * @param owner
	 */
	public GUIScore(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * Constructor
	 * 
	 * @param owner
	 */
	public GUIScore(MyGUI owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 460);
		this.setTitle("Scores");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {

			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(10, 40, 100, 21));
			jLabel1.setText("POSITION");

			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(100, 40, 100, 21));
			jLabel2.setText("NAME");

			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(200, 40, 60, 21));
			jLabel3.setText("SCORE");

			for (int i = 0; i < 10; i++) {
				positions[i] = new JLabel();
				positions[i].setBounds(new Rectangle(30, 70 + i * 30, 100, 21));
				positions[i].setText((i + 1) + ".");

				names[i] = new JLabel();
				names[i].setBounds(new Rectangle(100, 70 + i * 30, 100, 21));
				names[i].setText("");

				scores[i] = new JLabel();
				scores[i].setBounds(new Rectangle(200, 70 + i * 30, 100, 21));
				scores[i].setText("");
			}

			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane
					.setBackground(new Color(Integer.valueOf("f3a15a", 16)));

			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);

			for (int i = 0; i < 10; i++) {
				jContentPane.add(positions[i], null);
				jContentPane.add(names[i], null);
				jContentPane.add(scores[i], null);
			}

			jContentPane.add(getJButton(), null);

			jContentPane.add(getJButton1(), null);

			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton3(), null);
			jContentPane.add(getJButton4(), null);
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
			jButton.setBounds(new Rectangle(20, 385, 100, 20));
			jButton.setText("Reset");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					resetEventActionPerformed(evt);
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
			jButton1.setBounds(new Rectangle(140, 385, 100, 20));
			jButton1.setText("OK");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					okEventActionPerformed(evt);
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(20, 10, 80, 20));
			jButton2.setText("Easy");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					easyEventActionPerformed(evt);
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jButton3
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(110, 10, 80, 20));
			jButton3.setText("Medium");
			jButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					mediumEventActionPerformed(evt);
				}
			});
		}
		return jButton3;
	}

	/**
	 * This method initializes jButton3
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setBounds(new Rectangle(200, 10, 80, 20));
			jButton4.setText("Difficult");
			jButton4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					difficultEventActionPerformed(evt);
				}
			});
		}
		return jButton4;
	}

	/**
	 * Gets names
	 * 
	 * @return names
	 */
	public JLabel[] getNames() {
		return names;
	}

	/**
	 * Sets names
	 * 
	 * @param names
	 */
	public void setNames(JLabel[] names) {
		this.names = names;
	}

	/**
	 * Get scores
	 * 
	 * @return
	 */
	public JLabel[] getScores() {
		return scores;
	}

	/**
	 * Sets scores
	 * 
	 * @param scores
	 */
	public void setScores(JLabel[] scores) {
		this.scores = scores;
	}

	/**
	 * This function delete score for each game level type
	 * 
	 * @param evt
	 */
	private void resetEventActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_newGameMenuItemActionPerformed
		MastermindScoreFileParser parser = new MastermindScoreFileParser();
		parser.delete(GameLevelType.EASY.toString());
		parser.delete(GameLevelType.MEDIUM.toString());
		parser.delete(GameLevelType.DIFFICULT.toString());
		for (int i = 0; i < names.length; i++) {
			names[i].setText("");
			scores[i].setText("");
		}
		this.setVisible(false);
	}

	/**
	 * Closing this dialog.
	 * 
	 * @param evt
	 */
	private void okEventActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_newGameMenuItemActionPerformed

		this.setVisible(false);

	}

	/**
	 * Showing results for easy game level type.
	 * 
	 * @param evt
	 */
	private void easyEventActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_newGameMenuItemActionPerformed
		MastermindScoreFileParser parser = new MastermindScoreFileParser();
		Scores scoresLoad = parser.getScoreFromFile(GameLevelType.EASY);
		for (int i = 0; i < names.length; i++) {
			names[i].setText("");
			scores[i].setText("");
		}
		if (scoresLoad.getScores().size() != 0) {
			for (Score s : scoresLoad.getScores()) {
				names[scoresLoad.getScores().indexOf(s)].setText(s.getName());
				scores[scoresLoad.getScores().indexOf(s)].setText(String
						.valueOf(s.getScore()));
			}
		} else {
			// create new scores and set them
			names[0].setText("Not available");
			scores[0].setText("");
		}

	}

	/**
	 * Showing results for medium game level type.
	 * 
	 * @param evt
	 */
	private void mediumEventActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_newGameMenuItemActionPerformed
		MastermindScoreFileParser parser = new MastermindScoreFileParser();
		Scores scoresLoad = parser.getScoreFromFile(GameLevelType.MEDIUM);
		for (int i = 0; i < names.length; i++) {
			names[i].setText("");
			scores[i].setText("");
		}
		if (scoresLoad.getScores().size() != 0) {
			for (Score s : scoresLoad.getScores()) {
				names[scoresLoad.getScores().indexOf(s)].setText(s.getName());
				scores[scoresLoad.getScores().indexOf(s)].setText(String
						.valueOf(s.getScore()));
			}
		} else {
			// create new scores and set them
			names[0].setText("Not available");
			scores[0].setText("");
		}

	}

	/**
	 * Showing results for difficult game level type.
	 * 
	 * @param evt
	 */
	private void difficultEventActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_newGameMenuItemActionPerformed
		MastermindScoreFileParser parser = new MastermindScoreFileParser();
		Scores scoresLoad = parser.getScoreFromFile(GameLevelType.DIFFICULT);
		for (int i = 0; i < names.length; i++) {
			names[i].setText("");
			scores[i].setText("");
		}
		if (scoresLoad.getScores().size() != 0) {
			for (Score s : scoresLoad.getScores()) {
				names[scoresLoad.getScores().indexOf(s)].setText(s.getName());
				scores[scoresLoad.getScores().indexOf(s)].setText(String
						.valueOf(s.getScore()));
			}
		} else {
			// create new scores and set them
			names[0].setText("Not available");
			scores[0].setText("");
		}

	}
}
