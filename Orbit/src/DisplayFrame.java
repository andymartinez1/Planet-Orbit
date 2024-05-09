//import java.awt.*;
import javax.swing.*;

public class DisplayFrame extends JFrame {
  public void Activate ()  {
    setLocation(100,100);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    SolarSystem panel = new SolarSystem(); 
    getContentPane().add(panel);  
    pack();
    setVisible(true);
  }
}
