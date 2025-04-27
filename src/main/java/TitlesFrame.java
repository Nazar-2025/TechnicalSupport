import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TitlesFrame extends JFrame {
   //Initializes UI constructor
   public TitlesFrame() {
      this.initUI();
   }

   //Create user interface method
   private void initUI() {
      this.setTitle("Криві фігури");
      this.setDefaultCloseOperation(3);
      this.add(new TitlesPanel(37));
      this.setSize(350, 350);
      this.setLocationRelativeTo((Component)null);
   }

   //Start program method
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            TitlesFrame ps = new TitlesFrame();
            ps.setVisible(true);
         }
      });
   }
}