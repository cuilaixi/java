import java.io.*;
import java.util.*;

public class radixSort {
	public static void main(String [] args) throws IOException{
		Scanner scanner=new Scanner(System.in);		
//		char a[]=new char[s.length()];
//		s.getChars(0,s.length(),a,0);
//		ArrayList arraylist=new ArrayList();
//		for(int i=0;i<s.length();i++){
//			int arr=Integer.parseInt(s);//parseInt()ֻ��string��������char��������
//			System.out.println(arr);
//			arraylist.add(arr);
//		}
//		System.out.println(arraylist.toArray());
		
		ArrayList<Integer> list=new ArrayList<Integer>();
//		while(true){ 			
//			if(scanner.hasNext()){
//				list.add(scanner.nextInt());
//				System.out.println(list.get(0));//ֻ�ܶ���get(0),�����һ�Ų���
//			}
//			else{
//				break;
//			}
//		}
		while(scanner.hasNextInt()){//������hasNext()����hasNextInt()��enter�˶�û������hasNextInt����int���Խ���
//		String s=scanner.next();
//		int n=Integer.parseInt(s);
		int n=scanner.nextInt();
//		System.out.println(n);
		list.add(n);
//		System.out.println(list.size());

		}
		//��ȷ��һ�����������
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+" ");
		}	
		System.out.println();
		//�����������ʽ��ʼ radixSort--�ҳ��������
		int max=list.get(0);
		for(int i=1;i<list.size();i++){			
			if(max<list.get(i)){
				max=list.get(i);
			}
		}
		//�ж�������ֵ�λ��,Ҳ����ȷ�����������
		int d=1;
		while(max>10){
			max=max/10;
			d++;
		}
//		System.out.print(d);
		int r=10;
		//��ʼ��0~r��r������
		List<ArrayList> queue=new ArrayList<ArrayList>();//�����Ϊ��˵��arrayList����Ҳ��arraylist������object��
//		ArrayList��List�����࣬List��������Ҫ��ʵ���ࣺArrayList �� LinkedList
		for(int i=0;i<r;i++){
			ArrayList<Integer>queue1=new ArrayList<Integer>();//��ΪҪ�����ά���飬�ȹ����q1�����ڷ���ʱ�ڻᱻq2���ǵ�
			queue.add(queue1);
		}
		//����d�η�����ռ�
		for(int i=0;i<d;i++){
			//����ʱ��
			for(int j=0;j<list.size();j++){//�ȴ�0��ʼ�жϣ�β���ǲ���0���ǲ���1���ǲ���2�������ǲ���r���Ѵ��������ÿ���ֱ�Ͷ��queue.get(i)
				int x=list.get(j)%(int)Math.pow(10, j+1)/(int)Math.pow(10,j);
				//Math.pow(x,y)�����������x��y�η�,x,y��ֵ���Ǹ������͵�,���Ա�����ǰ���(int)
//				ArrayList<Integer>queue2=(ArrayList<Integer>)queue.get(x);//cannot convert from Object to ArrayList<Integer>				
				ArrayList<Integer>queue2=queue.get(x);//����List<ArrayList> queue=new ArrayList<ArrayList>();�������Ͳ���Ҫ��(ArrayList<Integer>)
				queue2.add((int)list.get(j));
				queue.set(x,queue2);
			}//������
			//�ռ�ʱ��
			int count=0;//Ԫ�ؼ�����
			for(int k=0;k<r;k++){
				System.out.print(queue.get(k).size()+" ");
				while(queue.get(k).size()>0){
					ArrayList<Integer>queue3=queue.get(k);
//					list.set(k,queue3.get(0));//�����������ˣ�����������k���룬���Ǵ�0˳����룬�ռ�.
					list.set(count,queue3.get(0));
					queue3.remove(0);
					count++;
				};
				
			}//�ռ���
		}//�����ռ���
		//���������
		System.out.println();
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+" ");
		}	
	}
	
	
}
