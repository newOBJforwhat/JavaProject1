package oop;


public class SonClassDemo extends SuperClassDemo{
	private String name = "";
    //无法重写私有方法
	//加final的方法无法重写
	public SonClassDemo(){
		name = "ctk";
	}
 	@Override
	public void overwriteMe(){
		System.out.println(name);
	}
 	public static void main(String[] args) {
 		SonClassDemo s = new SonClassDemo();
 		s.overwriteMe();
	}
}
