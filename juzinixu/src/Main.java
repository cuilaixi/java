import java.util.*;
//��������
public class Main {
	public static void main(String[] args) {  

        Scanner scanner=new Scanner(System.in);  
        String input=scanner.nextLine();
        //next()һ��Ҫ��ȡ����Ч�ַ��ſ��Խ������룬��������Ч�ַ�֮ǰ�����Ŀո�tab��Enter���Զ�ȥ��
        //��nextline()����Enter��Ϊ�����ģ����ذ�Enter��ǰ�������ַ����ǿ��Դ��ո��
        /* do{  
            input=scanner.nextLine();  
        }while(input.length()>100); 
        */
        StringBuffer s1=new StringBuffer();
        for(int i=0;i<input.length();i++){
        	s1.append(input.charAt(i));
        }//��input�ַ���ȫ�����뵽StringBuffer s1��
        StringBuffer s2=new StringBuffer();
        StringBuffer buffer=new StringBuffer();
        
        byte symbol;
        char[] chars=new char[s1.length()];
        
        s1.getChars(0, s1.length(), chars, 0);//�������ְ�s1�����ݵ���chars������ǲ��Ƿ����˵㣿
        if(chars[chars.length-1]==' ' || chars[chars.length-1]=='\t')
        	symbol=0;
        else
        	symbol=1;
        
        for(int i=chars.length-1;i>=0;i--){
        	if(chars[i]!=' '&&chars[i]!='\t'){
        		if(symbol==0){
        			symbol=1;
        			buffer.delete(0,buffer.length());
        		}
        		buffer.append(chars[i]);
        	}
        	else if(symbol==1){
        		symbol=0;
        		
        		s2.append(buffer.reverse());
        		s2.append(chars[i]);
        	}
        }  
        if(symbol==1){
        	
        	s2.append(buffer.reverse());
        }
        System.out.println(s2);
    }  

}
