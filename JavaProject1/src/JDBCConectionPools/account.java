package JDBCConectionPools;

public class account {
	private int id;
	private String name;
	private float money;
	public account(){
		
	}
	public account(int id, String name, float money) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
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
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	
}
