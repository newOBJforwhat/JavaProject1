package IoC_AOP;

import java.lang.reflect.Proxy;

public class Main {
	public void IocTest(){
		Injection in = new Injection();
		Person p1 = in.proxy1("zhangsan", "18");
		Person p2 = in.proxy2("tom", "19");
		p1.speak();
		p2.speak();
	}
	public static void main(String args[]){
		subject real = new subject();   
		interface1 proxySubject = (interface1)Proxy.newProxyInstance(interface1.class.getClassLoader(), 
	     new Class[]{interface1.class}, 
	     new proxySubject(real));
		proxySubject.doSomething();
	}
}
