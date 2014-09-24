import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine(); 
        int countNum = 0;//统计数字的个数
        int countChar = 0;//统计英文字母的个数
        int countSpace = 0;//统计空格的个数
        int countOthers = 0;//统计其它字符的个数
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
