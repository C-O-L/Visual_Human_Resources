
import java.io.Serializable;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Mysql extends Login_modules implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection ct;
	PreparedStatement ps;
	ResultSet rs;

	public boolean registeredBoolean = false; 								// 布尔判断是否可以注册
	public boolean newsqlBoolean = false;									// 布尔判断是否可以新建sql表
	
	//user_paswd
	String user_name, password;
	
	// 连接数据库的方法
	public void ConnectSQL()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 			// 注册JDBC的驱动
//			Class.forName("com.mysql.cj.jdbc.Driver");
			//连接数据库
			ct=DriverManager.getConnection("jdbc:mysql://localhost/visual_human_resources?user=root&password=980519"); 
			
			System.out.println("连接成功！");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();											// 捕获异常
		}
	}
	
	// 用户注册的方法，将用户名、密码、注册时间写入数据库
	public void UserRegis(String a,String b,String c)
	{
		try {
			ps=ct.prepareStatement("insert into user_info_list(user_name, password, create_time) VALUES (?,?,?)");
//			ps=ct.prepareStatement("insert into user_info_list values(?,?)");
			ps.setString(1, a);
			ps.setString(2, b);
			ps.setString(3, c);
			
			int i = ps.executeUpdate();
			if(i == 1){
				JOptionPane.showMessageDialog(null, "注册成功！", "succeed", JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);										// 关闭当前页面
				newsqlBoolean = true;										// 注册成功后可以新建sql表
				
				Login_modules L_m = new Login_modules();
				L_m.concealRegister();										// 调用Login_modules类中隐藏注册面板的方法，隐藏注册面板
				L_m.showLogin();											// 调用Login_modules类中显示登录面板的方法，显示登录面板
			}else if(i == 2){
				JOptionPane.showMessageDialog(null, "注册成功！", "succeed", JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
//				Login_modules L_m = new Login_modules();
//				L_m.concealRegister();
//				L_m.showLogin();
			}else {
				JOptionPane.showMessageDialog(null, "注册成功！", "succeed", JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
//				Login_modules L_m = new Login_modules();
//				L_m.concealRegister();
//				L_m.showLogin();
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
//				user_name = rs.getString(2);						// 第二列是user_name列
//				password = rs.getString(3);							// 第三列是password列
				//JOptionPane.showMessageDialog(null, "", "", JOptionPane.WARNING_MESSAGE);
				System.out.println("登录成功！");
				this.setVisible(false);		
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
				this.setVisible(false);								// 关闭当前页面
				Login_modules L_m = new Login_modules();
				L_m.showRegister();									// 调用Login_modules类中显示注册面板的方法，显示注册面板
				L_m.concealLogin();									// 调用Login_modules类中隐藏登录面板的方法，隐藏登录面板
			}
			else
			{
				registeredBoolean = true;
//				Login_modules cf = new Login_modules();
//				this.UserRegis(cf.username_register.getText(),cf.password_register.getText(),cf.depositTime.getText());
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
	
	// 新建绩效sql表的方法
	public void newAssesssql(String a) 
	{
		// 为每个用户创建独有的sql表，用来存放员工的信息，
		// sql表的命名规则遵循“用户名+_performance_appraisal_list”
		
		String b = "_performance_appraisal_list";
		String cString = a+b;
		try {
			
			ps=ct.prepareStatement("CREATE TABLE "+cString+" (\r\n" + 
					"  `id` INT NOT NULL AUTO_INCREMENT, \r\n" + 
					"  `staff_name` VARCHAR(45) NOT NULL COMMENT '员工姓名',\r\n" + 
					"  `normal_days` DECIMAL(10,1) NOT NULL COMMENT '正常天数',\r\n" + 
					"  `late_days` DECIMAL(10,1) NOT NULL COMMENT '迟到天数',\r\n" + 
					"  `leave_days` DECIMAL(10,1) NOT NULL COMMENT '请假天数',\r\n" + 
					"  `absenteeism_days` INT NOT NULL COMMENT '旷工天数',\r\n" + 
					"  `work_hours` INT NOT NULL COMMENT '工作时长',\r\n" + 
					"  `work_piece` INT NOT NULL COMMENT '工作计件',\r\n" + 
					"  `work_content` VARCHAR(45) NOT NULL COMMENT '工作质量',\r\n" + 
					"  `technology_improve` VARCHAR(45) NOT NULL COMMENT '工艺改善',\r\n" + 
					"  `quarter_class` VARCHAR(45) NOT NULL COMMENT '季度等级评定',\r\n" + 
					"  `rewards_time` INT NOT NULL COMMENT '奖励次数',\r\n" + 
					"  `punishment_time` INT NOT NULL COMMENT '惩罚次数',\r\n" + 
					"  `quarter` VARCHAR(45) NOT NULL COMMENT '第几季度',\r\n" + 
					"  `assess_result` VARCHAR(45) NULL COMMENT '考核结果',\r\n" + 
					"  PRIMARY KEY (`id`))");
			
			ps.executeUpdate();

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