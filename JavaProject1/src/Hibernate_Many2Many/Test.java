package Hibernate_Many2Many;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test {
	public static void main(String args[]){
		TestUtills tu = new TestUtills();
		List<Department> list = tu.selectDept();
		for(Department c : list)
		{
			System.out.println("部门名称："+c.getName());
			Set s = c.getEmps();
			Iterator<Employee> it = s.iterator();
			while(it.hasNext())
				System.out.println(it.next().getName());
				
		}
	}
}
