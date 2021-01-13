import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


// 进行绩效考核的类
public class Assess_modules extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel usernameJPanel;											// 放置个人中心按钮的面板
	JPanel left_functionJPanel;										// 左侧的功能面板，放置功能按钮
	JPanel search_boxJPanel;										// 放置搜索输入框的面板
	JPanel search_buttonJPanel;										// 放置搜索按钮的面板
	JPanel addInformation_windowJPanel;								// 放置添add_windowJLabel的面板
	JPanel add_nameAndnumJPanel;									// 放置姓名、工号文本框的面板
	JPanel add_otherInformationJPanel;								// 放置除姓名和工号之外的添加信息的面板
	JPanel add_buttonJPanel;										// 放置添加窗口中分析和保存两个按钮的面板
	JPanel add_closeJPanel;											// 放置添加窗口中关闭按钮的面板
	JPanel add_textJPanel;											// 放置添加窗口文字标签的面板
	JPanel plan_windowJPanel;										// 放置目标卡窗口的面板
	JPanel plan_textJPanel;											// 放置目标卡窗口文字标签的面板
	JPanel plan_textFieldJPanel;									// 放置目标卡窗口文本框的面板
	JPanel plan_buttonJPanel;										// 放置目标卡窗口按钮的面板
	
	JScrollPane assess_tabelJScrollPane;							// 放置员工信息表的滚动面板
	JTable assess_messageJTable;									// 员工信息表
	
	JLabel add_windowJLabel;										// 放置添加界面图片的标签
	JLabel nameJLabel;												// 员工姓名标签
	JLabel jobNumberJLabel;											// 工号标签
	JLabel normalDaysJLabel;										// 正常天数标签
	JLabel lateDaysJLabel;											// 迟到天数标签
	JLabel leaveDaysJLabel;											// 请假天数标签
	JLabel absenteeismDaysJLabel;									// 旷工天数标签
	JLabel workHoursJLabel;											// 工作时长标签
	JLabel workPieceJLabel;											// 工作计件标签
	JLabel jobContentJLabel;										// 工作质量标签
	JLabel processImproveJLabel;									// 工艺改善标签
	JLabel awardNumberJLabel;										// 奖励次数标签
	JLabel punishmentNumberJLabel;									// 惩罚次数标签
	JLabel manyQuartersJLabel;										// 第几季度标签
	JLabel quarterClassJLabel;										// 季度等级标签
	JLabel plan_windowJLabel;										// 放置目标卡图片的标签
	JLabel plan_hoursJLabel;										// 目标卡目标工时标签
	JLabel plan_pieceJLabel;										// 目标卡目标件数标签
	JLabel plan_contentJLabel;										// 目标卡目标质量标签
	
	JTextField searchField;											// 搜索文本框
	JTextField nameField;											// 员工姓名文本框
	JTextField jobNumberField;										// 工号文本框
	JTextField normalDaysField;										// 正常天数文本框
	JTextField lateDaysField;										// 迟到天数文本框
	JTextField leaveDaysField;										// 请假天数文本框
	JTextField absenteeismDaysField;								// 旷工天数文本框
	JTextField workHoursField;										// 工作时长文本框
	JTextField workPieceField;										// 工作计件文本框
	JTextField awardNumberField;									// 奖励次数文本框
	JTextField punishmentNumberField;								// 惩罚次数文本框
	JTextField manyQuartersField;									// 第几季度文本框
	JTextField plan_hoursField;										// 目标卡目标工时文本框
	JTextField plan_pieceField;										// 目标卡目标件数文本框
	JTextField plan_contentField;									// 目标卡目标质量文本框
	
	JComboBox<String> jobContentBox;										// 工作质量下拉框
	JComboBox<String> processImproveBox;									// 工艺改善下拉框
	JComboBox<String> quarterClassBox;										// 季度等级下拉框
	
	private JButton usernameButton = new JButton();									// 用户名按钮，在界面中显示登录的用户名，点击后查看个人中心
	private JButton addButton;										// 添加按钮
	private JButton modifyButton;									// 修改按钮
	private JButton deleteButton;									// 删除按钮
	private JButton analyseButton;									// 分析按钮
	private JButton planButton;										// 目标卡按钮
	private JButton searchButton;									// 搜索按钮
	private JButton add_analyseButton;								// 添加界面的分析按钮
	private JButton add_saveButton;									// 添加界面的保存按钮
	private JButton add_closeButton;								// 添加界面的关闭按钮
	private JButton plan_okButton;									// 目标卡界面的确定按钮
	
	public String usernameString;									// 存储用户名
	
	
	
	String id; String staff_name; String staff_number; String normal_days; String late_days; 
	String leave_days; String absenteeism_days; String work_hours; String work_piece; 
	String work_content; String technology_improve; String rewards_time; 
	String punishment_time; String many_quarter; String quarter_class; String assess_result;

	// 构造方法
	public Assess_modules() {
		
//		左侧功能按钮***********************************************************************************************************************************************************
		
		// 设置添加按钮
		addButton = new JButton("    添 加    ");
		addButton.setContentAreaFilled(false); 						// 将添加按钮设置为透明
		addButton.setBorder(null);									// 将添加按钮设置为无边框
		addButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));		// 设置添加按钮的字体属性
		addButton.setForeground(new java.awt.Color(255, 255, 255));	// 设置添加按钮的字体颜色
		addButton.addActionListener((ActionListener) this);			// 给添加按钮添加事件监听
		
		// 设置修改按钮
		modifyButton = new JButton("    修 改    ");
		modifyButton.setContentAreaFilled(false); 					// 将修改按钮设置为透明
		modifyButton.setBorder(null);								// 将修改按钮设置为无边框
		modifyButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));		// 设置修改按钮的字体属性
		// 设置修改按钮的字体颜色
		modifyButton.setForeground(new java.awt.Color(255, 255, 255));	
		modifyButton.addActionListener((ActionListener) this);		// 给修改按钮添加事件监听
		
		// 设置删除按钮
		deleteButton = new JButton("    删 除    ");
		deleteButton.setContentAreaFilled(false); 					// 将删除按钮设置为透明
		deleteButton.setBorder(null);								// 将删除按钮设置为无边框
		deleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));		// 设置删除按钮的字体属性
		// 设置删除按钮的字体颜色
		deleteButton.setForeground(new java.awt.Color(255, 255, 255));	
		deleteButton.addActionListener((ActionListener) this);		// 给删除按钮添加事件监听
		
		// 设置分析按钮
		analyseButton = new JButton("    分 析    ");
		analyseButton.setContentAreaFilled(false); 					// 将分析按钮设置为透明
		analyseButton.setBorder(null);								// 将分析按钮设置为无边框
		analyseButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));	// 设置分析按钮的字体属性
		// 设置分析按钮的字体颜色
		analyseButton.setForeground(new java.awt.Color(255, 255, 255));	
		analyseButton.addActionListener((ActionListener) this);		// 给分析按钮添加事件监听
		
		// 设置目标卡按钮
		planButton = new JButton("    目 标 卡    ");
		planButton.setContentAreaFilled(false); 					// 将目标卡按钮设置为透明
		planButton.setBorder(null);									// 将目标卡按钮设置为无边框
		planButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));		// 设置目标卡按钮的字体属性
		// 设置目标卡按钮的字体颜色
		planButton.setForeground(new java.awt.Color(255, 255, 255));	
		planButton.addActionListener((ActionListener) this);		// 给分析按钮添加事件监听
		
