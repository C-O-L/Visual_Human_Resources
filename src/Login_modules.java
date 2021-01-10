import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.security.auth.spi.LoginModule;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// �û���¼ע�����
public class Login_modules extends JFrame implements ActionListener{

	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	
	JPanel loginInformation;										// ��¼��Ϣ��壬���ڷ����û������������������
	JPanel loginPrompt;												// ��¼��ʾ��壬���ڷ����û������������ʾ��Ϣ
	JPanel loginRegister;											// ��¼��ע����壬���ڷ���ע�ᰴť�͵�¼��ť
	JPanel loginJPanel;												// �û���¼��壬����loginJLabel
	JPanel registerInformation;										// ע����Ϣ��壬���ڷ����û����������ע����Ϣ
	JPanel helpRegister;											// ������ע����壬���ڷ��ð�����ť��ע�ᰴť
	JPanel veriflcationCodeJPanel;									// ��֤��壬���û�ȡ��֤�밴ť����֤���ı���
	JPanel passwordJPanel;											// ������壬����ע�����������ı���
	JPanel registerJPanel;											// �û�ע����壬����registerJLabel
	
	JTextField username_login;										// �û����ı��򡪡���¼���
	JPasswordField password_login;									// �����ı��򡪡���¼���
	JTextField username_register;									// �û����ı��򡪡�ע�����
	JTextField veriflcationCode_register;							// ��֤���ı��򡪡�ע�����
	JPasswordField password_register;								// �����ı��򡪡�ע�����
	JPasswordField password_registertwo;						    // ȷ�������ı��򡪡�ע�����
	
	JTextField depositTime;											// ���ʱ����ı���
	
	private JButton loginButton; 									// ��¼��ť
	private JButton register_loginButton;							// ��½����ϵ�ע�ᰴť�����֮����ת��ע�����
	private JButton helpButton;										// ������ť
	private JButton register_registerButton;						// ע������ϵ�ע�ᰴť�����֮����ת����¼����
	
	private JLabel loginJLabel;										// ���õ�¼���ͼƬ�ı�ǩ
	private JLabel registerJLabel;									// ����ע�����ͼƬ�ı�ǩ

