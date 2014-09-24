import java.util.*;
//字符串反转 。。..华为要求还没这么多
public class Main {
	public static void main(String[] args) {  
        String str = "Iam love china";  
        System.out.println(swapWords(str));  
    }  
	public static String swapWords(String str) {  
        char[] arr = str.toCharArray();  
        swap(arr, 0, arr.length - 1);  
        int begin = 0;  
        for (int i = 1; i < arr.length; i++) {  
            if (arr[i] == ' ') {  
                swap(arr, begin, i - 1);  
                begin = i + 1;  
            }  
        }  
        swap(arr, begin, arr.length - 1);  //这个是为调换后最后一个单词准备的
        return new String(arr);  
    } 
	public static void swap(char[] arr, int begin, int end) {  
        while(begin < end) {  
            char temp = arr[begin];  
            arr[begin] = arr[end];  
            arr[end] = temp;  
            begin++;  
            end--;  
        }  
    } 
}
