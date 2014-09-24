import java.util.Scanner;
//½øÖÆ×ª»»
public class Main1 {
	public static void main(String [] args){
		Scanner scanner=new Scanner(System.in);
		String all=scanner.nextLine();
		String []s=all.split("," );
		int n=Integer.parseInt(s[0]);
		//byte d=scanner.nextByte();
		int m=Integer.parseInt(s[1]);
		jingzhizhuanhuan(n, m);
		
	}
	
	public static void jingzhizhuanhuan(int n,int m){
		
		if(n<m){
			System.out.print(n);
		}
		if(n>=m){
			jingzhizhuanhuan(n/m,m);
			System.out.print(n%m);
		}	
	}
}