	String time;													// ��ŵ�ǰʱ��
	
	
	// ���췽����ʵ���û���¼ע�����	
	public Login_modules() {
		
		// ���õ�¼�����û����ı���		
		username_login = new JTextField();
		username_login.setName("������3-12λ�û�����");
		// ���ý������������������ʾ����
		username_login.addFocusListener(new MyFocusListener(username_login.getName(),username_login));
		username_login.setOpaque(false);							// ��username_login�ؼ���������Ϊ͸��
		username_login.setBorder(null);								// ��username_login�ؼ�����Ϊ�ޱ߿�
		username_login.setFont(new Font("΢���ź�", Font.PLAIN, 14));	// ����username_login�����塢��ͨ����С
		// ����username_login������ɫΪ��ʯ��
		username_login.setForeground(new java.awt.Color(54, 52, 51));
		
		// ���õ�¼���������ı���
		password_login = new JPasswordField();
		password_login.setName("");
		// ���ý������������������ʾ����
		password_login.addFocusListener(new MyFocusListener(password_login.getName(),password_login));
		password_login.setOpaque(false);							// ��password_login�ؼ���������Ϊ͸��
		password_login.setBorder(null);								// ��password_login�ؼ�����Ϊ�ޱ߿�
		password_login.setFont(new Font("΢���ź�", Font.PLAIN, 14));	// ����password_login�����塢��ͨ����С
		// ����password_login������ɫΪ��ʯ��
		password_login.setForeground(new java.awt.Color(54, 52, 51));

		
		// ���õ�¼���ĵ�¼��ť
		loginButton = new JButton();
		loginButton.setContentAreaFilled(false); 					// ��loginButton��ť����Ϊ͸��
		loginButton.setBorder(null);								// ��loginButton��ť����Ϊ�ޱ߿�
		loginButton.addActionListener((ActionListener) this); 		// ��loginButton��ť����¼�����
		
		// ���õ�¼����ע�ᰴť
		register_loginButton = new JButton();
		register_loginButton.setContentAreaFilled(false); 			// ��register_loginButton��ť����Ϊ͸��
		register_loginButton.setBorder(null);						// ��register_loginButton��ť����Ϊ�ޱ߿�
		// ����¼����ע�ᰴť����¼�����
		register_loginButton.addActionListener((ActionListener) this); 			
		
		// ���õ�¼��Ϣ���
		loginInformation = new JPanel();
		loginInformation.setOpaque(false); 							// ����loginInformation͸��
		loginInformation.setLayout(new GridLayout(2, 1, 0, 25)); 	// ����loginInformationΪ���Բ��֣�����һ�У��ݼ��Ϊ25
		loginInformation.setBounds(820, 330, 150, 82); 				// ����loginInformation����λ�úʹ�С
		loginInformation.add(username_login);						// ���û����ı�����ӵ�loginInformation���
		loginInformation.add(password_login);						// �������ı�����ӵ�loginInformation���
		
		
		// ���õ�¼ע�ᰴť���
		loginRegister = new JPanel();
		loginRegister.setOpaque(false); 							// ����loginRegister͸��
		loginRegister.setLayout(new GridLayout(1, 2, 45, 0)); 		// ����loginRegisterΪ���Բ��֣�һ�����У�����Ϊ45
		loginRegister.setBounds(754, 443, 222, 29); 				// ����userPassword����λ�úʹ�С
		loginRegister.add(loginButton);								// ����¼��ť��ӵ�loginRegister���
		loginRegister.add(register_loginButton);					// ����¼�����ע�ᰴť����ӵ�loginRegister���
		
		// �����û���¼���
		loginJPanel = new JPanel();
		loginJPanel.setOpaque(false); 								// ����loginJPanel͸��
		loginJPanel.setLayout(new GridLayout(1, 1, 0, 0));			// ����loginJPanelΪ���Բ��֣�һ��һ�У��޼��
		loginJPanel.setBounds(665, 250, 400, 300);					// ����loginJPanel��λ�úʹ�С
		
		// ��ʼ��loginJLable����ʾloginInterfaceͼƬ
		loginJLabel = new JLabel(new ImageIcon("image/loginInterface.png"));
		loginJPanel.add(loginJLabel);								// ��loginJLabel��ӵ�loginJPanel����
		
/************************************************************************************************************************/
		
		// ����ע�������û����ı���		
		username_register = new JTextField();
		username_register.setOpaque(false);							// ��username_register�ؼ�����Ϊ͸��
		username_register.setBorder(null);							// ��username_register�ؼ�����Ϊ�ޱ߿�
		// ����username_register�����塢��ͨ����С
		username_register.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		// ����ע�����������ı���
		password_register = new JPasswordField();
		password_register.setOpaque(false);							// ��password_register�ؼ�����Ϊ͸��
		password_register.setBorder(null);							// ��password_register�ؼ�����Ϊ�ޱ߿�
		// ����password_register�����塢��ͨ����С
		password_register.setFont(new Font("΢���ź�", Font.PLAIN, 14));	
		
		// ����ע������ȷ�������ı���
		password_registertwo = new JPasswordField();
		password_registertwo.setOpaque(false);						// ��password_registertwo�ؼ�����Ϊ͸��
		password_registertwo.setBorder(null);						// ��password_registertwo�ؼ�����Ϊ�ޱ߿�
		// ����password_registertwo�����塢��ͨ����С
		password_registertwo.setFont(new Font("΢���ź�", Font.PLAIN, 14));	
		
		// ����ע��������֤���ı���
		veriflcationCode_register = new JTextField();
		veriflcationCode_register.setOpaque(false); 				// ��veriflcationCode_register�ؼ�����Ϊ͸��
		veriflcationCode_register.setBorder(null); 					// ��veriflcationCode_register�ؼ�����Ϊ�ޱ߿�
		// ����veriflcationCode_register�����塢б��Ӵ֡���С
		veriflcationCode_register.setFont(new Font("΢���ź�", Font.ITALIC|Font.BOLD, 16));
		veriflcationCode_register.setForeground(Color.red);			// ����veriflcationCode_register��������ɫΪ��ɫ			
		
		// ����ע�����İ�����ť
		helpButton = new JButton();
		helpButton.setContentAreaFilled(false); 					// ��helpButton��ť����Ϊ͸��
		helpButton.setBorder(null);									// ��helpButton��ť����Ϊ�ޱ߿�
		helpButton.addActionListener((ActionListener) this); 		// ��helpButton��ť����¼�����
		
		// ����ע������ע�ᰴť
		register_registerButton = new JButton();
		register_registerButton.setContentAreaFilled(false);		// ��register_registerButton��ť����Ϊ͸��
		register_registerButton.setBorder(null);					// ��register_registerButton��ť����Ϊ�ޱ߿�
		// ��register_registerButton��ť����¼�����
		register_registerButton.addActionListener((ActionListener) this);
		
		// ���ô��ʱ����ı���
		depositTime = new JTextField();
		showDate();													// ���û�ȡʱ��ķ���
		depositTime.setText(time);									// ����ȡ��ʱ������depositTime�ı�����
		
		// ����ע����Ϣ���
		registerInformation = new JPanel();
		registerInformation.setOpaque(false); 						// ����registerInformation͸��
		registerInformation.setLayout(new GridLayout(3, 1, 0, 24)); // ����registerInformationΪ���Բ��֣�����һ�У��ݼ��Ϊ24
		registerInformation.setBounds(820, 280, 150, 134); 			// ����registerInformation����λ�úʹ�С
		registerInformation.add(username_register);					// ���û����ı�����ӵ�registerInformationn���
		registerInformation.add(password_register);					// �������ı�����ӵ�registerInformationn���
		registerInformation.add(password_registertwo);				// ��ȷ�������ı�����ӵ�registerInformationn���
		
		// ������֤�����
		veriflcationCodeJPanel = new JPanel();
		veriflcationCodeJPanel.setOpaque(false);					// ����veriflcationCodeJPanel͸��
		// ����veriflcationCodeJPanelΪ���Բ��֣�һ��һ��
		veriflcationCodeJPanel.setLayout(new GridLayout(1, 1, 0, 0));
		veriflcationCodeJPanel.setBounds(754, 446, 90, 29);			// ����veriflcationCodeJPanel��λ�úʹ�С
		veriflcationCodeJPanel.add(veriflcationCode_register);		// ����֤���ı�����ӵ�veriflcationCodeJPanel
		
		// ����ע�����İ���ע�ᰴť���
		helpRegister = new JPanel();
		helpRegister.setOpaque(false); 								// ��helpRegister����Ϊ͸��
		helpRegister.setLayout(new GridLayout(1, 2, 45, 0)); 		// ����helpRegisterΪ���Բ��֣�һ�����У�����Ϊ45
		helpRegister.setBounds(754, 491, 222, 31);					// ����helpRegister��λ�úʹ�С
		helpRegister.add(helpButton);								// ��������ť��ӵ�helpRegister
		helpRegister.add(register_registerButton);					// ��ע������ע�ᰴť��ӵ�helpRegister
		
		// �����û�ע�����
		registerJPanel = new JPanel();
		registerJPanel.setOpaque(false); 							// ����registerJPanel͸��
		registerJPanel.setLayout(new GridLayout(1, 1, 0, 0));		// ����registerJPanelΪ���Բ��֣�һ��һ�У��޼��
		registerJPanel.setBounds(665, 200, 400, 400);				// ����registerJPanel��λ�úʹ�С
				
		// ��ʼ��registerJLabel����ʾregisterInterfaceͼƬ
		registerJLabel = new JLabel(new ImageIcon("image/registerInterface.png"));
		registerJPanel.add(registerJLabel);							// ��registerJLabel��ӵ�registerJPanel����
		
/************************************************************************************************************************/
		
		this.setTitle("��Ч����ϵͳ");									// ����ϵͳ��ǩ
		ImageIcon icon = new ImageIcon("image\\icon.png");			// ����ϵͳͼ��
		this.setIconImage(icon.getImage());							// ����JFrame���ڱ���ͼ��
	    this.setLayout(null);										// ��ղ��ֹ�����
		this.setSize(1014, 592);									// ���ô��ڿ��
		this.setLocationRelativeTo(null);							// ���������ʾ
	    
	    setWindows();												// ����setWindows���������ô���
	    Container Bottom_container = getContentPane();				// ��ʼ��Bottom_container����
	    
	    Bottom_container.add(loginInformation);						// ��loginInformation��ӵ�Bottom_container����
//	    Bottom_container.add(loginPrompt);
	    Bottom_container.add(loginRegister);						// ��loginRegister��ӵ�Bottom_container����
	    Bottom_container.add(loginJPanel);							// ��loginJPanel��ӵ�Bottom_container���� 
	    
	    Bottom_container.add(registerInformation);
	    Bottom_container.add(veriflcationCodeJPanel);
	    Bottom_container.add(helpRegister);
	    Bottom_container.add(registerJPanel);
	    
	    this.setResizable(false);									// �����С����Ϊ���ɱ�
	    this.setVisible(true);										// ��ʾ����
	
	    concealRegister();											// ����ע�����
	  
	}
	
/************************************************************************************************************************/
	
