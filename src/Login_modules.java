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

// 用户登录注册的类
public class Login_modules extends JFrame implements ActionListener{

	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	
	JPanel loginInformation;										// 登录信息面板，用于放置用户名输入框和密码输入框
	JPanel loginPrompt;												// 登录提示面板，用于放置用户名及密码的提示信息
	JPanel loginRegister;											// 登录、注册面板，用于放置注册按钮和登录按钮
	JPanel loginJPanel;												// 用户登录面板，放置loginJLabel
	JPanel registerInformation;										// 注册信息面板，用于放置用户名、密码等注册信息
	JPanel helpRegister;											// 帮助、注册面板，用于放置帮助按钮和注册按钮
	JPanel veriflcationCodeJPanel;									// 验证面板，放置获取验证码按钮和验证码文本框
	JPanel passwordJPanel;											// 密码面板，放置注册界面的密码文本框
	JPanel registerJPanel;											// 用户注册面板，放置registerJLabel
	
	JTextField username_login;										// 用户名文本框——登录面板
	JPasswordField password_login;									// 密码文本框——登录面板
	JTextField username_register;									// 用户名文本框——注册面板
	JTextField veriflcationCode_register;							// 验证码文本框——注册面板
	JPasswordField password_register;								// 密码文本框——注册面板
	JPasswordField password_registertwo;						    // 确认密码文本框——注册面板
	
	JTextField depositTime;											// 存放时间的文本框
	
	private JButton loginButton; 									// 登录按钮
	private JButton register_loginButton;							// 登陆面板上的注册按钮，点击之后跳转到注册界面
	private JButton helpButton;										// 帮助按钮
	private JButton register_registerButton;						// 注册面板上的注册按钮，点击之后跳转到登录界面
	
	private JLabel loginJLabel;										// 放置登录面板图片的标签
	private JLabel registerJLabel;									// 放置注册面板图片的标签

