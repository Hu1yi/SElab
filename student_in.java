package csc_db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import csc_db.Operate_MyDB;
import java.util.*;


public class student_in extends JFrame implements ActionListener {
	private JButton bt1,bt2;
	JPanel[] lab = new JPanel[7];
	JTextField[] text=new JTextField[6];
	public student_in(){
		super("������ѧ");
		init();
	    bt1.addActionListener(this);
    	bt2.addActionListener(this);
	}
	public void init(){
		JFrame f=new JFrame();
		f.setBounds(500,300,300,400);
		
		Container con=f.getContentPane();
		con.setLayout(new GridLayout(7,1));
		f.setVisible(true);
		
		JPanel pan1=new JPanel();//����һ���µİ���
		JLabel title=new JLabel("��ӭ��½��ϵͳ");
		title.setFont(new Font("����",Font.BOLD, 15));
		pan1.add(title);
		con.add(pan1);
		
		
		for(int x=1;x<=6;x++) {
			if(null == lab[x]) {
			lab[x]= new JPanel();
			}
		}
		for(int x=1;x<=5;x++) {
			if(null == text[x]) {
			text[x]= new JTextField(10);
			}
		}
		
	    JLabel pass1 = new JLabel("ѧ��");
	    pass1.setFont(new Font("����",Font.BOLD, 15));
	    lab[1].add(pass1);
	    text[1].setText("");
	    lab[1].add(text[1]);
	    con.add(lab[1]);
	    
	    JLabel pass2 = new JLabel("����");
	    pass2.setFont(new Font("����",Font.BOLD, 15));
	    lab[2].add(pass2);
	    text[2].setText("");
	    lab[2].add(text[2]);
	    con.add(lab[2]);
	    
	    
	    JLabel pass3 = new JLabel("�Ա�");
	    pass3.setFont(new Font("����",Font.BOLD, 15));
	    lab[3].add(pass3);
	    text[3].setText("");
	    lab[3].add(text[3]);
	    con.add(lab[3]);
	    
	    
	    JLabel pass4 = new JLabel("����");
	    pass4.setFont(new Font("����",Font.BOLD, 15));
	    lab[4].add(pass4);
	    text[4].setText("");
	    lab[4].add(text[4]);
	    con.add(lab[4]);
	    
	    JLabel pass5 = new JLabel("רҵ");
	    pass5.setFont(new Font("����",Font.BOLD, 15));
	    lab[5].add(pass5);	    
	    text[5].setText("");
	    lab[5].add(text[5]);
	    con.add(lab[5]);

	    bt1=new JButton("����");
	    lab[6].add(bt1);
	    bt2=new JButton("ע��");
	    lab[6].add(bt2);
	    con.add(lab[6]);
	    

	}
	
    public static void main(String args[]){          //������
    	student_in shh=new student_in();
    }
    public void actionPerformed(ActionEvent e){               //ʵ�ּ���
		if(e.getSource()==bt1){		
			for(int i=1;i<6;i++){
				text[i].setText("");
			}

			
		}
		if(e.getSource()==bt2){
			String str[] = new String[6];
			for(int i=1;i<6;i++){
				str[i]=text[i].getText().trim();
			}
			Operate_MyDB temp_db = new Operate_MyDB();
			if(temp_db.insert_information(str[1], str[2], str[3], str[4], str[5])){
			    temp_db.insert_informationScore(str[1]);
			    System.out.println("success");
			    JOptionPane.showMessageDialog(null,"     ��ϲ"+str[2]+"����ѧע��ɹ�!");   
			}
			else
			{
				System.out.println("false");
				JOptionPane.showMessageDialog(null,"��Ϣ�������");
			}
			}
			setVisible(false);
		}
	}

