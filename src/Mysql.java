
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

	public boolean registeredBoolean = false; 								// 布尔判断是否可以注册
	public boolean newsqlBoolean = false;									// 布尔判断是否可以新建sql表
	public boolean thisclose = true;										// 布尔判断是否登录成功，成功则关闭当前窗口
	
	
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
				System.out.println("登录成功！");
				
				this.dispose();										// 关闭登录注册界面
				
				// 将用户名传到Assess_modules类的userName方法中
				Assess_modules as = new Assess_modules();
				as.userName(a);
				as.messageTabel(a);
				
				this.setVisible(false);
				
			}else
			{
				this.setVisible(false);
				thisclose = false;
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
	
	public void loginClose() {
		this.dispose();
		this.setVisible(false);
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
				JOptionPane.showMessageDialog(null, "该用户名已存在,请直接登录或者换个用户名注册!", "error", JOptionPane.WARNING_MESSAGE);
				this.setVisible(false);								// 关闭当前页面
				Login_modules L_m = new Login_modules();
				L_m.showRegister();									// 调用Login_modules类中显示注册面板的方法，显示注册面板
				L_m.concealLogin();									// 调用Login_modules类中隐藏登录面板的方法，隐藏登录面板
			}
			else
			{
				registeredBoolean = true;

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
		String cString = a + b;
		try {
			
			ps=ct.prepareStatement("CREATE TABLE "+cString+" (\r\n" + 
					"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
					"  `staff_name` VARCHAR(45) NOT NULL COMMENT '员工姓名',\r\n" + 
					"  `staff_number` VARCHAR(45) NOT NULL COMMENT '员工号',\r\n" + 
					"  `normal_days` DECIMAL(10,2) NOT NULL COMMENT '正常天数',\r\n" + 
					"  `late_days` INT NOT NULL COMMENT '迟到时长',\r\n" + 
					"  `leave_days` DECIMAL(10,2) NOT NULL COMMENT '请假天数',\r\n" + 
					"  `absenteeism_days` DECIMAL(10,2) NOT NULL COMMENT '旷工天数',\r\n" + 
					"  `work_hours` INT NOT NULL COMMENT '工作时长',\r\n" + 
					"  `work_piece` INT NOT NULL COMMENT '工作计件',\r\n" + 
					"  `work_content` INT NOT NULL COMMENT '工作质量',\r\n" + 
					"  `technology_improve` INT NOT NULL COMMENT '工艺改善',\r\n" + 
					"  `rewards_time` INT NOT NULL COMMENT '奖励次数',\r\n" + 
					"  `punishment_time` INT NOT NULL COMMENT '惩罚次数',\r\n" + 
					"  `many_quarter` VARCHAR(45) NOT NULL COMMENT '第几季度',\r\n" + 
					"  `quarter_class` VARCHAR(45) NOT NULL COMMENT '季度等级评定',\r\n" + 
					"  `assess_result` DECIMAL(10,2) NULL COMMENT '考核结果',\r\n" + 
					"  PRIMARY KEY (`id`));");
			
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
	
	// 保存员工信息的方法，接收Assess_modules类中saveMessage方法传过来的值，将user_name + _performance_appraisal_list作为表名，
	// 将其余值作为sql表各列的值，写入表中，实现动态写表（登录的用户不同，写入的表也不同）。
	public void saveMessage(String user_name, String staff_name, String staff_number, String normal_days
			, String late_days, String leave_days, String absenteeism_days, String work_hours
			, String work_piece, String work_content, String technology_improve, String rewards_time
			, String punishment_time, String many_quarter, String quarter_class) 
	{
		
		String b = "_performance_appraisal_list";
		String dString = user_name + b;
		System.out.println(dString);
		try {
			ps=ct.prepareStatement("INSERT INTO "+dString+" (staff_name, staff_number, normal_days, late_days, leave_days, absenteeism_days, work_hours, work_piece, work_content, technology_improve, rewards_time, punishment_time, many_quarter, quarter_class) \r\n" + 
					"  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, staff_name);
			ps.setString(2, staff_number);
			ps.setString(3, normal_days);
			ps.setString(4, late_days);
			ps.setString(5, leave_days);
			ps.setString(6, absenteeism_days);
			ps.setString(7, work_hours);
			ps.setString(8, work_piece);
			ps.setString(9, work_content);
			ps.setString(10, technology_improve);
			ps.setString(11, rewards_time);
			ps.setString(12, punishment_time);
			ps.setString(13, many_quarter);
			ps.setString(14, quarter_class);
			
			int i = ps.executeUpdate();
			if(i == 1){
				this.setVisible(false);
			}else {
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			try {
				ct.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	// 修改员工信息的方法，接收Assess_modules类中modigyMessage方法传过来的值，将user_name + _performance_appraisal_list作为表名，
	public void modifyMessage(String user_name, String staff_name, String staff_number, String normal_days
			, String late_days, String leave_days, String absenteeism_days, String work_hours
			, String work_piece, String work_content, String technology_improve, String rewards_time
			, String punishment_time, String many_quarter, String quarter_class, String id) 
	{
			
		String b = "_performance_appraisal_list";
		String dString = user_name + b;
		System.out.println(dString);
		try {
			ps=ct.prepareStatement("UPDATE "+dString+" SET\r\n" + 
					" `staff_name` = ?, `staff_number` = ?, `normal_days` = ?, \r\n" + 
					" `late_days` = ?, `leave_days` = ?, `absenteeism_days` = ?, \r\n" + 
					" `work_hours` = ?, `work_piece` = ?, `work_content` = ?, \r\n" + 
					" `technology_improve` = ?, `rewards_time` = ?, `punishment_time` = ?, \r\n" + 
					" `many_quarter` = ?, `quarter_class` = ? WHERE (`id` = ?)");
			ps.setString(1, staff_name);
			ps.setString(2, staff_number);
			ps.setString(3, normal_days);
			ps.setString(4, late_days);
			ps.setString(5, leave_days);
			ps.setString(6, absenteeism_days);
			ps.setString(7, work_hours);
			ps.setString(8, work_piece);
			ps.setString(9, work_content);
			ps.setString(10, technology_improve);
			ps.setString(11, rewards_time);
			ps.setString(12, punishment_time);
			ps.setString(13, many_quarter);
			ps.setString(14, quarter_class);
			ps.setString(15, id);
				
			int i = ps.executeUpdate();
			if(i == 1){
				this.setVisible(false);
			}else {
					
			}
				
		}catch (SQLException e) {
			e.printStackTrace();
			try {
				ct.close();
			} catch (SQLException e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	// 修改员工信息的方法，接收Assess_modules类中modigyMessage方法传过来的值，将user_name + _performance_appraisal_list作为表名，
	public void deleteMessage(String user_name, String id) 
	{
				
		String b = "_performance_appraisal_list";
		String dString = user_name + b;
		System.out.println(dString);
		try {
			ps=ct.prepareStatement("DELETE FROM "+dString+" WHERE (`id` = ?)");
			ps.setString(1, id);
				
			ps.executeUpdate();
			this.setVisible(false);
					
		}catch (SQLException e) {
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