import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

// ��ʾ����ͨ�÷�����
public class MyFocusListener implements FocusListener {

	String info;
    JTextField jtf;
    public MyFocusListener(String info, JTextField jtf) {
        this.info = info;
        this.jtf = jtf;
    }
	
	public void focusGained(FocusEvent e) {					// ��ý����ʱ��,�����ʾ����
		// TODO Auto-generated method stub
		String temp = jtf.getText();
        if(temp.equals(info)){
            jtf.setText("");
//            Login_modules lomo = new Login_modules();
//            lomo.concealpassWordlogin();
        }
	}

	public void focusLost(FocusEvent e) {					// ʧȥ�����ʱ��,�ж����Ϊ��,����ʾ��ʾ����
		// TODO Auto-generated method stub
		String temp = jtf.getText();
        if(temp.equals("")){
            jtf.setText(info);
//            Login_modules lomo = new Login_modules();
//            lomo.showpassWordlogin();
        }
	}
}
