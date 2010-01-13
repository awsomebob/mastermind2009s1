package com.masprop.cluster1.privateclasses.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Dialog about manual
 *
 * @author Milan Stanic
 *
 */

public class ManualDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;

    private JButton jButton = null;

    private JTextArea jTextArea = null;

    private MyGUI myGUI;

    /**
     * Constructor
     *
     * @param owner
     */
    public ManualDialog(Frame owner){
        super(owner);
        initialize();
    }

    /**
     * Constructor
     *
     * @param owner
     */
    public ManualDialog(MyGUI owner){
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
        this.setSize(250, 260);
        this.setTitle("Manual for Game");
        this.setContentPane(getJContentPane());
        this.setResizable(false);
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {

            jTextArea = new JTextArea();
            jTextArea.setBounds(new Rectangle(20, 20, 200, 140));
            jTextArea.setText("Click on File, New Game to start a new game. If you really don't know what to do please consult the manual included with this game. It situates itself in the same folder as where the game is installed.");
            jTextArea.setEditable(false);
            jTextArea.setLineWrap(true);
            jTextArea.setWrapStyleWord(true);
            jTextArea.setBackground(new Color(Integer.valueOf("f3a15a", 16)));

            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.setBackground(new Color(Integer.valueOf("f3a15a", 16)));


            jContentPane.add(jTextArea, null);

            jContentPane.add(getJButton(), null);

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
            jButton.setBounds(new Rectangle(20, 180, 140, 20));
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
     * Closing dialog
     * @param evt
     */
    private void cancelEventActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_newGameMenuItemActionPerformed

        this.setVisible(false);
    }
}
