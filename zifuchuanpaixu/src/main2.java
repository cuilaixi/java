import java.util.Scanner;//用纯 char类 走死路了，决定换数组。
public class main2 {
	public static void main(String [] args){
		Scanner scanner=new Scanner(System.in);
		String s=scanner.nextLine();
		s.toLowerCase();
		StringBuffer b=new StringBuffer();
		b.append(s);
		for(int i=0;i<b.length()-1;i++){
			char temp;
			for(int j=0;j<b.length()-1-i;j++){
				Character b1=new Character(b.charAt(j));
				Character b2=new Character(b.charAt(j+1));
				
				
				if(b.charAt(j)>=65&&b.charAt(j)<=90&&b.charAt(j+1)>=65&&b.charAt(j+1)<=90
						||b.charAt(j)>=97&&b.charAt(j)<=122&&b.charAt(j+1)>=97&&b.charAt(j+1)<=122){
					if(b.charAt(j)>b.charAt(j+1)){
						temp=b.charAt(j);
						b.setCharAt(j,b.charAt(j+1));
						b.setCharAt(j+1,temp);					
					}
				}
			}
		}
		for(int i=0;i<b.length();i++){
			System.out.print(b.charAt(i));
		}
	}
}
