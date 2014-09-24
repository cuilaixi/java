import java.io.*;
import java.util.Scanner;
import java.util.Collections;
public class heapSort3 {
	public static void main(String [] args) throws IOException{
		   int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,101,56,17,18,23,34,15,35,25,53,51};
		   HeapSort3(a);  
		   for(int i=0;i<a.length;i++){  
		       System.out.print(a[i]+" ");  
		   }  			
	}
	
	public static void HeapSort3(int [] array){
		//������ʼ��	
		for(int i=(array.length)/2;i>=0;i--){
			sift(array,i,array.length-1);
		}
		//ɸѡ�Ѷ��㲢��������
		for(int i=array.length-1;i>=1;i--){
			exchangeElements(array,0,i);
			sift(array,0,i-1);
		}
	}
	public static void sift(int [] array,int ParentIndex,int lastIndex){
		/*
		 * ����ĳ��Ԫ��Ϊ���Ϊi(Java�����0��ʼ,iΪ0��n-1), �����������������ô��������λ����2i+1��
		 * ���������������������λ����2i+2������и��ڵ㣬���ڵ��λ����(n-1)/2ȡ����
		 */	
		int largest=ParentIndex;
		int left=ParentIndex*2+1;
		int right=ParentIndex*2+2;
		
		if(left<=lastIndex&&array[left]>array[ParentIndex]){
				largest=left;
			}
		if(right<=lastIndex&&array[right]>array[largest]){//���һ���������Ĵ�����array[ParentIndex]			
				largest=right;
			}
		if(ParentIndex!=largest){
			exchangeElements(array,largest,ParentIndex);
			//����ĵݹ��������ˡ�������
			sift(array,largest,lastIndex);//�����ӽڵ���ȥ
		}
	}
	
	public static void exchangeElements(int[] array, int index1, int index2) {  
        int temp = array[index1];  
        array[index1] = array[index2];  
        array[index2] = temp;  
    }  
}
