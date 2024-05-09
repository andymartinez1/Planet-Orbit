import java.awt.*;
import javax.swing.JPanel;

class SolarSystem  extends JPanel implements Runnable {

   private static final int SDIM = 600;  // screen size both x and y
   private static final int SMID = SDIM/2; // mid-screen location 
    private Planet p1 = new Planet (90, 270.0, 1, 20, SDIM, new Color(240,100,60) ); //orange
    private Planet p2 = new Planet (0,  220.0, 3, 18, SDIM, new Color(80,80,255) ); // blue  
    private Planet p3 = new Planet (45, 170.0, 2, 15, SDIM, new Color(240,220,30) ); // yellow  
    private Planet p4 = new Planet (25, 120.0, 1, 22, SDIM, new Color(130,200,30) ); // green  
   
   public SolarSystem() {    
    setBackground(new Color(0,0,0));
    setPreferredSize( new Dimension(SDIM, SDIM) );
    Thread t = new Thread (this);
    t.start ();
   }
  
  public void run() {
    while(true)  {
      p1.run(); 
      p2.run(); 
      p3.run(); 
      p4.run(); 
      repaint();
      try {
         Thread.sleep(8);
      } 
      catch(Exception e)
      {
         e.printStackTrace();
      }
    }
  }
  
  public void paintComponent(Graphics g)  {
    // clear out previous drawings
    g.setColor( new Color(0, 0, 0) ); 
    g.fillRect(0, 0, SDIM, SDIM);
    // paint each planet at new location
    p1.paint(g); 
    p2.paint(g);
    p3.paint(g); 
    p4.paint(g);   
    // repaint x-y axis lines 
    g.setColor( new Color(30, 120, 30) );
    g.drawLine( SMID, 0, SMID, SDIM); 
    g.drawLine( 0, SMID, SDIM, SMID); 
   }
}

