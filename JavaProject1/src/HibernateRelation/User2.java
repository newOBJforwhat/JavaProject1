package HibernateRelation;

public class User2 {
	private int userid;
	private String name;
	private String password;
	private Address2 address2;
	
	public Address2 getAddress2() {
		return address2;
	}
	public void setAddress2(Address2 address2) {
		this.address2 = address2;
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
	
}
