package csc_db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import csc_db.Operate_MyDB;
import java.util.*;
import java.sql.*;
import java.io.*;

public class information_delete extends JFrame implements ActionListener{
	private JButton bt1,bt2;
	private Operate_MyDB op;
	
	JPanel[] lab = new JPanel[3];
	
	TextField text = new TextField(10);
	
	JFrame f = new JFrame();
	
	JLabel pass = new JLabel("请输入要删除的学生学号信息");
	
	public information_delete() {
		super("信息删除");
		init();
		bt1.addActionListener(this);
    	bt2.addActionListener(this);
	}
	
	//界面初始化
	private void init() {
		f.setBounds(500,300,300,200);
		  
		Container con=f.getContentPane();
		con.setLayout(new GridLayout(3,1));
		f.setVisible(true);
		
		for(int x=1;x<=2;x++) {
			if(null == lab[x]) {
			lab[x]= new JPanel();
			}
		}
		if(null == text) {
			text = new TextField(0);
			}
		
		JPanel pan1=new JPanel();//生成一个新的版面
		JLabel title=new JLabel("欢迎使用本系统");
		title.setFont(new Font("宋体",Font.BOLD, 15));
		pan1.add(title);
		con.add(pan1);
		
		lab[1].add(pass);
		text.setText("");
		lab[1].add(text);
		con.add(lab[1]);
		

	    bt1=new JButton("删除");
	    lab[2].add(bt1);
	    bt2=new JButton("退出");
	    lab[2].add(bt2);
	    con.add(lab[2]);
	}
	    
	    //实现监听
	    public void actionPerformed(ActionEvent e)
	    {
	    	if(e.getSource()==bt1) {
	    		String str = new String();
	    		str = text.getText().trim();
	    		op=new Operate_MyDB();
			    if(op.delete_information(str)) {
			    	System.out.println("success");
			    JOptionPane.showMessageDialog(null,"删除成功!");
			    }
	    	    else
			    {
				  System.out.println("false");
				  JOptionPane.showMessageDialog(null,"信息输入错误");
			    }
            }
	    	if(e.getSource()==bt2) {
	    		f.setVisible(false); 
	    	}
	    }
	
}