//		搜索***************************************************************************************************************************************************************************
		
		// 设置搜索文本框
		searchField = new JTextField();
		searchField.setName("请输入搜索内容：");
		// 调用焦点监听方法类设置提示文字
		searchField.addFocusListener(new MyFocusListener(searchField.getName(),searchField));
		searchField.setOpaque(false); 								// 将搜索输入框设置为透明
		searchField.setBorder(null); 								// 将搜索输入框设置为无边框
		searchField.setFont(new Font("微软雅黑",Font.PLAIN, 15));		// 设置搜索输入框的字体属性
		// 设置搜索输入框的字体颜色为黄昏灰
		searchField.setForeground(new java.awt.Color(71, 75, 76));
		
		// 设置搜索按钮
		searchButton = new JButton("   搜 索   ");
		searchButton.setContentAreaFilled(false); 					// 将搜索按钮设置为透明
		searchButton.setBorder(null); 								// 将搜索按钮设置为无边框
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));  	// 设置搜索按钮的字体属性
		// 设置搜索按钮的字体颜色为白色
		searchButton.setForeground(new java.awt.Color(255, 255, 255));	
		searchButton.addActionListener((ActionListener) this);		// 给搜索按钮添加事件监听
		
//		添加界面***********************************************************************************************************************************************************************
		
		// 设置员工姓名标签
		nameJLabel = new JLabel("姓名");
		nameJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
		nameJLabel.setForeground(new java.awt.Color(255, 255, 255));	
		
		// 设置员工姓名文本框
		nameField = new JTextField();
		nameField.setName("请输入员工姓名");
		// 调用焦点监听方法类设置提示文字
		nameField.addFocusListener(new MyFocusListener(nameField.getName(),nameField));
		nameField.setOpaque(false); 								// 将员工姓名文本框设置为透明
		nameField.setBorder(null); 									// 将员工姓名文本框设置为无边框
		nameField.setFont(new Font("微软雅黑",Font.PLAIN, 14));		// 设置员工姓名文本框的字体属性
		// 设置员工姓名文本框的字体颜色为黄昏灰
		nameField.setForeground(new java.awt.Color(71, 75, 76));
		
		// 设置员工号标签
		jobNumberJLabel = new JLabel("工号");
		jobNumberJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
		jobNumberJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// 设置员工号文本框
		jobNumberField = new JTextField();
		jobNumberField.setName("请输入员工号");
		// 调用焦点监听方法类设置提示文字
		jobNumberField.addFocusListener(new MyFocusListener(jobNumberField.getName(),jobNumberField));
		jobNumberField.setOpaque(false); 							// 将员工号文本框设置为透明
		jobNumberField.setBorder(null); 							// 将员工号文本框设置为无边框
		jobNumberField.setFont(new Font("微软雅黑",Font.PLAIN, 14));	// 设置员工号文本框的字体属性
		// 设置员工号文本框的字体颜色为黄昏灰
		jobNumberField.setForeground(new java.awt.Color(71, 75, 76));
		
		// 设置正常天数标签
		normalDaysJLabel = new JLabel("正常天数");
		normalDaysJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
		normalDaysJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// 设置正常天数文本框
		normalDaysField = new JTextField();
		normalDaysField.setName("请输入正常天数");
		// 调用焦点监听方法类设置提示文字
		normalDaysField.addFocusListener(new MyFocusListener(normalDaysField.getName(),normalDaysField));
		normalDaysField.setOpaque(false); 							// 将正常天数文本框设置为透明
		normalDaysField.setBorder(null); 							// 将正常天数文本框设置为无边框
		normalDaysField.setFont(new Font("微软雅黑",Font.PLAIN, 14));	// 设置正常天数文本框的字体属性
		// 设置正常天数文本框的字体颜色为黄昏灰
		normalDaysField.setForeground(new java.awt.Color(71, 75, 76));
		
		// 设置迟到天数标签
		lateDaysJLabel = new JLabel("迟到时长");
		lateDaysJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
		lateDaysJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// 设置迟到天数文本框
		lateDaysField = new JTextField();
		lateDaysField.setName("请输入迟到时长");
		// 调用焦点监听方法类设置提示文字
		lateDaysField.addFocusListener(new MyFocusListener(lateDaysField.getName(),lateDaysField));
		lateDaysField.setOpaque(false); 							// 将迟到天数文本框设置为透明
		lateDaysField.setBorder(null); 								// 将迟到天数文本框设置为无边框
		lateDaysField.setFont(new Font("微软雅黑",Font.PLAIN, 14));		// 设置迟到天数文本框的字体属性
		// 设置迟到天数文本框的字体颜色为黄昏灰
		lateDaysField.setForeground(new java.awt.Color(71, 75, 76));
		
		// 设置请假天数标签
		leaveDaysJLabel = new JLabel("请假天数");
		leaveDaysJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
		leaveDaysJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// 设置请假天数文本框
		leaveDaysField = new JTextField();
		leaveDaysField.setName("请输入请假天数");
		// 调用焦点监听方法类设置提示文字
		leaveDaysField.addFocusListener(new MyFocusListener(leaveDaysField.getName(),leaveDaysField));
		leaveDaysField.setOpaque(false); 							// 将请假天数文本框设置为透明
		leaveDaysField.setBorder(null); 							// 将请假天数文本框设置为无边框
		leaveDaysField.setFont(new Font("微软雅黑",Font.PLAIN, 14));	// 设置请假天数文本框的字体属性
		// 设置请假天数文本框的字体颜色为黄昏灰
		leaveDaysField.setForeground(new java.awt.Color(71, 75, 76));
		
		// 设置旷工天数标签
		absenteeismDaysJLabel = new JLabel("旷工天数");
		absenteeismDaysJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
		absenteeismDaysJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// 设置旷工天数文本框
		absenteeismDaysField = new JTextField();
		absenteeismDaysField.setName("请输入旷工天数");
		// 调用焦点监听方法类设置提示文字
		absenteeismDaysField.addFocusListener(new MyFocusListener(absenteeismDaysField.getName(),absenteeismDaysField));
		absenteeismDaysField.setOpaque(false); 						// 将旷工天数文本框设置为透明
		absenteeismDaysField.setBorder(null); 						// 将旷工天数文本框设置为无边框
		absenteeismDaysField.setFont(new Font("微软雅黑",Font.PLAIN, 14));	// 设置旷工天数文本框的字体属性
		// 设置旷工天数文本框的字体颜色为黄昏灰
		absenteeismDaysField.setForeground(new java.awt.Color(71, 75, 76));
		
		// 设置工作时长标签
		workHoursJLabel = new JLabel("工作时长");
		workHoursJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
		workHoursJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// 设置工作时长文本框
		workHoursField = new JTextField();
		workHoursField.setName("请输入工作时长");
		// 调用焦点监听方法类设置提示文字
		workHoursField.addFocusListener(new MyFocusListener(workHoursField.getName(),workHoursField));
		workHoursField.setOpaque(false); 							// 将工作时长文本框设置为透明
		workHoursField.setBorder(null); 							// 将工作时长文本框设置为无边框
		workHoursField.setFont(new Font("微软雅黑",Font.PLAIN, 14));	// 设置工作时长文本框的字体属性
		// 设置工作时长文本框的字体颜色为黄昏灰
		workHoursField.setForeground(new java.awt.Color(71, 75, 76));
		
		// 设置工作计件标签
		workPieceJLabel = new JLabel("工作计件");
		workPieceJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
		workPieceJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// 设置工作计件文本框
		workPieceField = new JTextField();
		workPieceField.setName("请输入工作计件");
		// 调用焦点监听方法类设置提示文字
		workPieceField.addFocusListener(new MyFocusListener(workPieceField.getName(),workPieceField));
		workPieceField.setOpaque(false); 							// 将工作计件文本框设置为透明
		workPieceField.setBorder(null); 							// 将工作计件文本框设置为无边框
		workPieceField.setFont(new Font("微软雅黑",Font.PLAIN, 14));	// 设置工作计件文本框的字体属性
		// 设置工作计件文本框的字体颜色为黄昏灰
		workPieceField.setForeground(new java.awt.Color(71, 75, 76));
		
		// 设置奖励次数标签
		awardNumberJLabel = new JLabel("奖励次数");
		awardNumberJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
		awardNumberJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// 设置奖励次数文本框
		awardNumberField = new JTextField();
		awardNumberField.setName("请输入奖励次数");
		// 调用焦点监听方法类设置提示文字
		awardNumberField.addFocusListener(new MyFocusListener(awardNumberField.getName(),awardNumberField));
		awardNumberField.setOpaque(false); 							// 将奖励次数文本框设置为透明
		awardNumberField.setBorder(null); 							// 将奖励次数文本框设置为无边框
		awardNumberField.setFont(new Font("微软雅黑",Font.PLAIN, 14));	// 设置奖励次数文本框的字体属性
		// 设置奖励次数文本框的字体颜色为黄昏灰
		awardNumberField.setForeground(new java.awt.Color(71, 75, 76));
		
		// 设置惩罚次数标签
		punishmentNumberJLabel = new JLabel("惩罚次数");
		punishmentNumberJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
		punishmentNumberJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// 设置惩罚次数文本框
		punishmentNumberField = new JTextField();
		punishmentNumberField.setName("请输入惩罚次数");
		// 调用焦点监听方法类设置提示文字
		punishmentNumberField.addFocusListener(new MyFocusListener(punishmentNumberField.getName(),punishmentNumberField));
		punishmentNumberField.setOpaque(false); 					// 将惩罚次数文本框设置为透明
		punishmentNumberField.setBorder(null); 						// 将惩罚次数文本框设置为无边框
		punishmentNumberField.setFont(new Font("微软雅黑",Font.PLAIN, 14));	// 设置惩罚次数文本框的字体属性
		// 设置惩罚次数文本框的字体颜色为黄昏灰
		punishmentNumberField.setForeground(new java.awt.Color(71, 75, 76));
		
		// 设置第几季度标签
		manyQuartersJLabel = new JLabel("第几季度");
		manyQuartersJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
		manyQuartersJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// 设置第几季度文本框
		manyQuartersField = new JTextField();
		manyQuartersField.setName("例：2021-1");
		// 调用焦点监听方法类设置提示文字
		manyQuartersField.addFocusListener(new MyFocusListener(manyQuartersField.getName(),manyQuartersField));
		manyQuartersField.setOpaque(false); 						// 将第几季度文本框设置为透明
		manyQuartersField.setBorder(null); 							// 将第几季度文本框设置为无边框
		manyQuartersField.setFont(new Font("微软雅黑",Font.PLAIN, 14));	// 设置第几季度文本框的字体属性
		// 设置第几季度文本框的字体颜色为黄昏灰
		manyQuartersField.setForeground(new java.awt.Color(71, 75, 76));
		
		// 设置工作质量标签
		jobContentJLabel = new JLabel("工作质量");
		jobContentJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
		jobContentJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// 设置工作质量下拉框
		jobContentBox = new JComboBox<String>();
		jobContentBox.addItem("请选择工作质量");
		jobContentBox.addItem("100");
		jobContentBox.addItem("90");
		jobContentBox.addItem("80");
		jobContentBox.addItem("70");
		jobContentBox.addItem("60");
		jobContentBox.addItem("50");
		jobContentBox.addItem("40");
		jobContentBox.addItem("30");
		jobContentBox.addItem("20");
		jobContentBox.addItem("10");
		jobContentBox.setBackground(Color.WHITE);					// 设置下拉框背景颜色
		jobContentBox.setFont(new Font("微软雅黑",Font.PLAIN, 13));		// 设置工作质量下拉框的字体属性
    	jobContentBox.setForeground(new java.awt.Color(71, 75, 76));// 设置下拉框字体颜色
    	jobContentBox.addActionListener((ActionListener) this);		// 添加事件监听
    	
    	// 设置工艺改善标签
    	processImproveJLabel = new JLabel("工艺改善");
    	processImproveJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
    	processImproveJLabel.setForeground(new java.awt.Color(255, 255, 255));
    	
    	// 设置工艺改善下拉框
    	processImproveBox = new JComboBox<String>();
    	processImproveBox.addItem("请选择工艺改善情况");
    	processImproveBox.addItem("100");
    	processImproveBox.addItem("90");
    	processImproveBox.addItem("80");
    	processImproveBox.addItem("70");
    	processImproveBox.addItem("60");
    	processImproveBox.addItem("50");
    	processImproveBox.addItem("40");
    	processImproveBox.addItem("30");
    	processImproveBox.addItem("20");
    	processImproveBox.addItem("10");
    	processImproveBox.setBackground(Color.WHITE); 
    	processImproveBox.setFont(new Font("微软雅黑",Font.PLAIN, 13));	// 设置下拉框的字体属性
    	processImproveBox.setForeground(new java.awt.Color(71, 75, 76));
    	processImproveBox.addActionListener((ActionListener) this);
    	
    	// 设置季度等级标签
    	quarterClassJLabel = new JLabel("季度等级");
    	quarterClassJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
    	quarterClassJLabel.setForeground(new java.awt.Color(255, 255, 255));
    	
    	// 设置季度等级下拉框
    	quarterClassBox = new JComboBox<String>();
    	quarterClassBox.addItem("请选择季度等级");
    	quarterClassBox.addItem("A+");
    	quarterClassBox.addItem("A");
    	quarterClassBox.addItem("B+");
    	quarterClassBox.addItem("B");
    	quarterClassBox.addItem("C+");
    	quarterClassBox.addItem("C");
    	quarterClassBox.setBackground(Color.WHITE); 
    	quarterClassBox.setFont(new Font("微软雅黑",Font.PLAIN, 13));	// 设置下拉框的字体属性
    	quarterClassBox.setForeground(new java.awt.Color(71, 75, 76));
    	quarterClassBox.addActionListener((ActionListener) this);
    	
    	// 设置添加界面的分析按钮
    	add_analyseButton = new JButton("   分 析   ");
    	add_analyseButton.setContentAreaFilled(false); 				// 将添加界面的分析按钮设置为透明
    	add_analyseButton.setBorder(null); 							// 将添加界面的分析按钮设置为无边框
    	add_analyseButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));  	// 设置添加界面的分析按钮的字体属性
    	// 设置添加界面的分析按钮的字体颜色为白色
    	add_analyseButton.setForeground(new java.awt.Color(255, 255, 255));	
    	add_analyseButton.addActionListener((ActionListener) this);	// 给添加界面的分析按钮添加事件监听
    	
    	// 设置添加界面的保存按钮
    	add_saveButton = new JButton("   保 存   ");
    	add_saveButton.setContentAreaFilled(false); 				// 将添加界面的保存按钮设置为透明
    	add_saveButton.setBorder(null); 							// 将添加界面的保存按钮设置为无边框
    	add_saveButton.setFont(new Font("微软雅黑", Font.PLAIN, 17)); 	// 设置添加界面的保存按钮的字体属性
    	// 设置添加界面的保存按钮的字体颜色为白色
    	add_saveButton.setForeground(new java.awt.Color(255, 255, 255));	
    	add_saveButton.addActionListener((ActionListener) this);	// 给添加界面的保存按钮添加事件监听
    	
    	// 设置添加界面的关闭按钮
    	add_closeButton = new JButton("      ");
    	add_closeButton.setContentAreaFilled(false); 				// 将添加界面的关闭按钮设置为透明
    	add_closeButton.setBorder(null); 							// 将添加界面的关闭按钮设置为无边框
    	add_closeButton.addActionListener((ActionListener) this);	// 给添加界面的关闭按钮添加事件监听
		
    	// 设置放置添加界面图片的标签
    	add_windowJLabel = new JLabel(new ImageIcon("image/addInformation.png"));
    	
		
