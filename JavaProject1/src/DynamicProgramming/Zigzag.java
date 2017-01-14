package DynamicProgramming;

/**
 *	2003 TCCC Semifinals 3
 * 题目：给定的一个序列，他的增长是按照正负正负交替的，他叫做zigzag序列，
 * 程序实现输入一个序列计算他的最长zigzag序列，包括它的子序列，最后返回最长zigzag序列的长度。 类比：lis
 * 
 * @author MacBook
 * Problem Statement
 *         A sequence of numbers is called a zig-zag sequence if the differences
 *         between successive numbers strictly alternate between positive and
 *         negative. The first difference (if one exists) may be either positive
 *         or negative. A sequence with fewer than two elements is trivially a
 *         zig-zag sequence. For example, 1,7,4,9,2,5 is a zig-zag sequence
 *         because the differences (6,-3,5,-7,3) are alternately positive and
 *         negative. In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag
 *         sequences, the first because its first two differences are positive
 *         and the second because its last difference is zero. Given a sequence
 *         of integers, sequence, return the length of the longest subsequence
 *         of sequence that is a zig-zag sequence. A subsequence is obtained by
 *         deleting some number of elements (possibly zero) from the original
 *         sequence, leaving the remaining elements in their original order.
 */
public class Zigzag {
	public static void main(String args[]){
		Zigzag z = new Zigzag();
		int [] subsequence ={70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32};
		z.counting1(subsequence);
	}
	//欲计算d[i]的值，需要计算d[0]-d[i-1]中最大值（与a[i]组合形成zigzag序列的)+1
	//d(i) = max{d(j)+1},j∈(0,i-1) && 形成zigzag序列
	public void counting1(int[] subsequence) {
		int [] pre = new int[subsequence.length];//记录本元素上一个zigzag序列元素
		int [] liss = new int [subsequence.length];//计算当前元素最长zigzag序列
		boolean [] ispositive = new boolean[subsequence.length];//计算当前元素的下一个增长率
		pre[0] = 0;
		liss[0] = 1;
		//经过测试 --固定起手正负会影响最终结果的正确性，所以初始化的时候需要在i=1时候计算正负
		if(subsequence[1]-subsequence[0] < 0)	
			ispositive[0] = false;
		else if(subsequence[1] > 0)
			ispositive[0] = true;
		for(int i=1;i<subsequence.length;i++){
			for(int j=0;j<i;j++){
				//如果出现zigzag的特征：
				//1.判断当前序列+1是否大于已存序列，大于则存
				//2.将增长特征取反
				//3.前驱标记j存入数组
				if(subsequence[i]-subsequence[j]>0 && ispositive[j] == true){
					if(liss[j]+1>liss[i]){
						liss[i] = liss[j]+1;
						ispositive[i] = false;
						pre[i] = j;
					}
				}else if(subsequence[i]-subsequence[j]<0 && ispositive[j] == false){
					if(liss[i]+1>liss[i]){
						liss[i] = liss[j]+1;
						ispositive[i] = true;
						pre[i] = j;
					}
				}
			}
		}
		for(int a:pre)
			System.out.print(a+" ");
		System.out.println();
		for(int a:liss)
			System.out.print(a+" ");
		System.out.println();
		for(boolean a:ispositive)
			System.out.print(a+" ");
		System.out.println();
	}
}
