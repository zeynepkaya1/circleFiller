/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication42;

/**
 *
 * @author Mert Yacan
 */
public class Model {

    private int width;
    private int height;
    private ZCircle[] circles;
    private int howManyCircles = 500;
    private int sira = 0;
    Runnable myRunnable;

    public Model(int width, int height) {
        this.width = width;
        this.height = height;
    }

    //checks if the specified x,y location is inside another circle
    public boolean isInsideOther(int width, int height) {
        for (int i = 0; i < sira; i++) {
            if (circles[i].IsInside(width, height)) {
                //if inside one of the circles returns true
                return true;
            }
        }
        //if not inside any of the circles returns false
        return false;
    }

    public boolean isEdge(ZCircle a) {
        if ((a.getX() - a.getR() <= 0) || (a.getX() + a.getR() >= width) || (a.getY() - a.getR() <= 0) || (a.getY() + a.getR() >= height)) {
            return true;
        }
        return false;
    }

    //Checks if a circle is stucked or not
    public boolean isStucked(ZCircle a, int f) {
        if (a.getIsStucked()) {
            return true;
        }
        if(isEdge(a)){
            a.setStucked();
            return true;
        }
        //if the circle is at the beginning
        if (f == 0) {
            for (int i = 1; i < sira; i++) {
                if (distanceBetween(a, circles[i]) < 0) {
                    a.setStucked();
                    return true;
                }
            }
        } else if (f == sira - 1) {
            //if the circle is at the end
            for (int i = 0; i < sira - 1; i++) {
                if (distanceBetween(a, circles[i]) < 0) {
                    a.setStucked();
                    return true;
                }
            }
        } else {
            //for other circles
            for (int i = 0; i < f; i++) {
                if (distanceBetween(a, circles[i]) < 0) {
                    a.setStucked();
                    return true;
                }
            }
            for (int i = f + 1; i < sira; i++) {
                if (distanceBetween(a, circles[i]) < 0) {
                    a.setStucked();
                    return true;
                }
            }
        }
        return false;
    }

    //Finds the distance between two circles
    public int distanceBetween(ZCircle a, ZCircle b) {
        int xDif = a.getX() - b.getX();
        int yDif = a.getY() - b.getY();
        int r = a.getR() + b.getR();
        return (int) (Math.sqrt((xDif * xDif) + (yDif * yDif)) - r);
    }

    //Starts the getting bigger movement for all the circles that are not stucked
    public void getBigger() {
        for (int i = 0; i < sira; i++) {
            if (!isStucked(circles[i], i)) {
                circles[i].getBigCircle();
            }
        }
    }

    public ZCircle[] getArray() {
        return circles;
    }

    public int getSira() {
        return sira;
    }

    public void start() {
        circles = new ZCircle[howManyCircles];

        myRunnable = new Runnable() {
            public void run() {
                for (;;) {
                    try {
                        //sending the actual Thread of execution to sleep X milliseconds
                        Thread.sleep(100);
                    } catch (InterruptedException ie) {
                    }
                    getBigger();
                    int randomx = (int) (Math.random() * (width - 1)) + 1;
                    int randomy = (int) (Math.random() * (height - 1)) + 1;
                    if (!isInsideOther(randomx, randomy)) {
                        circles[sira++] = new ZCircle(randomx, randomy, 0);
                    }

                }
            }
        };

        Thread thread2 = new Thread(myRunnable);
        thread2.start();

    }

}
