package Proxy.Cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib代理 要求类不能使final 代理对象继承目标对象
 * 
 * @author ctk
 *
 */
public class Test {
	public static void main(String[] args) {
		UserDao target = new UserDao();
		Enhancer en = new Enhancer();
		//设置代理对象的父类
		en.setSuperclass(target.getClass());
		//设置回调
		en.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				System.out.println("在 代理对象 中拦截到 "+arg1.getName());
				Object obj = arg1.invoke(target, arg2);
				return obj;
			}
		});
		UserDao proxy = (UserDao) en.create();
		proxy.add();
	}
}
