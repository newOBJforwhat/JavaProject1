package package1;

import javax.swing.JFrame;  
import javax.swing.JPanel;  
import java.awt.Color;  
import java.awt.Graphics;  
 
public class DrawArcs extends JFrame {  
  public DrawArcs() {  
    setTitle("画弧形");  
    getContentPane().add(new ArcsPanel());  
  }  
 
  /** 主方法 */ 
  public static void main(String[] args) {  
    DrawArcs frame = new DrawArcs();  
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    frame.setSize(250, 300);  
    frame.setLocationRelativeTo(null);  
    frame.setVisible(true);
    
    new DD();
  }  
}  
 
// 在面板上画弧形的类  
class ArcsPanel extends JPanel {  
  protected void paintComponent(Graphics g) {  
    super.paintComponent(g);  
    g.setColor(Color.BLUE); //设置弧形的颜色为蓝色  
 
    int i=0;  
    int xCenter = getWidth() / 2;  
    int yCenter = getHeight() / 2;  
    int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);  
 
    int x = xCenter - radius;  
    int y = yCenter - radius;  
 
    //使用while循环画弧形  
    while(i<360){  
        g.fillArc(x, y, 2 * radius, 2 * radius, i, 30);  
        i+=90;  
    }  
  }  
}  

class DD extends JFrame{
 My_Panel jp=new My_Panel();
 DD(){
  Thread t=new Thread(jp);
  t.start();
  add(jp);
  setSize(500,500);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setVisible(true);
 }
}
class My_Panel extends JPanel implements Runnable{
 int x,y,r=100,theta=0;
 public void paint(Graphics g){
  x=(int)(200+r*Math.sin(theta));
  y=(int)(200+r*Math.cos(theta));
  g.drawOval(x, y, 100, 100);
 }
 public void run() {
  while(true){
   try {
    Thread.sleep(200);
    theta++;
    if(theta==360) 
    	theta=0;
    repaint();
   } catch (InterruptedException e) {
    e.printStackTrace();
   }
  }
 }
}
