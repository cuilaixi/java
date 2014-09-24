import java.util.Scanner;
//找出字符串中第一个只出现一次的字符
public class Main2 {
	public static void main(String[] args) {  

        String s = "xabb";  
//		Scanner input=new Scanner(System.in);   
//        String s=input.nextLine();
        char c = firstOne(s);  
        System.out.println(c);  
    } 
	public static char firstOne(String str){  
		if (str == null||str.length()<1){  
            return '.';  
        }  
        char[] strArr=str.toCharArray();   
        int[] charArr = new int[256];  //因为2^8=256，刚好是所有的字符。
        for (int i = 0; i < strArr.length; i++) {  
            charArr[strArr[i]]++;  
        }  
        for (int i = 0; i < strArr.length; i++) {  
            if (charArr[strArr[i]] == 1){  //这里的顺序实际上上strArr的顺序而不是char统计数组的顺序，所以解决了逻辑错误！
                return strArr[i];  
            }
        }  
        return '.';  
    }  
}
