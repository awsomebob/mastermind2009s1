package com.masprop.cluster1.shared.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author Michal Karm Babacek
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Actions and Swingworkers handled here manager.
     */
    private GUIManager guiManager = null;
    List<JTextField> cells = null;

    /**
     * Initialization of all the components included in this JFrame.
     */
    public GUI() {
        guiManager = new GUIManager(this) {
        };
        initComponents();
        initializeCells();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aboutDialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        buttonGameIsDone1 = new javax.swing.JButton();
        fileChooser = new javax.swing.JFileChooser();
        jSplitPane1 = new javax.swing.JSplitPane();
        sidebar = new javax.swing.JPanel();
        buttonGameIsDone = new javax.swing.JButton();
        gameBoard = new javax.swing.JPanel();
        statusBar = new javax.swing.JPanel();
        statusText = new javax.swing.JLabel();
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
        aboutDialog.setMinimumSize(new java.awt.Dimension(400, 350));
        aboutDialog.setResizable(false);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel1.setText("Authors:");

        jLabel2.setText("Michal \"Karm\" Babacek");

        jLabel3.setText("Anshuman Mehta");

        jLabel4.setText("Adrien Daunou");

        jLabel5.setText("Matus Pleva");

        jLabel6.setText("Matteo De Martino");

        jLabel7.setText("Andrea Gritti");

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel8.setText("Version:");

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel9.setText("Licence:");

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel10.setText("Third party:");

        jLabel11.setText("Icons by Brsev, CC by-nc-nd, 3.0");

        jLabel12.setFont(new java.awt.Font("DejaVu Sans", 2, 14));
        jLabel12.setText("http://brsev.deviantart.com/");

        jLabel13.setText("0.1b, rev32");

        jLabel14.setText("Apache 2");

        buttonGameIsDone1.setBackground(new java.awt.Color(196, 186, 166));
        buttonGameIsDone1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/masprop/cluster1/shared/view/graphics/menu_exit.png"))); // NOI18N
        buttonGameIsDone1.setText("Dismiss");
        buttonGameIsDone1.setToolTipText("Close this window.");
        buttonGameIsDone1.setActionCommand("Close");
        buttonGameIsDone1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonGameIsDone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGameIsDone1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout aboutDialogLayout = new javax.swing.GroupLayout(aboutDialog.getContentPane());
        aboutDialog.getContentPane().setLayout(aboutDialogLayout);
        aboutDialogLayout.setHorizontalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aboutDialogLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)))
                    .addGroup(aboutDialogLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addGroup(aboutDialogLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addGroup(aboutDialogLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutDialogLayout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addComponent(buttonGameIsDone1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        aboutDialogLayout.setVerticalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addGroup(aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGameIsDone1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        fileChooser.setBackground(new java.awt.Color(230, 215, 193));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jSplitPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jSplitPane1.setDividerLocation(120);
        jSplitPane1.setEnabled(false);
        jSplitPane1.setMaximumSize(new java.awt.Dimension(200, 1));
        jSplitPane1.setMinimumSize(new java.awt.Dimension(200, 1));

        sidebar.setBackground(new java.awt.Color(254, 197, 111));

        buttonGameIsDone.setBackground(new java.awt.Color(196, 186, 166));
        buttonGameIsDone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/masprop/cluster1/shared/view/graphics/button_done.png"))); // NOI18N
        buttonGameIsDone.setText("Done");
        buttonGameIsDone.setToolTipText("Click if you are done.");
        buttonGameIsDone.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonGameIsDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGameIsDoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonGameIsDone, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonGameIsDone)
                .addContainerGap(346, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(sidebar);

        gameBoard.setBackground(new java.awt.Color(236, 179, 95));
        gameBoard.setLayout(new java.awt.GridLayout(10, 10));
        jSplitPane1.setRightComponent(gameBoard);

        statusBar.setBackground(new java.awt.Color(248, 233, 210));
        statusBar.setLayout(new java.awt.BorderLayout());

        statusText.setText("Welcome");
        statusBar.add(statusText, java.awt.BorderLayout.CENTER);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(statusBar, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param evt GUI Event
     */
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        guiManager.exit();
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void buttonGameIsDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGameIsDoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonGameIsDoneActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        aboutDialog.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void buttonGameIsDone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGameIsDone1ActionPerformed
        aboutDialog.setVisible(false);
    }//GEN-LAST:event_buttonGameIsDone1ActionPerformed

    private void loadGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGameMenuItemActionPerformed
    }//GEN-LAST:event_loadGameMenuItemActionPerformed

    private void saveGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGameMenuItemActionPerformed
    }//GEN-LAST:event_saveGameMenuItemActionPerformed

    private void initializeCells() {
        CellActionListener cellActionListener = new CellActionListener();
        CellFocusListener cellFocusListener = new CellFocusListener();
        CellKeyListener cellKeyListener = new CellKeyListener();
        JTextField cell = null;
        cells = new ArrayList<JTextField>();
        
        for (int i = 0; i < 100; i++) {

            cell = new JTextField();
            cell.setBackground(new Color(239, 227, 209));
            cell.setColumns(2);
            cell.setFont(new Font("DejaVu Sans", 1, 31));
            cell.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
            cell.setMaximumSize(new Dimension(2, 2));
            cell.setMinimumSize(new Dimension(2, 2));

            cell.addActionListener(cellActionListener);
            cell.addFocusListener(cellFocusListener);
            cell.addKeyListener(cellKeyListener);
            //cell.setText(""+i);
            gameBoard.add(cell);
            cells.add(cell);
        }
        cells.get(13).setVisible(false);
        cells.get(14).setVisible(false);
        cells.get(15).setVisible(false);
        cells.get(16).setVisible(false);
        
        cells.get(22).setVisible(false);
        cells.get(27).setVisible(false);
        cells.get(32).setVisible(false);
        cells.get(43).setVisible(false);

        cells.get(97).setVisible(false);
        cells.get(88).setVisible(false);
        cells.get(79).setVisible(false);
    }

    class CellKeyListener implements KeyListener {

        public void keyTyped(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
            //Nothing
        }

        public void keyReleased(KeyEvent e) {
            if (e.getSource() instanceof JTextField) {
                try {
                    if (!((JTextField) e.getSource()).getText().isEmpty()) {
                        if (Integer.parseInt(((JTextField) e.getSource()).getText()) > 100) {
                            ((JTextField) e.getSource()).setBorder(new LineBorder(Color.RED, 1, true));
                            ((JTextField) e.getSource()).setText("");
                            statusText.setText("Max allowed number you can fill in is 100...");
                        } else {
                            statusText.setText("");
                            ((JTextField) e.getSource()).setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
                        }
                    }
                } catch (NumberFormatException ex) {
                    ((JTextField) e.getSource()).setBorder(new LineBorder(Color.RED, 1, true));
                    ((JTextField) e.getSource()).setText("");
                    statusText.setText("Only numbers are allowed in cells...");
                }
            }
        }
    }

    class CellActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    class CellFocusListener implements FocusListener {

        public void focusGained(FocusEvent e) {
            if (e.getSource() instanceof JTextField) {
                ((JTextField) e.getSource()).setBackground(new Color(236, 184, 21));
            }
        }

        public void focusLost(FocusEvent e) {
            if (e.getSource() instanceof JTextField) {
                ((JTextField) e.getSource()).setBackground(new Color(239, 227, 209));
                if (((JTextField) e.getSource()).getText().isEmpty()) {
                    statusText.setText("");
                    ((JTextField) e.getSource()).setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
                }
            }
        }
    }

    /**
     * Run the main thread.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog aboutDialog;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton buttonGameIsDone;
    private javax.swing.JButton buttonGameIsDone1;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel gameBoard;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JMenuItem loadGameMenuItem;
    private javax.swing.JMenuItem manualMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newGameMenuItem;
    private javax.swing.JMenuItem saveGameMenuItem;
    private javax.swing.JMenuItem scoresMenuItem;
    private javax.swing.JPanel sidebar;
    private javax.swing.JPanel statusBar;
    private javax.swing.JLabel statusText;
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
}
