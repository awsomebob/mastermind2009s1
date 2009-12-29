/**
 * Import our packages
 */
package com.masprop.cluster1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.masprop.cluster1.privateclasses.view.JImagePanel;
import com.masprop.cluster1.privateclasses.view.MyGUI;

/**
 * @author Nick
 *
 */
public class Main {
    /**
     * class constructor
     *
     * @param frame
     *            where component we be will drawn
     */
    public void createGraphicsComponents(JFrame frame) {
        // background image for center panel
        BufferedImage loadImg = JImagePanel
                .loadImage("Mastermind-hiddenbox.png");

        frame.setBounds(0, 0, 480, 810);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // base panel contain image panel and button panel
        // only because of layout
        JPanel basePanel = new JPanel(new BorderLayout());

        JImagePanel imagePanel = new JImagePanel(loadImg, 50, 38);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(Integer.valueOf("f3a15a", 16)));

        /*
         * //components are placed in inverse order //first physical row is with
         * index i=7 Circle inputs[] = new Circle[28]; int xInput = 100; int
         * yInput = 96; MyLine[] line = new MyLine[7];
         *
         * for(int i=0; i<7; i++){ for(int j=0; j<4; j++){ if(i==6) inputs[i*4 +
         * j] = new Circle(xInput + j*52, yInput + i*78, 20, 1, true, 1); else
         * inputs[i*4 + j] = new Circle(xInput + j*52, yInput + i*78, 20, 1,
         * true, 0); imagePanel.add(inputs[i*4 + j]); }
         *
         * //separator between rows //also if separator is white row is edit
         * able if(i==6) line [i] = new MyLine(xInput, yInput + (i+1)*78 - 28,
         * 2, Color.white); else line [i] = new MyLine(xInput, yInput + (i+1)*78 -
         * 28, 2, Color.GRAY); imagePanel.add(line[i]); }
         *
         * Circle results[] = new Circle[28]; int xOutput = 320; int yOutput =
         * 92;
         *
         * for(int i=0; i<7; i++) for(int j=0; j<2; j++) for(int k=0; k<2;
         * k++){ results[i*4 + j*2 + k] = new Circle(xOutput + j*26, yOutput +
         * i*78 + k*26, 11, 1, false, 0); imagePanel.add(results[i*4 + j*2 +
         * k]); }
         *
         */

        // This is button whit purpose of finishing guessing for current row
        JButton check = new JButton("Mastermind check");
        check.setBackground(new Color(Integer.valueOf("b25b10", 16)));
        check.setSize(20, 100);
        buttonPanel.add(check);

        basePanel.add(imagePanel, BorderLayout.CENTER);
        basePanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(basePanel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();

        // JFrame frame = new JFrame("Mastermind");

        MyGUI gui = new MyGUI();
        // gui.setVisible(true);

        main.createGraphicsComponents(gui);
    }

}
