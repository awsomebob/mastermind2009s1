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

/**
 * This class draws a circle
 * on defined coordinates with default radius
 * if it's circle for inputs then it have mouse 
 * listener that handle click on that circle 
 * and change value in Matrix and color
 * 
 * @see GUIManager
 * 
 * @author Milovan Duric
 *
 */
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
    
    /**
     * max value for color
     * uses for case when user set value
     * on the begin
     */
    private int max;


    // FIXME This should be removed later
    FileWriter fstream = null;
    BufferedWriter out;


  /**
   * Class constructor
   * with parameters for position on the screen 
   * and position corresponding cell in matrix 
   * 
   * @param x
   * @param y
   * @param r
   * @param manager
   * @param i
   * @param j
   * @param color
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
    * Class constructor
    * with parameters for position on the screen 
    * and position corresponding cell in matrix 
    * max is for max color value 
    * when computer play against value
    *  
    * @param x
    * @param y
    * @param r
    * @param manager
    * @param i
    * @param j
    * @param color
    * @param max
    */
    public Circle(int x, int y, int r, GUIManager manager, int i , int j,  int color, int max){
        this.x = x;
        this.y = y;

        this.manager = manager;
        this.i = i;
        this.j = j;


        this.r = r;
        this.color = color;
        
        this.max = max;

        this.addMouseListener(this);

    }

    /**
     * Class constructor for circle which will
     * be used only for displaying information
     * it doesn't have mouse listener
     * 
     * @param x
     * @param y
     * @param r
     * @param manager
     * @param color
     */
    public Circle(int x, int y, int r, GUIManager manager, int color){
        this.x = x;
        this.y = y;

        this.manager = manager;

        this.r = r;
        this.color = color;

    }

    
    /**
     * painting circle on defined position
     * in defined color 
     */
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


    /**
     * handler for mouse click event
     * it check for the status of corresponding
     * cell in matrix and change value and color
     */
    public void mouseClicked(MouseEvent arg0) {
       if(manager.getMastermind() != null && i<28 && j<28){
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
       
       if(i==100 && j==100){
    	   color = color + 1;
    	   if (color==(max+2)) color = 2;
    	   repaint();
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

    /**
     * 
     * @return color
     */
    public int getColor() {
        return color;
    }

    /**
     * set color
     * @param color
     */
    public void setColor(int color) {
        this.color = color;
    }






}