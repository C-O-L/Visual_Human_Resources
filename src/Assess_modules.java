import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


// ���м�Ч���˵���
public class Assess_modules extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel left_functionJPanel;										// ���Ĺ�����壬���ù��ܰ�ť
	JPanel search_boxJPanel;										// �����������������
	JPanel search_buttonJPanel;										// ����������ť�����
	JPanel addInformation_windowJPanel;								// ������add_windowJLabel�����
	JPanel add_nameAndnumJPanel;									// ���������������ı�������
	JPanel add_otherInformationJPanel;								// ���ó������͹���֮��������Ϣ�����
	JPanel add_buttonJPanel;										// ������Ӵ����з����ͱ���������ť�����
	JPanel add_closeJPanel;											// ������Ӵ����йرհ�ť�����
	JPanel add_textJPanel;											// ������Ӵ������ֱ�ǩ�����
	
	JLabel add_windowJLabel;										// ������ӽ���ͼƬ�ı�ǩ
	JLabel nameJLabel;												// Ա��������ǩ
	JLabel jobNumberJLabel;											// ���ű�ǩ
	JLabel normalDaysJLabel;										// ����������ǩ
	JLabel lateDaysJLabel;											// �ٵ�������ǩ
	JLabel leaveDaysJLabel;											// ���������ǩ
	JLabel absenteeismDaysJLabel;									// ����������ǩ
	JLabel workHoursJLabel;											// ����ʱ����ǩ
	JLabel workPieceJLabel;											// �����Ƽ���ǩ
	JLabel jobContentJLabel;										// ����������ǩ
	JLabel processImproveJLabel;									// ���ո��Ʊ�ǩ
	JLabel awardNumberJLabel;										// ����������ǩ
	JLabel punishmentNumberJLabel;									// �ͷ�������ǩ
	JLabel manyQuartersJLabel;										// �ڼ����ȱ�ǩ
	JLabel quarterClassJLabel;										// ���ȵȼ���ǩ
	
	JTextField searchField;											// �����ı���
	JTextField nameField;											// Ա�������ı���
	JTextField jobNumberField;										// �����ı���
	JTextField normalDaysField;										// ���������ı���
	JTextField lateDaysField;										// �ٵ������ı���
	JTextField leaveDaysField;										// ��������ı���
	JTextField absenteeismDaysField;								// ���������ı���
	JTextField workHoursField;										// ����ʱ���ı���
	JTextField workPieceField;										// �����Ƽ��ı���
	JTextField awardNumberField;									// ���������ı���
	JTextField punishmentNumberField;								// �ͷ������ı���
	JTextField manyQuartersField;									// �ڼ������ı���
	
	JComboBox jobContentBox;										// ��������������
	JComboBox processImproveBox;									// ���ո���������
	JComboBox quarterClassBox;										// ���ȵȼ�������
	
	private JButton addButton;										// ��Ӱ�ť
	private JButton modifyButton;									// �޸İ�ť
	private JButton deleteButton;									// ɾ����ť
	private JButton analyseButton;									// ������ť
	private JButton searchButton;									// ������ť
	private JButton add_analyseButton;								// ��ӽ���ķ�����ť
	private JButton add_saveButton;									// ��ӽ���ı��水ť
	private JButton add_closeButton;								// ��ӽ���Ĺرհ�ť

	// ���췽��
	public Assess_modules() {
//		��๦�ܰ�ť***********************************************************************************************************************************************************
		
		// ������Ӱ�ť
		addButton = new JButton("    �� ��    ");
		addButton.setContentAreaFilled(false); 						// ����Ӱ�ť����Ϊ͸��
		addButton.setBorder(null);									// ����Ӱ�ť����Ϊ�ޱ߿�
		addButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));		// ������Ӱ�ť����������
		addButton.setForeground(new java.awt.Color(255, 255, 255));	// ������Ӱ�ť��������ɫ
		addButton.addActionListener((ActionListener) this);			// ����Ӱ�ť����¼�����
		
		// �����޸İ�ť
		modifyButton = new JButton("    �� ��    ");
		modifyButton.setContentAreaFilled(false); 					// ���޸İ�ť����Ϊ͸��
		modifyButton.setBorder(null);								// ���޸İ�ť����Ϊ�ޱ߿�
		modifyButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));		// �����޸İ�ť����������
		// �����޸İ�ť��������ɫ
		modifyButton.setForeground(new java.awt.Color(255, 255, 255));	
		modifyButton.addActionListener((ActionListener) this);		// ���޸İ�ť����¼�����
		
		// ����ɾ����ť
		deleteButton = new JButton("    ɾ ��    ");
		deleteButton.setContentAreaFilled(false); 					// ��ɾ����ť����Ϊ͸��
		deleteButton.setBorder(null);								// ��ɾ����ť����Ϊ�ޱ߿�
		deleteButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));		// ����ɾ����ť����������
		// ����ɾ����ť��������ɫ
		deleteButton.setForeground(new java.awt.Color(255, 255, 255));	
		deleteButton.addActionListener((ActionListener) this);		// ��ɾ����ť����¼�����
		
		// ���÷�����ť
		analyseButton = new JButton("    �� ��    ");
		analyseButton.setContentAreaFilled(false); 					// ��������ť����Ϊ͸��
		analyseButton.setBorder(null);								// ��������ť����Ϊ�ޱ߿�
		analyseButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));	// ���÷�����ť����������
		// ���÷�����ť��������ɫ
		analyseButton.setForeground(new java.awt.Color(255, 255, 255));	
		analyseButton.addActionListener((ActionListener) this);		// ��������ť����¼�����
		
