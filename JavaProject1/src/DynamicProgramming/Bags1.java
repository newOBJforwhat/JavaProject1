package DynamicProgramming;


/**
 * 0-1背包问题
 * 有n个物品，每个物品的重量w[i],每件物品的价值为c[i]
 * 给定一个背包容量为m
 * 如何能装下最大价值的物品
 * 令f(i,j)为状态函数，i表示放入前i件物品，j表示当前背包容量
 * f(i,j) = max{f(i-1,j),f(i-1,j-w[i]) + c[i]}
 * 当前最优解为放入前i-1件物品和放入当前物品的最大者
 * @author MacBook
 *
 */
public class Bags1 {
	public static void main(String[] args) {
		int[] w = {2,2,6,5,4};
		int[] c = {6,3,5,4,6};
		int contain = 10;
		new Bags1().counting(w, c, w.length, contain);
	}
	public void counting(int[] w,int[] c,int numbers,int contain){
		int[][] state = new int[numbers][contain];
		//初始化第一行s
		for(int j=0;j<contain;j++){
			if(j-w[0]>=0)
				state[0][j] += c[0];
		}
		for(int i=1;i<numbers;i++)
			for(int j=0;j<contain;j++){
	            state[i][j] = state[i - 1][j];  
	            if (j >= w[i])  
	            {  
	                state[i][j] = Math.max(state[i - 1][j],state[i - 1][j - w[i]] + c[i]);  
	            } 
			}
		for(int i=0;i<numbers;i++)
		{
			for(int j=0;j<contain;j++)
				System.out.print(state[i][j]+" ");
			System.out.println();
		}
	}
}
