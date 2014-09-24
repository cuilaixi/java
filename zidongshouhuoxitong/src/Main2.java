import java.util.HashSet;  
import java.util.Scanner;  
import java.util.Stack;  
  
public class Main2{  
    class Goods {  
        public String name;  
        public int price;  
        public int count;  
        public Goods(String name,int price) {  
            this.name = name;  
            this.price = price;  
            count = 0;  
              
        }  
        public String print() {  
            return new String(name + " " + price + " " + count);  
        }  
        public int getNameOrder() {  
            return Integer.parseInt(name.substring(1));  
        }  
    }  
      
    class GoodsAll {  
        public Goods A1 = new Goods("A1",2);  
        public Goods A2 = new Goods("A2",3);  
        public Goods A3 = new Goods("A3",4);  
        public Goods A4 = new Goods("A4",5);  
        public Goods A5 = new Goods("A5",8);  
        public Goods A6 = new Goods("A6",6);  
      
        public Goods getA(int i) {  
            switch(i) {  
            case 1:  
                return A1;  
            case 2:  
                return A2;  
            case 3:  
                return A3;  
            case 4:  
                return A4;  
            case 5:  
                return A5;  
            case 6:  
                return A6;  
            default:  
                return null;  
            }  
        }  
          
        public String print() {  
            Goods[] goods = new Goods[] {A1,A2,A3,A4,A5,A6};  
            Goods tmp = null;  
            int i,j;  
            for (i = 0; i < goods.length - 1; i++) {  //֮������i < goods.length - 1��������i < goods.length����Ϊ����j�Ĵ���
                for (j = i + 1; j < goods.length; j++) {  
                    if (goods[i].count < goods[j].count) {  
                        tmp = goods[i];  
                        goods[i] = goods[j];  
                        goods[j] = tmp;  //����Ϊ�˽������У�
                    } else if (goods[i].count == goods[j].count) {  
                        if (goods[i].getNameOrder() > goods[j].getNameOrder()) {  
                            tmp = goods[i];  //�����1��2��6��˳������
                            goods[i] = goods[j];  
                            goods[j] = tmp;  
                        }  
                    }  
                }  
            }  
            StringBuilder sb = new StringBuilder();  
            for (i = 0; i < goods.length; i++) {  
                sb.append(goods[i].print() + "\r\n"); 
                //���з���\n���ͻس�����\r�����з���������һ�У��س������ǻص�һ�еĿ�ͷ����������ƽʱ��д�ļ��Ļس���Ӧ��ȷ����˵�����س����з�  
            }  
            return sb.toString();  
        }  
          
        public boolean isEmpty() {  
            int sum = 0;  
            for (int i = 1; i <= 6; i++) {  
                sum += getA(i).count;  
            }  
            if (sum == 0) {  //���л��ﶼ��������
                return true;  
            }else {  
                return false;  
            }  
        }  
    }  
      
    class Moneys {  
        //���������δ洢10��5��2��1����Ϣ  
        int[] change = new int[4];  
        //���Ǯ��������Ǯ  
        public String addMoney(int m) {  
            boolean ok = true;  
            StringBuilder sb = new StringBuilder();  
            if (m != 1 && m != 2 && m != 5 && m != 10) {  
                sb.append("E002:Denomination error\r\n");  
                ok = false;  
                return sb.toString();  
            }  
              
            if (m > 2 && m > change[3] + change[2] * 2) { //��������Ǯ1Ԫ(change[3])����2Ԫ���ܶ���˵����Ǯ���� 
                sb.append("E003:Change is not enough, pay fail\r\n");  
                ok = false;  
                return sb.toString();  
            }  
            if (m > 10) {  
                sb.append("E004:Pay the balance is beyond the scope biggest\r\n");  
                ok = false;  
                return sb.toString();  
            }  
            if (goodsAll.isEmpty()) {  
                sb.append("E005:All the goods sold out\r\n");  
                ok = false;  
                return sb.toString();  
            }  
            if(ok) {  //����м�Ǯû���©
                switch(m) {  
	                case 1:  
	                    change[3]++;  
	                    break;  
	                case 2:  
	                    change[2]++;  
	                    break;  
	                case 5:  
	                    change[1]++;  
	                    break;  
	                case 10:  
	                    change[0]++;  
	                    break;  
	                default:  
	                        break;  
                }  
                consumer.balance += m;  
                sb.append("S002:Pay success,balance=" + consumer.balance + "\r\n");  
            }  
            return sb.toString();  
        }  
          
