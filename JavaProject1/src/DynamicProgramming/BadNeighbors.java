package DynamicProgramming;

/**
 * tips：这个题目的大意是输入一个序列，按照跳位的方式求最大加起来的数值（因为邻居捐款之后它的临位不想捐款）
 * 		首位和末尾是邻居
 * @author MacBook 
 * Problem Statement
 * 
 *         The old song declares "Go ahead and hate your neighbor", and the
 *         residents of Onetinville have taken those words to heart. Every
 *         resident hates his next-door neighbors on both sides. Nobody is
 *         willing to live farther away from the town's well than his neighbors,
 *         so the town has been arranged in a big circle around the well.
 *         Unfortunately, the town's well is in disrepair and needs to be
 *         restored. You have been hired to collect donations for the Save Our
 *         Well fund.
 * 
 *         Each of the town's residents is willing to donate a certain amount,
 *         as specified in the int[] donations, which is listed in clockwise
 *         order around the well. However, nobody is willing to contribute to a
 *         fund to which his neighbor has also contributed. Next-door neighbors
 *         are always listed consecutively in donations, except that the first
 *         and last entries in donations are also for next-door neighbors. You
 *         must calculate and return the maximum amount of donations that can be
 *         collected.
 */
public class BadNeighbors {
	public static void main(String args[]){
		BadNeighbors b = new BadNeighbors();
		int [] subsequence1 ={ 10, 3, 2, 5, 7, 8 };
		b.counting1(subsequence1);
		int [] subsequence2 ={11,15};
		b.counting1(subsequence2);
		int []subsequence3 ={ 7, 7, 7, 7, 7, 7, 7 };
		b.counting1(subsequence3);
		int []subsequence4 ={ 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
		b.counting1(subsequence4);
		int []subsequence5 ={ 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
				  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
				  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};
		b.counting1(subsequence5);
	}
	//状态转移方程：d(i) = d(j) + a[i],并且j!=i-1
	public void counting1(int [] subsequence){
		int[] liss = new int[subsequence.length];
		int[] pre = new int[subsequence.length];
		int max = 0;
		pre[0] = 0;
		liss[0] = subsequence[0];
		//长度为2的有点特殊
		if (subsequence.length > 2) {
			for (int i = 1; i < subsequence.length; i++) {
				//不计算邻居捐款
				for (int j = 0; j < i - 1; j++) {
						if (liss[j] + subsequence[i] > liss[i])
						{
							liss[i] = liss[j] + subsequence[i];
							pre[i] = j;
						}
							
				}
				
			}
			// 因为最后一个和第一个是邻居
			max = liss[subsequence.length-2];
		}else if(subsequence.length == 2){
			max = Math.max(subsequence[0], subsequence[1]);
		}
		for(int a:pre)
			System.out.print(a+" ");
		System.out.println();
		System.out.println("max="+max);
	}
}
