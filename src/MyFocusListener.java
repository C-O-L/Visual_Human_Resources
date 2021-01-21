import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

// 提示文字通用方法类
public class MyFocusListener implements FocusListener {

	String info;
    JTextField jtf;
    public MyFocusListener(String info, JTextField jtf) {
        this.info = info;
        this.jtf = jtf;
    }
	
	public void focusGained(FocusEvent e) {					// 获得焦点的时候,清空提示文字
		// TODO Auto-generated method stub
		String temp = jtf.getText();
        if(temp.equals(info)){
            jtf.setText("");
//            Login_modules lomo = new Login_modules();
//            lomo.concealpassWordlogin();
        }
	}

	public void focusLost(FocusEvent e) {					// 失去焦点的时候,判断如果为空,就显示提示文字
		// TODO Auto-generated method stub
		String temp = jtf.getText();
        if(temp.equals("")){
            jtf.setText(info);
//            Login_modules lomo = new Login_modules();
//            lomo.showpassWordlogin();
        }
	}
}
