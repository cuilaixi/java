import java.util.*;
public class Main {
	public static void main(String [] args){
		Scanner scanner=new Scanner(System.in);
		float n=scanner.nextFloat();
		int m;
		if(n>=0){//��Ŀ��������ȫ������Ϊ�Ǵ���5��ԭ����С�������ֵ����5���������롣
//			n=(int)(n+0.5);//������������6.0,��Ϊn�Ѿ��������float��
			m=(int)(n+0.5);//���ԭ��Ҳ����Ҫ���ͣ���Ϊ��С������������룬����+0.5
		}else{
			m=(int)(n-0.5);
		}
		System.out.print(m);
	}
}
