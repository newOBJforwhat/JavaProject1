package HibernateRelation;

public class Address {
	private int addressid;
	private String addressinfo;
	public Address(int addressid,String addressinfo){
		this.addressid=addressid;
		this.addressinfo=addressinfo;
	}
	public Address(){
		
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getAddressinfo() {
		return addressinfo;
	}
	public void setAddressinfo(String addressinfo) {
		this.addressinfo = addressinfo;
	}
	
}
