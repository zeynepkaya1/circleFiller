/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication42;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mert Yacan
 */
public class CirclePanel extends JPanel {
    
    int wSize;
    int hSize;
    int sira = 0;
    ZCircle[] circles;

    CirclePanel(int wSize, int hSize) {
        super();
        this.wSize = wSize;
        this.hSize = hSize;
        this.setSize(wSize, hSize);
        setBackground(Color.WHITE);
        this.setLayout(null);
        start();
    }
    
    public void setShapes(ZCircle[] a, int sira){
        circles = a;
        this.sira = sira;
    }
    
    public void start(){
        
        Runnable myRunnable2 = new Runnable() {
            public void run() {
                for (;;) {
                    try {
                        //sending the actual Thread of execution to sleep X milliseconds
                        Thread.sleep(33);
                    } catch (InterruptedException ie) {
                    }
                    repaint();
                }
            }
        };
        
        Thread thread3 = new Thread(myRunnable2);
        thread3.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (sira != 0) {
            this.removeAll();
            Graphics2D ga = (Graphics2D) g;
            for(int i = 0; i<sira ; i++){
                ga.setColor(circles[i].getTheColor());
                ga.fillOval(circles[i].getX()-circles[i].getR(), circles[i].getY()-circles[i].getR(), circles[i].getR()*2, circles[i].getR()*2);
            }
        }
    }
    
}
