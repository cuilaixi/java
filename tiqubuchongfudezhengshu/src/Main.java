import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);	
		int inputInt = scanner.nextInt();
		String outputStr = "0";
//		�������������0��ͷ��ȥ��0��
//		����1010�����������ұ��Ѿ�������0��������ߵ�0�ظ��ˣ������ڷ���������0��ͷ��ȥ��0���������1�� 
//		�����101��Ӧ�������10������Ŀû���漰��һģ������
//		��ʵ���ϣ��������101�����1.����˵����������
		char[] charArr = (inputInt+"").toCharArray();
		for(int i=charArr.length-1;i>-1;i--){	
			if(outputStr.indexOf(charArr[i])>-1){
				//indexOf(ch)����ch��һ�γ��ֵ�����ֵ��û���ּ�-1
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
