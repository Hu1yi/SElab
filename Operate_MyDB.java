package csc_db;
import java.sql.*;
import java.util.*;
public class Operate_MyDB {//自定义类
	private String url,username,password;
	private Connection con=null;
	private Statement st=null;
	private ResultSet rs=null;
	private String sql=null;
	public static Connection getConnection() { //连接数据库
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=student-management";
            String user="sa";//sa超级管理员
            String password="csc937329533";//密码
            con=DriverManager.getConnection( url,user,password);;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
	public Operate_MyDB()
	{
	
		url="jdbc:sqlserver://localhost:1433;DatabaseName=student-management";
		username="sa";
	    password="csc937329533";
	    try
	    {
	    
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, username, password);
		    st=con.createStatement();	
	    
	    }
	    catch(Exception e)
	    {
	    	System.out.print("connection datebase error !");
	    }   
	}
    

	//登陆的验证
	public boolean login_check(String username,String password)
	{
		boolean temp=false;
		sql="select * from member where username='"+username+"' and password='"+password+"'";
		try
		{
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				temp=true;
			}
		}
		catch(Exception e)
		{
			temp=false;
		}
		return temp;
	}

	public boolean insert_information(String id,String name,String sex, String native1, String major)
	{
		sql="insert into information(id,name,sex,native,major) values('"+id+"','"+name+"','"+sex+"','"+native1+"','"+major+"')";
		try
		{
			st.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			System.out.print("insert into information error !");
			return false;
		}
		return true;
	}
	
	public boolean delete_information(String id)
	{
		sql="delete from information where id = '"+id+"' delete from score where id = '\"+id+\"'";
		try
		{
			st.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			System.out.print("delete information error !");
			return false;
		}
		return true;
	}
	//注册的同时将分数表建立此学生
	public void insert_informationScore(String number)
	{
		String sql="insert into score (id) values ('"+number+"')";
		try
		{
			st.executeUpdate(sql);
		}
		catch(Exception e)
		{
			System.out.print("insert into information error !");
		}
	}
    
	
	
	//获得学生数量
	public int getStudentCount()
	{
		int count=0;
		sql="select count(*) s_count from score";
		try
		{
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				count=rs.getInt("s_count");
			}
		}
		catch(Exception e)
		{
			
		}
		return count;
	}	

	//成绩录入
	public void score_register(String id, String math, String chinese, String english)
	{
		sql="update score set math='"+math+"', chinese='"+chinese+"', english='"+english+"' where id='"+id+"'";
	    try
	    {
	    	st.executeUpdate(sql);
	    }
	    catch(Exception e)
	    {
	    	System.out.print("update into data error !");
	    }
	}

	//获得列表
	public ArrayList getALLnumber()
	{
		ArrayList<Object> al=new ArrayList<Object>();
		sql="select id from information";
		try
		{
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				al.add(rs.getString("id"));
			}
		}
		catch(Exception e)
		{
		}
		return al;
	}
	public ArrayList getALLname()
	{
		ArrayList al=new ArrayList();
		sql="select name from information";
		try
		{
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				al.add(rs.getString("name"));
			}
		}
		catch(Exception e)
		{
			
		}
		return al;
	}
	public ArrayList getALLsex()
	{
		ArrayList al=new ArrayList();
		sql="select sex from information";
		try
		{
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				al.add(rs.getString("sex"));
			}
		}
		catch(Exception e)
		{	
		}
		return al;
	}
	public ArrayList getALLnative()
	{
		ArrayList al=new ArrayList();
		sql="select native from information";
		try
		{
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				al.add(rs.getString("native"));
			}
		}
		catch(Exception e)
		{	
		}
		return al;
	}
	public ArrayList getALLmajor()
	{
		ArrayList al=new ArrayList();
		sql="select major from information";
		try
		{
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				al.add(rs.getString("major"));
			}
		}
		catch(Exception e)
		{	
		}
		return al;
	}	
	
}
