import java.util.Scanner;
//�ҳ��ַ����е�һ��ֻ����һ�ε��ַ�
public class Main2 {
	public static void main(String[] args) {  

        String s = "xabb";  
//		Scanner input=new Scanner(System.in);   
//        String s=input.nextLine();
        char c = firstOne(s);  
        System.out.println(c);  
    } 
	public static char firstOne(String str){  
		if (str == null||str.length()<1){  
            return '.';  
        }  
        char[] strArr=str.toCharArray();   
        int[] charArr = new int[256];  //��Ϊ2^8=256���պ������е��ַ���
        for (int i = 0; i < strArr.length; i++) {  
            charArr[strArr[i]]++;  
        }  
        for (int i = 0; i < strArr.length; i++) {  
            if (charArr[strArr[i]] == 1){  //�����˳��ʵ������strArr��˳�������charͳ�������˳�����Խ�����߼�����
                return strArr[i];  
            }
        }  
        return '.';  
    }  
}
