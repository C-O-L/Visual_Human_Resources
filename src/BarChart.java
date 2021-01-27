import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.Layer;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.TextAnchor;

public class BarChart {
	
	String staffName;										// Ա������
	String timePie;
	String timePoly;
	double assessResult;									// ���˽��
	double deductMarks;										// �۷�
	double one;												// ��һ���ȼ�Ч
	double two;												// �ڶ����ȼ�Ч
	double three;
	double four;
	
	public boolean isPie = false;							// �ж��Ƿ����ɻ���ͼ
	public boolean isPoly = false;							// �����ж��Ƿ�����������ͼ
	
    public BarChart() {
    	 
    }

    StandardChartTheme theme = new StandardChartTheme("unicode") {  
    	//��дapply(...)������Ϊ�˽���������־��.VALUE_TEXT_ANTIALIAS_OFF
	    public void apply(JFreeChart chart) {  
	    	chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,  
	    	       RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);  
	    	super.apply(chart);  
	    }  
	};
      
	// ����ͼ
    @SuppressWarnings("deprecation")
    public void createChart() {
    	
        JFreeChart chart = ChartFactory.createRingChart(null, this.createDataset(), true, false, false);
        chart.getLegend().setVisible(false);						// ����ʾ�ײ���ʾ
        // ����ͼ
        RingPlot ringplot = (RingPlot) chart.getPlot();
        ringplot.setOutlineVisible(false);							// ����������Ƿ���ʾ
        // {0}��ʾsection��	{1}��ʾ��ʾ�������		{2}��ʾ��ʾ�ٷֱ�
        ringplot.setLabelGenerator(new StandardPieSectionLabelGenerator(" {0} {1}"));
        ringplot.setBackgroundPaint(new Color(255,255,255));
        ringplot.setOutlineVisible(false);
        
        //���ñ�ǩ��ʽ
        ringplot.setLabelFont(new Font("΢���ź�", Font.PLAIN, 14));
        ringplot.setSimpleLabels(true);								// ��ʾ���ֱ�ǩ
        ringplot.setLabelLinkPaint(Color.WHITE);
        ringplot.setLabelOutlinePaint(Color.WHITE);					// ��ǩ�߿���ɫ
        ringplot.setLabelLinksVisible(false);
        ringplot.setLabelShadowPaint(null);							// ��ǩ��Ӱ��ɫ
        ringplot.setLabelOutlinePaint(new Color(0,true));
        ringplot.setLabelBackgroundPaint(new Color(0,true));		// ��ǩ������ɫ
        ringplot.setLabelPaint(Color.WHITE);
        
        ringplot.setSectionOutlinePaint(Color.WHITE);
        ringplot.setSeparatorsVisible(true);
        ringplot.setSeparatorPaint(Color.WHITE);
        ringplot.setShadowPaint(new Color(253,253,253));
        ringplot.setSectionDepth(0.58);
        ringplot.setStartAngle(90);									// ͼƬ͸����
        ringplot.setDrawingSupplier(new DefaultDrawingSupplier(
                new Paint[] { 
                        new Color(134, 212, 222), 
                        new Color(174, 145, 195), 
                        new Color(255, 162, 195),
                        new Color(249, 163, 86),
                        new Color(119, 173, 195)
                        },
                DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE, 
                DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE, 
                DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE));

        FileOutputStream fos_jpg = null;
        try {
        	// �����ͼƬ������ʱ������
            fos_jpg = new FileOutputStream(timePie);
            ChartUtilities.writeChartAsPNG(fos_jpg,chart, 350, 350, null);
            System.out.println("�ɹ���ʾ����ͼ��");
            isPie = true;
//            //��������jfreechart���ñ���ɫ�󣬱����������ף�ֱ�ӽ�Ŀ��ͼƬ��ȡ
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ChartUtilities.writeChartAsPNG(baos,chart, 300,300, null);
//            
//            BufferedImage bi = ImageIO.read(new ByteArrayInputStream(baos.toByteArray()));
//            BufferedImage sub = bi.getSubimage(5, 0, 290, 290);
//            ImageIO.write(sub, "png", new File("E:\\Desktop\\ring_sub.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos_jpg.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // ������ݼ� �������������Ϊ�˲��������д��һ���Զ��������ݵ����ӣ�
    public PieDataset createDataset() {
    	DefaultPieDataset dataSet = new DefaultPieDataset();
        dataSet.setValue(staffName, assessResult);  
        dataSet.setValue("�۷�", deductMarks);
        return dataSet;
    }
    
    
    // ����ͼ
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

        mChart.getLegend().setVisible(false);
        CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
        mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
        mPlot.setRangeGridlinePaint(Color.BLUE);		// �����ײ�������
        mPlot.setOutlinePaint(Color.RED);				// �߽���

        // ����ΪͼƬ
        FileOutputStream fos_jpg = null;
        try {
            fos_jpg = new FileOutputStream(timePoly);
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
    public void getDataset(String time, String name, String result, String oneString, String twoString, String threeString, String fourString) {
    	
    	staffName = name;
    	timePie = "E:\\user\\Documents\\UI\\��Ч����ϵͳUI\\����\\" + time + "pie.png";
    	timePoly = "E:\\user\\Documents\\UI\\��Ч����ϵͳUI\\����\\" + time + "poly.png";
    	
		assessResult = Double.parseDouble(result);
		deductMarks = 100.00 - Double.parseDouble(result);
		createChart();
    	
    	one = Double.parseDouble(oneString);
    	two = Double.parseDouble(twoString);
    	three = Double.parseDouble(threeString);
    	four = Double.parseDouble(fourString);
		createPoly();
	}
     
//    // ����Ա�������뿼�˽��
//    public void getDataset(String name, String result) {
//		staffName = name;
//		assessResult = Double.parseDouble(result);
//		deductMarks = 100.00 - Double.parseDouble(result);
//		createChart();
//	}
     
    
	public static void main(String[] args) {
		
		new BarChart();
	}
}