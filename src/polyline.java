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
	double one;									// 第一季度绩效
	double two;									// 第二季度绩效
	double three;
	double four;
	
	public boolean isPoly = false;				// 布尔判断是否生成了折线图
	
	public polyline(){
	}
		
		StandardChartTheme theme = new StandardChartTheme("unicode") {  
	    	//重写apply(...)方法是为了借机消除文字锯齿.VALUE_TEXT_ANTIALIAS_OFF
		    public void apply(JFreeChart chart) {  
		    	chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,  
		    	       RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);  
		    	super.apply(chart);  
		    }  
		};
		
	public void createPoly() {
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
        mChartTheme.setLargeFont(new Font("微软雅黑", Font.BOLD, 20));
        mChartTheme.setExtraLargeFont(new Font("微软雅黑", Font.PLAIN, 15));
        mChartTheme.setRegularFont(new Font("微软雅黑", Font.PLAIN, 15));
        ChartFactory.setChartTheme(mChartTheme);
        
        CategoryDataset mDataset = GetDataset();
        JFreeChart mChart = ChartFactory.createLineChart(
                "潜力分析",						// 图名字
                "季度",						// 横坐标
                "绩效",						// 纵坐标
                mDataset,					// 数据集
                PlotOrientation.VERTICAL,
                true, 						// 显示图例
                true, 						// 采用标准生成器
                false);						// 是否生成超链接

        CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
        mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
        mPlot.setRangeGridlinePaint(Color.BLUE);		// 背景底部横虚线
        mPlot.setOutlinePaint(Color.RED);				// 边界线

        // 保存为图片
        FileOutputStream fos_jpg = null;
        try {
            fos_jpg = new FileOutputStream("image\\polyline.png");
            ChartUtilities.writeChartAsPNG(fos_jpg, mChart, 600, 400, null);
            System.out.println("成功显示折线图！");
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
        mDataset.addValue(one, "", "第一季度");
        mDataset.addValue(two, "", "第二季度");
        mDataset.addValue(three, "", "第三季度");
        mDataset.addValue(four, "", "第四季度");
        return mDataset;
    }
     
    // 接收员工姓名与考核结果
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