        //��Ǯ  
        public String exchange(int m) {  
            int mtmp = m;  
            //��������Ǯѹջ������С������ջ  
            Stack<Integer> stackChange = new Stack<Integer>();  
            //�½�һ����ջ�����洢������  
            Stack<Integer> stackResult = new Stack<Integer>();  
            int i,j,k;  
            int one, two, five, ten;  
//          for (i = 0; i < change[3]; i++) {  
//              stackChange.push(1);  
//          }  
//          for (i = 0; i < change[2]; i++) {  
//              stackChange.push(2);  
//          }  
//          for (i = 0; i < change[1]; i++) {  
//              stackChange.push(5);  
//          }  
//          for (i = 0; i < change[0]; i++) {  
//              stackChange.push(10);  
//          }  
//            
//          while(!stackChange.isEmpty()) {  
//              int test = stackChange.pop();  
//              if (m >= test) {  
//                  m -= test;  
//                  stackResult.push(test);  
//              }  
//          }  
              
            for (i = 0; i <= 3; i++) {  
                for(j = 3; j >= i; j-- ) {  //j��3��ʼ��Ҳ���Ǵ�change[3]�������һԪǮ��ʼ������ǰ����˵�ġ�����С������ջ ��
                    for (k = 0; k < change[j]; k++) { //�Ҿ��ÿ��Ըĳ�  k = 1; k <= change[j]; �������
                        if (j == 3) {  //change[3]��һԪǮ����
                            stackChange.push(1);  //kȡֵ��0~change[j]��������ÿ��push(1)��һԪǮ����Ǯ����ȥ
                        } else if(j == 2) {  
                            stackChange.push(2);  
                        } else if(j == 1) {  
                            stackChange.push(5);  
                        } else {  
                            stackChange.push(10);  
                        }  
                    }  
                }  
                while(!stackChange.isEmpty()) {  
                    int test = stackChange.pop();  
                    if (m >= test) {  //ֻҪstackChange��Ϊ���һֱ��whileѭ�������m>=test��m��һֱ��������Ǯ����ȥ
                    	//�������������Ϊm�Ѿ�<test�ˣ���stackChange���Ƿ���һֱ��ѭ����
                        m -= test;  
                        stackResult.push(test); //���ᣬ���ܿ�������m�Ѿ�<test������ test = stackChange.pop(); 
                        //��һֱ�ڳ�ջ�ģ�Ҳ����˵������stackChange�������ȫ��pop����
                    }     
                }  
                if (m == 0) {  
                    break;  
                } else {  
                    m = mtmp;  
                    stackChange.clear();  
                    stackResult.clear();  
                }  
            }  
              
            //���������洢�����ĸ�Int�����С�  
            one = two = five = ten = 0;  
            while(!stackResult.isEmpty()) {  
                int result = stackResult.pop();  
                switch(result) {  
                case 1:  
                    one++;  
                    break;  
                case 2:  
                    two++;  
                    break;  
                case 5:  
                    five++;  
                    break;  
                case 10:  
                    ten++;  
                    break;  
                default:  
                }  
            }  
              
            //���´�Ǯ��  
            change[0] -= ten;  
            change[1] -= five;  
            change[2] -= two;  
            change[3] -= one;  
            //�����������  
            consumer.balance = 0;  
            //������Ǯ��Ϣ  
            StringBuilder sb = new StringBuilder();  
            sb.append("1 yuan coin number=" + one + "\r\n");  
            sb.append("2 yuan coin number=" + two + "\r\n");  
            sb.append("5 yuan coin number=" + five + "\r\n");  
            sb.append("10 yuan coin number=" + ten  + "\r\n");  
            return sb.toString();  
        }  
          
        //��ӡǮ����Ϣ  
        String print() {  
            StringBuilder sb = new StringBuilder();  
            sb.append("1 yuan coin number=" + change[3] + "\r\n");  
            sb.append("2 yuan coin number=" + change[2] + "\r\n");  
            sb.append("5 yuan coin number=" + change[1] + "\r\n");  
            sb.append("10 yuan coin number=" + change[0] + "\r\n");  
            return sb.toString();  
        }  
    }  
      
    //��������  
    static class Consumer {  
        int balance = 0;  
        //str is like 'A1' or 'A3'  
        public String buy(String str) {  
            StringBuilder sb = new StringBuilder();  
            boolean ok = true;  
            HashSet<String> names = new HashSet<String>();  //ΪʲôҪ��HashSet
            names.add("A1");  
            names.add("A2");  
            names.add("A3");  
            names.add("A4");  
            names.add("A5");  
            names.add("A6");  
            if (!names.contains(str)) {  
                sb.append("E006:Goods does not exist");  
                ok = false;  
                return sb.toString();  
            }  
            int goodsId = Integer.parseInt(str.substring(1));  //Ϊʲôsubstring(1)����Ϊ�׸��ַ���A
            if (goodsAll.getA(goodsId).count == 0) {  //getA() ->return Ai,ǰ���goodsAll������GoodsAll��һ��ʵ������
                sb.append("E007:The goods sold out\r\n");  
                ok = false;  
                return sb.toString();  
            }  
            if (consumer.balance < goodsAll.getA(goodsId).price) {  
                sb.append("E008:Lack of balance\r\n");  
                ok =false;  
                return sb.toString();  
            }  
            if (ok) {  
                consumer.balance -= goodsAll.getA(goodsId).price;  
                goodsAll.getA(goodsId).count -- ;  
                sb.append("S003:Buy success,balance=" + consumer.balance + "\r\n");  
            }  
            return sb.toString();  
        }  
    }  
      
