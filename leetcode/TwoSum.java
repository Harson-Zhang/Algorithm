package leetcode;

public class TwoSum {
//	给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
//	你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
	public static int[] twoSum(int[] nums, int target) {
	      int[] res = new int[2];		//设置用于返回结果的数组，共2个数
	      
	      outterLoop:for(int i=0; i<nums.length; i++){
	    	  for(int j=i+1; j<nums.length; j++){
	    		  if(nums[i] + nums[j] == target){
	    			  res[0] = nums[i];
	    			  res[1] = nums[j];
	    			  break outterLoop;	//跳出二重循环
	    		  }
	    	  }
	      }
	      
	      return res;
	}
	
	
	
	public static void main(String[] args){
		
		int[] nums = {2, 7, 11, 15}; 
		int target = 9;
		for(int ele:twoSum(nums, target))
			System.out.println(ele);
		
	}
	
	
}
