import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class QuickSort2 {
	public static void main(String [] args) throws IOException{
		Scanner scanner=new Scanner(System.in);		
		ArrayList<Integer> list=new ArrayList<Integer>();
		while(scanner.hasNextInt()){
			int n=scanner.nextInt();	
			list.add(n);
		}
	   int l=list.size();
	   int a[]=new int[l];
	   for(int i=0;i<list.size();i++){
		   a[i]=(int)list.get(i);
	   }
		quick(a);  
	    for(int i=0;i<a.length;i++){  
	       System.out.print(a[i]+" ");  
	    }  
	}
	
		public static int getMiddle(int[] list, int low, int high) {    
	        int tmp =list[low];    //����ĵ�һ����Ϊ����    
	        while (low < high){    
	            while (low < high&& list[high] >= tmp) {    
	               high--;    
	            }    
	
	            list[low] =list[high];   //������С�ļ�¼�Ƶ��Ͷ�    
	            while (low < high&& list[low] <= tmp) {    
	                low++;    
	            }    
	
	            list[high] =list[low];   //�������ļ�¼�Ƶ��߶�    
	        }    
	       list[low] = tmp;              //�����¼��β    
	        return low;                   //���������λ��    
		}   

		public static void _quickSort(int[] list, int low, int high) {    
			if (low < high){    
	           int middle =getMiddle(list, low, high);  //��list�������һ��Ϊ��    
	           _quickSort(list, low, middle - 1);       //�Ե��ֱ���еݹ�����    
	           _quickSort(list,middle + 1, high);       //�Ը��ֱ���еݹ�����    
        	}    
		}  

		public static void quick(int[] a2) {    
	        if (a2.length > 0) {    //�鿴�����Ƿ�Ϊ��    
	            _quickSort(a2,0, a2.length - 1);    
	        }    
		}  
}
