import java.util.Scanner;

public class Main {
	  public static void main(String[] args) {
		 int count = 0;
		Scanner in = new Scanner(System.in);
		String readLine  =in.nextLine();
		char desChar =  in.next().charAt(0);
		count= specharCount(readLine ,desChar);
		System.out.println(count);
	  }
  
  
	  public static  int specharCount(String src ,char a){
		  int count = 0;
		   char[] data= src.toCharArray();
		   if(a>='A' && a <='Z')
			   a= (char) (a + 32);//如果大写字母，转换成小写字母
		   else if(a >= 'a' && a <= 'z')
			   a= a;//如果是小写字母，那就等于小写字母本身
			   
		  for(int i = 0 ;i <src.length();i++)
		  {
			  if(data[i] == a || data[i] ==(a-32))
			  { 
				  count ++;
			  }		  
		  }		  
		  return count;		  
	  }
}