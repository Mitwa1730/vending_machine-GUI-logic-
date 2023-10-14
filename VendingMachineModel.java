package Assignment5_000905034;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static javafx.application.Application.launch;

/**
 * This class represents the model components for the machine.
 * It contains a method that draws vending machine.
 * @author Mitwa Patel, 000905034
 */
public class VendingMachineModel {

    /**
     * It draws the vending machine on the canvas.
     * @param gc  The Graphics Context
     * @param quantity  The quantity of items in machine
     */
    public void draw(GraphicsContext gc, int quantity) {

        // YOUR CODE STARTS HERE
        gc.setStroke(Color.BLACK);
        gc.strokeRoundRect(75,30,450,630, 50, 50);

        gc.strokeLine(75, 80, 525, 80);
        gc.strokeLine(75, 120, 525, 120);

        gc.strokeRoundRect(100,150,250,300, 50, 50);

        gc.strokeLine(75, 560, 525, 560);

        for(int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                gc.setFill(Color.LIGHTSTEELBLUE);
                gc.fillRoundRect(120+60*j,180+95*i,30,50, 15, 15);
                gc.strokeRoundRect(120+60*j,180+95*i,30,50, 15, 15);
                gc.strokeLine(120+60*j, 222+95*i, 150+60*j, 222+95*i);
                gc.setFill(Color.BLACK);
                gc.fillOval(120+60*j,175+95*i,30,12);
                if(quantity==0){
                    break;
                }
                quantity--;
            }
        }

    }
}
