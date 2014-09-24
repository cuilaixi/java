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
            for (i = 0; i < goods.length - 1; i++) {  //之所以是i < goods.length - 1，而不是i < goods.length是因为还有j的存在
                for (j = i + 1; j < goods.length; j++) {  
                    if (goods[i].count < goods[j].count) {  
                        tmp = goods[i];  
                        goods[i] = goods[j];  
                        goods[j] = tmp;  //就是为了降序排列？
                    } else if (goods[i].count == goods[j].count) {  
                        if (goods[i].getNameOrder() > goods[j].getNameOrder()) {  
                            tmp = goods[i];  //以序号1，2到6的顺序排列
                            goods[i] = goods[j];  
                            goods[j] = tmp;  
                        }  
                    }  
                }  
            }  
            StringBuilder sb = new StringBuilder();  
            for (i = 0; i < goods.length; i++) {  
                sb.append(goods[i].print() + "\r\n"); 
                //换行符‘\n’和回车符‘\r’换行符就是另起一行，回车符就是回到一行的开头，所以我们平时编写文件的回车符应该确切来说叫做回车换行符  
            }  
            return sb.toString();  
        }  
          
        public boolean isEmpty() {  
            int sum = 0;  
            for (int i = 1; i <= 6; i++) {  
                sum += getA(i).count;  
            }  
            if (sum == 0) {  //所有货物都销售完了
                return true;  
            }else {  
                return false;  
            }  
        }  
    }  
      
    class Moneys {  
        //按次序依次存储10、5、2、1的信息  
        int[] change = new int[4];  
        //向存钱罐中增加钱  
        public String addMoney(int m) {  
            boolean ok = true;  
            StringBuilder sb = new StringBuilder();  
            if (m != 1 && m != 2 && m != 5 && m != 10) {  
                sb.append("E002:Denomination error\r\n");  
                ok = false;  
                return sb.toString();  
            }  
              
            if (m > 2 && m > change[3] + change[2] * 2) { //若大于零钱1元(change[3])，和2元的总额则说明零钱不够 
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
            if(ok) {  //向罐中加钱没有纰漏
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
          
        //找钱  
        public String exchange(int m) {  
            int mtmp = m;  
            //将所有零钱压栈，将最小的先入栈  
            Stack<Integer> stackChange = new Stack<Integer>();  
            //新建一个堆栈用来存储找零结果  
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
                for(j = 3; j >= i; j-- ) {  //j从3开始，也就是从change[3]所代表的一元钱开始。符合前面所说的“将最小的先入栈 ”
                    for (k = 0; k < change[j]; k++) { //我觉得可以改成  k = 1; k <= change[j]; 更好理解
                        if (j == 3) {  //change[3]是一元钱数量
                            stackChange.push(1);  //k取值从0~change[j]的数量，每次push(1)加一元钱到零钱堆里去
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
                    if (m >= test) {  //只要stackChange不为零就一直会while循环，如果m>=test，m会一直把所有零钱都减去
                    	//但是这个不会因为m已经<test了，而stackChange还是非零一直死循环吗？
                        m -= test;  
                        stackResult.push(test); //不会，尽管可能由于m已经<test，但是 test = stackChange.pop(); 
                        //是一直在出栈的，也就是说迟早会把stackChange里的数据全部pop出来
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
              
            //将找零结果存储在这四个Int变量中。  
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
              
            //更新存钱罐  
            change[0] -= ten;  
            change[1] -= five;  
            change[2] -= two;  
            change[3] -= one;  
            //消费余额清零  
            consumer.balance = 0;  
            //生成找钱信息  
            StringBuilder sb = new StringBuilder();  
            sb.append("1 yuan coin number=" + one + "\r\n");  
            sb.append("2 yuan coin number=" + two + "\r\n");  
            sb.append("5 yuan coin number=" + five + "\r\n");  
            sb.append("10 yuan coin number=" + ten  + "\r\n");  
            return sb.toString();  
        }  
          
        //打印钱盒信息  
        String print() {  
            StringBuilder sb = new StringBuilder();  
            sb.append("1 yuan coin number=" + change[3] + "\r\n");  
            sb.append("2 yuan coin number=" + change[2] + "\r\n");  
            sb.append("5 yuan coin number=" + change[1] + "\r\n");  
            sb.append("10 yuan coin number=" + change[0] + "\r\n");  
            return sb.toString();  
        }  
    }  
      
    //消费者类  
    static class Consumer {  
        int balance = 0;  
        //str is like 'A1' or 'A3'  
        public String buy(String str) {  
            StringBuilder sb = new StringBuilder();  
            boolean ok = true;  
            HashSet<String> names = new HashSet<String>();  //为什么要用HashSet
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
            int goodsId = Integer.parseInt(str.substring(1));  //为什么substring(1)？因为首个字符是A
            if (goodsAll.getA(goodsId).count == 0) {  //getA() ->return Ai,前面的goodsAll是类名GoodsAll的一个实例对象
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
      
    //初始化  
    public String reset(String str) {  
        String[] strOne = str.split(" ");  
        String[] strA = strOne[1].split("-");  
        String[] strMoney = strOne[2].split("-");  
        int i;  
        for (i = 0; i < strA.length; i++) {  
            goodsAll.getA(i + 1).count = Integer.parseInt(strA[i]);  
        }  
        for (i = 0; i < strMoney.length; i++) {  
            moneys.change[3 - i] = Integer.parseInt(strMoney[i]);  //因为change[3]是一元钱，change[0]才是10元钱
        }  
        return new String("S001:Initialization is successful");  
    }  
      
    public String pay(String str) {  
        String s = str.substring(2);  //为什么substring(2)？因为p和空格?
        return moneys.addMoney(Integer.parseInt(s));  
    }  
      
    public String buy(String str) {  
        return consumer.buy(str.substring(2));  //为什么substring(2)？因为b和空格
    }  
      
    public String change(String str) {  
        if (consumer.balance > 0) {  
            return moneys.exchange(consumer.balance); //调用找零钱方法exchange 
        } else {  
            return new String("E009:Work failure");  
        }  
    }  
      
    public String query(String str) {  
    	//题意只有两种查询 ，一种查货物qo，一种查零钱罐 q1
        if (!str.equals("q 0") && !str.equals("q 1")) {  
            return new String("E010:Parameter error");  
        } else {  
            int queryId = Integer.parseInt(str.substring(2));  //为什么substring(2)？因为q和空格
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
//    public static Main main = new Main();  //麻痹这么写果然是看Main的，而不是Main2的
    public static Main2 main = new Main2();  //这样写才是对的
//  public static Main.Consumer consumer = new Consumer();
//	No enclosing instance of type Main is accessible.
//	Must qualify the allocation with an enclosing instance of type Main
//	(e.g. x.new A() where x is an instance of Main).
//	没有可访问的内部类Main的实例，必须分配一个合适的内部类Main的实例（如x.new A()，x必须是Main的实例。）
//	enclosing instance译作内部类实例
//	我就纳闷了，我已经用new实例化了这个类，为什么还不行呢--new Consumer()。
//	百度谷歌了一下相关资料。原来我写的内部类是动态的，也就是开头以public class开头。而主程序是public static class main。
//	在Java中，类中的静态方法不能直接调用动态方法。只有将某个内部类修饰为静态类，然后才能够在静态类中调用该类的成员变量与成员方法。
//	所以在不做其他变动的情况下，最简单的解决办法是将public class改为public static class.
//	于是改 class Consumer 为 static class Consumer就可以了
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
        for (String s:str) {  //for(声明循环变量 : 数组名)
            String title = s.substring(0,1); //是为了判断是r还是p还是b还是c还是q 
            switch(title) {  
            case "r":  
                System.out.println(main.reset(s));  
//                比如reset里的s根据空格分组后是只作用str[1]和str[2]，而没有str[0](也就是r)
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
