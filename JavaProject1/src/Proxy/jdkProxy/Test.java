package Proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		DAOInterface userDao = new UserDao();
		DAOInterface proxy = (DAOInterface) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces()
				, new InvocationHandler() {
					//回调方法 拦截到目标对象的时候执行
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("在 代理对象 中拦截到："+method.getName());
						Object o = method.invoke(userDao, args);//调用拦截到的方法
						return o;
					}
				});
		proxy.add();
	}
}
