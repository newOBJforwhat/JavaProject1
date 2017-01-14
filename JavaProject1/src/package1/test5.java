package package1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author MacBook
 *
 */
public class test5 {
	private static final int Integer = 0;

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> result = (new test5().divide(nums));
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++)
				System.out.print(result.get(i).get(j) + " ");
			System.out.println();
		}
	}

	// 分解集合为三元素的子集
	public List<List<Integer>> divide(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Arrays.sort(nums);
		for (int k = 0; k < nums.length; ++k) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int target = 0 - nums[k];
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                	List<Integer> resultset = new ArrayList<Integer>();
                	resultset.add(nums[k]);
                	resultset.add(nums[i]);
                	resultset.add(nums[j]);
                	result.add(resultset);
                    while (i < j && nums[i] == nums[i + 1]) ++i;
                    while (i < j && nums[j] == nums[j - 1]) --j;
                    ++i; --j;
                } else if (nums[i] + nums[j] < target) ++i;
                else --j;
            }
        }

		return result;
	}

}
