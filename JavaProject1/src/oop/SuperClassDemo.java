package oop;

public class SuperClassDemo {
	public SuperClassDemo(){
		overwriteMe();
	}
	public void overwriteMe(){
		
	}
	public void pubMethod(){
		System.out.println("公有方法");
	}
	protected final void proMethod(){
		System.out.println("受保护方法");
	}
	private void priMethod(){
		System.out.println("私有方法");
	}
	void defMethod(){
		System.out.println("默认方法");
	}
	
}
