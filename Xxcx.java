package csc_db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import csc_db.Operate_MyDB;
import java.util.*;
public class Xxcx extends JFrame implements ActionListener {//��Ϣ��ѯ

	private JButton bt1,bt2;
	private Operate_MyDB op;
	JLabel title;
	public Xxcx(){
		super("��Ϣ��ѯ");
		init();
	}
	public void init(){                         //ʵ�ֽ��������
		this.setLayout(new FlowLayout());
    	this.setBounds(200,200,360, 250);
    	this.setVisible(true);
    	title=new JLabel("��ӭʹ�ñ�ϵͳ��");
    	title.setBounds(0, 0, 360,300);
    	this.add(title);
    	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	bt1=new JButton("��ӡ");
    	bt2=new JButton("�˳�");
    	bt1.setBounds(100, 220, 60,25);
    	bt2.setBounds(180,220, 60,25);
    	this.add(bt1);
    	this.add(bt2);
    	bt1.addActionListener(this);
    	bt2.addActionListener(this);
	op=new Operate_MyDB();
	if(op.getStudentCount()<=0)
	{
		JOptionPane.showMessageDialog(null,"    ���ڻ�û���κ�ѧ����¼��");
	}
	
    	//��ѯ������Ϣ
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
        String[] Names = {"ѧ��","����","�Ա�","����","רҵ"};
		JTable table=new JTable(playerInfo, Names);
		table.setGridColor(Color.BLUE);
        table.setPreferredScrollableViewportSize(new Dimension(330, 150));
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
		this.setResizable(false);
		this.setSize(350,300);
	}
    public static void main(String args[]){          //������
    	Xxcx cx=new Xxcx();
    }
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bt1){
			JOptionPane.showMessageDialog(null,"     ��ӡ�ɹ�!");		
    	}
		if(e.getSource()==bt2){
			this.setVisible(false);
    	}		
	}	


}