	// ���ô��ڵķ���
	public void setWindows(){
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("image/background.png");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }

	
	// �¼���������
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == register_loginButton) {					// ������µ�¼�����ע�ᰴť
			concealLogin();											// ���ص�¼����
			showRegister();											// ��ʾע�����
		}else if(e.getSource() == loginButton) {					// ������µ�¼����ĵ�¼��ť
			this.login();											// ���õ�¼����
//			this.setVisible(false); 								// �رյ�ǰҳ��
		}else if(e.getSource() == register_registerButton) {		// �������ע������ע�ᰴť
			this.register();										// ����ע�᷽��
//			this.setVisible(false);									// �رյ�ǰҳ��
			
		}
	}
	
	// ע�᷽��	
	public void register() {
    	String regex1 = "\\w{3,12}"; 								// ����3-12λ�û��������ֻ�����ĸ��ϣ�
 		boolean flag1 = username_register.getText().matches(regex1);// ���û������Ϊbooleanֵ�������ж�
 		
 		String regex2 = "\\w{6,12}"; 								// ����6-12λ���루���ֻ�����ĸ��ϣ�
 		boolean flag2 = password_register.getText().matches(regex2);// ��������Ϊbooleanֵ�������ж�
 		
// 		String regex3 = "\\w{6,12}";								// ����6-12λ���룬ȷ�����룬��Ҫ��regex2һ��
// 		boolean flag3 = password_registertwo.getText().matches(regex3);
 		
 		if(flag1 == false)											// ����û�����ʽ����ȷ
 		{
 			JOptionPane.showMessageDialog(null, "�û�����ʽ����ȷ" + "\n" + "���������룡", "error", JOptionPane.WARNING_MESSAGE);
 			username_register.setText("");							// ���username_register�ı���
 		}
 		else if(flag2 == false) {									// ��������ʽ����ȷ
 			JOptionPane.showMessageDialog(null, "�����ʽ����ȷ" + "\n" + "���������룡", "error", JOptionPane.WARNING_MESSAGE);
            password_register.setText("");							// ���password_register�ı���
            password_registertwo.setText("");						// ���password_registertwo�ı���
 		}
 		// ����������벻һ��
 		else if(!password_register.getText().equals(password_registertwo.getText())) {	
 			JOptionPane.showMessageDialog(null, "�����������벻һ��" + "\n" + "���������룡", "error", JOptionPane.WARNING_MESSAGE);
 			password_register.setText("");							// ���password_register�ı���
 			password_registertwo.setText("");						// ���password_registertwo�ı���
 		}
 		else
 		{			
 		// ����Mysql���ע�᷽��������֤
 		Mysql co = new Mysql();
 		    co.ConnectSQL();
 		    co.ZhuceVerify(username_register.getText()); 			// ��username_register�е����ݴ���Mysql���ZhuceVerify������
 		    
 		    if(co.registeredBoolean == true) {						// ����жϿ���ע��
	 		    // ��username_register��password_register�е����ݴ���Mysql���UserRegis�����н���ע��
	 		    co.UserRegis(username_register.getText(),password_register.getText(),depositTime.getText());
 		    }
 		    
 		    if(co.newsqlBoolean == true) {							// ����жϿ����½�sql��
 		    	this.setVisible(false);
 		    	
 		    	// ��username_register�е����ݴ���Mysql���newAssesssql�������½�sql��
 		    	co.newAssesssql(username_register.getText());
 		    	
 		    }
 		    
 		    this.username_register.setText("");						// ���username_register������
 		    this.password_register.setText("");						// ���password_register������
 		    this.password_registertwo.setText(""); 					// ���password_registertwo������
 		    this.depositTime.setText(""); 							// ���depositTime������
 		}
	}

	// ��¼����
	public void login() {
		
		String regex1 = "\\w{3,12}"; 								// ����3-12λ�û��������ֻ�����ĸ��ϣ�
 		boolean flag1 = username_login.getText().matches(regex1);	// ���û������Ϊbooleanֵ�������ж�
 		
 		String regex2 = "\\w{6,12}"; 								// ����6-12λ���루���ֻ�����ĸ��ϣ�
 		boolean flag2 = password_login.getText().matches(regex2);	// ��������Ϊbooleanֵ�������ж�
 		
 		if(flag1 == false)											// ����û�����ʽ����ȷ
 		{
 			JOptionPane.showMessageDialog(null, "�û�����ʽ����ȷ" + "\n" + "���������룡", "error", JOptionPane.WARNING_MESSAGE);
 			username_login.setText("");								// ���username_login�ı���
 			password_login.setText("");								// ���password_login�ı���
 		}
 		else if(flag2 == false) {									// ��������ʽ����ȷ
 			JOptionPane.showMessageDialog(null, "�����ʽ����ȷ" + "\n" + "���������룡", "error", JOptionPane.WARNING_MESSAGE);
            password_login.setText("");								// ���password_login�ı���
 		}
 		else
 		{	
			Mysql s = new Mysql();
			s.ConnectSQL();
			// ��username_login��password_login�е����ݴ���Mysql���е�SQLverify������
			s.SQLverify(username_login.getText(), password_login.getText());
			
			this.username_login.setText("");
			this.password_login.setText("");
			
			if(s.thisclose == true) {								// �����¼�ɹ��رյ�ǰ����
				this.setVisible(false);
			}
			
 		}
	}
	
	// ��ʾ��¼����ķ���
	public void showLogin() {
		loginInformation.setVisible(true);
	    loginRegister.setVisible(true);
	    loginJLabel.setVisible(true);
	}
	
    // ���ص�¼����ķ���
	public void concealLogin() {
		loginInformation.setVisible(false);
	    loginRegister.setVisible(false);
	    loginJLabel.setVisible(false);
	}
	
	// ��ʾע�����ķ���
	public void showRegister() {
		registerInformation.setVisible(true);
	    veriflcationCodeJPanel.setVisible(true);
	    helpRegister.setVisible(true);
	    registerJPanel.setVisible(true);
	}
	
	// ����ע�����ķ���
	public void concealRegister() {
		registerInformation.setVisible(false);
	    veriflcationCodeJPanel.setVisible(false);
	    helpRegister.setVisible(false);
	    registerJPanel.setVisible(false);
	}

	
	// ��ȡʱ��ķ���
	public void showDate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  	// �������ڸ�ʽ
		time = df.format(new Date()); 									// new Date()Ϊ��ȡ��ǰϵͳʱ��
//		System.out.println(time);								
	}

	public static void main(String arg[]) {
		// TODO Auto-generated method stub
		new Login_modules();
	}
}
