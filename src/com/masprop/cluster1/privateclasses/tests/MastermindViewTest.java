package com.masprop.cluster1.privateclasses.tests;

import java.awt.image.BufferedImage;
import javax.swing.JFrame;

import com.masprop.cluster1.privateclasses.view.Circle;
import com.masprop.cluster1.privateclasses.view.JImagePanel;


public class MastermindViewTest {
	
         
	     //FIX ME 
	     //THIS SHOULD BE IN ANOTHER CLASS 	
	     public void loadAndDisplayImage(JFrame frame) {  
		         BufferedImage loadImg = JImagePanel.loadImage("slika.jpg") ;
		         frame.setBounds(0, 0, 400, 400);  
		         JImagePanel panel = new JImagePanel(loadImg, 100, 40);
		         Circle c1 = new Circle(20, 20, 2);
		         panel.add(c1);
		         Circle c2 = new Circle(20, 80, 2);
		         panel.add(c2);
		         frame.add(panel);  
		         frame.setVisible(true);  
		     }
	
	     public static void main(String[] args) {  
	    	     MastermindViewTest test = new MastermindViewTest();  
		         JFrame frame = new JFrame("Mastermind");  
		         test.loadAndDisplayImage(frame);  
		     }  
}