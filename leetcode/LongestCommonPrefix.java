package leetcode;
//最长相同前缀
/*
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""
 */

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
	        int len = strs.length;
	        int n = 1314;	//n代表最短字母的长度，咱找公共前缀就对比到那儿
	        for(int i = 0; i<len; i++){
	        	if(strs[i].length()<n)
	        		n = strs[i].length();
	        }
	        //找出最短字母的长度n
	        
	        int i = 0;	//正在对比每个字符串的第i个字母
	        point:for(; i<n; i++){
	        	char c = strs[0].charAt(i);
	        	for(int j = 1; j<len; j++){	//正在对比第j个字符串
	        		if(strs[j].charAt(i) != c)
	        			break point;
	        	}
	        }
	        return strs[0].substring(0, i);
	    }
	
	
	
	public static void main(String[] args) {
		String[] str1 = {"flower","flow","flight","fly"};
		String[] str2 = {"love", "like", "lonely"};
		String[] str3 = {"man", "woman"};
		System.out.println(longestCommonPrefix(str1));
		System.out.println(longestCommonPrefix(str2));
		System.out.println(longestCommonPrefix(str3));
		
	}

}
