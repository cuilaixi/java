import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
//��Ȼ���������򣬵���ʵ��ȴ����string��ʵ�ֵ�
public class Main {
	public static void main(String[] args) throws IOException 

	  {
	    java.util.Calendar calendar=new java.util.GregorianCalendar();
	    System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		Scanner reader = new Scanner(System.in);
	   
	    int a = reader.nextInt();
	   
	    String s = a+" ";//ΪʲôҪ�ӿո�Ϊ�˷ָ�����ʵ���ǣ�
	    //��Ϊ����String ���ͣ�����Ҫ��int a�ټ�һ���ַ�������int�͵�a����string����
	    
	    StringBuffer buf = new StringBuffer();

	    for(int i=s.length()-1;i>=0;i--)

	    {

	    	buf.append(s.charAt(i));

	    }

	    String out = buf.toString();//����ֻ�Ǹ�ֵ�ˣ���û�����

	    System.out.printf("%s\n",out);//��������

	    }	 

	}



