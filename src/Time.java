import java.util.Date;

import java.text.SimpleDateFormat;

// 获取时间的类
public class Time {
	// 显示时间的方法
	public void showDate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  	// 设置日期格式
		String time = df.format(new Date()); 									// new Date()为获取当前系统时间
        System.out.println(time);								
	}
	
	public static void main(String arg[]) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date()); 
        System.out.println(time);
	}
}
