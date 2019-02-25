package leetcode;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int i = 0, j = 0;	//i为慢指针，j为快指针
		
		while (j < nums.length) {
			if(nums[j] != val){
				nums[i] = nums[j];
				i++;	j++;
			}else{
				j++;
			}
		}	//建议自己画图思考
		
		return i;
	}
}