//		����***************************************************************************************************************************************************************************
		
		// ���������ı���
		searchField = new JTextField();
		searchField.setName("�������������ݣ�");
		// ���ý������������������ʾ����
		searchField.addFocusListener(new MyFocusListener(searchField.getName(),searchField));
		searchField.setOpaque(false); 								// ���������������Ϊ͸��
		searchField.setBorder(null); 								// ���������������Ϊ�ޱ߿�
		searchField.setFont(new Font("΢���ź�",Font.PLAIN, 15));		// ����������������������
		// ��������������������ɫΪ�ƻ��
		searchField.setForeground(new java.awt.Color(71, 75, 76));
		
		// ����������ť
		searchButton = new JButton("   �� ��   ");
		searchButton.setContentAreaFilled(false); 					// ��������ť����Ϊ͸��
		searchButton.setBorder(null); 								// ��������ť����Ϊ�ޱ߿�
		searchButton.setFont(new Font("΢���ź�", Font.PLAIN, 17));  	// ����������ť����������
		// ����������ť��������ɫΪ��ɫ
		searchButton.setForeground(new java.awt.Color(255, 255, 255));	
		searchButton.addActionListener((ActionListener) this);		// ��������ť����¼�����
		
//		��ӽ���***********************************************************************************************************************************************************************
		
		// ����Ա��������ǩ
		nameJLabel = new JLabel("����");
		nameJLabel.setFont(new Font("΢���ź�",Font.PLAIN, 16));
		nameJLabel.setForeground(new java.awt.Color(255, 255, 255));	
		
		// ����Ա�������ı���
		nameField = new JTextField();
		nameField.setName("������Ա��������");
		// ���ý������������������ʾ����
		nameField.addFocusListener(new MyFocusListener(nameField.getName(),nameField));
		nameField.setOpaque(false); 								// ��Ա�������ı�������Ϊ͸��
		nameField.setBorder(null); 									// ��Ա�������ı�������Ϊ�ޱ߿�
		nameField.setFont(new Font("΢���ź�",Font.PLAIN, 14));		// ����Ա�������ı������������
		// ����Ա�������ı����������ɫΪ�ƻ��
		nameField.setForeground(new java.awt.Color(71, 75, 76));
		
		// ����Ա���ű�ǩ
		jobNumberJLabel = new JLabel("����");
		jobNumberJLabel.setFont(new Font("΢���ź�",Font.PLAIN, 16));
		jobNumberJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// ����Ա�����ı���
		jobNumberField = new JTextField();
		jobNumberField.setName("������Ա���ţ�");
		// ���ý������������������ʾ����
		jobNumberField.addFocusListener(new MyFocusListener(jobNumberField.getName(),jobNumberField));
		jobNumberField.setOpaque(false); 							// ��Ա�����ı�������Ϊ͸��
		jobNumberField.setBorder(null); 							// ��Ա�����ı�������Ϊ�ޱ߿�
		jobNumberField.setFont(new Font("΢���ź�",Font.PLAIN, 14));	// ����Ա�����ı������������
		// ����Ա�����ı����������ɫΪ�ƻ��
		jobNumberField.setForeground(new java.awt.Color(71, 75, 76));
		
		// ��������������ǩ
		normalDaysJLabel = new JLabel("��������");
		normalDaysJLabel.setFont(new Font("΢���ź�",Font.PLAIN, 16));
		normalDaysJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// �������������ı���
		normalDaysField = new JTextField();
		normalDaysField.setName("����������������");
		// ���ý������������������ʾ����
		normalDaysField.addFocusListener(new MyFocusListener(normalDaysField.getName(),normalDaysField));
		normalDaysField.setOpaque(false); 							// �����������ı�������Ϊ͸��
		normalDaysField.setBorder(null); 							// �����������ı�������Ϊ�ޱ߿�
		normalDaysField.setFont(new Font("΢���ź�",Font.PLAIN, 14));	// �������������ı������������
		// �������������ı����������ɫΪ�ƻ��
		normalDaysField.setForeground(new java.awt.Color(71, 75, 76));
		
		// ���óٵ�������ǩ
		lateDaysJLabel = new JLabel("�ٵ�����");
		lateDaysJLabel.setFont(new Font("΢���ź�",Font.PLAIN, 16));
		lateDaysJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// ���óٵ������ı���
		lateDaysField = new JTextField();
		lateDaysField.setName("������ٵ�������");
		// ���ý������������������ʾ����
		lateDaysField.addFocusListener(new MyFocusListener(lateDaysField.getName(),lateDaysField));
		lateDaysField.setOpaque(false); 							// ���ٵ������ı�������Ϊ͸��
		lateDaysField.setBorder(null); 								// ���ٵ������ı�������Ϊ�ޱ߿�
		lateDaysField.setFont(new Font("΢���ź�",Font.PLAIN, 14));		// ���óٵ������ı������������
		// ���óٵ������ı����������ɫΪ�ƻ��
		lateDaysField.setForeground(new java.awt.Color(71, 75, 76));
		
		// �������������ǩ
		leaveDaysJLabel = new JLabel("�������");
		leaveDaysJLabel.setFont(new Font("΢���ź�",Font.PLAIN, 16));
		leaveDaysJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// ������������ı���
		leaveDaysField = new JTextField();
		leaveDaysField.setName("���������������");
		// ���ý������������������ʾ����
		leaveDaysField.addFocusListener(new MyFocusListener(leaveDaysField.getName(),leaveDaysField));
		leaveDaysField.setOpaque(false); 							// ����������ı�������Ϊ͸��
		leaveDaysField.setBorder(null); 							// ����������ı�������Ϊ�ޱ߿�
		leaveDaysField.setFont(new Font("΢���ź�",Font.PLAIN, 14));	// ������������ı������������
		// ������������ı����������ɫΪ�ƻ��
		leaveDaysField.setForeground(new java.awt.Color(71, 75, 76));
		
		// ���ÿ���������ǩ
		absenteeismDaysJLabel = new JLabel("��������");
		absenteeismDaysJLabel.setFont(new Font("΢���ź�",Font.PLAIN, 16));
		absenteeismDaysJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// ���ÿ��������ı���
		absenteeismDaysField = new JTextField();
		absenteeismDaysField.setName("���������������");
		// ���ý������������������ʾ����
		absenteeismDaysField.addFocusListener(new MyFocusListener(absenteeismDaysField.getName(),absenteeismDaysField));
		absenteeismDaysField.setOpaque(false); 						// �����������ı�������Ϊ͸��
		absenteeismDaysField.setBorder(null); 						// �����������ı�������Ϊ�ޱ߿�
		absenteeismDaysField.setFont(new Font("΢���ź�",Font.PLAIN, 14));	// ���ÿ��������ı������������
		// ���ÿ��������ı����������ɫΪ�ƻ��
		absenteeismDaysField.setForeground(new java.awt.Color(71, 75, 76));
		
		// ���ù���ʱ����ǩ
		workHoursJLabel = new JLabel("����ʱ��");
		workHoursJLabel.setFont(new Font("΢���ź�",Font.PLAIN, 16));
		workHoursJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// ���ù���ʱ���ı���
		workHoursField = new JTextField();
		workHoursField.setName("�����빤��ʱ����");
		// ���ý������������������ʾ����
		workHoursField.addFocusListener(new MyFocusListener(workHoursField.getName(),workHoursField));
		workHoursField.setOpaque(false); 							// ������ʱ���ı�������Ϊ͸��
		workHoursField.setBorder(null); 							// ������ʱ���ı�������Ϊ�ޱ߿�
		workHoursField.setFont(new Font("΢���ź�",Font.PLAIN, 14));	// ���ù���ʱ���ı������������
		// ���ù���ʱ���ı����������ɫΪ�ƻ��
		workHoursField.setForeground(new java.awt.Color(71, 75, 76));
		
		// ���ù����Ƽ���ǩ
		workPieceJLabel = new JLabel("�����Ƽ�");
		workPieceJLabel.setFont(new Font("΢���ź�",Font.PLAIN, 16));
		workPieceJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// ���ù����Ƽ��ı���
		workPieceField = new JTextField();
		workPieceField.setName("�����빤���Ƽ���");
		// ���ý������������������ʾ����
		workPieceField.addFocusListener(new MyFocusListener(workPieceField.getName(),workPieceField));
		workPieceField.setOpaque(false); 							// �������Ƽ��ı�������Ϊ͸��
		workPieceField.setBorder(null); 							// �������Ƽ��ı�������Ϊ�ޱ߿�
		workPieceField.setFont(new Font("΢���ź�",Font.PLAIN, 14));	// ���ù����Ƽ��ı������������
		// ���ù����Ƽ��ı����������ɫΪ�ƻ��
		workPieceField.setForeground(new java.awt.Color(71, 75, 76));
		
		// ���ý���������ǩ
		awardNumberJLabel = new JLabel("��������");
		awardNumberJLabel.setFont(new Font("΢���ź�",Font.PLAIN, 16));
		awardNumberJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// ���ý��������ı���
		awardNumberField = new JTextField();
		awardNumberField.setName("�����뽱��������");
		// ���ý������������������ʾ����
		awardNumberField.addFocusListener(new MyFocusListener(awardNumberField.getName(),awardNumberField));
		awardNumberField.setOpaque(false); 							// �����������ı�������Ϊ͸��
		awardNumberField.setBorder(null); 							// �����������ı�������Ϊ�ޱ߿�
		awardNumberField.setFont(new Font("΢���ź�",Font.PLAIN, 14));	// ���ý��������ı������������
		// ���ý��������ı����������ɫΪ�ƻ��
		awardNumberField.setForeground(new java.awt.Color(71, 75, 76));
		
		// ���óͷ�������ǩ
		punishmentNumberJLabel = new JLabel("�ͷ�����");
		punishmentNumberJLabel.setFont(new Font("΢���ź�",Font.PLAIN, 16));
		punishmentNumberJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// ���óͷ������ı���
		punishmentNumberField = new JTextField();
		punishmentNumberField.setName("������ͷ�������");
		// ���ý������������������ʾ����
		punishmentNumberField.addFocusListener(new MyFocusListener(punishmentNumberField.getName(),punishmentNumberField));
		punishmentNumberField.setOpaque(false); 					// ���ͷ������ı�������Ϊ͸��
		punishmentNumberField.setBorder(null); 						// ���ͷ������ı�������Ϊ�ޱ߿�
		punishmentNumberField.setFont(new Font("΢���ź�",Font.PLAIN, 14));	// ���óͷ������ı������������
		// ���óͷ������ı����������ɫΪ�ƻ��
		punishmentNumberField.setForeground(new java.awt.Color(71, 75, 76));
		
		// ���õڼ����ȱ�ǩ
		manyQuartersJLabel = new JLabel("�ڼ�����");
		manyQuartersJLabel.setFont(new Font("΢���ź�",Font.PLAIN, 16));
		manyQuartersJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// ���õڼ������ı���
		manyQuartersField = new JTextField();
		manyQuartersField.setName("������ڼ����ȣ�");
		// ���ý������������������ʾ����
		manyQuartersField.addFocusListener(new MyFocusListener(manyQuartersField.getName(),manyQuartersField));
		manyQuartersField.setOpaque(false); 						// ���ڼ������ı�������Ϊ͸��
		manyQuartersField.setBorder(null); 							// ���ڼ������ı�������Ϊ�ޱ߿�
		manyQuartersField.setFont(new Font("΢���ź�",Font.PLAIN, 14));	// ���õڼ������ı������������
		// ���õڼ������ı����������ɫΪ�ƻ��
		manyQuartersField.setForeground(new java.awt.Color(71, 75, 76));
		
		// ���ù���������ǩ
		jobContentJLabel = new JLabel("��������");
		jobContentJLabel.setFont(new Font("΢���ź�",Font.PLAIN, 16));
		jobContentJLabel.setForeground(new java.awt.Color(255, 255, 255));
		
		// ���ù�������������
		jobContentBox = new JComboBox();
		jobContentBox.addItem("����");
		jobContentBox.addItem("����");
		jobContentBox.addItem("�ϸ�");
		jobContentBox.addItem("���ϸ�");
		jobContentBox.setBackground(Color.WHITE);					// ���������򱳾���ɫ
		jobContentBox.setFont(new Font("΢���ź�",Font.PLAIN, 14));		// ���ù����������������������
    	jobContentBox.setForeground(new java.awt.Color(71, 75, 76));// ����������������ɫ
    	jobContentBox.addActionListener((ActionListener) this);		// ����¼�����
    	
    	// ���ù��ո��Ʊ�ǩ
    	processImproveJLabel = new JLabel("���ո���");
    	processImproveJLabel.setFont(new Font("΢���ź�",Font.PLAIN, 16));
    	processImproveJLabel.setForeground(new java.awt.Color(255, 255, 255));
    	
    	// ���ù��ո���������
    	processImproveBox = new JComboBox();
    	processImproveBox.addItem("B");
    	processImproveBox.setBackground(Color.WHITE); 
    	processImproveBox.setFont(new Font("΢���ź�",Font.PLAIN, 14));	// �������������������
    	processImproveBox.setForeground(new java.awt.Color(71, 75, 76));
    	processImproveBox.addActionListener((ActionListener) this);
    	
    	// ���ü��ȵȼ���ǩ
    	quarterClassJLabel = new JLabel("���ȵȼ�");
    	quarterClassJLabel.setFont(new Font("΢���ź�",Font.PLAIN, 16));
    	quarterClassJLabel.setForeground(new java.awt.Color(255, 255, 255));
    	
    	// ���ü��ȵȼ�������
    	quarterClassBox = new JComboBox();
    	quarterClassBox.addItem("A+");
    	quarterClassBox.addItem("A");
    	quarterClassBox.addItem("B+");
    	quarterClassBox.addItem("B");
    	quarterClassBox.addItem("C+");
    	quarterClassBox.addItem("C");
    	quarterClassBox.setBackground(Color.WHITE); 
    	quarterClassBox.setFont(new Font("΢���ź�",Font.PLAIN, 14));	// �������������������
    	quarterClassBox.setForeground(new java.awt.Color(71, 75, 76));
    	quarterClassBox.addActionListener((ActionListener) this);
    	
    	// ������ӽ���ķ�����ť
    	add_analyseButton = new JButton("   �� ��   ");
    	add_analyseButton.setContentAreaFilled(false); 				// ����ӽ���ķ�����ť����Ϊ͸��
    	add_analyseButton.setBorder(null); 							// ����ӽ���ķ�����ť����Ϊ�ޱ߿�
    	add_analyseButton.setFont(new Font("΢���ź�", Font.PLAIN, 17));  	// ������ӽ���ķ�����ť����������
    	// ������ӽ���ķ�����ť��������ɫΪ��ɫ
    	add_analyseButton.setForeground(new java.awt.Color(255, 255, 255));	
    	add_analyseButton.addActionListener((ActionListener) this);	// ����ӽ���ķ�����ť����¼�����
    	
    	// ������ӽ���ı��水ť
    	add_saveButton = new JButton("   �� ��   ");
    	add_saveButton.setContentAreaFilled(false); 				// ����ӽ���ı��水ť����Ϊ͸��
    	add_saveButton.setBorder(null); 							// ����ӽ���ı��水ť����Ϊ�ޱ߿�
    	add_saveButton.setFont(new Font("΢���ź�", Font.PLAIN, 17));  	// ������ӽ���ı��水ť����������
    	// ������ӽ���ı��水ť��������ɫΪ��ɫ
    	add_saveButton.setForeground(new java.awt.Color(255, 255, 255));	
    	add_saveButton.addActionListener((ActionListener) this);	// ����ӽ���ı��水ť����¼�����
    	
    	// ������ӽ���Ĺرհ�ť
    	add_closeButton = new JButton("      ");
    	add_closeButton.setContentAreaFilled(false); 				// ����ӽ���Ĺرհ�ť����Ϊ͸��
    	add_closeButton.setBorder(null); 							// ����ӽ���Ĺرհ�ť����Ϊ�ޱ߿�
    	add_closeButton.addActionListener((ActionListener) this);	// ����ӽ���Ĺرհ�ť����¼�����
		
    	// ���÷�����ӽ���ͼƬ�ı�ǩ
    	add_windowJLabel = new JLabel(new ImageIcon("image/addInformation.png"));
    	
		
		
