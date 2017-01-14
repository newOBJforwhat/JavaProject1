package Hibernate_Many2Many;
/**
 * 雇员类
 */
public class Employee {
	private int id;  
    private String name;  
    private Department depart;
    public Employee(){
    	
    }
	public Employee(int id, String name, Department depart) {
		super();
		this.id = id;
		this.name = name;
		this.depart = depart;
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
	public Department getDepart() {
		return depart;
	}
	public void setDepart(Department depart) {
		this.depart = depart;
	}
    
}
