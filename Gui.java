package csc_db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import csc_db.Xxcx;
import csc_db.Operate_MyDB;
import csc_db.Login_db;
import csc_db.Xsrx;
import csc_db.Cjlr;
import csc_db.Cjcx;
public class Gui extends JFrame implements ActionListener {//�������������
	JLabel title;
    JButton bt1,bt2;
    JMenuBar menubar = new JMenuBar();
    JMenu menu1,menu2,menu4;
    JMenuItem item11,item21,item22,item23,item41,item42,item43;
    public Gui(){                 //���췽��
    	super("ѧ��ѧ������ϵͳ");
    	init();
    }    
    public void init(){               //ʵ�ֽ��������
    	this.setLayout(null);
    	this.setBounds(100,100,360, 250);
    	this.setVisible(true);
    	this.setJMenuBar(menubar);
    	//�������
    	title=new JLabel("��ӭʹ��ѧ������ϵͳ��");
    	title.setBounds(100, -50, 360, 250);
    	this.add(title);	
    	//�˵���1
    	menu1 = new JMenu("������ѧ");
    	menu2 = new JMenu("��У����");
    	menu4 = new JMenu("ϵͳά��");
    	menubar.add(menu1);
    	menubar.add(menu2);
    	menubar.add(menu4);	
    	//�˵���2
    	item11 = new JMenuItem("������ѧ"); 
    	item21 = new JMenuItem("��Ϣ��ѯ");
    	item22 = new JMenuItem("�ɼ�¼��");
    	item23 = new JMenuItem("�ɼ���ѯ");
    	item41 = new JMenuItem("�汾��Ϣ");
    	item42 = new JMenuItem("����");
    	item43 = new JMenuItem("�˳�");
    	menu1.add(item11);
    	menu2.add(item21);
    	menu2.add(item22);
    	menu2.add(item23);
    	menu4.add(item41);
    	menu4.add(item42);
    	menu4.add(item43); 	
    	//ע�������
    	item11.addActionListener(this);
    	item43.addActionListener(this);
    	item21.addActionListener(this);
    	item22.addActionListener(this);
    	item23.addActionListener(this);
    	item41.addActionListener(this);
    	item42.addActionListener(this);
	}
    public static void main(String args[]){          //������
    	Gui lg=new Gui();
    }
    public void actionPerformed(ActionEvent e){               //ʵ�ּ���
    	if(e.getSource()==item11){
    		Xsrx shh= new Xsrx();
    	}
    	if(e.getSource()==item21){
    		Xxcx cx= new Xxcx();
    	}
    	if(e.getSource()==item22){
    		Cjlr cj= new Cjlr();
    	}
    	if(e.getSource()==item23){
    		Cjcx cj= new Cjcx();
    	}
    	if(e.getSource()==item41){
    		JOptionPane.showMessageDialog(null,"     ��ϵͳ�İ汾Ϊ1.0!");   
    	}
    	if(e.getSource()==item42){
    		JOptionPane.showMessageDialog(null,"     ���ް���!");   
    	}
    	if(e.getSource()==item43){
    		System.exit(0);
    	}
    	
    }
}
