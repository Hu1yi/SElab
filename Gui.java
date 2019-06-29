package csc_db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import csc_db.information_query;
import csc_db.Operate_MyDB;
import csc_db.Login_db;
import csc_db.student_in;
import csc_db.score_register;
import csc_db.score_check;
public class Gui extends JFrame implements ActionListener {//�������������
	JLabel title;
    JButton bt1,bt2;
    JMenuBar menubar = new JMenuBar();
    JMenu menu1,menu2,menu4;
    JMenuItem item11,item21,item22,item23,item24,item25,item41,item42,item43;
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
    	//һ���˵���
    	menu1 = new JMenu("������ѧ");
    	menu2 = new JMenu("��У����");
    	menu4 = new JMenu("ϵͳά��");
    	menubar.add(menu1);
    	menubar.add(menu2);
    	menubar.add(menu4);	
    	//�����˵���
    	item11 = new JMenuItem("������ѧ"); 
    	item21 = new JMenuItem("��Ϣ��ѯ");
    	item22 = new JMenuItem("�ɼ�¼��");
    	item23 = new JMenuItem("�ɼ���ѯ");
    	item24 = new JMenuItem("��Ϣɾ��");
    	item25 = new JMenuItem("�ɼ�ͳ��");
    	item41 = new JMenuItem("�汾��Ϣ");
    	item42 = new JMenuItem("����");
    	item43 = new JMenuItem("�˳�");
    	menu1.add(item11);
    	menu2.add(item21);
    	menu2.add(item22);
    	menu2.add(item23);
    	menu2.add(item24);
    	menu2.add(item25);
    	menu4.add(item41);
    	menu4.add(item42);
    	menu4.add(item43); 	
    	//ע�������
    	item11.addActionListener(this);
    	item43.addActionListener(this);
    	item21.addActionListener(this);
    	item22.addActionListener(this);
    	item23.addActionListener(this);
    	item24.addActionListener(this);
    	item25.addActionListener(this);
    	item41.addActionListener(this);
    	item42.addActionListener(this);
	}
    public static void main(String args[]){          //������
    	Gui lg=new Gui();
    }
    public void actionPerformed(ActionEvent e){               //ʵ�ּ���
    	if(e.getSource()==item11){
    		student_in shh= new student_in(); 
    	}
    	if(e.getSource()==item21){
    		information_query cx= new information_query();
    	}
    	if(e.getSource()==item22){
    		score_register cj= new score_register();
    	}
    	if(e.getSource()==item23){
    		score_check cj= new score_check();
    	}
    	if(e.getSource()==item24) {
    		information_delete id = new information_delete();
    	}
    	if(e.getSource()==item25) {
    		view_score_report vsr = new view_score_report();
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
