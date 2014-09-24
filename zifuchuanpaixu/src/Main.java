import java.util.*;
//字符串逆序
public class Main{
	public static void main(String [] args){
		Scanner scanner=new Scanner(System.in);
		String s=scanner.nextLine();
		char c;
		char[] chars=new char[s.length()];     
        s.getChars(0, s.length(), chars, 0);//把字符串导入一个数组里

        for(int i=0;i<chars.length;i++){
        	char temp;
        	int n=1;
			for(int j=0;j<chars.length-1-i;j++){
				while(isChar(chars[j])==false){
					j++;
					if(j>=chars.length-1){
						break;
					}
				}	
				if(j<chars.length-1){
					while(isChar(chars[j+n])==false){
						n++;
						if((j+n)>=(chars.length-i)){
							break;
						}
					}
					if((j+n)<=chars.length-1){
						if(isChar(chars[j])==true&&isChar(chars[j+n])==true){
							if(ignoreCase(chars[j])>ignoreCase(chars[j+n])){
								temp=chars[j];
								chars[j]=chars[j+n];
								chars[j+n]=temp;
							}
						}
					}
				}
				n=1;
			}
        }
		
		for(int i=0;i<chars.length;i++){
			System.out.print(chars[i]);
		}
	}
	
	public static boolean isChar(char c){
		return (c-'a'>=0&&c-'z'<=0)||(c-'A'>=0&&c-'Z'<=0);
	}
	public static int ignoreCase(char c){
		if(c-'a'<0){
			return (c-'A')%26;
		}
		else {
			return (c-'a')%26;
		}
	}
	
}
