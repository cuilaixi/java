import java.util.Scanner;
public class Main {
	 public static void main(String[] args) {
	        Scanner input=new Scanner(System.in);   
	        String s=input.nextLine();
	        if(s.trim().isEmpty()){
	         System.out.println(0);
	        }else{
	          String ss[]=s.split(" ");//�������Կո��β���Ǹ��ո񲢲������һ�飬Ҳ�������ǰ��һ�飬�ᱻ����  
	             System.out.println(calcCharacter(ss[ss.length-1]));
	        }
	         
	 } 
	 public static int calcCharacter(String str){
		 int n=0;
		 for(int i=0;i<str.length();i++){
				char c=str.charAt(i);
				if((c>='A'&&c<='Z')||(c>'a'&&c<'z')){
					n++;
				}
		}
		return n;
	}
	 
}
