
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

	public boolean registeredBoolean = false; 								// �����ж��Ƿ����ע��
	public boolean newsqlBoolean = false;									// �����ж��Ƿ�����½�sql��
	public boolean thisclose = true;										// �����ж��Ƿ��¼�ɹ����ɹ���رյ�ǰ����
	
	
	// �������ݿ�ķ���
	public void ConnectSQL()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 			// ע��JDBC������
//			Class.forName("com.mysql.cj.jdbc.Driver");
			//�������ݿ�
			ct=DriverManager.getConnection("jdbc:mysql://localhost/visual_human_resources?user=root&password=980519"); 
			
			System.out.println("���ӳɹ���");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();											// �����쳣
		}
	}
	
	// �û�ע��ķ��������û��������롢ע��ʱ��д�����ݿ�
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
				JOptionPane.showMessageDialog(null, "ע��ɹ���", "succeed", JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);										// �رյ�ǰҳ��
				newsqlBoolean = true;										// ע��ɹ�������½�sql��
				
				Login_modules L_m = new Login_modules();
				L_m.concealRegister();										// ����Login_modules��������ע�����ķ���������ע�����
				L_m.showLogin();											// ����Login_modules������ʾ��¼���ķ�������ʾ��¼���
			}else if(i == 2){
				JOptionPane.showMessageDialog(null, "ע��ɹ���", "succeed", JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
//				Login_modules L_m = new Login_modules();
//				L_m.concealRegister();
//				L_m.showLogin();
			}else {
				JOptionPane.showMessageDialog(null, "ע��ɹ���", "succeed", JOptionPane.INFORMATION_MESSAGE);
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
	
	// �û���¼�����������û����������Ƿ�ƥ��
	public void SQLverify(String a,String b)
	{
		try {
			ps=ct.prepareStatement("select * from user_info_list where user_name = ? and password = ? ");
			ps.setString(1, a);
			ps.setString(2, b);
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				System.out.println("��¼�ɹ���");
				
				this.dispose();										// �رյ�¼ע�����
				
				// ���û�������Assess_modules���userName������
				Assess_modules as = new Assess_modules();
				as.userName(a);
				as.messageTabel(a);
				
				this.setVisible(false);
				
			}else
			{
				this.setVisible(false);
				thisclose = false;
				JOptionPane.showMessageDialog(null, "�û���������������������룡", "error", JOptionPane.ERROR_MESSAGE);
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
	
	// �û�ע�᷽�����鿴�û����Ƿ��ظ�
	public void ZhuceVerify(String a)
	{
		try {
			ps=ct.prepareStatement("select * from user_info_list where user_name=?");
			ps.setString(1, a);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				JOptionPane.showMessageDialog(null, "���û����Ѵ���,��ֱ�ӵ�¼���߻����û���ע��!", "error", JOptionPane.WARNING_MESSAGE);
				this.setVisible(false);								// �رյ�ǰҳ��
				Login_modules L_m = new Login_modules();
				L_m.showRegister();									// ����Login_modules������ʾע�����ķ�������ʾע�����
				L_m.concealLogin();									// ����Login_modules�������ص�¼���ķ��������ص�¼���
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
	
	// �½���Чsql��ķ���
	public void newAssesssql(String a) 
	{
		// Ϊÿ���û��������е�sql���������Ա������Ϣ��
		// sql�������������ѭ���û���+_performance_appraisal_list��
		
		String b = "_performance_appraisal_list";
		String cString = a + b;
		try {
			
			ps=ct.prepareStatement("CREATE TABLE "+cString+" (\r\n" + 
					"  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + 
					"  `staff_name` VARCHAR(45) NOT NULL COMMENT 'Ա������',\r\n" + 
					"  `staff_number` VARCHAR(45) NOT NULL COMMENT 'Ա����',\r\n" + 
					"  `normal_days` DECIMAL(10,2) NOT NULL COMMENT '��������',\r\n" + 
					"  `late_days` INT NOT NULL COMMENT '�ٵ�ʱ��',\r\n" + 
					"  `leave_days` DECIMAL(10,2) NOT NULL COMMENT '�������',\r\n" + 
					"  `absenteeism_days` DECIMAL(10,2) NOT NULL COMMENT '��������',\r\n" + 
					"  `work_hours` INT NOT NULL COMMENT '����ʱ��',\r\n" + 
					"  `work_piece` INT NOT NULL COMMENT '�����Ƽ�',\r\n" + 
					"  `work_content` INT NOT NULL COMMENT '��������',\r\n" + 
					"  `technology_improve` INT NOT NULL COMMENT '���ո���',\r\n" + 
					"  `rewards_time` INT NOT NULL COMMENT '��������',\r\n" + 
					"  `punishment_time` INT NOT NULL COMMENT '�ͷ�����',\r\n" + 
					"  `many_quarter` VARCHAR(45) NOT NULL COMMENT '�ڼ�����',\r\n" + 
					"  `quarter_class` VARCHAR(45) NOT NULL COMMENT '���ȵȼ�����',\r\n" + 
					"  `assess_result` DECIMAL(10,2) NULL COMMENT '���˽��',\r\n" + 
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
	
	// ����Ա����Ϣ�ķ���������Assess_modules����saveMessage������������ֵ����user_name + _performance_appraisal_list��Ϊ������
	// ������ֵ��Ϊsql����е�ֵ��д����У�ʵ�ֶ�̬д����¼���û���ͬ��д��ı�Ҳ��ͬ����
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
	
	// �޸�Ա����Ϣ�ķ���������Assess_modules����modigyMessage������������ֵ����user_name + _performance_appraisal_list��Ϊ������
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

	// �޸�Ա����Ϣ�ķ���������Assess_modules����modigyMessage������������ֵ����user_name + _performance_appraisal_list��Ϊ������
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