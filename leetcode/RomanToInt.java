package leetcode;


//事实表明，将string实现转换为char[]会更快！！———— char[] c = s.toCharArray();
public class RomanToInt {

    public static int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i<s.length(); i++){
        	switch(s.charAt(i)){
        	case 'I':	//表示1
        		if(i+1<s.length()){		//表示IV和IX的情况
        			if(s.charAt(i+1) == 'V'){
            			res += 4;
            			i++;
            		}
        			else if(s.charAt(i+1) == 'X'){
            			res +=9;
            			i++;
            		}else{
            			res += 1;
            		}
        		}else{
        			res += 1;
        		}	
        	break;
        		
        	case 'V':	//表示5
        		res += 5;
        	break;
        	
        	case 'X':	//表示10
        		if(i+1<s.length()){		//表示XL和XC的情况
        			if(s.charAt(i+1) == 'L'){
            			res += 40;
            			i++;
            		}else if(s.charAt(i+1) == 'C'){
            			res +=90;
            			i++;
            		}else{
            			res += 10;
            		}
        		}else{
        			res += 10;
        		}
        	break;
        		
        	case 'L':	//表示50
        		res += 50;
        	break;
        		
        	case 'C':	//表示100
        		if(i+1<s.length()){		//表示CD和CM的情况
        			if(s.charAt(i+1) == 'D'){
            			res += 400;
            			i++;
            		}else if(s.charAt(i+1) == 'M'){
            			res += 900;
            			i++;
            		}else{
            			res += 100;
            		}
        		}else{
        			res += 100;
        		}
        	break;
        		
        	case 'D':	//表示500
        		res += 500;
        	break;
        		
        	case 'M':	//表示1000
        		res += 1000;
        	break;	
        	
        	}
        }
        return res;
    }

	
	public static void main(String[] args) {
		System.out.println(romanToInt("LVIII"));	//58
		System.out.println(romanToInt("IX"));		//9
		System.out.println(romanToInt("MCMXCIV"));	//1994
	}

}
