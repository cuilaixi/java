import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
//应该是求1-n以内的所有素数
public class prime {
	public static void main(String[] args){
		//定义一个Scanner类，实例名为 input
		Scanner input = new Scanner(System.in);

		System.out.println("请输入 数字n");
		//调用 input的nextInt（）方法来输入n并赋值？
		int n = input.nextInt();
		JFrame frame1=new JFrame();
		frame1.setTitle(" Primes decode");
		frame1.setSize(200,150);
		frame1.setLocation(400, 500);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
		
		
		ArrayList List = new ArrayList();//这是不定长数组
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
		System.out.println(" 下面分解质因子： ");
		for(int i=0;i<List.size();i++){
			int j=(int) List.get(i);//开始我写的 int =List.get(i)始终不对
			while(isPrime(n)!=true){
				if(n%j!=0){//因为j全部是质数，所以用j来整除n
					break;
				}
				n=n/j;	//如果顺利整除，就继续并且输出j
				System.out.print(j+" ");
			}
		}
		System.out.print(n+" ");
	}


	public static boolean isPrime(int n){
		int i;
		for(i=2;i<=Math.sqrt(n);i++){//求从2到n为止这么多数字中有哪些是 质数
				if((n%i)==0){
					return false;
				}	
		}
			return true;
		}
		
}
