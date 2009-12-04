package com.masprop.cluster1.privateclasses.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * Panel that load image as background
 * 
 * @author Milovan Duric
 *
 */
public class JImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	     private BufferedImage image;  
	     private int x, y;  
	     

	     /**
	      * Class Constructor
	      * display image on defined position
	      * 
	      * @param image
	      * @param x
	      * @param y
	      */
	     public JImagePanel(BufferedImage image, int x, int y) {  
	         super();  
	         this.image = image;  
	         this.x = x;  
	         this.y = y;  
	         this.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
	     }  
	     
	     /**
	      * paint of image
	      */
	     protected void paintComponent(Graphics g) {  
	         super.paintComponent(g); 
	         g.drawImage(image, x, y, null);  
	     } 
	     
	     /**
	 	 * static method for loading image
	 	 */
	     public static BufferedImage loadImage(String ref) {  
	         BufferedImage bimg = null;  
	         try {  
	   
	             bimg = ImageIO.read(new File(ref));  
	         } catch (Exception e) {  
	             e.printStackTrace();  
	         }  
	         return bimg;  
	     }


}