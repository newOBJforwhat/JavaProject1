package stateMachine;
/**
 * 规则：升序的小写字母，并且数目一致且字符数目大于3的的连续子串为Beauty String
 * 		比如 abc，aabbcc，abcd等
 * 检查字符串中是否包含有BS
 * @author MacBook
 * 状态机：现态，次态，条件，动作
 * 1.当前字符；2.当前字符的数目；3.前一字符的数目；4.当前字符为第几个字符；
 * 
 * 检查字符串时候会发生：当前字符与上一字符相等、当前字符为上一字符+1、其他；
 * 
 * 当前字符与上一字符相等：1.第一位字符串，则count++;2.第二位字符串，则检查pre_num,若大于地index=1；3.第三位字符，若count不等于pre_num则countinue，等则break并设置result为true；
 * 当前字符为上一字符+1：1.index=1，则直接设置index=2并拷贝1所得信息；2.index=2，则拷贝信息后设置index=3；3.index=3，则检查是否count==pre_num,相等则result=true，否则设置为第index=2，拷贝信息；
 * 
 */
public class BeautyString {
	public static void main(String[] args) {
		new BeautyString().counting("aaab");
	}
	public void counting(String s){
		state Machine = new state();
		boolean result = false;
		Machine.setCurrent(s.charAt(0));
		Machine.setIndex(1);
		Machine.setCount(1);
		for(int i=1;i<s.length();i++){
			//当前字符与上一字符相同的时候
			if(Machine.getCurrent() == s.charAt(i)){
				Machine.setCount(Machine.getCount()+1);
				if(Machine.getIndex() == 1)
					continue;
				else if(Machine.getIndex() == 2){
					if(Machine.getPre_num() < Machine.getCount())
					{
						Machine.setPre_num(0);
						Machine.setIndex(1);
					}
				}else if(Machine.getIndex() == 3){
					if(Machine.getCount() == Machine.getPre_num())
					{
						result = true;
						System.out.println("条件1");
						break;
					}
				}
			//当前字符为上一字符+1的时候
			}else if(Machine.getCurrent() == s.charAt(i) - 1){
				if(Machine.index == 1){
					Machine.setCurrent(s.charAt(i));
					Machine.setPre_num(Machine.getCount());
					Machine.setCount(1);
					Machine.setIndex(2);
				}else if(Machine.index == 2){
					Machine.setCurrent(s.charAt(i));
					Machine.setPre_num(Machine.getCount());
					Machine.setCount(1);
					Machine.setIndex(3);
					if(Machine.getCount() == Machine.getPre_num())
					{
						result = true;
						System.out.println("条件2");
						break;
					}
				}else if(Machine.index == 3){
					if(Machine.getCount() == Machine.getPre_num())
					{
						result = true;
						System.out.println("条件3");
						break;
					}else{
						Machine.setCurrent(s.charAt(i));
						Machine.setPre_num(Machine.getCount());
						Machine.setCount(1);
						Machine.setIndex(2);
					}
				}
			//其他
			}else{
				Machine.setCurrent(s.charAt(i));
				Machine.setIndex(1);
				Machine.setCount(1);
			}
			System.out.println(Machine.getCurrent()+" "+Machine.getCount()+" "+Machine.getPre_num()+" "+Machine.getIndex());
		}
		System.out.println(result);
	}
}
//状态机
class state{
	char current;
	int pre_num;
	int count;
	int index;
	public char getCurrent() {
		return current;
	}
	public void setCurrent(char current) {
		this.current = current;
	}
	public int getPre_num() {
		return pre_num;
	}
	public void setPre_num(int pre_num) {
		this.pre_num = pre_num;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
