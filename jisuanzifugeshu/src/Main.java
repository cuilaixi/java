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
			   a= (char) (a + 32);//�����д��ĸ��ת����Сд��ĸ
		   else if(a >= 'a' && a <= 'z')
			   a= a;//�����Сд��ĸ���Ǿ͵���Сд��ĸ����
			   
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