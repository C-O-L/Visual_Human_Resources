import java.util.Date;

import java.text.SimpleDateFormat;

// ��ȡʱ�����
public class Time {
	// ��ʾʱ��ķ���
	public void showDate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  	// �������ڸ�ʽ
		String time = df.format(new Date()); 									// new Date()Ϊ��ȡ��ǰϵͳʱ��
        System.out.println(time);								
	}
	
	public static void main(String arg[]) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date()); 
        System.out.println(time);
	}
}
