package IoC_AOP;

public class American implements Person{
	private String name;
	private String age;
	public American(){
		
	}
	public American(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("I'm American,my name is "+this.name+" ,my age is "+this.age);
	}
	
}
