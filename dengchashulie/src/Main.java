import java.io.*;
import java.util.Scanner;
public class Main {
	public static void main(String [] args){
		Scanner input=new Scanner(System.in);
	    int n=input.nextInt();
	    int d=3;
	    int a1=2;
	    System.out.print(a1*n+n*(n-1)*d/2);
	}
}
