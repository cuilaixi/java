import java.util.Scanner;
public class main3 {
	public static void main(String [] args){
		Scanner scanner=new Scanner(System.in);
		String s=scanner.nextLine();
		//s.toLowerCase();
		char c;
		char[] chars=new char[s.length()];
        
        s.getChars(0, s.length(), chars, 0);
		
        //Arrays.sort(chars);
        for(int i=0;i<chars.length;i++){
        	//忽略大小写用取余来做？
        	char temp;
        	int n=1;
			for(int j=0;j<chars.length-1-i;j++){
				//n=1;这个差点忘了
				//if(isChar(chars[j])==false){ //这个用if只能加一次啊混蛋
				while(isChar(chars[j])==false){
					j++;
				}
				
				//if(isChar(chars[j+n])==false){
				//while(isChar(chars[j+n])==false&&(j+n)<=chars.length){
				while(isChar(chars[j+n])==false&&(j+n)<chars.length-i){	
					n++;
				}
				if(isChar(chars[j])==true&&isChar(chars[j+n])==true){
					if(ignoreCase(chars[j])>ignoreCase(chars[j+n])){
						temp=chars[j];
						chars[j]=chars[j+n];
						chars[j+n]=temp;
					}
				}
				n=1;
			}
        }
		
		for(int i=0;i<chars.length;i++){
			System.out.print(chars[i]);
		}

	}
	
	public static boolean isChar(char c){
		//Character c1=new Character(c);
		
		//return Character.isLetter(c1);
		return (c-'a'>=0&&c-'z'<=0)||(c-'A'>=0&&c-'Z'<=0);
	}
	public static int ignoreCase(char c){
		if(c-'a'<0){
			//return (Integer.parseInt(c+" ")-'A')%26;
			return (c-'A')%26;
		}
		else {
			//return (Integer.parseInt(c+" ")-'a')%26;
			return (c-'a')%26;
		}

	}
	
}//A Famous Saying: Much Ado About Nothing
