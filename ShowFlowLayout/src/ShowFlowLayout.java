import javax.swing.*;
import java.awt.*;
public class ShowFlowLayout extends JFrame{
	public ShowFlowLayout(){
		//Set FlowLayout,aligned left with horizonal gap 10
		//and vertical gap 20 between components
		setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
		//Add labels and text fields to the frame
		add(new JLabel("First Name"));
		add(new JTextField(8));
		add(new JLabel("MI"));
		add(new JTextField(1));
		add(new JLabel("Last Name"));
		add(new JTextField(8));
	}
	public static void main(String[] args){
		ShowFlowLayout frame=new ShowFlowLayout();
		frame.setTitle("ShowFlowLayout");
//		frame.setLocationRelativeTo(null);//���ע�͵�����--���������Ͻǣ������ע�ͣ����ǳ���������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setVisible(true);
	}	
}
