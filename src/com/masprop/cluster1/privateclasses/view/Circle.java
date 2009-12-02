package com.masprop.cluster1.privateclasses.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JComponent;

public class Circle extends JComponent implements MouseListener, MouseMotionListener {
    private static final long serialVersionUID = 1L;

public class Circle extends JComponent implements MouseListener{
	private static final long serialVersionUID = 1L;

	/**
	 * all colors in which circle can be drawn 
	 * num of used colors from this array 
	 * depends from difficulty level   
	 */
	private Color colors[] = {Color.GRAY, Color.white, Color.red, Color.green,
    		Color.yellow, Color.cyan, Color.pink, Color.MAGENTA};
	
	/**
	 * difficulty level
	 */
	private int level;
	
	/**
	 * position where circle will be drawn
	 * and radios of circle  
	 */
	private int x, y, r;
	
	
	
	/**
	 * current color of the circle 
	 */
	private int color;
	
	
	/**
	 * is only for input 
	 */
	boolean input;
	
	// FIXME This should be removed later
	FileWriter fstream = null;
	BufferedWriter out;
	

	/**
	 * class constructor
	 * @params x, y position of circle
	 */
	public Circle(int x, int y, int r, int level, boolean input, int color){
		this.x = x;
		this.y = y;
		
		/**
		 * level value   easy = 0, medium = 1, hard = 2
		 * num of colors easy = 3, medium = 6, hard = 9  
		 */
		this.level = 3 * (level+1);
		
	    this.input = input;
		
	    this.r = r;
		this.color = color;
		
		this.addMouseListener(this);	
		
	}

	public void paint(Graphics g) {
		//setBounds(0,0,1000,1000);
		setBounds(0,0,x+2*r+5,y+2*r+5); 
	    Graphics2D g2 = (Graphics2D) g;

	    g2.setColor(Color.BLACK);
		Stroke stroke = new BasicStroke(1);
		g2.setStroke(stroke);

		g2.drawOval(x-1, y-1, 2*r, 2*r);
		
		g2.setColor(colors[color]);
		g2.fillOval(x, y, 2*r-2, 2*r-2);

    private boolean drag;

	@Override
	public void mouseClicked(MouseEvent arg0) {
		//FIX ME 
		//here should be check if cell is editable
		//if not do nothing
		//controler.check....
		if(input){
			int xclick = arg0.getX();
			int yclick = arg0.getY();
			if(xclick>x && xclick<x+2*r && yclick>y && yclick<y+2*r){
				color = (color + 1) % level;
				repaint();
		}
			
	}
		
		
		
		
		
        /*
        try {
			out.write("input[" + ++i +"] = new Circle(" + x + "," + y + ", 1)\n");
			if(i==7) out.close();
            }catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
		    }
		*/    
	}

        /**
         * level value   easy = 0, medium = 1, hard = 2
         * num of colors easy = 3, medium = 6, hard = 9
         */
        this.level = 3 * (level+1);

        // FIX ME
        // this should be default value of circle size
        r = 15;
        color = 1;

        drag = false;

        startx = this.getParent().getX();
        starty = this.getParent().getY();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void paint(Graphics g) {

        //FIX ME
        //bound should be image size or....
        this.setBounds(startx, starty, startx , 1000);
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(colors[color]);
        Stroke stroke = new BasicStroke(6);
        g2.setStroke(stroke);

        g2.drawOval(x, y, 2*r, 2*r);
        g2.fillOval(x, y, 2*r, 2*r);



}
