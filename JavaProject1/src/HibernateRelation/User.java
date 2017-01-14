package HibernateRelation;
//一个用户只有一个地址
public class User {
	private int userid;
	private String name;
	private String password;
	private Address address;
	public User(){
		
	}
	public User(String name,String password,Address address){
		this.name=name;
		this.password=password;
		this.address=address;
		
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
