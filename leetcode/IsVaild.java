package leetcode;
/*
 * 
 	给定一个只包括 '(' ')' '{' '}' '[' ']' 的字符串，判断字符串是否有效。

	有效字符串需满足：

	左括号必须用相同类型的右括号闭合。
	左括号必须以正确的顺序闭合。
	注意空字符串可被认为是有效字符串。
 * 
 */
public class IsVaild {

	public static boolean isValid(String s) {
        int top1 = 0, top2 = 0, top3 = 0;	//定义3个栈
        char[] chars = s.toCharArray();		//转换为字符数组
        
        for(int i = 0; i<chars.length; i++){
        	switch(chars[i]){
        	case '(':
        		top1++;
        		break;
        		
        	case ')':
        		top1--;
        		break;
        		
        	case '{':
        		top2++;
        		break;
        		
        	case '}':
        		top2--;
        		break;	
        		
        	case '[':
        		top3++;
        		break;
        		
        	case ']':
        		top3--;
        		break;
        	}
        	
        	if(top1<0 || top2<0 || top3<0)
        		return false;
        }
        if(top1==0 && top2==0 && top3==0)
        	return true;
        else
        	return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isValid("() {}"));		//T
		System.out.println(isValid("())[]{}(")); 	//F
		System.out.println(isValid("()[}"));		//F
	}

}
