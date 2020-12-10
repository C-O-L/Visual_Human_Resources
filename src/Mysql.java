import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.Serializable;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Mysql extends Login_modules implements Serializable{
	
	Connection ct;
	PreparedStatement ps;
	ResultSet rs;
	
	//user_paswd
	String user,passwd;
	
	// �������ݿ�ķ���
	public void ConnectSQL()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 						//ע��JDBC������
			//�������ݿ�
			ct=DriverManager.getConnection("jdbc:mysql://localhost/visual_human_resources?user=root&password=980519"); 
			
			System.out.println("���ӳɹ���");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// �û�ע��ķ���������û����������Ƿ�����
	public void UserRegis(String a,String b)
	{
		
		try {
			ps=ct.prepareStatement("insert into user_info_list values(?,?)");
			ps.setString(1,a);
			ps.setString(2,b);
			
			
			int i=ps.executeUpdate();
			if(i==1)
			{
				JOptionPane.showMessageDialog(null, "�˺Ŵ���","���������룡",JOptionPane.WARNING_MESSAGE);   
			}else
			{
				JOptionPane.showMessageDialog(null, "�������","���������룡",JOptionPane.ERROR_MESSAGE);
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
			ps=ct.prepareStatement("select * from user_info_list where user_name=? and password=? ");
			ps.setString(1, a);
			ps.setString(2, b);
			
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				user = rs.getString(1);
				passwd = rs.getString(2);
				//JOptionPane.showMessageDialog(null, "", "", JOptionPane.WARNING_MESSAGE);
				System.out.println("��¼�ɹ���");
				//System.out.println(user + "\t" + passwd + "\t");
				   
				
			}else
			{
				JOptionPane.showMessageDialog(null, "", "", JOptionPane.ERROR_MESSAGE);
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
			}else
			{
           
//				CosMsFrame cf=new CosMsFrame();
//				this.UserRegis(cf.jtf.getText(),cf.jpf.getText());
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