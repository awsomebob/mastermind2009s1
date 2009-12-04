package com.masprop.cluster1.privateclasses.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JComponent;

/**
 * This class draw line like separator 
 * between components
 * 
 * @author Milovan
 *
 */
public class MyLine extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * position where line will be drawn 
	 */
	private int x, y, w;
	
	/**
	 * color in which line will be painted
	 */
	private Color color;
	
	
	/**
	 * Class constructor
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param color
	 */
	public MyLine(int x, int y, int w, Color color){
		this.x = x;
		this.y = y;
			
	    this.w = w;
	    this.color = color;
		
	}

	/**
	 * paint line on defined position
	 * and in defined color
	 */
	public void paint(Graphics g) {
		setBounds(0, 0, x+300, y+10); 
	    Graphics2D g2 = (Graphics2D) g;

	    g2.setColor(color);
		Stroke stroke = new BasicStroke(w);
		g2.setStroke(stroke);

		g2.drawLine(x, y, x+200, y);
		g2.drawLine(x+219, y, x+270, y);

	}
	

	/**
	 * set color
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * 
	 * @return color
	 */
	public Color getColor() {
		return color;
	}

}
