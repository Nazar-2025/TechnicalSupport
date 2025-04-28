import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class {@code TitlesPanel} generates graphical panel.
 * Extends {@link JPanel} and implements {@link ActionListener}.
 *
 *<p>Draws {@code ShapeFactory}.</p>
 *
 * @author Nazar-2025
 *
 * @version 1.0
 */
public class TitlesPanel extends JPanel implements ActionListener {
    /**
    * Indicator for redraw.
    */
   private boolean isDone = true;
   /**
    * Shape angle rotation.
    */
   private int startAngle = 0;
   /**
    * Parameter which depends on shape form.
    */
   private final int shapeForm;
   /**
    * Parameter which depends on shape color.
    */
   private final int shapeColor;

   /**
    * Constructs {@code TitlesPanel} set drawing shape and start animation.
    *
    * @param shapeForm shape type form argument.
    * @param shapeColor shape type color argument.
    */
   //Start shape rotation animation constructor
   public TitlesPanel(int shapeForm, int shapeColor) {
      this.shapeForm = shapeForm;
      this.shapeColor = shapeColor;
      Timer animation = new Timer(50, this);
      animation.setInitialDelay(50);
      animation.start();
   }

   /**
    * Method that start repaint.
    * @param arg0 (not use).
    */
   //Repaint rotation shape
   public void actionPerformed(ActionEvent arg0) {
      if (this.isDone) {
         this.repaint();
      }
   }

   /**
    * Method that draw various shape.
    * @param g UI panel graphic.
    */
   //Drawing various shape method
   private void doDrawing(Graphics g) {
      this.isDone = false;
      Graphics2D g2d = (Graphics2D)g;
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      Dimension size = this.getSize();
      Insets insets = this.getInsets();
      int w = size.width - insets.left - insets.right;
      int h = size.height - insets.top - insets.bottom;
      ShapeFactory shape = new ShapeFactory(shapeForm, shapeColor);
      g2d.setStroke(shape.getStroke());
      g2d.setPaint(shape.getPaint());
      double angle = (this.startAngle++);
      if (this.startAngle > 360) {
         this.startAngle = 0;
      }

      double dr = 90.0D / (w / (ShapeFactory.WIDTH * 1.5D));

      for(int j = ShapeFactory.WIDTH; j < h; j += (int)(ShapeFactory.HEIGHT * 1.5D)) {
         for(int i = ShapeFactory.WIDTH; i < w; i += (int)(ShapeFactory.WIDTH * 1.5D)) {
            angle = angle > 360.0D ? 0.0D : angle + dr;
            AffineTransform transform = new AffineTransform();
            transform.translate(i, j);
            transform.rotate(Math.toRadians(angle));
            g2d.draw(transform.createTransformedShape(shape.getShape()));
         }
      }

      this.isDone = true;
   }

   /**
    * Method that starts drawing.
    * @param g graphic for {@code doDrawing} method.
    */
   //Method that start drawing shape process
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      this.doDrawing(g);
   }
}
