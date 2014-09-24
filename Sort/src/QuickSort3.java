import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort3 {
	public static void main(String [] args) throws IOException{
//	   int a[]={49,38};//���� //��������if�ڵݹ鴦�����ڲ������ˡ�
		int a[]={49,38};
	   quickSort(a,0,a.length-1);  
	   for(int i=0;i<a.length;i++){  
	       System.out.print(a[i]+" ");  
	   }  			
	}
	public static void quickSort(int[] array,int low,int high){
		int l=low;
		int h=high;
		int temp=array[low];	
		if(low<high){
			while(l!=h){
//				while(l<h&&array[h]>temp)//�����ͻ���ѵ�����Ϊ���ڵ�ʱ��hֹͣ--��������a[l]ȥ�ˣ�Ȼ��l
				while(l<h&&array[h]>=temp)
					h--;
					array[l]=array[h];	
				while(l<h&&array[l]<=temp)
					l++;
					array[h]=array[l];
			}//while(l!=h)��
			array[l]=temp;	
			if(l-1>=0){
				quickSort(array,low,l-1);
			}
			if(l+1<=high){
				quickSort(array,l+1,high);		
			}
		}//if(low<high)��
	}//quickSort��
}

