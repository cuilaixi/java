import java.util.Scanner;
public class Main {
	public static void main(String [] args){
		Scanner scanner=new Scanner(System.in);
		int m=scanner.nextInt();
		int n=scanner.nextInt();//����ո�������ȷ���س����뾹ȻҲ��ȷ��	
		int a=m,b=n;//����Ǹ�ֵ����Ϊ����object�����Բ��Ǹ�����ַ
		int temp;
		while(m%n!=0){
			
			temp=m%n;
			m=n;
			n=temp;
		}
		m=((m%n)==0)?n:m;//��������Լ��
		System.out.println(a*b/m);
		
	}
}