package se.ikran.kth.labb3A.Shapes.FillableShapes;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends FillableShape{

    private double width;
    private double height;




    public Rectangle(double x, double y, double width, double height,Color color,boolean filled) {

        super(x, y, color, filled);
        Rectangle rct=new Rectangle();
        this.width = width;
        this.height = height;
        this.isFilled();

        if (rct instanceof FillableShape)
        {
            setFilled(false);
        }


    }
    public Rectangle()
    {
        super();


        // this.height=200;
        // this.width=200;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    @Override
    public void paint(GraphicsContext gc) {
        gc.setStroke(getColor());
        gc.strokeRect(getX(), getY(), width,height);

        if (isFilled())
        {
            gc.setFill(Color.BLACK);
            gc.fillRect(getX(), getY(), width,height);
        }
    }

    public void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY, boxWidth, boxHeight);
        double newDx = this.getDx();
        double newDy = this.getDy();
        if (getX() + this.width < boxX) { // checkar att värdet inte går utanför nedre delen av rektangeln
            newDx = Math.abs(this.getDx());
        } else if (getX() + this.width > boxWidth) {
            newDx = -Math.abs(this.getDx());
        }
        if (getY() + this.height < boxY) { //checkar
            newDy = Math.abs(this.getDy());
        } else if (getY() + this.height > boxHeight) {
            newDy = -Math.abs(getDy());
        }

        this.setVelocity(newDx, newDy);
    }




    @Override
    public String toString() {
        return "Rex" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}