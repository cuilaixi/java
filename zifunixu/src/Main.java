import java.util.*;
//字符逆序
public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String temp=Main.reverseString(scanner.nextLine());
		System.out.println(temp);
		
	}
	
	public static String reverseString(String inputString){
	int length=inputString.length();
	if(length>1){
		String endSubstring=inputString.substring(length-1, length);
		String begSubstring=inputString.substring(0, length-1);
		inputString=endSubstring + reverseString(begSubstring);//这里迭代了，begSubstring的长度也作为了参数！
	}
	return inputString;
	}

}
