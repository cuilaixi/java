import java.util.Scanner;
public class Main {
	 public static void main(String[] args) {
	        Scanner input=new Scanner(System.in);   
	        String s=input.nextLine();
	        if(s.trim().isEmpty()){
	         System.out.println(0);
	        }else{
	          String ss[]=s.split(" ");//如果最后以空格结尾，那个空格并不会另成一组，也不会加入前面一组，会被忽略  
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
