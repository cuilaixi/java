import java.util.*;
//句子逆序
public class Main {
	public static void main(String[] args) {  

        Scanner scanner=new Scanner(System.in);  
        String input=scanner.nextLine();
        //next()一定要读取到有效字符才可以结束输入，对输入有效字符之前遇到的空格，tab或Enter都自动去掉
        //而nextline()是以Enter键为结束的，返回按Enter键前的所有字符，是可以带空格的
        /* do{  
            input=scanner.nextLine();  
        }while(input.length()>100); 
        */
        StringBuffer s1=new StringBuffer();
        for(int i=0;i<input.length();i++){
        	s1.append(input.charAt(i));
        }//把input字符串全部导入到StringBuffer s1里
        StringBuffer s2=new StringBuffer();
        StringBuffer buffer=new StringBuffer();
        
        byte symbol;
        char[] chars=new char[s1.length()];
        
        s1.getChars(0, s1.length(), chars, 0);//接下来又把s1里数据导入chars数组里，是不是繁琐了点？
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
