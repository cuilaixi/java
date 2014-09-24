import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);	
		int inputInt = scanner.nextInt();
		String outputStr = "0";
//		如果返的整数以0开头，去掉0。
//		对于1010：由于在最右边已经出现了0，所以左边的0重复了；又由于返的整数以0开头，去掉0，所以输出1。 
//		如果是101：应该是输出10，但题目没有涉及这一模糊处。
//		但实际上，这个输入101，输出1.所以说还是有问题
		char[] charArr = (inputInt+"").toCharArray();
		for(int i=charArr.length-1;i>-1;i--){	
			if(outputStr.indexOf(charArr[i])>-1){
				//indexOf(ch)返回ch第一次出现的索引值，没出现即-1
				continue;
			}else{
				outputStr += charArr[i];
			}	
		}
		if(outputStr.charAt(0)=='0'&&outputStr.length()>1){
			outputStr = outputStr.substring(1);
		}	
		System.out.println(outputStr);
	}
}
