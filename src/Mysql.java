
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

	public boolean registeredBoolean = false; 								// �����ж��Ƿ����ע��
	public boolean newsqlBoolean = false;									// �����ж��Ƿ�����½�sql��
	
	//user_paswd
	String user_name, password;
	
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
			e.printStackTrace();
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
//				user_name = rs.getString(2);						// �ڶ�����user_name��
//				password = rs.getString(3);							// ��������password��
				//JOptionPane.showMessageDialog(null, "", "", JOptionPane.WARNING_MESSAGE);
				System.out.println("��¼�ɹ���");
				this.setVisible(false);		
				//System.out.println(user + "\t" + passwd + "\t");
			}else
			{
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
	
	// �û�ע�᷽�����鿴�û����Ƿ��ظ�
	public void ZhuceVerify(String a)
	{
		try {
			ps=ct.prepareStatement("select * from user_info_list where user_name=?");
			ps.setString(1, a);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				JOptionPane.showMessageDialog(null, "���û����Ѵ���", "��ֱ�ӵ�¼���߻����û���ע��", JOptionPane.WARNING_MESSAGE);
				this.setVisible(false);								// �رյ�ǰҳ��
				Login_modules L_m = new Login_modules();
				L_m.showRegister();									// ����Login_modules������ʾע�����ķ�������ʾע�����
				L_m.concealLogin();									// ����Login_modules�������ص�¼���ķ��������ص�¼���
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
	
	// �½���Чsql��ķ���
	public void newAssesssql(String a) 
	{
		
	}
}