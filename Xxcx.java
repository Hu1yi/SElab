package csc_db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import csc_db.Operate_MyDB;
import java.util.*;
public class Xxcx extends JFrame implements ActionListener {//信息查询

	private JButton bt1,bt2;
	private Operate_MyDB op;
	JLabel title;
	public Xxcx(){
		super("信息查询");
		init();
	}
	public void init(){                         //实现界面的内容
		this.setLayout(new FlowLayout());
    	this.setBounds(200,200,360, 250);
    	this.setVisible(true);
    	title=new JLabel("欢迎使用本系统！");
    	title.setBounds(0, 0, 360,300);
    	this.add(title);
    	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	bt1=new JButton("打印");
    	bt2=new JButton("退出");
    	bt1.setBounds(100, 220, 60,25);
    	bt2.setBounds(180,220, 60,25);
    	this.add(bt1);
    	this.add(bt2);
    	bt1.addActionListener(this);
    	bt2.addActionListener(this);
	op=new Operate_MyDB();
	if(op.getStudentCount()<=0)
	{
		JOptionPane.showMessageDialog(null,"    现在还没有任何学生记录！");
	}
	
    	//查询基本信息
		ArrayList temp1_array=new ArrayList();
		ArrayList temp2_array=new ArrayList();
		ArrayList temp3_array=new ArrayList();
		ArrayList temp4_array=new ArrayList();
		ArrayList temp5_array=new ArrayList();
		temp1_array=op.getALLnumber();
		temp2_array=op.getALLname();
		temp3_array=op.getALLsex();
		temp4_array=op.getALLnative();
		temp5_array=op.getALLmajor();
		String[][] playerInfo = new String[temp1_array.size()][5];
		for(int i=0;i<temp1_array.size();i++)
		{
			for(int j=0;j<=4;j++)
			{
				if(j==0)
				{
					playerInfo[i][j]=(String)temp1_array.get(i);		 
				}
				else if(j==1)
				{
					playerInfo[i][j]=(String)temp2_array.get(i);
				}
				else if(j==2)
				{
					playerInfo[i][j]=(String)temp3_array.get(i);
				}
				else if(j==3)
				{
					playerInfo[i][j]=(String)temp4_array.get(i);
				}
				else if(j==4)
				{
					playerInfo[i][j]=(String)temp5_array.get(i);
				}
				 
			}
		}
        String[] Names = {"学号","姓名","性别","籍贯","专业"};
		JTable table=new JTable(playerInfo, Names);
		table.setGridColor(Color.BLUE);
        table.setPreferredScrollableViewportSize(new Dimension(330, 150));
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
		this.setResizable(false);
		this.setSize(350,300);
	}
    public static void main(String args[]){          //主函数
    	Xxcx cx=new Xxcx();
    }
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bt1){
			JOptionPane.showMessageDialog(null,"     打印成功!");		
    	}
		if(e.getSource()==bt2){
			this.setVisible(false);
    	}		
	}	


}
