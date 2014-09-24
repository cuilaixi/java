import java.util.Scanner;
//Êý´óÐ´×ÖÄ¸£¿
public class Main {
		public static void main(String[] args){
			Scanner s=new Scanner(System.in);
			String str=s.nextLine();
			calcCapital(str);
					
		}

		public static int calcCapital(String str){
			int n=0;
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(c>='A'&&c<='Z'){
				n++;
			}
		}
			System.out.println(n);
				return n;
		}
	}

