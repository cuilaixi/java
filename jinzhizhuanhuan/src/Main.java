import java.util.*;
public class Main {
	public static void main(String [] args){
		Scanner scanner=new Scanner(System.in);
		String all=scanner.nextLine();
		//String []s=all.split("," );
		int n=Integer.parseInt(all);
		//byte d=scanner.nextByte();
		//int m=Integer.parseInt(s[1]);
		jingzhizhuanhuan(n);
		
	}
	
	public static void jingzhizhuanhuan(int n){
		int m=10;
		if(n<m){
			System.out.print(n);
		}
		if(n>=m){
			jingzhizhuanhuan(n/m);
			System.out.print(n%m);
		}
		
		
		
	}
}
