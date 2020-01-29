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
public class Controller {
    
    public static void main(String[] args){
        Model model = new Model(1200, 605);
        View view = new View(1200, 605);
        
        model.start();
        view.StartGui();
        
        
        for (;;) {
            try {
                //sending the actual Thread of execution to sleep X milliseconds
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
            view.setShapes(model.getArray(), model.getSira());
        }
        
    }    
}
