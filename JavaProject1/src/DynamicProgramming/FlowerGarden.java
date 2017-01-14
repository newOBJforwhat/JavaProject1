package DynamicProgramming;

/**
 * 
 * @author MacBook
 *  Problem Statement
 * 
 *         You are planting a flower garden with bulbs to give you joyous
 *         flowers throughout the year. However, you wish to plant the flowers
 *         such that they do not block other flowers while they are visible.
 * 
 *         You will be given a int[] height, a int[] bloom, and a int[] wilt.
 *         Each type of flower is represented by the element at the same index
 *         of height, bloom, and wilt. height represents how high each type of
 *         flower grows, bloom represents the morning that each type of flower
 *         springs from the ground, and wilt represents the evening that each
 *         type of flower shrivels up and dies. Each element in bloom and wilt
 *         will be a number between 1 and 365 inclusive, and wilt[i] will always
 *         be greater than bloom[i]. You must plant all of the flowers of the
 *         same type in a single row for appearance, and you also want to have
 *         the tallest flowers as far forward as possible. However, if a flower
 *         type is taller than another type, and both types can be out of the
 *         ground at the same time, the shorter flower must be planted in front
 *         of the taller flower to prevent blocking. A flower blooms in the
 *         morning, and wilts in the evening, so even if one flower is blooming
 *         on the same day another flower is wilting, one can block the other.
 * 
 *         You should return a int[] which contains the elements of height in
 *         the order you should plant your flowers to acheive the above goals.
 *         The front of the garden is represented by the first element in your
 *         return value, and is where you view the garden from. The elements of
 *         height will all be unique, so there will always be a well-defined
 *         ordering.
 *         
 *         tips:输入 : 1.开花高度 2.开花开始时间 3.开花结束时间
 *         		规则 : 保证最大可能高度在第一位；如果开花周期交叉，则将高度矮的放在高度高的之前；如果周期不交叉，则序列不变。
 */
public class FlowerGarden {
	public static void main(String[] args) {
		FlowerGarden f = new FlowerGarden();
		//测试用例1
		int[] height1 = {5,4,3,2,1};
		int[] bloom1 = {1,5,10,15,20};
		int[] wilt1 = {5,10,14,20,25};
		f.counting(height1,bloom1,wilt1,height1.length);
		for(int a:height1)
			System.out.print(a+" ");
		System.out.println();
		//测试用例2
		int[] height2 = {5,4,3,2,1};
		int[] bloom2 = {1,5,10,15,20};
		int[] wilt2 = {5,10,15,20,25};
		f.counting(height2,bloom2,wilt2,height2.length);
		for(int a:height1)
			System.out.print(a+" ");
		//测试用例3
		int[] height3 = {5,4,3,2,1};
		int[] bloom3 = {1,5,10,15,20};
		int[] wilt3 = {4,9,14,19,24};
		f.counting(height3,bloom3,wilt3,height3.length);
		for(int a:height1)
			System.out.print(a+" ");
		//测试用例4
		int[] height4 = {1,2,3,4,5,6};
		int[] bloom4 = {1,3,1,3,1,3};
		int[] wilt4 = {2,4,2,4,2,4};
		f.counting(height4,bloom4,wilt4,height4.length);
		for(int a:height1)
			System.out.print(a+" ");
	}
	//不校验输入-->bloom（相同index）要比wilt的小
	public void counting(int[] height,int[] bloom,int[] wilt,int length){
		for(int i=0;i<length;i++){
			for(int j=0;j<i;j++){
				//如果存在交集
				if(bloom[i] <= wilt[j]){
					if(height[j]>height[i]){
						int temp = height[i];
						height[i] = height[j];
						height[j] = temp;
						temp = bloom[i];
						bloom[i] = bloom[j];
						bloom[j] = temp;
						temp = wilt[i];
						wilt[i] = wilt[j];
						wilt[j] = temp;
					}
				}else{
					if(height[j]<height[i]){
						int temp = height[i];
						height[i] = height[j];
						height[j] = temp;
						temp = bloom[i];
						bloom[i] = bloom[j];
						bloom[j] = temp;
						temp = wilt[i];
						wilt[i] = wilt[j];
						wilt[j] = temp;
					}
				}
			}
		}
	}
}
