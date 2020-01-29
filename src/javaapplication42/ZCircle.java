/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication42;

import java.awt.Color;

/**
 *
 * @author Monster
 */
public class ZCircle{
    private int x,y,r;
    static int isim = 0;
    private String benimIsmim = "Circle-";
    private boolean isStucked = false;
    private Color color;
    
    public ZCircle(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
        if(isim<10){
            this.benimIsmim = benimIsmim+"00"+isim++;
        }
        else if(isim<100){
            this.benimIsmim = benimIsmim+"0"+isim++;
        }
        else{
            this.benimIsmim = benimIsmim+ isim++;
        }
        setAColor();
    }
    
    public ZCircle(int x, int y, int x2, int y2){
        this.x = (x + x2)/2;
        this.y = (y + y2)/2;
        int xfarki = x - x2;
        int yfarki = y - y2;
        this.r = (int) Math.sqrt((xfarki*xfarki)*(yfarki*yfarki));
        if(isim<10){
            this.benimIsmim = benimIsmim+"00"+isim++;
        }
        else if(isim<100){
            this.benimIsmim = benimIsmim+"0"+isim++;
        }
        else{
            this.benimIsmim = benimIsmim+ isim++;
        }
        setAColor();
    }
    
    public ZCircle(){
        this.x = 0;
        this.y = 0;
        this.r = 1;
        if(isim<10){
            this.benimIsmim = benimIsmim+"00"+isim++;
        }
        else if(isim<100){
            this.benimIsmim = benimIsmim+"0"+isim++;
        }
        else{
            this.benimIsmim = benimIsmim+ isim++;
        }
        setAColor();
    }
    
    public void setAColor(){
        int rC = 0;
        int gC = 0;
        int bC = 0;
        int s = (int) (Math.random()*4);
        switch(s){
            case 0:
                rC = 190;
                gC = 30;
                bC = 45;
                break;
            case 1:
                rC = 33;
                gC = 64;
                bC = 154;
                break;
            case 2:
                rC = 255;
                gC = 222;
                bC = 23;
                break;
            default:
                break;
        }
        color = new Color(rC,gC,bC);
    }
    
    public Color getTheColor(){
        return color;
    }
    
    public void getBigCircle(){
        r++;
    }
    
    public boolean getIsStucked(){
        return isStucked;
    }
    
    public void setStucked(){
        isStucked = true;
    }
    
    public boolean IsInside(int x, int y){
        int xDifference = this.x - x;
        int yDifference = this.y - y;
        double Distance = Math.sqrt((xDifference*xDifference)+(yDifference*yDifference));
        return (Distance < r+0.5);
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void setR(int r){
        this.r = r;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getR(){
        return r;
    }
    
    public double area(){
        return Math.PI*r*r;
    }
    
    public double circumferance(){
        return 2*Math.PI*r;
    }
    
    public double distance(){
       return Math.sqrt((x*x)+(y*y));
    }
    
    public String info(){
        String a = "my name is: "+benimIsmim+" this circle is located at x: "+x+" y: "+y+" radious: "+r+" area: "+(int)area()+" circumferance: "+(int)circumferance()+" distance: "+(int)distance();
        return a;
    }
}