	String time;													// 存放当前时间
	
	
	// 构造方法，实现用户登录注册界面	
	public Login_modules() {
		
		// 设置登录面板的用户名文本框		
		username_login = new JTextField();
		username_login.setName("请输入3-12位用户名：");
		// 调用焦点监听方法类设置提示文字
		username_login.addFocusListener(new MyFocusListener(username_login.getName(),username_login));
		username_login.setOpaque(false);							// 将username_login控件背景设置为透明
		username_login.setBorder(null);								// 将username_login控件设置为无边框
		username_login.setFont(new Font("微软雅黑", Font.PLAIN, 14));	// 设置username_login的字体、普通、大小
		// 设置username_login字体颜色为长石灰
		username_login.setForeground(new java.awt.Color(54, 52, 51));
		
		// 设置登录面板的密码文本框
		password_login = new JPasswordField();
		password_login.setName("");
		// 调用焦点监听方法类设置提示文字
		password_login.addFocusListener(new MyFocusListener(password_login.getName(),password_login));
		password_login.setOpaque(false);							// 将password_login控件背景设置为透明
		password_login.setBorder(null);								// 将password_login控件设置为无边框
		password_login.setFont(new Font("微软雅黑", Font.PLAIN, 14));	// 设置password_login的字体、普通、大小
		// 设置password_login字体颜色为长石灰
		password_login.setForeground(new java.awt.Color(54, 52, 51));

		
		// 设置登录面板的登录按钮
		loginButton = new JButton();
		loginButton.setContentAreaFilled(false); 					// 将loginButton按钮设置为透明
		loginButton.setBorder(null);								// 将loginButton按钮设置为无边框
		loginButton.addActionListener((ActionListener) this); 		// 给loginButton按钮添加事件监听
		
		// 设置登录面板的注册按钮
		register_loginButton = new JButton();
		register_loginButton.setContentAreaFilled(false); 			// 将register_loginButton按钮设置为透明
		register_loginButton.setBorder(null);						// 将register_loginButton按钮设置为无边框
		// 给登录面板的注册按钮添加事件监听
		register_loginButton.addActionListener((ActionListener) this); 			
		
		// 设置登录信息面板
		loginInformation = new JPanel();
		loginInformation.setOpaque(false); 							// 设置loginInformation透明
		loginInformation.setLayout(new GridLayout(2, 1, 0, 25)); 	// 设置loginInformation为绝对布局，两行一列，纵间距为25
		loginInformation.setBounds(820, 330, 150, 82); 				// 设置loginInformation面板的位置和大小
		loginInformation.add(username_login);						// 将用户名文本框添加到loginInformation面板
		loginInformation.add(password_login);						// 将密码文本框添加到loginInformation面板
		
		
		// 设置登录注册按钮面板
		loginRegister = new JPanel();
		loginRegister.setOpaque(false); 							// 设置loginRegister透明
		loginRegister.setLayout(new GridLayout(1, 2, 45, 0)); 		// 设置loginRegister为绝对布局，一行两列，横间距为45
		loginRegister.setBounds(754, 443, 222, 29); 				// 设置userPassword面板的位置和大小
		loginRegister.add(loginButton);								// 将登录按钮添加到loginRegister面板
		loginRegister.add(register_loginButton);					// 将登录界面的注册按钮框添加到loginRegister面板
		
		// 设置用户登录面板
		loginJPanel = new JPanel();
		loginJPanel.setOpaque(false); 								// 设置loginJPanel透明
		loginJPanel.setLayout(new GridLayout(1, 1, 0, 0));			// 设置loginJPanel为绝对布局，一行一列，无间距
		loginJPanel.setBounds(665, 250, 400, 300);					// 设置loginJPanel的位置和大小
		
		// 初始化loginJLable，显示loginInterface图片
		loginJLabel = new JLabel(new ImageIcon("image/loginInterface.png"));
		loginJPanel.add(loginJLabel);								// 将loginJLabel添加到loginJPanel容器
		
/************************************************************************************************************************/
		
		// 设置注册面板的用户名文本框		
		username_register = new JTextField();
		username_register.setOpaque(false);							// 将username_register控件设置为透明
		username_register.setBorder(null);							// 将username_register控件设置为无边框
		// 设置username_register的字体、普通、大小
		username_register.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		// 设置注册面板的密码文本框
		password_register = new JPasswordField();
		password_register.setOpaque(false);							// 将password_register控件设置为透明
		password_register.setBorder(null);							// 将password_register控件设置为无边框
		// 设置password_register的字体、普通、大小
		password_register.setFont(new Font("微软雅黑", Font.PLAIN, 14));	
		
		// 设置注册面板的确认密码文本框
		password_registertwo = new JPasswordField();
		password_registertwo.setOpaque(false);						// 将password_registertwo控件设置为透明
		password_registertwo.setBorder(null);						// 将password_registertwo控件设置为无边框
		// 设置password_registertwo的字体、普通、大小
		password_registertwo.setFont(new Font("微软雅黑", Font.PLAIN, 14));	
		
		// 设置注册面板的验证码文本框
		veriflcationCode_register = new JTextField();
		veriflcationCode_register.setOpaque(false); 				// 将veriflcationCode_register控件设置为透明
		veriflcationCode_register.setBorder(null); 					// 将veriflcationCode_register控件设置为无边框
		// 设置veriflcationCode_register的字体、斜体加粗、大小
		veriflcationCode_register.setFont(new Font("微软雅黑", Font.ITALIC|Font.BOLD, 16));
		veriflcationCode_register.setForeground(Color.red);			// 设置veriflcationCode_register的字体颜色为红色			
		
		// 设置注册面板的帮助按钮
		helpButton = new JButton();
		helpButton.setContentAreaFilled(false); 					// 将helpButton按钮设置为透明
		helpButton.setBorder(null);									// 将helpButton按钮设置为无边框
		helpButton.addActionListener((ActionListener) this); 		// 给helpButton按钮添加事件监听
		
		// 设置注册面板的注册按钮
		register_registerButton = new JButton();
		register_registerButton.setContentAreaFilled(false);		// 将register_registerButton按钮设置为透明
		register_registerButton.setBorder(null);					// 将register_registerButton按钮设置为无边框
		// 给register_registerButton按钮添加事件监听
		register_registerButton.addActionListener((ActionListener) this);
		
		// 设置存放时间的文本框
		depositTime = new JTextField();
		showDate();													// 调用获取时间的方法
		depositTime.setText(time);									// 将获取的时间存放在depositTime文本框中
		
		// 设置注册信息面板
		registerInformation = new JPanel();
		registerInformation.setOpaque(false); 						// 设置registerInformation透明
		registerInformation.setLayout(new GridLayout(3, 1, 0, 24)); // 设置registerInformation为绝对布局，三行一列，纵间距为24
		registerInformation.setBounds(820, 280, 150, 134); 			// 设置registerInformation面板的位置和大小
		registerInformation.add(username_register);					// 将用户名文本框添加到registerInformationn面板
		registerInformation.add(password_register);					// 将密码文本框添加到registerInformationn面板
		registerInformation.add(password_registertwo);				// 将确认密码文本框添加到registerInformationn面板
		
		// 设置验证码面板
		veriflcationCodeJPanel = new JPanel();
		veriflcationCodeJPanel.setOpaque(false);					// 设置veriflcationCodeJPanel透明
		// 设置veriflcationCodeJPanel为绝对布局，一行一列
		veriflcationCodeJPanel.setLayout(new GridLayout(1, 1, 0, 0));
		veriflcationCodeJPanel.setBounds(754, 446, 90, 29);			// 设置veriflcationCodeJPanel的位置和大小
		veriflcationCodeJPanel.add(veriflcationCode_register);		// 将验证码文本框添加到veriflcationCodeJPanel
		
		// 设置注册界面的帮助注册按钮面板
		helpRegister = new JPanel();
		helpRegister.setOpaque(false); 								// 将helpRegister设置为透明
		helpRegister.setLayout(new GridLayout(1, 2, 45, 0)); 		// 设置helpRegister为绝对布局，一行两列，横间距为45
		helpRegister.setBounds(754, 491, 222, 31);					// 设置helpRegister的位置和大小
		helpRegister.add(helpButton);								// 将帮助按钮添加到helpRegister
		helpRegister.add(register_registerButton);					// 将注册界面的注册按钮添加到helpRegister
		
		// 设置用户注册面板
		registerJPanel = new JPanel();
		registerJPanel.setOpaque(false); 							// 设置registerJPanel透明
		registerJPanel.setLayout(new GridLayout(1, 1, 0, 0));		// 设置registerJPanel为绝对布局，一行一列，无间距
		registerJPanel.setBounds(665, 200, 400, 400);				// 设置registerJPanel的位置和大小
				
		// 初始化registerJLabel，显示registerInterface图片
		registerJLabel = new JLabel(new ImageIcon("image/registerInterface.png"));
		registerJPanel.add(registerJLabel);							// 将registerJLabel添加到registerJPanel容器
		
/************************************************************************************************************************/
		
		this.setTitle("绩效考核系统");									// 设置系统标签
		ImageIcon icon = new ImageIcon("image\\icon.png");			// 设置系统图标
		this.setIconImage(icon.getImage());							// 设置JFrame窗口标题图标
	    this.setLayout(null);										// 清空布局管理器
		this.setSize(1014, 592);									// 设置窗口宽高
		this.setLocationRelativeTo(null);							// 窗体居中显示
	    
	    setWindows();												// 调用setWindows方法，设置窗口
	    Container Bottom_container = getContentPane();				// 初始化Bottom_container容器
	    
	    Bottom_container.add(loginInformation);						// 将loginInformation添加到Bottom_container容器
//	    Bottom_container.add(loginPrompt);
	    Bottom_container.add(loginRegister);						// 将loginRegister添加到Bottom_container容器
	    Bottom_container.add(loginJPanel);							// 将loginJPanel添加到Bottom_container容器 
	    
	    Bottom_container.add(registerInformation);
	    Bottom_container.add(veriflcationCodeJPanel);
	    Bottom_container.add(helpRegister);
	    Bottom_container.add(registerJPanel);
	    
	    this.setResizable(false);									// 窗体大小设置为不可变
	    this.setVisible(true);										// 显示窗体
	
	    concealRegister();											// 隐藏注册界面
	  
	}
	
/************************************************************************************************************************/
	
