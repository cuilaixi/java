import java.io.*;
import java.util.*;

public class QuickSort {
	public static void main(String [] args) throws IOException{
	   int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,101,56,17,18,23,34,15,35,25,53,51};
	   quickSort(a,0,a.length-1);  
	    for(int i=0;i<a.length;i++){  
	       System.out.print(a[i]+" ");  
	    }  			
	}
	public static void quickSort(int []array,int low,int high){
		int l=low;
		int h=high;//ԭ������Ҫ����������l��h,�Ҹ�����ûд����ɷ���߼���ô�ô���
//		int temp=array[0];//����Ҵ���ش�
		int temp=array[low];	
		if(low<high){//���arrayԪ�ظ�����0��1���򷵻�
			while(l!=h){
				//��������ɨ��
	//			while(array[h]<temp){
	//				array[l]=array[h];
	//				h--;//������ôд�������С��temp���ͽ�������һ���������С�ڣ���ô�Ͳ���ȥ��������ɨ��ȥ�ˡ�������
	//			}
	//			//��������ɨ��
	//			while(array[l]>temp){
	//				array[h]=array[l];
	//				l++;//�������ʱ��ղ�h��--��ʹh=l�ˣ�
	//			}
				while(l<h&&array[h]>temp){
					h--;
				}//������һ��С��temp�������Ԫ��ʱ������whileѭ����hҲͣ������ض���h�ϡ�
		
					array[l]=array[h];
	
				while(l<h&&array[l]<temp){
					l++;
				}
					array[h]=array[l];
	
			}//����while(l<h)ѭ���Ĵ�ʱlow=high���Ѿ�
			array[l]=temp;//�����������˸�ֵ��������ⲻ����
	
	//		quickSort(array,0,l-1);//ǰ�벿�ֵݹ飬�о����񲻶԰��������ǲ���array.length���� 
	//		quickSort(array,low+1,array.length);//��벿�ֵݹ飬�о����񲻶԰��������ǲ���array.length���� 
			quickSort(array,low,l-1);
			quickSort(array,l+1,high);
		}//if(low<high)��
	}//quickSort��
}
