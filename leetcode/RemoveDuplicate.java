package leetcode;

public class RemoveDuplicate {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        
        for(int i = 0; i<len-1; i++ ){
        	if(nums[i] == nums[i+1]){
        		for(int j = i+1; j<len - 1; j++){
        			nums[j] = nums[j+1];
        		}
    			len--;
    			i--;
        	}
        }
        
        
        return len;
    }
    
    
    public static void main(String[] args){
    	int[] nums = {0, 0, 1,1,1,2,2,3,4,4};
    	int len = removeDuplicates(nums);
    	for (int i = 0; i < len; i++) {
			System.out.println(nums[i]);
		}
    	System.out.println(len);
    }
}

