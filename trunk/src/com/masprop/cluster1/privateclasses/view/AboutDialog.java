package com.masprop.cluster1.privateclasses.view;


import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Frame;
import javax.swing.JDialog;
import java.awt.Rectangle;



import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * Dialog about game
 *
 * @author Milan Stanic
 *
 */



public class AboutDialog extends JDialog {


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
    public AboutDialog(Frame owner){
        super(owner);
        initialize();
    }

    /**
     * Constructor
     *
     * @param owner
     */
    public AboutDialog(MyGUI owner){
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
        this.setTitle("About Game");
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
            jTextArea.setText("This game was created for learning purposes. It is licensed under a GPLv2 agreement. If you have any questions about this program please email us on the following address: nick.veenhof@gmail.com");
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
