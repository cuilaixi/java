import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
//虽然是数字逆序，但是实现却是用string来实现的
public class Main {
	public static void main(String[] args) throws IOException 

	  {
	    java.util.Calendar calendar=new java.util.GregorianCalendar();
	    System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		Scanner reader = new Scanner(System.in);
	   
	    int a = reader.nextInt();
	   
	    String s = a+" ";//为什么要加空格？为了分隔？其实不是，
	    //因为这是String 类型，必须要给int a再加一个字符方便让int型的a构成string类型
	    
	    StringBuffer buf = new StringBuffer();

	    for(int i=s.length()-1;i>=0;i--)

	    {

	    	buf.append(s.charAt(i));

	    }

	    String out = buf.toString();//这里只是赋值了，还没有输出

	    System.out.printf("%s\n",out);//这才是输出

	    }	 

	}



