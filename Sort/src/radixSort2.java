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
	   //int a[l]={};//然后就 indexOfException
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
       //首先确定排序的趟数;    
       int max=array[0];    
       for(int i=1;i<array.length;i++){    
            if(array[i]>max){    
              max=array[i];    
            }    
       }    
       int time=0;    
       //判断位数;    
       while(max>0){    
          max/=10;    
           time++;    
       }    
  
        //建立10个队列;    
       List<ArrayList> queue=new ArrayList<ArrayList>();    
       for(int i=0;i<10;i++){    
              ArrayList<Integer>queue1=new ArrayList<Integer>();  
           queue.add(queue1);    
       }    
  
       //进行time次分配和收集;    
       for(int i=0;i<time;i++){    
           //分配数组元素;    
          for(int j=0;j<array.length;j++){    
               //得到数字的第time+1位数;  
                 int x=array[j]%(int)Math.pow(10,i+1)/(int)Math.pow(10, i);  
                 ArrayList<Integer>queue2=queue.get(x);  
                 queue2.add(array[j]);  
                 queue.set(x, queue2);  
          }   
          int count=0;//元素计数器;    
          //收集队列元素;    
          for(int k=0;k<10;k++){  
               while(queue.get(k).size()>0){ //其他的地方我都没疑问，就这里有疑问，为什么是queue.get(k).size(),当queue3.remove(0)它也改变了？ 
               //又费了一天后终于理解 java里是用对象引用来代替指针 那句话的真正含义
                //没错,是queue3.remove()而不是queue.get(k).remove()，但是这又怎么样呢？你难道忘了他们是指向同一个地址的吗？只要一个改变了，另一个的值也会改变
            	//这也是为什么要新建 queue2 和　queue3的原因，否则直接用queue.get()不就行了么？费了一天终于想懂了。   
            	   ArrayList<Integer>queue3=queue.get(k);  
                   array[count]=queue3.get(0);    
                   queue3.remove(0);  
                   count++;  
               }   
          }    
       }               
    }
}
