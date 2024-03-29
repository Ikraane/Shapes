package se.ikran.kth.labb3A.Shapes;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape{

    private double x2, y2;


    public Line(double x, double y, double x2, double y2, Color color){
        super(x,y,color);
        this.x2 = x2;
        this.y2 = y2;
    }

    public Line(){
        super();
        this.x2 = 100;
        this.y2 = 100;
    }

    public double getX2(){
        return x2;
    }

    public void setX2(double x2){
        this.x2 = x2;
    }

    public double getY2(){
        return y2;
    }

    public void setY2(double y2){
        this.y2 = y2;
    }





    @Override
    public void move(long elapsedTimeNs){
        super.move(elapsedTimeNs);
        x2 += getDx() * elapsedTimeNs / BILLION;  // Får x-axeln dela sig att röra sig
        y2 += getDy() * elapsedTimeNs / BILLION;   // Får y-axeln dela sig att röra sig
    }
    @Override
    public void constrain(double boxX, double boxY, double boxWidth, double boxHeight){ // Restrict the movement outside the box
        super.constrain(boxX,boxY,boxWidth,boxHeight); // Dynamic binding
        double newDx = getDx(), newDy = getDy();
        if (x2 < boxX) {
            newDx = Math.abs(getDx());
        } else if (x2 > boxWidth) {
            newDx = -Math.abs(getDx());
        }
        if (y2 < boxY) {
            newDy = Math.abs(getDy());
        } else if (y2 > boxHeight) {
            newDy = -Math.abs(getDy());
        }
        setVelocity(newDx,newDy); // hastighet rörelse av nya Dx och dy
    }







    @Override
    public void paint(GraphicsContext gc) {
        gc.setStroke(getColor());
        gc.strokeLine(getX(), getY(), x2, y2);

    }

    @Override
    public String toString() {
        return super.toString() +
                ", x2=" + x2 +
                ", y2=" + y2;
    }
}
