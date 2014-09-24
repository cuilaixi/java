import java.util.*;
public class Main {
	public static void main(String [] args){
		Scanner scanner=new Scanner(System.in);
		float n=scanner.nextFloat();
		int m;
		if(n>=0){//题目看错了完全，我以为是大于5，原来是小数点后数值大于5来四舍五入。
//			n=(int)(n+0.5);//这样最后还是输出6.0,因为n已经定义成了float吧
			m=(int)(n+0.5);//这个原理也不需要解释，因为是小数点后四舍五入，所以+0.5
		}else{
			m=(int)(n-0.5);
		}
		System.out.print(m);
	}
}
