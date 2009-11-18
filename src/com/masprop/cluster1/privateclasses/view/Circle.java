package com.masprop.cluster1.privateclasses.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class Circle extends JComponent implements MouseListener, MouseMotionListener {
    private static final long serialVersionUID = 1L;

    /**
     * all colors in which circle can be drawn
     * num of used colors from this array
     * depends from difficulty level
     */
    private Color colors[] = {Color.black, Color.white, Color.red, Color.green, Color.blue,
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
     * position of parrent component
     **/
    private int startx, starty;

    /**
     * position that is defined in constructor
     * where circle will be drawn
     * and radios of circle
     */
    private int xx,yy;

    /**
     * current color of the circle
     */
    private int color;

    private boolean drag;


    /**
     * class constructor
     * @params x, y position of circle
     */
    public Circle(int x, int y, int level){
        this.x = x;
        this.y = y;
        this.xx = x;
        this.yy = y;

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


    public void mouseClicked(MouseEvent arg0) {
        //FIX ME
        //here should be check if cell is editable
        //if not do nothing
        //controler.check....


        int xclick = arg0.getX();
        int yclick = arg0.getY();
        if(xclick>x && xclick<x+2*r && yclick>y && yclick<y+2*r){
            color = (color + 1) % level;
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

        int xclick = arg0.getX();
        int yclick = arg0.getY();
        if(xclick>x && xclick<x+2*r && yclick>y && yclick<y+2*r){
            drag = true;
        }
    }

    public void mouseReleased(MouseEvent arg0) {

        //FOX ME
        //here should be some check if
        //new position is valid


        if(drag){
            x = xx;
            y = yy;
            repaint();
        }


        //else COPY this circle on the chosen position

    }


    public void mouseDragged(MouseEvent e) {
        //FIX ME
        //here should be check if cell is editable
        //if not do nothing
        //controler.check....

        if(drag){
            int dragx = e.getX() - r;
            int dragy = e.getY() - r;

            int dx = dragx - x;
            int dy = dragy - y;

            x += dx;
            y += dy;

            repaint();
        }

    }

    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
