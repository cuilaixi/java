import java.util.*;      
 public class Main{      
      public static void main(String[] args) {      
         Scanner scan=new Scanner(System.in); 
         int n=scan.nextInt();
         ArrayList<String> strArr=new ArrayList<String>();
         String str;
         String strArray[]=null;
         while(n>=0){  
        	str=scan.nextLine().trim();
        	strArray= String_splitArray(str);
            for(int j=0;j<strArray.length;j++)
            	strArr.add(strArray[j]);
            n--;
         }
         for(String strindex:strArr)
         System.out.println(strindex);    
      }
      
      public static String[] String_splitArray(String s){
    	  int length=s.length();
    	  String result[];
    	  if(length%8!=0)
    	   result=new String[length/8+1];
    	  else result=new String[length/8];
    	  int index=0;
    	  int first=0;
    	  int last=8;
    	  while(length>0){
    		  if(length>8)
    			  {result[index++]=s.substring(first,last);
    			  first=first+8;
    			  last=last+8;
    			  }
    		  else {
    			  result[index]=s.substring(first,s.length());
    			  for(int k=0;k<8-(s.length()-first);k++)
    				  result[index]=result[index]+"0";
    			 
    				}
    		  length=length-8;	  
    	  }  
    	  return result;
      }    
}     
