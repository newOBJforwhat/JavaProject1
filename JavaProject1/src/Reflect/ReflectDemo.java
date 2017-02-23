package Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		String className = "Reflect.ReflectService";
		Class<?> ref = Class.forName(className);
		try {
			Method method = ref.getMethod("method2",new Class[]{int.class});
			method.invoke(ref.newInstance(), new Object[]{1});
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
}
