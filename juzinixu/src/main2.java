import java.util.*;
public class main2 {
	public static void main(String[] args) {  

        Scanner scanner=new Scanner(System.in);  
        String input=scanner.nextLine();
    
        //StringBuffer s1=new StringBuffer();
        /*for(int i=0;i<input.length();i++){
        	s1.append(input.charAt(i));
        }*/
        StringBuffer s2=new StringBuffer();
        StringBuffer buffer=new StringBuffer();
        
        byte symbol;
       // char[] chars=new char[s1.length()];
        
        //s1.getChars(0, s1.length(), chars, 0);
        if(input.charAt(input.length()-1)==' ' || input.charAt(input.length()-1)=='\t')
        	symbol=0;//如果最后的值为空格，则 symbol=0
        else
        	symbol=1;//如果最后的值不为空格，则 symbol=1
        
        for(int i=input.length()-1;i>=0;i--){
        	if(input.charAt(i)!=' '&&input.charAt(i)!='\t'){
        		if(symbol==0){
        			symbol=1;///如果最后的值为空格，symbol=0；则改为让程序去执行地39行开始的程序
        			buffer.delete(0,buffer.length());//这样在最后的值本来为空格的情况下就把空格删除了
        		}
        		buffer.append(input.charAt(i));
        	}
        	else if(symbol==1){//如果写else｛｝，那么输入‘i am a ’会返回‘ a am i’，而这样写则不会有空格
        		symbol=0;//即说明如果最后的值不是空格，直接反转就好了。
        		
        		s2.append(buffer.reverse());//这就是StringBuffer比string好的地方，可以直接反转
        		s2.append(input.charAt(i));
        	}
        }  
        if(symbol==1){//如果最后的值不为空格，则 symbol=1
        	//这个是针对27行开始的那个if程序来的（因为它后来改symbol=0为1）
        	s2.append(buffer.reverse());
        }
        System.out.println(s2);
    }  

}
