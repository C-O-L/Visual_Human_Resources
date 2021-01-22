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
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.Layer;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.TextAnchor;

public class BarChart {
	
	String staffName;										// 员工姓名
	double assessResult;									// 考核结果
	double deductMarks;										// 扣分
	
    public BarChart() {
    	 
    }

    StandardChartTheme theme = new StandardChartTheme("unicode") {  
    	//重写apply(...)方法是为了借机消除文字锯齿.VALUE_TEXT_ANTIALIAS_OFF
	    public void apply(JFreeChart chart) {  
	    	chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,  
	    	       RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);  
	    	super.apply(chart);  
	    }  
	};
        
    @SuppressWarnings("deprecation")
    public void createChart() {
    	
        JFreeChart chart = ChartFactory.createRingChart(null, this.createDataset(), true, false, false);
        chart.getLegend().setVisible(false);						// 不显示底部提示
        // 环形图
        RingPlot ringplot = (RingPlot) chart.getPlot();
        ringplot.setOutlineVisible(false);							// 坐标区表框是否显示
        // {0}表示section名	{1}表示显示具体分数		{2}表示显示百分比
        ringplot.setLabelGenerator(new StandardPieSectionLabelGenerator(" {0} {1}"));
        ringplot.setBackgroundPaint(new Color(253,253,253));
        ringplot.setOutlineVisible(false);
        
        //设置标签样式
        ringplot.setLabelFont(new Font("微软雅黑", Font.PLAIN, 14));
        ringplot.setSimpleLabels(true);								// 显示文字标签
        ringplot.setLabelLinkPaint(Color.WHITE);
        ringplot.setLabelOutlinePaint(Color.WHITE);					// 标签边框颜色
        ringplot.setLabelLinksVisible(false);
        ringplot.setLabelShadowPaint(null);							// 标签阴影颜色
        ringplot.setLabelOutlinePaint(new Color(0,true));
        ringplot.setLabelBackgroundPaint(new Color(0,true));		// 标签背景颜色
        ringplot.setLabelPaint(Color.WHITE);
        
        ringplot.setSectionOutlinePaint(Color.WHITE);
        ringplot.setSeparatorsVisible(true);
        ringplot.setSeparatorPaint(Color.WHITE);
        ringplot.setShadowPaint(new Color(253,253,253));
        ringplot.setSectionDepth(0.58);
        ringplot.setStartAngle(90);									// 图片透明度
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
            fos_jpg = new FileOutputStream("image\\ring.png");
            ChartUtilities.writeChartAsPNG(fos_jpg,chart, 300, 300, null);
            System.out.println("成功显示环形图！");
            
//            //以下由于jfreechart设置背景色后，背景会有留白，直接将目标图片截取
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

    // 获得数据集 （这里的数据是为了测试我随便写的一个自动生成数据的例子）
    public PieDataset createDataset() {
    	DefaultPieDataset dataSet = new DefaultPieDataset();
        dataSet.setValue(staffName, assessResult);  
        dataSet.setValue("扣分", deductMarks);
        return dataSet;
    }
     
     
    // 接收员工姓名与考核结果
    public void getDataset(String name, String result) {
		staffName = name;
		assessResult = Double.parseDouble(result);
		deductMarks = 100.00 - Double.parseDouble(result);
		createChart();
	}
     
    
	public static void main(String[] args) {
		
		new BarChart();
	}
}