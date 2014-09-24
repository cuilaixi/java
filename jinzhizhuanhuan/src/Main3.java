import java.util.Scanner;
//16½øÖÆ×ª»»  
public class Main3 {
	public static void main(String [] args){	
		Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println( Integer.parseInt(s.substring(2), 16));
	}

}


