import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
//Ӧ������1-n���ڵ���������
public class prime {
	public static void main(String[] args){
		//����һ��Scanner�࣬ʵ����Ϊ input
		Scanner input = new Scanner(System.in);

		System.out.println("������ ����n");
		//���� input��nextInt��������������n����ֵ��
		int n = input.nextInt();
		JFrame frame1=new JFrame();
		frame1.setTitle(" Primes decode");
		frame1.setSize(200,150);
		frame1.setLocation(400, 500);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
		
		
		ArrayList List = new ArrayList();//���ǲ���������
		for(int j=2;j<=n;j++){
			if(isPrime(j)==true){
				//System.out.print(" "+j+" ");
				List.add(j);
			}
		}
		for(int i=0;i<List.size();i++){
			System.out.print(" "+List.get(i)+" ");
			
		}
		System.out.println(" are Primes ");

		//System.out.println("  "+binarySearch(List1,5));
		System.out.println(" ����ֽ������ӣ� ");
		for(int i=0;i<List.size();i++){
			int j=(int) List.get(i);//��ʼ��д�� int =List.get(i)ʼ�ղ���
			while(isPrime(n)!=true){
				if(n%j!=0){//��Ϊjȫ����������������j������n
					break;
				}
				n=n/j;	//���˳���������ͼ����������j
				System.out.print(j+" ");
			}
		}
		System.out.print(n+" ");
	}


	public static boolean isPrime(int n){
		int i;
		for(i=2;i<=Math.sqrt(n);i++){//���2��nΪֹ��ô������������Щ�� ����
				if((n%i)==0){
					return false;
				}	
		}
			return true;
		}
		
}
