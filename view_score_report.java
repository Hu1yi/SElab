package csc_db;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import csc_db.Operate_MyDB;
import java.util.*;
import java.sql.*;
import java.io.*;
import javax.swing.JFrame;

public class view_score_report extends JFrame implements ActionListener{
	private JButton bt1,bt2;
	private Operate_MyDB op;
	JPanel[] lab = new JPanel[5];
	TextField[] text=new TextField[4];
	
	JFrame f=new JFrame();
    JLabel pass1 = new JLabel("数学平均成绩: ",JLabel.RIGHT);
    JLabel pass2 = new JLabel("语文平均成绩:",JLabel.RIGHT);
    JLabel pass3 = new JLabel("英语平均成绩:",JLabel.RIGHT);
    
	public view_score_report(){
		super("查看成绩报告");
		init();
		bt1.addActionListener(this);
    	bt2.addActionListener(this);
	}
	public void init(){
		f.setBounds(500,300,300,300);
		  
		Container con=f.getContentPane();
		con.setLayout(new GridLayout(5,1));
		f.setVisible(true);
		
		for(int x=1;x<=4;x++) {
			if(null == lab[x]) {
			lab[x]= new JPanel();
			}
		}
		for(int x=1;x<=3;x++) {
			if(null == text[x]) {
			text[x]= new TextField(0);
			}
		}
		
		JPanel pan1=new JPanel();//生成一个新的版面
		JLabel title=new JLabel("欢迎使用本查询系统");
		title.setFont(new Font("宋体",Font.BOLD, 15));
		pan1.add(title);
		con.add(pan1);
		

		lab[1].add(pass1);
		text[1].setText("");
		lab[1].add(text[1]);
		con.add(lab[1]);
		
	    lab[2].add(pass2);
	    text[2].setText("");
	    lab[2].add(text[2]);
	    con.add(lab[2]);
	    
	    
	    lab[3].add(pass3);
	    text[3].setText("");
	    lab[3].add(text[3]);
	    con.add(lab[3]);
	    
	    bt1=new JButton("查询");
	    lab[4].add(bt1);
	    bt2=new JButton("退出");
	    lab[4].add(bt2);
	    con.add(lab[4]);
	}
	public void actionPerformed(ActionEvent e)//成绩查询
	{
		if(e.getSource()==bt1){
			try{
				op=new Operate_MyDB();
				Statement s=op.getConnection().createStatement();
				String sql="select AVG(math),AVG(chinese),AVG(english) from score";
				ResultSet rs=s.executeQuery(sql);
				if(rs.next())
				{  
					int rowCount = rs.getInt(1);
					int rowCount1 = rs.getInt(2);
					int rowCount2 = rs.getInt(3);
					String s1=Integer.toString(rowCount);
					String s2=Integer.toString(rowCount1);
					String s3=Integer.toString(rowCount2);
					text[1].setText(s1);
					text[2].setText(s2);
					text[3].setText(s3);
				}
			}catch (Exception error){
				System.err.println("异常："+error.getMessage());
			}	 
		}
    	if(e.getSource()==bt2){      
    		f.setVisible(false); 
		}
}

}