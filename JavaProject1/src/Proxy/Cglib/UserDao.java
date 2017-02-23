package Proxy.Cglib;

public class UserDao{

	public void add() {
		System.out.println("在目标对象中执行add");
	}

	public void delete() {
		System.out.println("在目标对象中执行delete");
	}

	public void update() {
		System.out.println("在目标对象中执行update");
	}

	public void query() {
		System.out.println("在目标对象中执行query");
	}

}
