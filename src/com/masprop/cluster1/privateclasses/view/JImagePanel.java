package com.masprop.cluster1.privateclasses.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class JImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	     private BufferedImage image;  
	     private int x, y;  
	     
	     /**
	 	 * class constructor
	 	 * 
	 	 * @param image
	 	 * @params x, y position where image will be displayed 	 	 
	 	 **/
	     public JImagePanel(BufferedImage image, int x, int y) {  
	         super();  
	         this.image = image;  
	         this.x = x;  
	         this.y = y;  
	         this.setBackground(new Color(Integer.valueOf("f3a15a", 16)));
	     }  
	     
	     @Override  
	     protected void paintComponent(Graphics g) {  
	         super.paintComponent(g); 
	         g.drawImage(image, x, y, null);  
	     } 
	     
	     /**
	 	 * static method for loading image
	 	 **/
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