package HibernateRelation;

import java.util.HashSet;
import java.util.Set;
//一个用户对应多个地址
public class User1 {
	private int userid;
	private String name;
	private String password;
	private Set<Address1> addresses=new HashSet<Address1>();
	public User1(){
		
	}
	public User1(int userid,String name,String password){
		this.userid=userid;
		this.name=name;
		this.password=password;	
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
	public Set<Address1> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address1> addresses) {
		this.addresses = addresses;
	}
	
}
