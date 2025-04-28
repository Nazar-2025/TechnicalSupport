import java.awt.Component;
import javax.swing.*;

/**
 * Class {@code TitlesFrame} that initialize UI and graphical panel.
 * Extends {@link JFrame}.
 *
 * <p>Displays {@code TitlesPanel} and has clear dimensions.</p>
 *
 * @author Nazar-2025
 *
 * @version 1.0
 */
public class TitlesFrame extends JFrame {
   /**
    * Constructs {@code TitlesFrame} initialize user interface.
    */
   //Initializes UI constructor
   public TitlesFrame() {
      this.initUI();
   }

   /**
    * Method initialize user interface add {@code TitlesPanel},
    * set clear dimensions.
    */
   //Create user interface method
   private void initUI() {
      this.setTitle("Криві фігури");
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      this.add(new TitlesPanel(3, 7));
      this.setSize(350, 350);
      this.setLocationRelativeTo((Component)null);
   }

   /**
    * Method which start all the program.
    *
    * @param args command-line arguments (not used).
    */
   //Start program method
   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         TitlesFrame ps = new TitlesFrame();
         ps.setVisible(true);
      });
   }
}