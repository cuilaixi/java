import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class heapSort2 {
	public static void main(String [] args) throws IOException{
		   int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,101,56,17,18,23,34,15,35,25,53,51};
		   heapSort2(a);  
		   for(int i=0;i<a.length;i++){  
		       System.out.print(a[i]+" ");  
		   }  			
	}
	
	public static void heapSort2(int [] array){
		//������ʼ��	

		for(int i=array.length/2;i>=1;i--){//�ѺͶ��������Ǵ�1��ʼ��
			sift(array,i,array.length-1);//������ʼ���ѵ�ʱ�򣬵�Ȼhigh����length.
		}
		//ɸѡ�Ѷ��㲢��������
//		for(int i=array.length;i>=2;i--){//���nӦ����lastindex��������length��
		for(int i=array.length-1;i>=2;i--){
			int temp=array[1];
			array[1]=array[i];
			array[i]=temp;
			sift(array,1,i-1);
		}
	}
	public static void sift(int [] array,int low,int high){//high�����һ���ڵ�lastIndex����siftҪ�����һ�����ĸ���㿪ʼ
		//����Ҫ���� low ��  ��ʼ�������Ǹ�����㡣
		int i=low;
		int j=i*2;//�ⲿ��˵����low��������Ϊ1,
		int tmp=array[i];
		while(j<high){//���j<high�����ܴ���j+1,�����ܴ������ӽ��
			if(j+1<=high&&array[j+1]>array[j]){
				j++;
			}
			if(array[j]<tmp){
				
				array[i]=array[j];
				i=j;
				j=i*2;
				}
			else break;
		}
		array[i]=tmp;//��ɸѡ����ֵ��������λ��
	}
}