	// 设置窗口的方法
	public void setWindows(){
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("image/background.png");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }

	
	// 事件监听方法
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == register_loginButton) {					// 如果按下登录界面的注册按钮
			concealLogin();											// 隐藏登录界面
			showRegister();											// 显示注册界面
		}else if(e.getSource() == loginButton) {					// 如果按下登录界面的登录按钮
			this.login();											// 调用登录方法
//			this.setVisible(false); 								// 关闭当前页面
		}else if(e.getSource() == register_registerButton) {		// 如果按下注册界面的注册按钮
			this.register();										// 调用注册方法
//			this.setVisible(false);									// 关闭当前页面
			
		}
	}
	
	// 注册方法	
	public void register() {
    	String regex1 = "\\w{3,12}"; 								// 输入3-12位用户名（数字或者字母组合）
 		boolean flag1 = username_register.getText().matches(regex1);// 将用户名标记为boolean值，方便判断
 		
 		String regex2 = "\\w{6,12}"; 								// 输入6-12位密码（数字或者字母组合）
 		boolean flag2 = password_register.getText().matches(regex2);// 将密码标记为boolean值，方便判断
 		
// 		String regex3 = "\\w{6,12}";								// 输入6-12位密码，确认密码，需要与regex2一致
// 		boolean flag3 = password_registertwo.getText().matches(regex3);
 		
 		if(flag1 == false)											// 如果用户名格式不正确
 		{
 			JOptionPane.showMessageDialog(null, "用户名格式不正确" + "\n" + "请重新输入！", "error", JOptionPane.WARNING_MESSAGE);
 			username_register.setText("");							// 清空username_register文本框
 		}
 		else if(flag2 == false) {									// 如果密码格式不正确
 			JOptionPane.showMessageDialog(null, "密码格式不正确" + "\n" + "请重新输入！", "error", JOptionPane.WARNING_MESSAGE);
            password_register.setText("");							// 清空password_register文本框
            password_registertwo.setText("");						// 清空password_registertwo文本框
 		}
 		// 如果两次密码不一致
 		else if(!password_register.getText().equals(password_registertwo.getText())) {	
 			JOptionPane.showMessageDialog(null, "两次密码输入不一致" + "\n" + "请重新输入！", "error", JOptionPane.WARNING_MESSAGE);
 			password_register.setText("");							// 清空password_register文本框
 			password_registertwo.setText("");						// 清空password_registertwo文本框
 		}
 		else
 		{			
 		// 调用Mysql类的注册方法进行验证
 		Mysql co = new Mysql();
 		    co.ConnectSQL();
 		    co.ZhuceVerify(username_register.getText()); 			// 将username_register中的内容传到Mysql类的ZhuceVerify方法中
 		    
 		    if(co.registeredBoolean == true) {						// 如果判断可以注册
	 		    // 将username_register和password_register中的内容传到Mysql类的UserRegis方法中进行注册
	 		    co.UserRegis(username_register.getText(),password_register.getText(),depositTime.getText());
 		    }
 		    
 		    if(co.newsqlBoolean == true) {							// 如果判断可以新建sql表
 		    	this.setVisible(false);
 		    	
 		    	// 将username_register中的内容传到Mysql类的newAssesssql方法中新建sql表
 		    	co.newAssesssql(username_register.getText());
 		    	
 		    }
 		    
 		    this.username_register.setText("");						// 清空username_register的内容
 		    this.password_register.setText("");						// 清空password_register的内容
 		    this.password_registertwo.setText(""); 					// 清空password_registertwo的内容
 		    this.depositTime.setText(""); 							// 清空depositTime的内容
 		}
	}

	// 登录方法
	public void login() {
		
		String regex1 = "\\w{3,12}"; 								// 输入3-12位用户名（数字或者字母组合）
 		boolean flag1 = username_login.getText().matches(regex1);	// 将用户名标记为boolean值，方便判断
 		
 		String regex2 = "\\w{6,12}"; 								// 输入6-12位密码（数字或者字母组合）
 		boolean flag2 = password_login.getText().matches(regex2);	// 将密码标记为boolean值，方便判断
 		
 		if(flag1 == false)											// 如果用户名格式不正确
 		{
 			JOptionPane.showMessageDialog(null, "用户名格式不正确" + "\n" + "请重新输入！", "error", JOptionPane.WARNING_MESSAGE);
 			username_login.setText("");								// 清空username_login文本框
 			password_login.setText("");								// 清空password_login文本框
 		}
 		else if(flag2 == false) {									// 如果密码格式不正确
 			JOptionPane.showMessageDialog(null, "密码格式不正确" + "\n" + "请重新输入！", "error", JOptionPane.WARNING_MESSAGE);
            password_login.setText("");								// 清空password_login文本框
 		}
 		else
 		{	
			Mysql s = new Mysql();
			s.ConnectSQL();
			// 将username_login和password_login中的内容传到Mysql类中的SQLverify方法中
			s.SQLverify(username_login.getText(), password_login.getText());
			
			this.username_login.setText("");
			this.password_login.setText("");
			
			if(s.thisclose == true) {								// 如果登录成功关闭当前窗口
				this.setVisible(false);
			}
			
 		}
	}
	
	// 显示登录界面的方法
	public void showLogin() {
		loginInformation.setVisible(true);
	    loginRegister.setVisible(true);
	    loginJLabel.setVisible(true);
	}
	
    // 隐藏登录界面的方法
	public void concealLogin() {
		loginInformation.setVisible(false);
	    loginRegister.setVisible(false);
	    loginJLabel.setVisible(false);
	}
	
	// 显示注册界面的方法
	public void showRegister() {
		registerInformation.setVisible(true);
	    veriflcationCodeJPanel.setVisible(true);
	    helpRegister.setVisible(true);
	    registerJPanel.setVisible(true);
	}
	
	// 隐藏注册界面的方法
	public void concealRegister() {
		registerInformation.setVisible(false);
	    veriflcationCodeJPanel.setVisible(false);
	    helpRegister.setVisible(false);
	    registerJPanel.setVisible(false);
	}

	
	// 获取时间的方法
	public void showDate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  	// 设置日期格式
		time = df.format(new Date()); 									// new Date()为获取当前系统时间
//		System.out.println(time);								
	}

	public static void main(String arg[]) {
		// TODO Auto-generated method stub
		new Login_modules();
	}
}
