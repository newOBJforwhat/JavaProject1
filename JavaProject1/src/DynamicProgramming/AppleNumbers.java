package DynamicProgramming;

/**
 * 有m*n个格子放置苹果，每次行进只能往右和往下，计算一个能达到的最大的苹果数的路线
 * @author MacBook
 *
 */
public class AppleNumbers {
	public static void main(String[] args) {
		int[][] data = {
				{1,2,3},
				{3,8,6},
				{6,2,3}
		};
		new AppleNumbers().counting(data);
	}
	//状态转移方程:d(i,j) = max{d(i - 1,j) + a[i][j], d(i,j - 1) + a[i][j]}
	public void counting(int[][] data){
		int[][] state = new int[data.length][data[0].length];
		state[0][0] = data[0][0];//初始化
		for(int i=1;i<data[0].length;i++)
			state[0][i] = (data[0][i] + state[0][i-1]);
		for(int i=1;i<data.length;i++)
			state[i][0] = (data[i][0] + state[i-1][0]);
		for(int i=1;i<data.length;i++)
			for(int j=1;j<data[0].length;j++)
			{
				state[i][j] = Math.max(state[i-1][j] + data[i][j], state[i][j-1] + data[i][j]); 
			}
		System.out.println(state[data.length-1][data[0].length-1]);
		}
		
}
