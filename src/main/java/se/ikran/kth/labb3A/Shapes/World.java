package se.ikran.kth.labb3A.Shapes;


import se.ikran.kth.labb3A.Shapes.FillableShapes.Circle;
import se.ikran.kth.labb3A.Shapes.FillableShapes.Rectangle;
import javafx.scene.paint.Color;


/**
 * A representation of a world containing a set of moving shapes. NB! The worlds
 * y-axis points downward.
 *
 * @author Anders LindstrÃ¶m, anderslm@kth.se 2021-09-15
 */
public class World {

    private double width, height; // this worlds width and height

    private final Shape[] shapes; // an array of references to the shapes

    /**
     * Creates a new world, containing a pad and a set of balls. NB! The worlds
     * y-axis points downward.
     *
     * @param width  the width of this world
     * @param height the height of this world
     */
    public World(double width, double height) {
        this.width = width;
        this.height = height;

        shapes = new Shape[3]; // / an array of references (change to non-zero size)
        shapes[0] = new Line(0, 0, 100, 80, Color.ROSYBROWN);
        shapes[0].setVelocity(20, 40);
        shapes[1] = new Rectangle(160, 60, 60, 30, Color.RED, true);
        shapes[1].setVelocity(20, 40);
        shapes[2] = new Circle(10, 10, 20, Color.RED, true);
        shapes[2].setVelocity(20, 40);


    }

    /**
     * Sets the new dimensions, in pixels, for this world. The method could be
     * used for example when the canvas is reshaped.
     *
     * @param newWidth
     * @param newHeight
     */
    public void setDimensions(double newWidth, double newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    /**
     * Move the world one step, based on the time elapsed since last move.
     *
     * @param elapsedTimeNs the elapsed time in nanoseconds
     */
    public void moveAndConstrain(long elapsedTimeNs) {
        // alterantive loop: for(Shape s : shapes) { ...
        for (Shape s : shapes) {
            s.moveAndConstrain(elapsedTimeNs, 0, 0, width, height);
        }
    }

    /**
     * Returns a copy of the list of ball references.
     * Due to the implementation of clone, a shallow copy is returned.
     *
     * @return a copy of the list of balls
     */
    public Shape[] getShapes() {
        return (Shape[]) shapes.clone();
    }
}