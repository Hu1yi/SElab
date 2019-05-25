package csc_db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import csc_db.Operate_MyDB;
import java.util.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class Cjcx extends JFrame implements ActionListener {
	private JButton bt1,bt2;
	private Operate_MyDB op;
	private int i1,i2,i3,i;
	JPanel[] lab = new JPanel[7];
	TextField[] text1=new TextField[5];
	TextField text=new TextField(10);
	JFrame f=new JFrame();
	JLabel pass1 = new JLabel("������Ҫ��ѯ��ѧ��");
    JLabel pass2 = new JLabel("����: ",JLabel.RIGHT);
    JLabel pass3 = new JLabel("��ѧ:",JLabel.RIGHT);
    JLabel pass4 = new JLabel("Ӣ��:",JLabel.RIGHT);
    JLabel pass5 = new JLabel("ƽ���ɼ�: ",JLabel.RIGHT);
    
	public Cjcx(){
		super("�ɼ���ѯ");
		init();
		bt1.addActionListener(this);
    	bt2.addActionListener(this);
	}
	public void init(){
		f.setBounds(500,300,300,400);
		  
		Container con=f.getContentPane();
		con.setLayout(new GridLayout(7,1));
		f.setVisible(true);
		
		for(int x=1;x<=6;x++) {
			if(null == lab[x]) {
			lab[x]= new JPanel();
			}
		}
		for(int x=1;x<=4;x++) {
			if(null == text1[x]) {
			text1[x]= new TextField(0);
			}
		}
		
		JPanel pan1=new JPanel();//����һ���µİ���
		JLabel title=new JLabel("��ӭ����ѯϵͳ");
		title.setFont(new Font("����",Font.BOLD, 15));
		pan1.add(title);
		con.add(pan1);
		

		lab[1].add(pass1);
		text.setText("");
		lab[1].add(text);
		con.add(lab[1]);
		
	    lab[2].add(pass2);
	    lab[2].add(text1[1]);
	    con.add(lab[2]);
	    
	    
	    lab[3].add(pass3);
	    lab[3].add(text1[2]);
	    con.add(lab[3]);
	    
	    lab[4].add(pass4);
	    lab[4].add(text1[3]);
	    con.add(lab[4]); 

	    lab[5].add(pass5);
	    lab[5].add(text1[4]);
	    con.add(lab[5]);
	    
	    bt1=new JButton("��ѯ");
	    lab[6].add(bt1);
	    bt2=new JButton("�˳�");
	    lab[6].add(bt2);
	    con.add(lab[6]);
	}
	public void actionPerformed(ActionEvent e)//�ɼ���ѯ
	{
		if(e.getSource()==bt1){
			try{
				op=new Operate_MyDB();
				Statement s=op.getConnection().createStatement();
				String sql="select * from score "+ "where id='"+text.getText()+"'";
				ResultSet rs=s.executeQuery(sql);
				if(rs.next())
				{  
					text1[2].setText(rs.getString("math"));
					text1[1].setText(rs.getString("chinese"));
					text1[3].setText(rs.getString("english"));
					i1=Integer.parseInt(text1[1].getText());
					i2=Integer.parseInt(text1[2].getText());
					i3=Integer.parseInt(text1[3].getText());
					i=(i1+i2+i3)/3;
					String j=Integer.toString(i);
					text1[4].setText(j);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"�����ڸ�ѧ�ŵ�ѧ����");
				}
			}catch (Exception error){
				System.err.println("�쳣��"+error.getMessage());
			}	 
		}
    	if(e.getSource()==bt2){      
    		f.setVisible(false); 
		}
}
}
