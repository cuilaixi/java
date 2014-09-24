import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
public class ShowBorderLayout extends JFrame{
	public ShowBorderLayout(){
		setLayout(new BorderLayout(5,30));
		
		add(new JButton("East"),BorderLayout.EAST);
		add(new JButton("South"),BorderLayout.SOUTH);
		add(new JButton("West"),BorderLayout.WEST);
	}
	public static void main(String[] args){
		int a[]=new int[8];
//		System.out.print(a[2]);//我二级考试的时候写的输出为空
		ShowBorderLayout frame=new ShowBorderLayout();
		frame.setTitle("ShowBorderLayout");
		frame.setLocationRelativeTo(null);//如果注释掉这行--出现在左上角；如果不注释，则是出现在中央
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setVisible(true);
	}
	
}
