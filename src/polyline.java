import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class polyline {
	double one;									// ��һ���ȼ�Ч
	double two;									// �ڶ����ȼ�Ч
	double three;
	double four;
	
	public boolean isPoly = false;				// �����ж��Ƿ�����������ͼ
	
	public polyline(){
	}
		
		StandardChartTheme theme = new StandardChartTheme("unicode") {  
	    	//��дapply(...)������Ϊ�˽���������־��.VALUE_TEXT_ANTIALIAS_OFF
		    public void apply(JFreeChart chart) {  
		    	chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,  
		    	       RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);  
		    	super.apply(chart);  
		    }  
		};
		
	public void createPoly() {
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
        mChartTheme.setLargeFont(new Font("΢���ź�", Font.BOLD, 20));
        mChartTheme.setExtraLargeFont(new Font("΢���ź�", Font.PLAIN, 15));
        mChartTheme.setRegularFont(new Font("΢���ź�", Font.PLAIN, 15));
        ChartFactory.setChartTheme(mChartTheme);
        
        CategoryDataset mDataset = GetDataset();
        JFreeChart mChart = ChartFactory.createLineChart(
                "Ǳ������",						// ͼ����
                "����",						// ������
                "��Ч",						// ������
                mDataset,					// ���ݼ�
                PlotOrientation.VERTICAL,
                true, 						// ��ʾͼ��
                true, 						// ���ñ�׼������
                false);						// �Ƿ����ɳ�����

        CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
        mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
        mPlot.setRangeGridlinePaint(Color.BLUE);		// �����ײ�������
        mPlot.setOutlinePaint(Color.RED);				// �߽���

        // ����ΪͼƬ
        FileOutputStream fos_jpg = null;
        try {
            fos_jpg = new FileOutputStream("image\\polyline.png");
            ChartUtilities.writeChartAsPNG(fos_jpg, mChart, 600, 400, null);
            System.out.println("�ɹ���ʾ����ͼ��");
            isPoly = true;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos_jpg.close();
            } catch (Exception e) {
            	
            }
        }
    }

    private DefaultCategoryDataset GetDataset(){
    	DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
        mDataset.addValue(one, "", "��һ����");
        mDataset.addValue(two, "", "�ڶ�����");
        mDataset.addValue(three, "", "��������");
        mDataset.addValue(four, "", "���ļ���");
        return mDataset;
    }
     
    // ����Ա�������뿼�˽��
    public void getDataset(String oneString, String twoString, String threeString, String fourString) {
    	one = Double.parseDouble(oneString);
    	two = Double.parseDouble(twoString);
    	three = Double.parseDouble(threeString);
    	four = Double.parseDouble(fourString);
		createPoly();
	}
     
    
	public static void main(String[] args) {
		new polyline();
	}
}