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
	 * 截图
	 * 
	 * @param filePath
	 *            截图保存文件夹路径
	 * @param fileName
	 *            截图文件名称
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
				// 截图保存的路径
				File screenFile = new File(filePath + fileName);
				// 如果文件夹路径不存在，则创建
				if (!screenFile.getParentFile().exists()) {
					screenFile.getParentFile().mkdirs();
				}
		 
				// 指定屏幕区域，参数为截图左上角坐标(404,215)+右下角坐标(1703,860)
				BufferedImage subimage = image.getSubimage(404, 215, 1500, 860);
				ImageIO.write(subimage, "png", screenFile);
				System.out.println("截图");
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