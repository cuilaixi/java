import java.util.Scanner;
public class Main {
	public static void main(String [] args){
		Scanner scanner=new Scanner(System.in);
		int m=scanner.nextInt();
		int n=scanner.nextInt();//这个空格输入正确，回车输入竟然也正确！	
		int a=m,b=n;//这个是赋值，因为不是object，所以不是赋给地址
		int temp;
		while(m%n!=0){
			
			temp=m%n;
			m=n;
			n=temp;
		}
		m=((m%n)==0)?n:m;//已求出最大公约数
		System.out.println(a*b/m);
		
	}
}