//		panel******************************************************************************************************
		
		// ����������
		left_functionJPanel = new JPanel();
		left_functionJPanel.setOpaque(false); 						// ����left_functionJPanel͸��
		left_functionJPanel.setLayout(new GridLayout(4, 1, 0, 35)); // ����left_functionJPanelΪ���Բ��֣�����һ�У��ݼ��Ϊ25
		left_functionJPanel.setBounds(21, 140, 140, 231); 			// ����left_functionJPanel����λ�úʹ�С
		left_functionJPanel.add(addButton);							// ����Ӱ�ť��ӵ�left_functionJPanel���
		left_functionJPanel.add(modifyButton);
		left_functionJPanel.add(deleteButton);
		left_functionJPanel.add(analyseButton);
		
		// �������������
		search_boxJPanel = new JPanel();
		search_boxJPanel.setOpaque(false); 							// ���������������Ϊ͸��
		search_boxJPanel.setLayout(new GridLayout(1, 1, 0, 0)); 	// ����Ϊ���Բ��֣�һ��һ��
		search_boxJPanel.setBounds(715, 23, 290, 40); 				// ��������������λ�úʹ�С
		search_boxJPanel.add(searchField);							// �������ı�����ӵ����������
		
		// ����������ť���
		search_buttonJPanel = new JPanel();
		search_buttonJPanel.setOpaque(false); 						// ��������ť�������Ϊ͸��
		search_buttonJPanel.setLayout(new GridLayout(1, 1, 0, 0)); 	// ����Ϊ���Բ��֣�һ��һ��
		search_buttonJPanel.setBounds(1020, 23, 82, 40); 			// ����������ť����λ�úʹ�С
		search_buttonJPanel.add(searchButton);						// ��������ť��ӵ�������ť���
		
		// ������ӽ������
		addInformation_windowJPanel = new JPanel();
		addInformation_windowJPanel.setOpaque(false);
		addInformation_windowJPanel.setLayout(new GridLayout(1, 1, 0, 0));
		addInformation_windowJPanel.setBounds(320, 110, 800, 500);
		addInformation_windowJPanel.add(add_windowJLabel);
		
		
		// ������ӽ�����������������
		add_nameAndnumJPanel = new JPanel();
		add_nameAndnumJPanel.setOpaque(false);
		add_nameAndnumJPanel.setLayout(new GridLayout(1, 2, 135, 0));
		add_nameAndnumJPanel.setBounds(470, 154, 480, 35);
		add_nameAndnumJPanel.add(nameField);
		add_nameAndnumJPanel.add(jobNumberField);
		
		// ������ӽ����������Ϣ���
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
		
		// ������ӽ���İ�ť���
		add_buttonJPanel = new JPanel();
		add_buttonJPanel.setOpaque(false);
		add_buttonJPanel.setLayout(new GridLayout(1, 2, 35, 0)); 
		add_buttonJPanel.setBounds(895, 555, 195, 35);
		add_buttonJPanel.add(add_analyseButton);
		add_buttonJPanel.add(add_saveButton);
		
		// ������ӽ���Ĺرհ�ť���
		add_closeJPanel = new JPanel();
		add_closeJPanel.setOpaque(false);
		add_closeJPanel.setLayout(new GridLayout(1, 1, 0, 0)); 
		add_closeJPanel.setBounds(1082, 120, 25, 25);
		add_closeJPanel.add(add_closeButton);
		
		// ������ӽ�������ֱ�ǩ���
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
		
		
		
		this.setTitle("��Ч����ϵͳ");									// ����ϵͳ��ǩ
		ImageIcon icon = new ImageIcon("image\\icon.png");			// ����ϵͳͼ��
		this.setIconImage(icon.getImage());							// ����JFrame���ڱ���ͼ��
	    this.setLayout(null);										// ��ղ��ֹ�����
		this.setSize(1300, 707);									// ���ô��ڿ��
		this.setLocationRelativeTo(null);							// ���������ʾ
	    
	    setWindows();												// ����setWindows���������ô���
	    Container Bottom_container = getContentPane();				// ��ʼ��Bottom_container����
	    
	    Bottom_container.add(left_functionJPanel);					// ��left_functionJPanel��ӵ�Bottom_container����
	    Bottom_container.add(search_boxJPanel);
	    Bottom_container.add(search_buttonJPanel);
	    Bottom_container.add(add_textJPanel);
	    Bottom_container.add(add_nameAndnumJPanel);
	    Bottom_container.add(add_otherInformationJPanel);
	    Bottom_container.add(add_buttonJPanel);
	    Bottom_container.add(add_closeJPanel);
	    Bottom_container.add(addInformation_windowJPanel);
	    
	    
	    this.setResizable(false);									// �����С����Ϊ���ɱ�
	    this.setVisible(true);										// ��ʾ����
	    
	    concealAdd_window();
	}
	
	// ���ô��ڵķ���
	public void setWindows(){
	    ((JPanel)this.getContentPane()).setOpaque(false);
	    ImageIcon img = new ImageIcon("image/assessBackground.png");
	    JLabel background = new JLabel(img);
	    this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	    background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	}
	
	// �¼���������
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addButton) {							// ���������Ӱ�ť
			showAdd_window();										// ��ʾ��ӽ���
		}else if(e.getSource() == add_closeButton) {				// ���������ӽ���Ĺرհ�ť
			concealAdd_window();									// ������ӽ���
		}
	}
	
	
	// ��ʾ��ӽ���ķ���
	public void showAdd_window() {
		addInformation_windowJPanel.setVisible(true);
		add_buttonJPanel.setVisible(true);
		add_closeJPanel.setVisible(true);
		add_nameAndnumJPanel.setVisible(true);
		add_otherInformationJPanel.setVisible(true);
		add_textJPanel.setVisible(true);
	}
	
	// ������ӽ���ķ���
	public void concealAdd_window() {
		addInformation_windowJPanel.setVisible(false);
		add_buttonJPanel.setVisible(false);
		add_closeJPanel.setVisible(false);
		add_nameAndnumJPanel.setVisible(false);
		add_otherInformationJPanel.setVisible(false);
		add_textJPanel.setVisible(false);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Assess_modules();
	}
}
