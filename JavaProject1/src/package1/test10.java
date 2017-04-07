package package1;

import java.lang.reflect.Field;

/**
 * 反射
 * @author ctk
 *
 */
public class test10 {
	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("package1.DemoBean");
			System.out.println(clazz.getSimpleName());
			Field[] fs = clazz.getDeclaredFields();//获取所有字段
			System.out.println(fs[0].getName());
			System.out.println(fs[0].getAnnotation(PrimaryKey.class));
			System.out.println(fs[0].getAnnotation(Column.class).value());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
