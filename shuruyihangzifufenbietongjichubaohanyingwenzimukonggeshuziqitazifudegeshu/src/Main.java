import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine(); 
        int countNum = 0;//ͳ�����ֵĸ���
        int countChar = 0;//ͳ��Ӣ����ĸ�ĸ���
        int countSpace = 0;//ͳ�ƿո�ĸ���
        int countOthers = 0;//ͳ�������ַ��ĸ���
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && (int) c <= '9') {
                countNum++;
            } else if ((c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z')) {
                countChar++;
            } else if (c == ' ') {
                countSpace++;
            } else{
                countOthers++;
            }
        }       
        System.out.println(countChar);
        System.out.println(countSpace);
        System.out.println(countNum);
        System.out.println(countOthers);
    }
}
