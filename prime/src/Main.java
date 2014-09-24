import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
public class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		long n = input.nextLong();
		ArrayList List = new ArrayList();
		for(long j=2;j<=n;j++){
			if(isPrime(j)==true){
				List.add(j);
			}
		}
		for(int i=0;i<List.size();i++){
			long j=(long) List.get(i);
			while(isPrime(n)!=true){
				if(n%j!=0){
					break;
				}
				n=n/j;	
				System.out.print(j+" ");
			}
		}
		System.out.print(n+" ");
	}
	public static boolean isPrime(long n){
		long i;
		for(i=2;i<=Math.sqrt(n);i++){
				if((n%i)==0){
					return false;
				}	
		}
			return true;
		}
		
}
