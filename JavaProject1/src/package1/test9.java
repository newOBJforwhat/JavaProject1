package package1;

public class test9 extends test9F{
	public int age = 2;
	public void method(){
		System.out.println("in b class");
	}
	public static void methodStatic(){
		System.out.println("static rewrite");
	}
	public void method1(){
		System.out.println("method 1");
	}
	public static void main(String[] args) {
	}

}
class test9F{
	public int age = 1;
	public test9F(){
		method();
	}
	public void method(){
		System.out.println("in a class");
	}
	public static void methodStatic(){
		System.out.println("static");
	}
}
