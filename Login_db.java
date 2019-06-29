package csc_db;                 //����˻��Ϸ���
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import csc_db.Operate_MyDB;
public class Login_db extends JFrame implements ActionListener {//��½����
	JLabel title;
	JTextField name=new JTextField(20);
	JPasswordField word=new JPasswordField(20);
	JFrame f=new JFrame();
    JLabel lab1,lab2;
    JButton bt1=new JButton("��½");
    JButton bt2=new JButton("����");
    
    public static Connection getConnection() { //�������ݿ�
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
    public Login_db(){                 //���췽��
    	super("ѧ��ѧ������ϵͳ");
    	init();
    	bt1.addActionListener(this);
    	bt2.addActionListener(this);
    }
    public void init(){               //ʵ�ֽ��������	
    	
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    	f.setVisible(true);

    	//���ô��ڵĴ�С��λ��
    	f.setSize(400,400);
    	f.setLocation(450,180);


    	Container con=f.getContentPane();//����һ������	
    	con.setLayout(new GridLayout(4,1));

    	JPanel pan1=new JPanel();//����һ���µİ���
    	JLabel title=new JLabel("����ϵͳ");
    	title.setFont(new Font("����",Font.BOLD, 30));
    	pan1.add(title);
    	con.add(pan1);
    	//������ĵ�½����

    	JPanel pan2=new JPanel();//����һ���µİ���
    	JLabel lab1=new JLabel("�û���");
    	pan2.add(lab1);
    	name.setText("");
    	pan2.add(name);
    	con.add(pan2);
    	//�û��������ı�������ڵڶ���������


    	JPanel pan3=new JPanel();//����һ���µİ���
    	JLabel lab2 = new JLabel("����");
    	pan3.add(lab2);
    	word.setEchoChar('*');
    	pan3.add(word);
    	con.add(pan3);
    	//���뼰����������ڵ�����������



    	JPanel pan4 = new JPanel();
    	pan4.add(bt1);
    	pan4.add(bt2); 
    	con.add(pan4);
    	//��½���˳���������ť���ڵ��ĸ�������
	}
	public void check()                  //����˻��Ϸ���
	{
		String username=name.getText();
		char[] password1=word.getPassword();
		String password=String.valueOf(password1);
		if(username==null || password==null || username.equals("") || password.equals(""))
		{
			JOptionPane.showMessageDialog(null,"       ����ȷ����! ");
			word.setText(null);	
		}
		else
		{
			Operate_MyDB temp_db=new Operate_MyDB();                //�������ݿ��������ʹ������ķ�����
			if(temp_db.login_check(username, password))              //���ü��鷽��
			{
				f.setVisible(false);               //����¼���ڹص�
				JOptionPane.showMessageDialog(null,"     ��ӭ"+username+"��½ѧ��ѧ������ϵͳ!");
				Gui gui=new Gui();     
				gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gui.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"�û������������!\n��½ʧ��,�����µ�½!");
				name.setText(null);
				word.setText(null);
			}
		}
	}
	
	
	
    public static void main(String args[]){          //������
    	Login_db lg=new Login_db();
    }
    
    
    public void actionPerformed(ActionEvent e){               //ʵ�ּ���
    	if(e.getSource()==bt2){      //���������ð�ť�����û����������ı���Ϊ��
    		name.setText("");
    		word.setText("");
		}
    	if(e.getSource()==bt1){
    		check();
    	}
	}
}
