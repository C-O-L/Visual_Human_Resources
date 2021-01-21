import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
    
public class Screenshot {
	
	/**
	 * 
	 */

	public Screenshot() {
		
	}
	 
	/**
	 * ��ͼ
	 * 
	 * @param filePath
	 *            ��ͼ�����ļ���·��
	 * @param fileName
	 *            ��ͼ�ļ�����
	 * @throws IOException 
	 * @throws AWTException 
	 * @throws Exception
	 */
	
	public static void captureScreen(String filePath, String fileName){
		
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRectangle = new Rectangle(screenSize);
			FileOutputStream fos_jpg = null;
			try {
				Robot robot = new Robot();
				BufferedImage image = robot.createScreenCapture(screenRectangle);
				// ��ͼ�����·��
				File screenFile = new File(filePath + fileName);
				// ����ļ���·�������ڣ��򴴽�
				if (!screenFile.getParentFile().exists()) {
					screenFile.getParentFile().mkdirs();
				}
		 
				// ָ����Ļ���򣬲���Ϊ��ͼ���Ͻ�����(404,215)+���½�����(1703,860)
				BufferedImage subimage = image.getSubimage(404, 215, 1500, 860);
				ImageIO.write(subimage, "png", screenFile);
				System.out.println("��ͼ");
			}catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	            try {
	                fos_jpg.close();
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
	        }
		
	}
	
	public static void main(String[] args){
			new Screenshot();
			Date now = new Date();
			SimpleDateFormat sdfPath = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sdfName = new SimpleDateFormat("yyyyMMddHHmmss");
			String path = sdfPath.format(now);
			String name = sdfName.format(now);
			captureScreen("E:\\Desktop" + File.separator + path + File.separator, name + ".png");
			System.out.println("jietu");
	}
}