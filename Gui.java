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
public class Gui extends JFrame implements ActionListener {//程序主界面设计
	JLabel title;
    JButton bt1,bt2;
    JMenuBar menubar = new JMenuBar();
    JMenu menu1,menu2,menu4;
    JMenuItem item11,item21,item22,item23,item41,item42,item43;
    public Gui(){                 //构造方法
    	super("学生学籍管理系统");
    	init();
    }    
    public void init(){               //实现界面的内容
    	this.setLayout(null);
    	this.setBounds(100,100,360, 250);
    	this.setVisible(true);
    	this.setJMenuBar(menubar);
    	//标题界面
    	title=new JLabel("欢迎使用学籍管理系统！");
    	title.setBounds(100, -50, 360, 250);
    	this.add(title);	
    	//菜单栏1
    	menu1 = new JMenu("新生入学");
    	menu2 = new JMenu("在校管理");
    	menu4 = new JMenu("系统维护");
    	menubar.add(menu1);
    	menubar.add(menu2);
    	menubar.add(menu4);	
    	//菜单栏2
    	item11 = new JMenuItem("新生入学"); 
    	item21 = new JMenuItem("信息查询");
    	item22 = new JMenuItem("成绩录入");
    	item23 = new JMenuItem("成绩查询");
    	item41 = new JMenuItem("版本信息");
    	item42 = new JMenuItem("帮助");
    	item43 = new JMenuItem("退出");
    	menu1.add(item11);
    	menu2.add(item21);
    	menu2.add(item22);
    	menu2.add(item23);
    	menu4.add(item41);
    	menu4.add(item42);
    	menu4.add(item43); 	
    	//注册监听器
    	item11.addActionListener(this);
    	item43.addActionListener(this);
    	item21.addActionListener(this);
    	item22.addActionListener(this);
    	item23.addActionListener(this);
    	item41.addActionListener(this);
    	item42.addActionListener(this);
	}
    public static void main(String args[]){          //主函数
    	Gui lg=new Gui();
    }
    public void actionPerformed(ActionEvent e){               //实现监听
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
    		JOptionPane.showMessageDialog(null,"     此系统的版本为1.0!");   
    	}
    	if(e.getSource()==item42){
    		JOptionPane.showMessageDialog(null,"     暂无帮助!");   
    	}
    	if(e.getSource()==item43){
    		System.exit(0);
    	}
    	
    }
}
