import java.util.Scanner;
public class Main {
	public static void main(String[] args) {  

        String s = "xabb";  

        char c = firstOne(s);  
        System.out.println(c);  
    } 
	public static char firstOne(String s){  
        char result = 0;  
        char temp;  
        int[] num = new int[52];  
        for (int i = 0; i < s.length(); i ++)  //����߼�����ȫ�����ˣ�������е�ȫ����һ�飬������ȥ�ҵ�һ��ֻ����һ�ε�
        {  
            temp = s.charAt(i);  
            if ( temp >= 'a' && temp <= 'z' )  
            {  
                num[temp - 'a']++;  
            }  
            else  if (temp >= 'A' && temp <= 'Z')  
                {  
                    num[temp - 'A' + 26] ++;  
                }  
        }  
        for (int i = 0; i < num.length; i ++)  
        {  
            if (num[i] == 1)  
            {  
                if (i >= 0 && i <=26)  
                {  
                    result = (char)(i + 'a');  
                }else  
                    result = (char)(i - 26 + 'A');  
                break;  
            }  
        }  
        return result;  
    }  
}
