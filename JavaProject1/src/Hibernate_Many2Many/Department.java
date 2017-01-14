package Hibernate_Many2Many;

import java.util.Set;
/**
 * 部门类
 * @author MacBook
 *
 */
public class Department {
		private int id;  
	    private String name;  
	    private Set<Employee> emps;//用集合来存储员工
	    public Department(){
	    	
	    }
	    public Department(int id, String name, Set<Employee> emps) {
			super();
			this.id = id;
			this.name = name;
			this.emps = emps;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Set<Employee> getEmps() {
			return emps;
		}
		public void setEmps(Set<Employee> emps) {
			this.emps = emps;
		}
	    
}
