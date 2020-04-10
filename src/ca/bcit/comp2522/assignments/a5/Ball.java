package ca.bcit.comp2522.assignments.a5;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.List;
import java.util.Random;

/**
 *  Ball is a Runnable.  A Ball bounces.
 *
 * @author BCIT
 * @version 2020
 */
public class Ball extends Circle implements Runnable {
    private static List<Ball> ballList;

    private static final Random generator = new Random();

    private static final int MAX_X = 500; // horizontal edge of enclosing Panel
    private static final int MAX_Y = 500; // vertical edge of enclosing Panel

    private int dx; // change in horizontal position of ball
    private int dy; // change in vertical position of ball


    /**
     * Constructs an object of type Ball.
     * @param xPosition an int
     * @param yPosition an int
     */
    public Ball(int xPosition, int yPosition) {
        super(10, Color.RED);
        this.setCenterX(xPosition);
        this.setCenterY(yPosition);
        dx = generator.nextInt(5); // change in x (0 - 4 pixels)
        if (dx != 0)
            dy = generator.nextInt(5); // change in y (0 - 4 pixels)
        else
            dy = generator.nextInt((5 - 1) + 1) + 1;
    }

    public void setBallList(List<Ball> newBallList) {
        ballList = newBallList;
    }

    public List<Ball> getBallList() {
        return ballList;
    }

    /**
     * Bounces the Ball perpetually.
     */
    public void run() {
        while (true) {
            try {
                Thread.sleep(20); // sleep for 20 milliseconds
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            /* Long-running operations must not be run on the JavaFX application
               thread, since this prevents JavaFX from updating the UI, resulting
               in a frozen UI.

               Furthermore any change to a Node that is part of a "live" scene
               graph must happen on the JavaFX application thread.

               Platform.runLater can be used to execute those updates on the
               JavaFX application thread.
             */
            Platform.runLater( () -> {
                // if bounce off top or bottom of Panel
                if (this.getCenterY() <= 0 || this.getCenterY() >= MAX_Y)
                    dy *= -1; // reverses velocity in y direction

                // if bounce off left or right of Panel
                if (this.getCenterX() <= 0 || this.getCenterX() >= MAX_X)
                    dx *= -1; // reverses velocity in x direction

                for (Ball ball : ballList) {
                    if (!ball.equals(this)) {
                        Shape intersect = Shape.intersect(ball, this);
                        if (intersect.getBoundsInLocal().getWidth() != -1) {
                            if (dx == 0) {
                                dx = 1;
                                dx *= -1;
                            }
                            else if (dy == 0) {
                                dy = 1;
                                dy *= -1;
                            }
                            dx *= -1;
                            dy *= -1;
                        }
                    }

                }

                this.setCenterX(this.getCenterX() + dx); // determines new x-position
                this.setCenterY(this.getCenterY() + dy); // determines new y-position
            });
        }
    }
}