package package1;

public class DemoBean {
	@PrimaryKey
	@Column("field1")
	private int f1;
	
	private String f2;
	public int getF1() {
		return f1;
	}
	public void setF1(int f1) {
		this.f1 = f1;
	}
	public String getF2() {
		return f2;
	}
	public void setF2(String f2) {
		this.f2 = f2;
	}
}