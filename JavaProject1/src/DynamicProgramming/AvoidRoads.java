package DynamicProgramming;


/**
 * Problem Statement
 * Problem contains images. Plugin users can view them in the
 * applet.
 * 
 * In the city, roads are arranged in a grid pattern. Each point on the grid
 * represents a corner where two blocks meet. The points are connected by line
 * segments which represent the various street blocks. Using the cartesian
 * coordinate system, we can assign a pair of integers to each corner as shown
 * below.
 * 
 * You are standing at the corner with coordinates 0,0. Your destination is at
 * corner width,height. You will return the number of distinct paths that lead
 * to your destination. Each path must use exactly width+height blocks. In
 * addition, the city has declared certain street blocks untraversable. These
 * blocks may not be a part of any path. You will be given a String[] bad
 * describing which blocks are bad. If (quotes for clarity) "a b c d" is an
 * element of bad, it means the block from corner a,b to corner c,d is
 * untraversable. For example, let's say
 * 
 * Tips:
 * 		输入街道的width，height，不可通行坐标data[][] 
 * 		6 
 * 		6 
 * 		{"0 0 0 1",
 * 		"6 6 5 6"}
 * 		Returns: 252 Example from above
 * 		数组表示x1y1 到 x2y2的道路不通；
 * 		从左下角开始，到右上角为止，只能网上或者往右走；
 * 		返回结果是求走法可能种类。
 * 分析：
 * 		考虑一元格子，长度高度均为1的时候，从0，0到0，1不通，则0，0到0，1的路径可能性为1，因为从1，1来算，左边到达的路径为0，下方到达的路径为1
 * 		考虑到二元格子，长度高度为2的时候，依旧，从0，0到0，1不通，到达2，2的路径条数是从左边2，1和从下方1，2的路径条数的和；2，1的可能数为1，而1，2的可能条数为2，则2，2的最终结果为3
 * 		考虑到n*m格子，长度为n，高度为m，则d(n,m) = d(n-1,m) + d(n,m-1),并且在block点置零。
 * 
 */
public class AvoidRoads {
	public static void main(String[] args) {
		int[][] data = {{0,0,1,0},
						{1,2,2,2},
						{1,1,2,1}};
		new AvoidRoads().counting(2, 2, data);
	}
	//初始状态0,0 赋值1
	//当前状态i,j 只能接受上方和左方的和
	//如果向量(i-1,j)<->(i,j) (i,j-1)<->(i,j)不通,则减去该道路上的值
	public long counting(int width,int height,int[][] data){
		long[][] state = new long[height+1][width+1];
		state[0][0] = 1;
		for(int i=0;i<=height;i++)
			for(int j=0;j<=width;j++){
				if(j-1>=0)
				{
					state[i][j] += state[i][j-1];
				}
				if(i-1>=0){
					state[i][j] += state[i-1][j];
				}
				//检查block
				if(data != null)
				for(int k=0;k<data.length;k++){
					//道路方向性
					if((data[k][2] == i && data[k][3] == j
							&& data[k][0] == i && data[k][1] == j-1) || 
							(data[k][2] == i && data[k][3] == j -1
							&& data[k][0] == i && data[k][1] == j))
						state[i][j] -= state[i][j-1];
					if((data[k][2] == i && data[k][3] == j
							&& data[k][0] == i-1 && data[k][1] == j) || (
							data[k][2] == i-1 && data[k][3] == j
							&& data[k][0] == i && data[k][1] == j))
						state[i][j] -= state[i-1][j];
				}
			}

		return state[height][width];
	}
}
