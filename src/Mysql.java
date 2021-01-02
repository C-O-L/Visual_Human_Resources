
import java.io.Serializable;
import java.sql.*;

import javax.swing.JOptionPane;

public class Mysql extends Login_modules implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection ct;
	PreparedStatement ps;
	ResultSet rs;
	
	//user_paswd
	String user_name, password;
	
	// 连接数据库的方法
	public void ConnectSQL()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 						// 注册JDBC的驱动
//			Class.forName("com.mysql.cj.jdbc.Driver");
			//连接数据库
			ct=DriverManager.getConnection("jdbc:mysql://localhost/visual_human_resources?user=root&password=980519"); 
			
			System.out.println("连接成功！");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 用户注册的方法，检测用户名或密码是否有误
	public void UserRegis(String a,String b)
	{
		
		try {
			ps=ct.prepareStatement("insert into user_info_list values(?,?)");
			ps.setString(1,a);
			ps.setString(2,b);
			
			
			int i=ps.executeUpdate();
			if(i==1)
			{
				JOptionPane.showMessageDialog(null, "账号错误","请重新输入！",JOptionPane.WARNING_MESSAGE);   
			}else
			{
				JOptionPane.showMessageDialog(null, "密码错误","请重新输入！",JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				ct.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	// 用户登录方法，核验用户名与密码是否匹配
	public void SQLverify(String a,String b)
	{
		try {
			ps=ct.prepareStatement("select * from user_info_list where user_name = ? and password = ? ");
			ps.setString(1, a);
			ps.setString(2, b);
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				user_name = rs.getString(2);									// 第二列是user_name列
				password = rs.getString(3);										// 第三列是password列
				//JOptionPane.showMessageDialog(null, "", "", JOptionPane.WARNING_MESSAGE);
				System.out.println("登录成功！");
				//System.out.println(user + "\t" + passwd + "\t");
				   
				
			}else
			{
				JOptionPane.showMessageDialog(null, "用户名或密码错误，请重新输入！", "error", JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				ct.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	// 用户注册方法，查看用户名是否重复
	public void ZhuceVerify(String a)
	{
		try {
			ps=ct.prepareStatement("select * from user_info_list where user_name=?");
			ps.setString(1, a);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				JOptionPane.showMessageDialog(null, "该用户名已存在", "请直接登录或者换个用户名注册", JOptionPane.WARNING_MESSAGE);
			}else
			{
				Login_modules cf = new Login_modules();
				this.UserRegis(cf.username_register.getText(),cf.password_register.getText());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				ct.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}