//    	目标卡******************************************************************************************************
    	
    	// 设置放置目标卡图片的标签
    	plan_windowJLabel = new JLabel(new ImageIcon("image/目标卡.png"));
    	
    	// 设置目标卡界面的目标工时标签
    	plan_hoursJLabel = new JLabel("目标工时");
    	plan_hoursJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
    	plan_hoursJLabel.setForeground(new java.awt.Color(255, 255, 255));
    	
    	// 设置目标卡界面的目标工时文本框
    	plan_hoursField = new JTextField("490");
    	plan_hoursField.setName("请输入目标工时");
		// 调用焦点监听方法类设置提示文字
    	plan_hoursField.addFocusListener(new MyFocusListener(plan_hoursField.getName(),plan_hoursField));
    	plan_hoursField.setOpaque(false);	 						// 将目标工时文本框设置为透明
    	plan_hoursField.setBorder(null); 							// 将目标工时文本框设置为无边框
    	plan_hoursField.setFont(new Font("微软雅黑",Font.PLAIN, 14));	// 设置目标工时文本框的字体属性
		// 设置目标工时文本框的字体颜色为黄昏灰
    	plan_hoursField.setForeground(new java.awt.Color(71, 75, 76));
    	
    	// 设置目标卡界面的目标件数标签
    	plan_pieceJLabel = new JLabel("目标件数");
    	plan_pieceJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
    	plan_pieceJLabel.setForeground(new java.awt.Color(255, 255, 255));
    	
    	// 设置目标卡界面的目标件数文本框
    	plan_pieceField = new JTextField("1000");
    	plan_pieceField.setName("请输入目标件数");
		// 调用焦点监听方法类设置提示文字
    	plan_pieceField.addFocusListener(new MyFocusListener(plan_pieceField.getName(),plan_pieceField));
    	plan_pieceField.setOpaque(false);	 						// 将目标件数文本框设置为透明
    	plan_pieceField.setBorder(null); 							// 将目标件数文本框设置为无边框
    	plan_pieceField.setFont(new Font("微软雅黑",Font.PLAIN, 14));	// 设置目标件数文本框的字体属性
		// 设置目标件数文本框的字体颜色为黄昏灰
    	plan_pieceField.setForeground(new java.awt.Color(71, 75, 76));
    	
    	// 设置目标卡界面的目标质量标签
    	plan_contentJLabel = new JLabel("目标质量");
    	plan_contentJLabel.setFont(new Font("微软雅黑",Font.PLAIN, 16));
    	plan_contentJLabel.setForeground(new java.awt.Color(255, 255, 255));
    	
    	// 设置目标卡界面的目标质量文本框
    	plan_contentField = new JTextField("90");
    	plan_contentField.setName("请输入目标质量");
		// 调用焦点监听方法类设置提示文字
    	plan_contentField.addFocusListener(new MyFocusListener(plan_contentField.getName(),plan_contentField));
    	plan_contentField.setOpaque(false);	 						// 将目标质量文本框设置为透明
    	plan_contentField.setBorder(null); 							// 将目标质量文本框设置为无边框
    	plan_contentField.setFont(new Font("微软雅黑",Font.PLAIN, 14));	// 设置目标质量文本框的字体属性
		// 设置目标质量文本框的字体颜色为黄昏灰
    	plan_contentField.setForeground(new java.awt.Color(71, 75, 76));
    	
    	// 设置目标卡界面的确认按钮
    	plan_okButton = new JButton(" ");
    	plan_okButton.setContentAreaFilled(false); 					// 将确认按钮设置为透明
    	plan_okButton.setBorder(null); 								// 将确认按钮设置为无边框
    	plan_okButton.setFont(new Font("微软雅黑",Font.PLAIN, 80));
    	plan_okButton.addActionListener((ActionListener) this);		// 给确认按钮添加事件监听
    	
		
