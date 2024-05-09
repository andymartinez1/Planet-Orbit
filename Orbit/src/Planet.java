import java.awt.*;
//import javax.swing.JPanel;

public class Planet  {
  private final int viewSize ;
  private final int planetSize;  
  private final Color color;
    
  // variable to track position of planet 
  private int x;
  private int y; 
  private int angle; 
  private int angleIncrement;
  private double orbit ; 
  private Trail trail; //first change
    
  public Planet (int startAngle, double scale, int inc, int size, int vsize, Color c1) {
     angle = startAngle;
     orbit = scale; 
     color = c1;
     angleIncrement = inc;
     planetSize = size; 
     viewSize  = vsize;
     trail = new Trail(planetSize, viewSize, color); //second change
  }
    
  public void run() {
      angle = ( angle + angleIncrement ) % 360;
      double rads = Math.toRadians(angle);
      double xd = orbit * Math.cos(rads);  
      double yd = orbit * Math.sin(rads);   
      x = (int) xd;
      y = (int) yd;
      trail.run(x, y); //third change
  }
  
  public void paint(Graphics g) {
    g.setColor(color);
    g.fillOval( x+viewSize/2, y+viewSize/2, planetSize, planetSize);
    g.setColor( new Color(30, 120, 30) );
    g.drawLine( viewSize/2, viewSize/2, x+viewSize/2, y+viewSize/2); 
    trail.paint(g); //fourth change
  }
}

