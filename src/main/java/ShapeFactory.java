import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D.Double;

/**
 * The {@code ShapeFactory} class that generate various shapes.
 *
 * @author Nazar-2025
 *
 * @version 1.0
 */
public class ShapeFactory {
   /**
    * Drawing shape.
    */
   private Shape shape;
   /**
    * Shape line thickness.
    */
   private BasicStroke stroke = new BasicStroke(3.0F);
   /**
    * Color shape.
    */
   private Paint paint;
   /**
    * Width of shape.
    */
   public static final int WIDTH = 25;
   /**
    * Height of shape.
    */
   public static final int HEIGHT = 25;

   /**
    * @return shape.
    */
   public Shape getShape(){
      return shape;
   }

   /**
    * @return shape line thickness.
    */
   public BasicStroke getStroke(){
      return stroke;
   }

   /**
    * @return shape color.
    */
   public Paint getPaint(){
      return paint;
   }

   /**
    * Constructs {@code ShapeFactory} create shapes.
    *
    * @param shapeForm generation shapes form type argument.
    * @param shapeColor generation shapes color type argument.
    */
   //Various shapes constructor
   public ShapeFactory(int shapeForm, int shapeColor) {
      setFigureForm(shapeForm);
      setFigureColor(shapeColor);
   }

   /**
    * Method that generate figure form.
    *
    * @param shapeType shapes form type argument.
    */
   //Generates figure form
   private void setFigureForm(int shapeType){
      switch(shapeType){
         case 1:
            this.shape = createStar(3, new Point(0, 0), WIDTH / 2.0D, WIDTH / 2.0D);
            break;
         case 3:
            this.shape = createStar(5, new Point(0, 0), WIDTH / 2.0D, WIDTH / 4.0D);
            break;
         case 5:
            this.shape = new Double((-WIDTH) / 2.0D, (-HEIGHT) / 2.0D, WIDTH, HEIGHT);
            break;
         case 7:
            GeneralPath path = new GeneralPath();
            double tmpHeight = Math.sqrt(2.0D) / 2.0D * HEIGHT;
            path.moveTo((-WIDTH / 2D), -tmpHeight);
            path.lineTo(0.0D, -tmpHeight);
            path.lineTo((WIDTH / 2D), tmpHeight);
            path.closePath();
            this.shape = path;
            break;
         case 9:
            this.shape = new java.awt.geom.Arc2D.Double((-WIDTH) / 2.0D, (-HEIGHT) / 2.0D, WIDTH, HEIGHT, 30.0D, 300.0D, Arc2D.PIE);
            break;
         default:
            throw new IllegalArgumentException("Type is unsupported");
      }
   }

   /**
    * Method that generate figure color.
    *
    * @param shapeColor shapes color type argument.
    */
   //Generates figure color
   private void setFigureColor(int shapeColor){
      switch(shapeColor) {
         case 1:
            this.stroke = new BasicStroke(3.0F);
            break;
         case 3:
            break;
         case 4:
            this.stroke = new BasicStroke(7.0F);
            break;
         case 7:
            this.paint = new GradientPaint(-WIDTH, -HEIGHT, Color.white, WIDTH, HEIGHT, Color.gray, true);
            break;
         case 8:
            this.paint = Color.red;
            break;
         default:
            throw new IllegalArgumentException("Type is unsupported");
      }
   }

   /**
    * Return different shape depending on angles count.
    *
    * @param arms angles count argument.
    * @param center shape center argument.
    * @param rOuter outer`s angles argument.
    * @param rInner inner`s angles argument.
    */
   //Method that generates five-pointed star
   private static Shape createStar(int arms, Point center, double rOuter, double rInner) {
      double angle = 3.141592653589793D / arms;
      GeneralPath path = new GeneralPath();

      for(int i = 0; i < 2 * arms; ++i) {
         double r = (i & 1) == 0 ? rOuter : rInner;
         java.awt.geom.Point2D.Double p = new java.awt.geom.Point2D.Double(center.x + Math.cos(i * angle) * r, center.y + Math.sin(i * angle) * r);
         if (i == 0) {
            path.moveTo(p.getX(), p.getY());
         } else {
            path.lineTo(p.getX(), p.getY());
         }
      }

      path.closePath();
      return path;
   }
}
