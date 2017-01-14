package DynamicProgramming;
/**
 * 数塔问题
 * 输入一个数塔，找到从根节点逐层找到最大的路径
 * @author MacBook
 *
 */
//i表示行
//j表示列
 
public class NumberTower {
	public static void main(String[] args) {
		int data1[][] ={
				{9,0,0,0,0},
				{12,15,0,0,0},
				{10,6,8,0,0},
				{2,18,9,5,0},
				{19,7,10,4,16}
		};
		int data2[][] ={
				{7,0,0,0,0},
				{3,8,0,0,0},
				{8,1,0,0,0},
				{2,7,4,4,0},
				{4,5,2,6,5}
		};
		new NumberTower().counting(data1, 5);
		new NumberTower().counting(data2, 5);
	}
	//    a[i-1][j]		   -- d(i-1,j)
	//		/	\
	//	a[i][j]  a[i][j+1] -- d(i,j) , d(i,j+1)
	//状态转移方程：d(i-1,j) = max{d(i,j) + a[i-1][j] , d(i,j+1) + a[i-1][j]}
	public void counting(int[][] data,int rank){
		int [][] state = new int[data.length][data[0].length];
		for(int i = 0 ;i<rank;i++){
			state[rank-1][i]+=data[rank-1][i];
		}
		for(int i = rank -2;i>=0;i--){
			for(int j = 0;j<=i;j++){
				System.out.println("d = "+data[i][j]);
				System.out.println(state[i+1][j]+" "+state[i+1][j+1]);
				state[i][j] = Math.max(state[i+1][j] + data[i][j], state[i+1][j+1] + data[i][j]);
				System.out.println("result="+state[i][j]);
			}
		}
		System.out.println(state[0][0]);
	}
}
