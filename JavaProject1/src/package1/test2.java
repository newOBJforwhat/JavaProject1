package package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;

public class test2 extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 85441201828193036L;
	Graphics2D grph;
	//柱子中心横坐标
	final int x1_mind=145;
	final int x2_mind=355;
	final int x3_mind=565;
	//栈元素
	Dish dish1;
	Dish dish2;
	Dish dish3;
	Dish dish4;
	//栈指针
	int Acount=4;
	int Bcount=0;
	int Ccount=0;
	ArrayList<Dish> Al_A;
	ArrayList<Dish> Al_B;
	ArrayList<Dish> Al_C;
	int point[]={350,280,210,140};
	public test2(){
		this.setTitle("汉诺塔");
		this.setLocation(200, 150);
		this.setSize(700, 500);
		this.setDefaultCloseOperation(3);
		
		this.setVisible(true);
		
		grph=(Graphics2D) this.getGraphics();
		
		//初始化栈
		Al_A=new ArrayList<Dish>();
		Al_B=new ArrayList<Dish>();
		Al_C=new ArrayList<Dish>();
		dish1=new Dish(x1_mind,350,100,30,Color.orange);
		dish2=new Dish(x1_mind,280,90,30,Color.orange);
		dish3=new Dish(x1_mind,210,80,30,Color.orange);
		dish4=new Dish(x1_mind,140,70,30,Color.orange);
		Al_A.add(dish1);
		Al_A.add(dish2);
		Al_A.add(dish3);
		Al_A.add(dish4);
		

	}
	public void HanioTower(int n ,char A,char B,char C)
	{
	
		if(n==1)
			MoveTo(A,C);
		else{
			HanioTower(n-1,A,C,B);
			MoveTo(A,C);
			HanioTower(n-1,B,A,C);
		}
		
	}
	public void MoveTo(char A,char C){
		System.out.println(A+"->"+C);
		if(A=='A' && C=='C')
		{
			Dish d_temp=Al_A.get(Acount-1);
			d_temp.setCenterX(x3_mind);
			Al_A.remove(Acount-1);
			Acount--;
			Al_C.add(d_temp);
			Ccount++;
		}else if(A=='A' && C=='B'){
			Dish d_temp=Al_A.get(Acount-1);
			d_temp.setCenterX(x2_mind);
			Al_A.remove(Acount-1);
			Acount--;
			Al_B.add(d_temp);
			Bcount++;
		}else if(A=='B' && C=='C'){
			Dish d_temp=Al_B.get(Bcount-1);
			d_temp.setCenterX(x3_mind);
			Al_B.remove(Bcount-1);
			Bcount--;
			Al_C.add(d_temp);
			Ccount++;
		}else if(A=='B' && C=='A'){
			Dish d_temp=Al_B.get(Bcount-1);
			d_temp.setCenterX(x1_mind);
			Al_B.remove(Bcount-1);
			Bcount--;
			Al_A.add(d_temp);
			Acount++;
		}else if(A=='C' && C=='A')
		{
			Dish d_temp=Al_C.get(Ccount-1);
			d_temp.setCenterX(x1_mind);
			Al_C.remove(Ccount-1);
			Ccount--;
			Al_A.add(d_temp);
			Acount++;
		}else if(A=='C' && C=='B')
		{
			Dish d_temp=Al_C.get(Ccount-1);
			d_temp.setCenterX(x2_mind);
			Al_C.remove(Ccount-1);
			Ccount--;
			Al_B.add(d_temp);
			Bcount++;
		}
		System.out.println("Acount="+Acount+" Bcount="+Bcount+" Ccount="+Ccount);
		update(grph);

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//画图方法
	public void paint(Graphics g){
			super.paint(g);	
			g.setColor(Color.BLACK);
			//中心x=145，355，565 y∈[80,400]
			g.fillRect(140, 80, 10, 320);
			g.fillRect(350, 80, 10, 320);
			g.fillRect(560, 80, 10, 320);
			
			grph.setColor(dish1.getRectColor());
			for(int i=0;i<Al_A.size();i++){
				grph.fillRect(Al_A.get(i).getCenterX()-Al_A.get(i).getHalf_len(), point[i]-Al_A.get(i).getHalf_wide(), 
						2*Al_A.get(i).getHalf_len(), 2*Al_A.get(i).getHalf_wide());
//				System.out.println((Al_A.get(i).getCenterX()-Al_A.get(i).getHalf_len())+"    "+(point[i]-Al_A.get(i).getHalf_wide()));
//				System.out.println((2*Al_A.get(i).getHalf_len())+"    "+(2*Al_A.get(i).getHalf_wide()));
			}
			for(int i=0;i<Al_B.size();i++){
				grph.fillRect(Al_B.get(i).getCenterX()-Al_B.get(i).getHalf_len(), point[i]-Al_B.get(i).getHalf_wide(), 
						2*Al_B.get(i).getHalf_len(), 2*Al_B.get(i).getHalf_wide());
			}
			for(int i=0;i<Al_C.size();i++){
				grph.fillRect(Al_C.get(i).getCenterX()-Al_C.get(i).getHalf_len(), point[i]-Al_C.get(i).getHalf_wide(), 
						2*Al_C.get(i).getHalf_len(), 2*Al_C.get(i).getHalf_wide());
			}
	}

	public static void main(String[] args) {
		test2 t=new test2();
		Thread t1=new Thread(t);
		t1.start();
	
	}
	//线程方法
	@Override
	public void run() {


		//不知道是不是画图线程和申请内存线程不大一样
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		//初始化塔
		grph.setColor(dish1.getRectColor());
		for(int i=0;i<4;i++)
			grph.fillRect(Al_A.get(i).getCenterX()-Al_A.get(i).getHalf_len(), Al_A.get(i).getCenterY()-Al_A.get(i).getHalf_wide(), 
					2*Al_A.get(i).getHalf_len(), 2*Al_A.get(i).getHalf_wide());

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		HanioTower(4, 'A', 'B', 'C');
		
	}

}
class Dish{
	int centerX;
	int centerY;
	int half_len;
	int half_wide;
	Color rectColor;
	public Color getRectColor() {
		return rectColor;
	}
	public void setRectColor(Color rectColor) {
		this.rectColor = rectColor;
	}
	public int getCenterX() {
		return centerX;
	}
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}
	public int getCenterY() {
		return centerY;
	}
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
	public int getHalf_len() {
		return half_len;
	}
	public void setHalf_len(int half_len) {
		this.half_len = half_len;
	}
	public int getHalf_wide() {
		return half_wide;
	}
	public void setHalf_wide(int half_wide) {
		this.half_wide = half_wide;
	}

	public Dish(int x,int y,int len,int wide,Color c)
	{
		centerX=x;
		centerY=y;
		half_len=len;
		half_wide=wide;
		rectColor=c;
	}
	
}
