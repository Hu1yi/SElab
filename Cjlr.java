package csc_db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import csc_db.Operate_MyDB;
import java.util.*;
import java.sql.*;
public class Cjlr extends JFrame implements ActionListener {
	
	private JButton bt1,bt2;
	private Operate_MyDB op;
	private String id,math,chinese,english;
	JPanel[] lab = new JPanel[7];
	TextField[] text=new TextField[5];
    
	public Cjlr(){
		super("成绩录入");
		init();
		bt1.addActionListener(this);
    	bt2.addActionListener(this);
	}
	public void init(){
		JFrame f=new JFrame();
		f.setBounds(500,300,300,400);

		
		Container con=f.getContentPane();
		con.setLayout(new GridLayout(6,1));
		f.setVisible(true);
		
		for(int x=1;x<=6;x++) {
			if(null == lab[x]) {
			lab[x]= new JPanel();
			}
		}
		for(int x=1;x<=4;x++) {
			if(null == text[x]) {
			text[x]= new TextField(15);
			}
		}
		
		JPanel pan1=new JPanel();//生成一个新的版面
		JLabel title=new JLabel("欢迎登陆本系统");
		title.setFont(new Font("宋体",Font.BOLD, 15));
		pan1.add(title);
		con.add(pan1);
		
		
	    JLabel pass1 = new JLabel("请输入要录入的学号");
	    pass1.setFont(new Font("宋体",Font.BOLD, 15));
	    lab[1].add(pass1);
	    text[1].setText("");
	    lab[1].add(text[1]);
	    con.add(lab[1]);
	    
	    JLabel pass2 = new JLabel("语文");
	    pass2.setFont(new Font("宋体",Font.BOLD, 15));
	    lab[2].add(pass2);
	    text[2].setText("");
	    lab[2].add(text[2]);
	    con.add(lab[2]);
	    
	    
	    
	    JLabel pass3 = new JLabel("数学");
	    pass3.setFont(new Font("宋体",Font.BOLD, 15));
	    lab[3].add(pass3);
	    text[3].setText("");
	    lab[3].add(text[3]);
	    con.add(lab[3]);
	    
	    JLabel pass4 = new JLabel("英语");
	    pass4.setFont(new Font("宋体",Font.BOLD, 15));
	    lab[4].add(pass4);	    
	    text[4].setText("");
	    lab[4].add(text[4]);
	    con.add(lab[4]);
	    
	    bt1=new JButton("修改");
	    lab[6].add(bt1);
	    bt2=new JButton("重置");
	    lab[6].add(bt2);
	    con.add(lab[6]);
	}
	
	public void actionPerformed(ActionEvent e)//成绩录入
	{
		if(e.getSource()==bt1){
			try{
				op=new Operate_MyDB();
				Statement s=op.getConnection().createStatement();
				String sql="select * from score "+ "where id='"+text[1].getText()+"'";
				ResultSet rs=s.executeQuery(sql);
				if(rs.next())
				{  
					id=text[1].getText();
					chinese=text[2].getText();
					math=text[3].getText();
					english=text[4].getText();
					Operate_MyDB temp_db = new Operate_MyDB();
		    		temp_db.Cjlr(id, math, chinese, english);
		    		System.out.println("success");
					JOptionPane.showMessageDialog(null,"     恭喜"+id+"成绩录入成功!");   
		    		setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"不存在该学号的学生！");
				}
			}
			catch (Exception error)
			{
				System.err.println("异常："+error.getMessage());
			}	 
		}
		if(e.getSource()==bt2){      //如果点击重置按钮，将用户名和密码文本设为空
			text[1].setText("");
			text[2].setText("");
			text[3].setText("");
			text[4].setText("");
		}

	}
}
