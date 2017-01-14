package IoC_AOP;

public class Injection {
	public Person proxy1(String name,String age){
		Chinese c=new Chinese();
		c.setAge(age);
		c.setName(name);
		return c;
	}
	public Person proxy2(String name,String age){
		American p=new American();
		p.setAge(age);
		p.setName(name);
		return p;
	}
}