//		panel******************************************************************************************************
		
    	// 设置个人中心面板
    	usernameJPanel = new JPanel();
    	usernameJPanel.setOpaque(false); 							// 设置usernameJPanel透明
    	usernameJPanel.setLayout(new GridLayout(1, 1, 0, 0)); 		// 设置usernameJPanel为绝对布局，四行一列，纵间距为25
    	usernameJPanel.setBounds(13, 90, 150, 25); 					// 设置usernameJPanel面板的位置和大小
    	usernameJPanel.add(usernameButton);
    	
		// 设置左侧面板
		left_functionJPanel = new JPanel();
		left_functionJPanel.setOpaque(false); 						// 设置left_functionJPanel透明
		left_functionJPanel.setLayout(new GridLayout(4, 1, 0, 35)); // 设置left_functionJPanel为绝对布局，四行一列，纵间距为25
		left_functionJPanel.setBounds(21, 140, 140, 230); 			// 设置left_functionJPanel面板的位置和大小
		left_functionJPanel.add(addButton);							// 将添加按钮添加到left_functionJPanel面板
		left_functionJPanel.add(deleteButton);
		left_functionJPanel.add(analyseButton);
		left_functionJPanel.add(planButton);
		
		// 设置搜索框面板
		search_boxJPanel = new JPanel();
		search_boxJPanel.setOpaque(false); 							// 将搜索框面板设置为透明
		search_boxJPanel.setLayout(new GridLayout(1, 1, 0, 0)); 	// 设置为绝对布局，一行一列
		search_boxJPanel.setBounds(715, 23, 290, 40); 				// 设置搜索框面板的位置和大小
		search_boxJPanel.add(searchField);							// 将搜索文本框添加到搜索框面板
		
		// 设置搜索按钮面板
		search_buttonJPanel = new JPanel();
		search_buttonJPanel.setOpaque(false); 						// 将搜索按钮面板设置为透明
		search_buttonJPanel.setLayout(new GridLayout(1, 1, 0, 0)); 	// 设置为绝对布局，一行一列
		search_buttonJPanel.setBounds(1020, 23, 82, 40); 			// 设置搜索按钮面板的位置和大小
		search_buttonJPanel.add(searchButton);						// 将搜索按钮添加到搜索按钮面板
		
		// 设置添加界面面板
		addInformation_windowJPanel = new JPanel();
		addInformation_windowJPanel.setOpaque(false);
		addInformation_windowJPanel.setLayout(new GridLayout(1, 1, 0, 0));
		addInformation_windowJPanel.setBounds(320, 110, 800, 500);
		addInformation_windowJPanel.add(add_windowJLabel);
		
		
		// 设置添加界面的姓名、工号面板
		add_nameAndnumJPanel = new JPanel();
		add_nameAndnumJPanel.setOpaque(false);
		add_nameAndnumJPanel.setLayout(new GridLayout(1, 2, 135, 0));
		add_nameAndnumJPanel.setBounds(470, 154, 480, 35);
		add_nameAndnumJPanel.add(nameField);
		add_nameAndnumJPanel.add(jobNumberField);
		
		// 设置添加界面的其余信息面板
		add_otherInformationJPanel = new JPanel();
		add_otherInformationJPanel.setOpaque(false);
		add_otherInformationJPanel.setLayout(new GridLayout(6, 2, 175, 20));
		add_otherInformationJPanel.setBounds(502, 205, 440, 302);
		add_otherInformationJPanel.add(normalDaysField);
		add_otherInformationJPanel.add(lateDaysField);
		add_otherInformationJPanel.add(leaveDaysField);
		add_otherInformationJPanel.add(absenteeismDaysField);
		add_otherInformationJPanel.add(workHoursField);
		add_otherInformationJPanel.add(workPieceField);
		add_otherInformationJPanel.add(jobContentBox);
		add_otherInformationJPanel.add(processImproveBox);
		add_otherInformationJPanel.add(awardNumberField);
		add_otherInformationJPanel.add(punishmentNumberField);
		add_otherInformationJPanel.add(manyQuartersField);
		add_otherInformationJPanel.add(quarterClassBox);
		
		// 设置添加界面的按钮面板
		add_buttonJPanel = new JPanel();
		add_buttonJPanel.setOpaque(false);
		add_buttonJPanel.setLayout(new GridLayout(1, 2, 35, 0)); 
		add_buttonJPanel.setBounds(895, 555, 195, 35);
		add_buttonJPanel.add(add_analyseButton);
		add_buttonJPanel.add(add_saveButton);
		
		// 设置添加界面的关闭按钮面板
		add_closeJPanel = new JPanel();
		add_closeJPanel.setOpaque(false);
		add_closeJPanel.setLayout(new GridLayout(1, 1, 0, 0)); 
		add_closeJPanel.setBounds(1082, 120, 25, 25);
		add_closeJPanel.add(add_closeButton);
		
		// 设置添加界面的文字标签面板
		add_textJPanel = new JPanel();
		add_textJPanel.setOpaque(false);
		add_textJPanel.setLayout(new GridLayout(7, 2, 175, 20));
		add_textJPanel.setBounds(430, 155, 440, 355);
		add_textJPanel.add(nameJLabel);
		add_textJPanel.add(jobNumberJLabel);
		add_textJPanel.add(normalDaysJLabel);
		add_textJPanel.add(lateDaysJLabel);
		add_textJPanel.add(leaveDaysJLabel);
		add_textJPanel.add(absenteeismDaysJLabel);
		add_textJPanel.add(workHoursJLabel);
		add_textJPanel.add(workPieceJLabel);
		add_textJPanel.add(jobContentJLabel);
		add_textJPanel.add(processImproveJLabel);
		add_textJPanel.add(awardNumberJLabel);
		add_textJPanel.add(punishmentNumberJLabel);
		add_textJPanel.add(manyQuartersJLabel);
		add_textJPanel.add(quarterClassJLabel);
		
		
		// 设置目标卡界面放置背景图片的面板
		plan_windowJPanel = new JPanel();
		plan_windowJPanel.setOpaque(false);
		plan_windowJPanel.setBounds(200, 350, 390, 200);
		plan_windowJPanel.add(plan_windowJLabel);
		
		// 设置目标卡界面放置文字标签的面板
		plan_textJPanel = new JPanel();
		plan_textJPanel.setOpaque(false);
		plan_textJPanel.setLayout(new GridLayout(3, 1, 0, 30));
		plan_textJPanel.setBounds(230, 385, 100, 130);
		plan_textJPanel.add(plan_hoursJLabel);
		plan_textJPanel.add(plan_pieceJLabel);
		plan_textJPanel.add(plan_contentJLabel);
		
		// 设置目标卡界面放置文本框的面板
		plan_textFieldJPanel = new JPanel();
		plan_textFieldJPanel.setOpaque(false);
		plan_textFieldJPanel.setLayout(new GridLayout(3, 1, 0, 30));
		plan_textFieldJPanel.setBounds(300, 385, 160, 130);
		plan_textFieldJPanel.add(plan_hoursField);
		plan_textFieldJPanel.add(plan_pieceField);
		plan_textFieldJPanel.add(plan_contentField);
		
		// 设置目标卡界面放置确认按钮的面板
		plan_buttonJPanel = new JPanel();
		plan_buttonJPanel.setOpaque(false);
		plan_buttonJPanel.setBounds(495, 390, 60, 125);
		plan_buttonJPanel.add(plan_okButton);
		
		
		// 设置放置表格的滚动面板
		assess_tabelJScrollPane = new JScrollPane();
		
		// JScrollPane 基本上由 JScrollBar、一个 JViewport 以及它们之间的连线组成 ,
		// 因此设置背景透明时，除了要设置pane的背景，还要将JViewport背景也设置为透明才可。
		assess_tabelJScrollPane.setOpaque(false);
		assess_tabelJScrollPane.getViewport().setOpaque(false);
		
		assess_tabelJScrollPane.setBounds(182, 75, 1082, 575);

		
		this.setTitle("绩效考核系统");									// 设置系统标签
		ImageIcon icon = new ImageIcon("image\\icon.png");			// 设置系统图标
		this.setIconImage(icon.getImage());							// 设置JFrame窗口标题图标
	    this.setLayout(null);										// 清空布局管理器
		this.setSize(1300, 707);									// 设置窗口宽高
		this.setLocationRelativeTo(null);							// 窗体居中显示
	    
	    setWindows();												// 调用setWindows方法，设置窗口
	    Container Bottom_container = getContentPane();				// 初始化Bottom_container容器
	    
	    Bottom_container.add(usernameJPanel);
	    Bottom_container.add(plan_textJPanel);
	    Bottom_container.add(plan_textFieldJPanel);
	    Bottom_container.add(plan_buttonJPanel);
	    Bottom_container.add(plan_windowJPanel);
	    Bottom_container.add(left_functionJPanel);					// 将left_functionJPanel添加到Bottom_container容器
	    Bottom_container.add(search_boxJPanel);
	    Bottom_container.add(search_buttonJPanel);
	    Bottom_container.add(add_textJPanel);
	    Bottom_container.add(add_nameAndnumJPanel);
	    Bottom_container.add(add_otherInformationJPanel);
	    Bottom_container.add(add_buttonJPanel);
	    Bottom_container.add(add_closeJPanel);
	    Bottom_container.add(addInformation_windowJPanel);
	    Bottom_container.add(assess_tabelJScrollPane);
	    
	    this.setResizable(false);									// 窗体大小设置为不可变
	    this.setVisible(true);										// 显示窗体
	    
	    concealAdd_window();
	    concealPlan();
	}
	
	// 设置窗口的方法
	public void setWindows(){
	    ((JPanel)this.getContentPane()).setOpaque(false);
	    ImageIcon img = new ImageIcon("image/assessBackground.png");
	    JLabel background = new JLabel(img);
	    this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	    background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	}
	
	// 事件监听方法
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addButton) {							// 如果按下添加按钮
			showAdd_window();										// 显示添加界面
			assess_messageJTable.setEnabled(false);					// 不能对表格进行操作
		}
		else if(e.getSource() == modifyButton) {					// 如果按下修改按钮
			
		}
		else if(e.getSource() == deleteButton) {					// 如果按下删除按钮
			
		}
		else if(e.getSource() == analyseButton) {					// 如果按下分析按钮
			
		}
		else if(e.getSource() == planButton) {						// 如果按下目标卡按钮
			showPlan();												// 显示目标卡界面
		}
		else if(e.getSource() == add_closeButton) {					// 如果按下添加界面的关闭按钮
			concealAdd_window();									// 隐藏添加界面
			assess_messageJTable.setEnabled(true);					// 可以对表格进行操作
		}
		else if(e.getSource() == usernameButton) {				    // 如果按下个人中心按钮
			System.out.println("欢迎 " + usernameString);								
		}
		else if(e.getSource() == add_saveButton) {					// 如果按下添加界面的保存按钮
			saveMessage();											// 保存到数据库
			messageTabel(usernameString);							// 刷新考核表
			cleanAdd(); 											// 清空文本框
			assess_messageJTable.setEnabled(false);					// 不能对表格进行操作
		}
		else if(e.getSource() == plan_okButton) {					// 如果按下目标卡界面的确认按钮
			concealPlan();											// 关闭目标卡
		}
	}
	
	
	// 设置个人中心按钮的方法，动态显示用户名
	public void userName(String username ) {
		
		usernameString = username;
		System.out.println("获取的用户名为：" + usernameString);
		
		usernameButton.setText(usernameString);
		usernameButton.setContentAreaFilled(false); 				// 将个人中心按钮设置为透明
		usernameButton.setBorder(null);								// 将个人中心按钮设置为无边框
		usernameButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));	// 设置个人中心按钮的字体属性
		// 设置个人中心按钮的字体颜色
		usernameButton.setForeground(new java.awt.Color(255, 255, 255));	
		usernameButton.addActionListener((ActionListener) this);	// 给个人中心按钮添加事件监听
		
	}

	// 设置员工信息表的方法
	public void messageTabel(String a) {
		
		// 创建表格
		assess_messageJTable = new JTable();
		// 获取表格的数据模型
		DefaultTableModel model = (DefaultTableModel) assess_messageJTable.getModel();
		// 设置表头
		model.setColumnIdentifiers(new String[] {"id", "姓名", "工号", "正常天数", "迟到时长", "请假天数"
				, "旷工天数", "工作时长", "工作计件", "工作质量", "工艺改善", "奖励次数", "惩罚次数", "第几季度"
				, "季度等级", "考核结果"});								
			
		Mysql ms = new Mysql();
		ms.ConnectSQL();
		
		String b = "_performance_appraisal_list";
		String tabelName = a + b;
		System.out.println("查找" + tabelName + "的内容");
		
		try {
			ms.ps=ms.ct.prepareStatement("select * from "+tabelName+"");
			
			ms.rs = ms.ps.executeQuery();
			
			while(ms.rs.next())
			{
				id = ms.rs.getString(1);								// 将第一列保存在id中
				staff_name = ms.rs.getString(2);
				staff_number = ms.rs.getString(3);
				normal_days = ms.rs.getString(4);
				late_days = ms.rs.getString(5);
				leave_days = ms.rs.getString(6);
				absenteeism_days = ms.rs.getString(7);
				work_hours = ms.rs.getString(8);
				work_piece = ms.rs.getString(9);
				work_content = ms.rs.getString(10);
				technology_improve = ms.rs.getString(11);
				rewards_time = ms.rs.getString(12);
				punishment_time = ms.rs.getString(13);
				many_quarter = ms.rs.getString(14);
				quarter_class = ms.rs.getString(15);
				assess_result = ms.rs.getString(16);
				
				ms.loginClose();
				
				// 增加行
				model.addRow(new Object[]{id, staff_name, staff_number, normal_days, late_days, leave_days, 
						absenteeism_days, work_hours, work_piece, work_content, technology_improve, 
						rewards_time, punishment_time, many_quarter, quarter_class, assess_result});
					
			}ms.loginClose();
		
		// 更新表格模型
		assess_messageJTable.setModel(model);
			
		// 为JScrollPane面板设置一个可视化图表
		assess_tabelJScrollPane.setViewportView(assess_messageJTable);
		
			
		
		// 鼠标对表格的操作
		assess_messageJTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
//					// 可单选也可拖动多选
//					int[] rows = assess_messageJTable.getSelectedRows();
//					// int[] cols = table.getSelectedColumns();//选中的列
//					for (int i : rows){
//						System.out.println(assess_messageJTable.getValueAt(i, 2) + "\t" + assess_messageJTable.getValueAt(i, 1));
//					}
					
					// 可单选
					int row = assess_messageJTable.getSelectedRow();//选中行
					//int col=table.getSelectedColumn();//选中列
					
					// 将选中行的第一列存到id中
					id = (String) assess_messageJTable.getValueAt(row, 0);
					System.out.println(id);
					staff_name = (String) assess_messageJTable.getValueAt(row, 1);
					System.out.println(staff_name);
					staff_number = (String) assess_messageJTable.getValueAt(row, 2);
					System.out.println(staff_number);
					normal_days = (String) assess_messageJTable.getValueAt(row, 3);
					System.out.println(normal_days);
					late_days = (String) assess_messageJTable.getValueAt(row, 4);
					System.out.println(late_days);
					leave_days = (String) assess_messageJTable.getValueAt(row, 5);
					System.out.println(leave_days);
					absenteeism_days = (String) assess_messageJTable.getValueAt(row, 6);
					System.out.println(absenteeism_days);
					work_hours = (String) assess_messageJTable.getValueAt(row, 7);
					System.out.println(work_hours);
					work_piece = (String) assess_messageJTable.getValueAt(row, 8);
					System.out.println(work_piece);
					work_content = (String) assess_messageJTable.getValueAt(row, 9);
					System.out.println(work_content);
					technology_improve = (String) assess_messageJTable.getValueAt(row, 10);
					System.out.println(technology_improve);
					rewards_time = (String) assess_messageJTable.getValueAt(row, 11);
					System.out.println(rewards_time);
					punishment_time = (String) assess_messageJTable.getValueAt(row, 12);
					System.out.println(punishment_time);
					many_quarter = (String) assess_messageJTable.getValueAt(row, 13);
					System.out.println(many_quarter);
					quarter_class = (String) assess_messageJTable.getValueAt(row, 14);
					System.out.println(quarter_class);
					assess_result = (String) assess_messageJTable.getValueAt(row, 15);
					System.out.println(assess_result);
//					System.out.println(assess_messageJTable.getValueAt(row, 0) + "\t" + assess_messageJTable.getValueAt(row, 1));
				}
			}
		});
		
		}catch (SQLException e) {
			e.printStackTrace();
			try {
				ms.ct.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
			}
		}
	}
	
	// 保存员工信息的方法，所有文本框都不为空
	public void saveMessage() {
		if(nameField.getText().equals("") || nameField.getText().equals("请输入员工姓名")) {
			JOptionPane.showMessageDialog(null, "姓名不能为空，请输入", "warning", JOptionPane.WARNING_MESSAGE);
		}else if(jobNumberField.getText().equals("") || jobNumberField.getText().equals("请输入员工号")) {
			JOptionPane.showMessageDialog(null, "工号不能为空，请输入", "warning", JOptionPane.WARNING_MESSAGE);
		}else if(normalDaysField.getText().equals("") || normalDaysField.getText().equals("请输入正常天数")) {
			JOptionPane.showMessageDialog(null, "正常天数不能为空，请输入", "warning", JOptionPane.WARNING_MESSAGE);
		}else if(lateDaysField.getText().equals("") || lateDaysField.getText().equals("请输入迟到时长")) {
			JOptionPane.showMessageDialog(null, "迟到时长不能为空，请输入", "warning", JOptionPane.WARNING_MESSAGE);
		}else if(leaveDaysField.getText().equals("") || leaveDaysField.getText().equals("请输入请假天数")) {
			JOptionPane.showMessageDialog(null, "请假天数不能为空，请输入", "warning", JOptionPane.WARNING_MESSAGE);
		}else if(absenteeismDaysField.getText().equals("") || absenteeismDaysField.getText().equals("请输入旷工天数")) {
			JOptionPane.showMessageDialog(null, "旷工天数不能为空，请输入", "warning", JOptionPane.WARNING_MESSAGE);
		}else if(workHoursField.getText().equals("") || workHoursField.getText().equals("请输入工作时长")) {
			JOptionPane.showMessageDialog(null, "工作时长不能为空，请输入", "warning", JOptionPane.WARNING_MESSAGE);
		}else if(workPieceField.getText().equals("") || workPieceField.getText().equals("请输入工作计件")) {
			JOptionPane.showMessageDialog(null, "工作计件不能为空，请输入", "warning", JOptionPane.WARNING_MESSAGE);
		}else if(jobContentBox.getSelectedItem().toString().equals("请选择工作质量")) {
			JOptionPane.showMessageDialog(null, "工作质量不能为空，请选择", "warning", JOptionPane.WARNING_MESSAGE);
		}else if(processImproveBox.getSelectedItem().toString().equals("请选择工艺改善情况")) {
			JOptionPane.showMessageDialog(null, "工艺改善不能为空，请选择", "warning", JOptionPane.WARNING_MESSAGE);
		}else if(awardNumberField.getText().equals("") || awardNumberField.getText().equals("请输入奖励次数")) {
			JOptionPane.showMessageDialog(null, "奖励次数不能为空，请输入", "warning", JOptionPane.WARNING_MESSAGE);
		}else if(punishmentNumberField.getText().equals("") || punishmentNumberField.getText().equals("请输入惩罚次数")) {
			JOptionPane.showMessageDialog(null, "惩罚次数不能为空，请输入", "warning", JOptionPane.WARNING_MESSAGE);
		}else if(manyQuartersField.getText().equals("") || manyQuartersField.getText().equals("例：2021-1")) {
			JOptionPane.showMessageDialog(null, "第几季度不能为空，请输入", "warning", JOptionPane.WARNING_MESSAGE);
		}else if(quarterClassBox.getSelectedItem().toString().equals("请选择季度等级")) {
			JOptionPane.showMessageDialog(null, "季度等级不能为空，请输入", "warning", JOptionPane.WARNING_MESSAGE);
		}
		else {
			Mysql ms = new Mysql();
			ms.ConnectSQL();
			
			ms.saveMessage(usernameButton.getText(), nameField.getText(), jobNumberField.getText(), normalDaysField.getText(), 
				lateDaysField.getText(), leaveDaysField.getText(), absenteeismDaysField.getText()
				, workHoursField.getText(), workPieceField.getText(), jobContentBox.getSelectedItem().toString()
				, processImproveBox.getSelectedItem().toString(), awardNumberField.getText()
				, punishmentNumberField.getText(), manyQuartersField.getText()
				, quarterClassBox.getSelectedItem().toString());
			
			
			
			System.out.println("正常");
		}
		
	}
	
	
	// 清空添加界面文本框的方法
	public void cleanAdd() {
		nameField.setText("");
		jobNumberField.setText("");
		normalDaysField.setText("");
		lateDaysField.setText("");
		leaveDaysField.setText("");
		absenteeismDaysField.setText("");
		workHoursField.setText("");
		workPieceField.setText("");
		awardNumberField.setText("");
		punishmentNumberField.setText("");
		manyQuartersField.setText("");
		jobContentBox.setSelectedIndex(0);
		processImproveBox.setSelectedIndex(0);
		quarterClassBox.setSelectedIndex(0);
	}
	
	
	// 显示添加界面的方法
	public void showAdd_window() {
		addInformation_windowJPanel.setVisible(true);
		add_buttonJPanel.setVisible(true);
		add_closeJPanel.setVisible(true);
		add_nameAndnumJPanel.setVisible(true);
		add_otherInformationJPanel.setVisible(true);
		add_textJPanel.setVisible(true);
	}
		
	// 隐藏添加界面的方法
	public void concealAdd_window() {
		addInformation_windowJPanel.setVisible(false);
		add_buttonJPanel.setVisible(false);
		add_closeJPanel.setVisible(false);
		add_nameAndnumJPanel.setVisible(false);
		add_otherInformationJPanel.setVisible(false);
		add_textJPanel.setVisible(false);
	}
	
	// 显示目标卡界面的方法
	public void showPlan() {
		plan_buttonJPanel.setVisible(true);
		plan_textFieldJPanel.setVisible(true);
		plan_textJPanel.setVisible(true);
		plan_windowJPanel.setVisible(true);
	}
	
	// 隐藏目标卡界面的方法
	public void concealPlan() {
		plan_buttonJPanel.setVisible(false);
		plan_textFieldJPanel.setVisible(false);
		plan_textJPanel.setVisible(false);
		plan_windowJPanel.setVisible(false);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Assess_modules();
		
	}
}
