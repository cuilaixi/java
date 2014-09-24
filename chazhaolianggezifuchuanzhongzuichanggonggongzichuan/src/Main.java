import java.util.Scanner;
//查找两个字符串a,b中的最长公共子串--稍作修改把return i改为target
public class Main {
	public static void main(String[] args) {  
				Scanner sca = new Scanner(System.in);  
		        String[] strArray = new String[2]; 
		        strArray[0]= sca.nextLine();  
		        strArray[1]= sca.nextLine();  
		        System.out.println(getMaxSame(strArray[0], strArray[1]));  
	}  
	public static String getMaxSame(String first0,String second0) {  
        
        String first = first0.toLowerCase();  
        String second = second0.toLowerCase();  
          
        int fLen = first.length();  
        int sLen = second.length();  
        int d = (fLen <= sLen) ? fLen : sLen;  
        String min = null;  
        String max = null;  
        String target = null;  
        if (fLen <= sLen) {  
            min = first;  
            max = second;  
        } else {  
            min = second;  
            max = first;  
        }  
        for (int i = d; i >= 1; i--) {  
            for (int j = 0; j <= min.length() - i; j++) {  
            	//如果要我来写， j <= min.length() - i 这个是最难想的，特别抽象，
            	//我的话就限制min.length,但正确的还有减i  ，
            	//是因为在下面的 substring到j+i,则最大情况j+i=min.length() - i +i<=min.length()?
                target = min.substring(j, j + i);  
                for (int k = 0; k <= max.length() - i; k++) {  
                    if (max.substring(k,k + i).equals(target)) {  
                        return target;  
                    }  
                }  
            }  
        }  
        return null;  
    }
}
