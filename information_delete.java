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
	
	JLabel pass = new JLabel("������Ҫɾ����ѧ��ѧ����Ϣ");
	
	public information_delete() {
		super("��Ϣɾ��");
		init();
		bt1.addActionListener(this);
    	bt2.addActionListener(this);
	}
	
	//�����ʼ��
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
		
		JPanel pan1=new JPanel();//����һ���µİ���
		JLabel title=new JLabel("��ӭʹ�ñ�ϵͳ");
		title.setFont(new Font("����",Font.BOLD, 15));
		pan1.add(title);
		con.add(pan1);
		
		lab[1].add(pass);
		text.setText("");
		lab[1].add(text);
		con.add(lab[1]);
		

	    bt1=new JButton("ɾ��");
	    lab[2].add(bt1);
	    bt2=new JButton("�˳�");
	    lab[2].add(bt2);
	    con.add(lab[2]);
	}
	    
	    //ʵ�ּ���
	    public void actionPerformed(ActionEvent e)
	    {
	    	if(e.getSource()==bt1) {
	    		String str = new String();
	    		str = text.getText().trim();
	    		op=new Operate_MyDB();
			    if(op.delete_information(str)) {
			    	System.out.println("success");
			    JOptionPane.showMessageDialog(null,"ɾ���ɹ�!");
			    }
	    	    else
			    {
				  System.out.println("false");
				  JOptionPane.showMessageDialog(null,"��Ϣ�������");
			    }
            }
	    	if(e.getSource()==bt2) {
	    		f.setVisible(false); 
	    	}
	    }
	
}

