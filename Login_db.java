package csc_db;                 //检查账户合法性
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import csc_db.Operate_MyDB;
public class Login_db extends JFrame implements ActionListener {//登陆程序
	JLabel title;
	JTextField name=new JTextField(20);
	JPasswordField word=new JPasswordField(20);
	JFrame f=new JFrame();
    JLabel lab1,lab2;
    JButton bt1=new JButton("登陆");
    JButton bt2=new JButton("重置");
    
    public static Connection getConnection() { //连接数据库
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con1 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=student-management","sa", "csc937329533");
            con=con1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
    public Login_db(){                 //构造方法
    	super("学生学籍管理系统");
    	init();
    	bt1.addActionListener(this);
    	bt2.addActionListener(this);
    }
    public void init(){               //实现界面的内容	
    	
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    	f.setVisible(true);

    	//设置窗口的大小和位置
    	f.setSize(400,400);
    	f.setLocation(450,180);


    	Container con=f.getContentPane();//生成一个容器	
    	con.setLayout(new GridLayout(4,1));

    	JPanel pan1=new JPanel();//生成一个新的版面
    	JLabel title=new JLabel("管理系统");
    	title.setFont(new Font("宋体",Font.BOLD, 30));
    	pan1.add(title);
    	con.add(pan1);
    	//最上面的登陆文字

    	JPanel pan2=new JPanel();//生成一个新的版面
    	JLabel lab1=new JLabel("用户名");
    	pan2.add(lab1);
    	name.setText("");
    	pan2.add(name);
    	con.add(pan2);
    	//用户名及其文本框放置在第二个版面上


    	JPanel pan3=new JPanel();//生成一个新的版面
    	JLabel lab2 = new JLabel("密码");
    	pan3.add(lab2);
    	word.setEchoChar('*');
    	pan3.add(word);
    	con.add(pan3);
    	//密码及其密码域放在第三个版面上



    	JPanel pan4 = new JPanel();
    	pan4.add(bt1);
    	pan4.add(bt2); 
    	con.add(pan4);
    	//登陆和退出这两个按钮放在第四个版面上
	}
	public void check()                  //检查账户合法性
	{
		String username=name.getText();
		char[] password1=word.getPassword();
		String password=String.valueOf(password1);
		if(username==null || password==null || username.equals("") || password.equals(""))
		{
			JOptionPane.showMessageDialog(null,"       请正确输入! ");
			word.setText(null);	
		}
		else
		{
			Operate_MyDB temp_db=new Operate_MyDB();                //创建数据库操作对象，使用里面的方法。
			if(temp_db.login_check(username, password))              //调用检验方法
			{
				f.setVisible(false);               //将登录窗口关掉
				JOptionPane.showMessageDialog(null,"     欢迎"+username+"登陆学生学籍管理系统!");
				Gui gui=new Gui();     
				gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gui.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"用户名或密码错误!\n登陆失败,请重新登陆!");
				name.setText(null);
				word.setText(null);
			}
		}
	}
	
	
	
    public static void main(String args[]){          //主函数
    	Login_db lg=new Login_db();
    }
    
    
    public void actionPerformed(ActionEvent e){               //实现监听
    	if(e.getSource()==bt2){      //如果点击重置按钮，将用户名和密码文本设为空
    		name.setText("");
    		word.setText("");
		}
    	if(e.getSource()==bt1){
    		check();
    	}
	}
}
