package HibernateRelation;

import java.util.HashSet;
import java.util.Set;

public class User3 {
	private int userid;
	private String name;
	private String password;
	private Set<Address3> address3s=new HashSet<Address3>();
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
	public Set<Address3> getAddress3s() {
		return address3s;
	}
	public void setAddress3s(Set<Address3> address3s) {
		this.address3s = address3s;
	}
	
}
