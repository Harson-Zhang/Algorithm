package leetcode;
/*
 * find the longest common prefix string amongst an array of strings.
 * 在strs数组中寻找每个String的最长公共前缀
 */

public class T14_LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];	//前缀初始值为第1个字符
		
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) { //indexOf()返回第一次出现prefix串的数组下标
				prefix = prefix.substring(0, prefix.length() - 1); //
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}

	public static void main(String[] args) {

	}

}
