package ThreadLeaning;

public class Demo1 implements Runnable{
	private String name;
	public Demo1(String name){
		this.name = name;
	}
	 public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public void run() {
		forTest ft =new forTest();
		ft.test1(name);
	}
	public static void main(String[] arges){
		Demo1 d1 =new Demo1("tom");
		Demo1 d2 =new Demo1("bob");
		Thread t1 =new Thread(d1);
		Thread t2 =new Thread(d2);
		t1.start();
		t2.start();
	}
}
class forTest{
	public synchronized void test1(String args){
		for(int i=0;i<5;i++)
			System.out.println("I' m "+args);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}