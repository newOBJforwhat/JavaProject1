package enumLearning;

public enum Screen {
	All(1,"测试一"),
	FRIENDS(2,"测试二"),
	;
	private int code;
	private String name;
	private Screen(int code , String name){
		this.code = code;
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getNameByCode(int code){
		for(Screen sc: Screen.values()){
			if(sc.code == code)
				return sc.name;
		}
		return null;
	}
}
