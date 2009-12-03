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
     * GUI manager for communication with 
     * domain layer
     */
    GUIManager manager;

    /**
     * position in domain layer
     */
    private int i, j;

    /**
     * position where circle will be drawn
     * and radios of circle
     */
    private int x, y, r;



    /**
     * current color of the circle
     */
    private int color;


    // FIXME This should be removed later
    FileWriter fstream = null;
    BufferedWriter out;


    /**
     * class constructor
     * @params x, y position of circle
     * @params i, j position in domain layer
     */
    public Circle(int x, int y, int r, GUIManager manager, int i , int j,  int color){
        this.x = x;
        this.y = y;

        this.manager = manager;
        this.i = i;
        this.j = j;


        this.r = r;
        this.color = color;

        this.addMouseListener(this);

    }
    
    
    /**
     * class constructor
     * @params x, y position of circle
     * this circles are only for results and status 
     */
    public Circle(int x, int y, int r, GUIManager manager, int color){
        this.x = x;
        this.y = y;

        this.manager = manager;

        this.r = r;
        this.color = color;

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

    }


    public void mouseClicked(MouseEvent arg0) {
       if(manager.getMastermind() != null){
           if(manager.getMastermind().getMastermindStatus().
           		getMatrixMastermind().getCell(i, j).isEditable()){
               int xclick = arg0.getX();
               int yclick = arg0.getY();
               if(xclick>x && xclick<x+2*r && yclick>y && yclick<y+2*r){
               	
               	int value = manager.getMastermind().getMastermindStatus().
           		getMatrixMastermind().getCell(i, j).getCurrentValue();
               	
               	value = (value + 1) % manager.numColors
               	(manager.getMastermind().getGameLevelType());
               	
               	manager.getMastermind().getMastermindStatus().
           		getMatrixMastermind().getCell(i, j).setCurrentValue(value);
               	
               	manager.getMastermind().getMastermindStatus().
           		getMatrixMastermind().getCell(i, j).setActive(true);
               	
               	color = value + 2;
                   repaint();
                }
            	
           }
        	   
       }

    }


    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }


    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }


    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }


    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }


	public int getColor() {
		return color;
	}


	public void setColor(int color) {
		this.color = color;
	}






}