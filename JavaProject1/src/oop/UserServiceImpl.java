package oop;

public class UserServiceImpl extends BaseServiceImpl<Object> implements UserService<Object>{

	public UserServiceImpl(){
		System.out.println("扩展类启动");
	}
	@Override
	public void addMethod1() {
		// TODO Auto-generated method stub
		System.out.println("method1");
	}

	@Override
	public void addMethod2() {
		// TODO Auto-generated method stub
		System.out.println("method2");
	}





}
