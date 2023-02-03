package se.ikran.kth.labb3A.Shapes.FillableShapes;

import se.ikran.kth.labb3A.Shapes.Shape;
import javafx.scene.paint.Color;


public abstract class FillableShape extends Shape {

    private boolean filled;

    protected FillableShape()
    {
        this(0,0,Color.RED,true);
    }

    protected FillableShape(double x, double y, Color color,boolean filled)//,double x2, double y2)
    {
        super(x, y,color);
        this.filled=filled;



    }




    public boolean isFilled() {
        return filled;
    }


    public void setFilled(boolean filled)
    {
        this.filled=filled;
    }
}