import java.io.*;
import java.util.*;

public class radixSort2{	  
	public static void main(String [] args) throws IOException{  
		Scanner scanner=new Scanner(System.in);		
		ArrayList<Integer> list=new ArrayList<Integer>();
		while(scanner.hasNextInt()){
			int n=scanner.nextInt();	
			list.add(n);
		}
//	   int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,101,56,17,18,23,34,15,35,25,53,51};
	   int l=list.size();
	   //int a[l]={};//Ȼ��� indexOfException
	   int a[]=new int[l];
	   for(int i=0;i<list.size();i++){
		   a[i]=(int)list.get(i);
	   }
	   sort(a);  
       for(int i=0;i<a.length;i++){  
              System.out.print(a[i]+" ");  
       }  
    }
	
    public  static void sort(int[] array){    
       //����ȷ�����������;    
       int max=array[0];    
       for(int i=1;i<array.length;i++){    
            if(array[i]>max){    
              max=array[i];    
            }    
       }    
       int time=0;    
       //�ж�λ��;    
       while(max>0){    
          max/=10;    
           time++;    
       }    
  
        //����10������;    
       List<ArrayList> queue=new ArrayList<ArrayList>();    
       for(int i=0;i<10;i++){    
              ArrayList<Integer>queue1=new ArrayList<Integer>();  
           queue.add(queue1);    
       }    
  
       //����time�η�����ռ�;    
       for(int i=0;i<time;i++){    
           //��������Ԫ��;    
          for(int j=0;j<array.length;j++){    
               //�õ����ֵĵ�time+1λ��;  
                 int x=array[j]%(int)Math.pow(10,i+1)/(int)Math.pow(10, i);  
                 ArrayList<Integer>queue2=queue.get(x);  
                 queue2.add(array[j]);  
                 queue.set(x, queue2);  
          }   
          int count=0;//Ԫ�ؼ�����;    
          //�ռ�����Ԫ��;    
          for(int k=0;k<10;k++){  
               while(queue.get(k).size()>0){ //�����ĵط��Ҷ�û���ʣ������������ʣ�Ϊʲô��queue.get(k).size(),��queue3.remove(0)��Ҳ�ı��ˣ� 
               //�ַ���һ���������� java�����ö�������������ָ�� �Ǿ仰����������
                //û��,��queue3.remove()������queue.get(k).remove()������������ô���أ����ѵ�����������ָ��ͬһ����ַ����ֻҪһ���ı��ˣ���һ����ֵҲ��ı�
            	//��Ҳ��ΪʲôҪ�½� queue2 �͡�queue3��ԭ�򣬷���ֱ����queue.get()��������ô������һ�������붮�ˡ�   
            	   ArrayList<Integer>queue3=queue.get(k);  
                   array[count]=queue3.get(0);    
                   queue3.remove(0);  
                   count++;  
               }   
          }    
       }               
    }
}
