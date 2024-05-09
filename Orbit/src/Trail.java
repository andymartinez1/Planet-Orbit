import java.awt.*;
//import javax.swing.JPanel;

public class Trail {
  private final static int MAX_TRAIL = 30; // number of past location values stored 
  private final static double MAX_TRAIL_DOUBLE = (int) MAX_TRAIL;
  private int planetSize; 
  private int viewSize; 
  private Color color2; 
  private  Point[] queue = new Point[MAX_TRAIL]; 
    
  public Trail ( int size, int vsize, Color c2) {
     planetSize = size; 
     viewSize  = vsize;
     color2 = c2;  
     // fill up trail queue with placeholder data
      for (int i = 0; i<MAX_TRAIL; i++) {
         queue[i] = new Point(i,0);
      }
  }
    
  public void run(int x, int y) {
    // first shift all data down one slot
   for (int i=(MAX_TRAIL-1); i >= 1 ; i--) {  // must be done backwards
     queue[i] = queue[i-1]; 
   }
   // now put current location at top 
   queue[0] = new Point(x,y);
  }
  
  public void paint(Graphics g)  {
    for (int i = 1; i < MAX_TRAIL; i=i+1) {  // increment by 4 or 3 gives sparse trail 
       double tscale = (MAX_TRAIL-i); 
       double prop = (tscale/MAX_TRAIL_DOUBLE)*planetSize;  // this makes trail smaller 
       int ovalSize = (int) prop; 
       if (ovalSize > 2) {
           g.setColor(color2);
           int xtrail = queue[i].x + viewSize/2; 
           int ytrail = queue[i].y + viewSize/2; 
           g.fillOval(xtrail, ytrail, ovalSize, ovalSize); 
       }
    }
  }
}
 