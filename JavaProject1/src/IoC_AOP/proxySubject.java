package IoC_AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class proxySubject implements InvocationHandler{

	private Object proxied;
	public proxySubject(Object proxied){
		this.proxied = proxied;
	}
	public void setProxied(Object proxied) {
		this.proxied = proxied;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		//执行方法之前可以做一些操作
		
		//执行目标方法
		method.invoke(proxied, args);
		//之后可以执行一些操作
		return null;
	}
	
}