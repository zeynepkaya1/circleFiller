/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication42;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mert Yacan
 */
public class View {
    
    private int width;
    private int height;
    JFrame frame;
    CirclePanel panel;
    JLabel bg;
    
    
    public View(int width, int height){
        this.width = width;
        this.height = height;
    }
    
    public void setShapes(ZCircle[] a, int sira){
        panel.setShapes(a, sira);
    }

    public void StartGui() {
        ImageIcon bgimg = new ImageIcon("C:\\Users\\Mert Yacan\\Documents\\NetBeansProjects\\JavaApplication42\\src\\javaapplication42\\BG.jpg");
        bg = new JLabel(bgimg);
        bg.setBounds(0, 0, bgimg.getIconWidth(), bgimg.getIconHeight());
        JFrame frame = new JFrame("circleFiller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(width+97, height+160);
        frame.setVisible(true);
        panel = new CirclePanel(width,height);
        panel.setLocation(40, 75);
        panel.setVisible(true);
        frame.add(panel);
        frame.add(bg);
    }
}
