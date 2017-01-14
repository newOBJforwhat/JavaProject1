package DynamicProgramming;
/**
 * 存在1块 3块 5块面值的纸币
 * @author MacBook
 *
 */
public class LessMoney {
	//mix{d(i-1) + 1} i<3
	//min{d(i-3) + 1,d(i-1) +1} 3=<i<5
	//min{d(i-5) + 1,d(i-1) + 1} i>=5
	public int counting(int money){
		int[] state = new int[money+1];
		state[0] = 0;
		for(int i=1 ; i<=money; i++){
			int before = getBeforeState(i);
			int number1 = state[before]+1;
			int number2 = state[i-1]+1;
			int min = Math.min(number1, number2);
			state[i] = min;
		}
		for(int a : state)
			System.out.print(a+" ");
		System.out.println();
		return state[money];
	}
	//计算上态函数 d(i-m)
	public int getBeforeState(int currentState){
		if(currentState < 3 && currentState >0){
			return currentState -1;
		}else if(currentState >= 3 && currentState < 5){
			return currentState -3;
		}else if(currentState >= 5)
			return currentState -5;
		else {
			return -1;
		}
	}
	public static void main(String args[]){
		LessMoney lm = new LessMoney();
		System.out.println(lm.counting(15));
		
	}
}
