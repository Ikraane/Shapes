package se.ikran.kth.labb3A.Shapes.FillableShapes;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends FillableShape{

    private double diameter;


    public Circle(double x, double y,double diameter,Color color,boolean filled)
    {
        super(x,y,color,filled);
        Circle circle= new Circle();
        this.diameter=diameter;

        isFilled();

        if (circle instanceof FillableShape)
        {
            setFilled(false);
        }

    }
    public Circle()
    {
        super();
        this.diameter=100;
    }



    public double getDiameter()
    {
        return diameter;
    }

    public void setDiameter(double diameter)
    {
        this.diameter=diameter;
    }

    @Override
    public void paint(GraphicsContext gc) {

        gc.setStroke(getColor());
        gc.strokeOval(getX(), getY(), diameter,diameter);


        if (isFilled())
        {
            gc.setFill(Color.BLACK);
            gc.fillOval(getX(), getY(), diameter,diameter);
        }
    }

    public void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY, boxWidth, boxHeight);

        double newDx = this.getDx();
        double newDy = this.getDy();
        if (getX() + this.diameter < boxX) {
            newDx = Math.abs(getDx());
        } else if (getX() + this.diameter > boxWidth) {
            newDx = -Math.abs(getDx());
        }

        if (getY() + this.diameter < boxY) {
            newDy = Math.abs(getDy());
        } else if (getY() + this.diameter > boxHeight) {
            newDy = -Math.abs(getDy());
        }

        this.setVelocity(newDx, newDy);
    }

    @Override
    public String toString() {
        return super.toString() +
                "diameter=" + diameter +
                '}';
    }
}