    //��ʼ��  
    public String reset(String str) {  
        String[] strOne = str.split(" ");  
        String[] strA = strOne[1].split("-");  
        String[] strMoney = strOne[2].split("-");  
        int i;  
        for (i = 0; i < strA.length; i++) {  
            goodsAll.getA(i + 1).count = Integer.parseInt(strA[i]);  
        }  
        for (i = 0; i < strMoney.length; i++) {  
            moneys.change[3 - i] = Integer.parseInt(strMoney[i]);  //��Ϊchange[3]��һԪǮ��change[0]����10ԪǮ
        }  
        return new String("S001:Initialization is successful");  
    }  
      
    public String pay(String str) {  
        String s = str.substring(2);  //Ϊʲôsubstring(2)����Ϊp�Ϳո�?
        return moneys.addMoney(Integer.parseInt(s));  
    }  
      
    public String buy(String str) {  
        return consumer.buy(str.substring(2));  //Ϊʲôsubstring(2)����Ϊb�Ϳո�
    }  
      
    public String change(String str) {  
        if (consumer.balance > 0) {  
            return moneys.exchange(consumer.balance); //��������Ǯ����exchange 
        } else {  
            return new String("E009:Work failure");  
        }  
    }  
      
    public String query(String str) {  
    	//����ֻ�����ֲ�ѯ ��һ�ֲ����qo��һ�ֲ���Ǯ�� q1
        if (!str.equals("q 0") && !str.equals("q 1")) {  
            return new String("E010:Parameter error");  
        } else {  
            int queryId = Integer.parseInt(str.substring(2));  //Ϊʲôsubstring(2)����Ϊq�Ϳո�
            if (queryId == 0) {  
                return goodsAll.print();  
            } else {  
                return moneys.print();  
            }  
        }  
    }  
      
    //////////////////////////////////////////////////////////  
    public GoodsAll getGoodsAll() {  
        return new GoodsAll();  
    }  
    public Moneys getMoneys() {  
        return new Moneys();  
    }  
    public Consumer getConsumer() {  
        return new Consumer();  
    }  
//	r 1-1-1-1-1-1 10-5-2-1;p 1;q 1;     
//    public static Main main = new Main();  //�����ôд��Ȼ�ǿ�Main�ģ�������Main2��
    public static Main2 main = new Main2();  //����д���ǶԵ�
//  public static Main.Consumer consumer = new Consumer();
//	No enclosing instance of type Main is accessible.
//	Must qualify the allocation with an enclosing instance of type Main
//	(e.g. x.new A() where x is an instance of Main).
//	û�пɷ��ʵ��ڲ���Main��ʵ�����������һ�����ʵ��ڲ���Main��ʵ������x.new A()��x������Main��ʵ������
//	enclosing instance�����ڲ���ʵ��
//	�Ҿ������ˣ����Ѿ���newʵ����������࣬Ϊʲô��������--new Consumer()��
//	�ٶȹȸ���һ��������ϡ�ԭ����д���ڲ����Ƕ�̬�ģ�Ҳ���ǿ�ͷ��public class��ͷ������������public static class main��
//	��Java�У����еľ�̬��������ֱ�ӵ��ö�̬������ֻ�н�ĳ���ڲ�������Ϊ��̬�࣬Ȼ����ܹ��ھ�̬���е��ø���ĳ�Ա�������Ա������
//	�����ڲ��������䶯������£���򵥵Ľ���취�ǽ�public class��Ϊpublic static class.
//	���Ǹ� class Consumer Ϊ static class Consumer�Ϳ�����
    public static Main2.Consumer consumer = new Consumer();//main.getConsumer();  
    public static Main2.GoodsAll goodsAll = main.getGoodsAll();  
    public static Main2.Moneys moneys = main.getMoneys();  
    ////////////////////////////////////////////////////////////  
    public static void main(String[] args) {  
//      Main main = new Main();  
//      Main.Consumer consumer = main.getConsumer();  
//      Main.GoodsAll goodsAll = main.getGoodsAll();  
//      Main.Moneys moneys = main.getMoneys();  
          
        Scanner sca = new Scanner(System.in);  
        String order = sca.nextLine();  
        //while(!((order = sca.nextLine()).equals("0"))){  
          
        String[] str = order.split(";");  
        for (String s:str) {  //for(����ѭ������ : ������)
            String title = s.substring(0,1); //��Ϊ���ж���r����p����b����c����q 
            switch(title) {  
            case "r":  
                System.out.println(main.reset(s));  
//                ����reset���s���ݿո�������ֻ����str[1]��str[2]����û��str[0](Ҳ����r)
                //System.out.print(goodsAll.print());  
                 //System.out.print(moneys.print());  
                break;  
            case "p":  
                System.out.print(main.pay(s));  
                break;  
            case "b":  
                System.out.print(main.buy(s));  
                break;  
            case "c":  
                System.out.print(main.change(s));  
                break;  
            case "q":  
                System.out.print(main.query(s));  
                break;  
            default:  
                  
            }  
        }  
         
    }  
}  
