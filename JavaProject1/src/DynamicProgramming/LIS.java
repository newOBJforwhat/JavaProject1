package DynamicProgramming;


/**
 * longest increasing subsequence
 * A[1],A[2],...,A[n] 求出最长非降自段和
 * @author MacBook
 *
 */
public class LIS {
	/*
	 * 状态转移方程：d(i) = max{1,d(i-1)+1}，其中,A[i-1]<=A[i]
	 */
	public static void main(String args[]){
		LIS l = new LIS();
		int[] subsequence={5,3,4,8,6,7,2,9,10,21,15};
		System.out.println(l.counting3(subsequence));
		
	}
	//连续非降子序列
	public void counting(int[] subsequence){
		int len = 0;
		int [] state = new int[subsequence.length];//状态集合
		for(int i=0;i<subsequence.length ;i++){
			if(i == 0){
				len++;
				state[i] = len;
			}else{
				if(subsequence[i]>subsequence[i-1])
				{
					len++;
				}else{
					len = 1;
				}
				int statecode = Math.max(state[i-1], len);
				state[i] = statecode;
			}
		}
		for(int a:state){
			System.out.print(a+" ");
		}
		System.out.println();
	}
	//若计算A[j]的最大子序列 则计算A[j-1]所有元素作为最大元素的字段和 加上当前元素并记录--算法复杂度O(n*n)
	public void counting1(int[] subsequence){
		int lenTemp = 1;
		int[] liss = new int[subsequence.length];
		liss[0] = 1;
		for(int i=0;i<subsequence.length;i++){
			for(int j = i;j>=0;j--){
				if(subsequence[j]<subsequence[i])
				{
					if(lenTemp < liss[j]+1)
					{
						lenTemp = liss[j]+1;
					}
				}
			}
			liss[i] = lenTemp;
			lenTemp = 1;
		}
		for(int a:liss)
			System.out.print(a+" ");
		System.out.println();
	}
	
	//改进算法 使用一个栈来维护一个单调序列，读到sub的元素时候：
	//1.如果比栈顶元素大，则放在栈顶；2.如果比栈顶元素小，则二分查找替换单挑序列中比它大的第一个元素
	public int counting3(int[] subsequence){
		int [] array = new int[subsequence.length];
		//初始化栈
		array[0] = subsequence[0];
		int index = 0;
		for(int i=0;i<subsequence.length;i++){
			if(subsequence[i]>array[index]){
				array[++index] = subsequence[i];
			}
			else if(subsequence[i]<array[index]){
				int location = bisection(array,subsequence[i],0,index);
				//如果相应位置的值等于查询值 则替换它下一个元素
				array[location] = subsequence[i];
			}
		}
		return index+1;
	}
	//二分查找查询比元素大的位置
	//寻找比sign大的第一个元素，如果存在与sign相等的元素，再行判定
	public int bisection(int[] array,int sign,int start,int end){
		int mid = 0;
		while(start<end)
		{
			
			mid = (start + end)/2;
			if(sign>array[mid]){
				start = mid;
			}else{
				end = mid;
			}
			if(start+1 == end)
			{
				mid = end;
				break;
			}
		}
		return mid;
		
	}
}
