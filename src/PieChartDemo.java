import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class PieChartDemo {

	ChartPanel pieChart;											// 放置饼状图
	ChartPanel histogram;											// 放置柱状图
	ChartPanel lineChart;											// 放置折线图

    /**
     * 创建饼状图的步骤如下： 1、创建一个饼状的实例，注意传参的格式，还有需要注意的是此时的数据集应该是defaultPieDataset，
     * 而不是CategoryDataset格式 2、获得饼状图的所在区域 3、设置两个格式化的数据格式，为后面的床架饼状图的实例做基础
     * 4、细节方面是对无数据、零值、负值等情况的处理 5、最后就是设置在出现汉字的地方进行字体内容的设置了（同样的，这是为了防止出现乱码的状况）
     */
    public PieChartDemo() {
        DefaultPieDataset dataset = getDataset();

        JFreeChart chart = ChartFactory.createPieChart("学校占比情况", dataset,
                true, false, false);

        PiePlot piePlot = (PiePlot) chart.getPlot();
        DecimalFormat df = new DecimalFormat("0.00%");
        NumberFormat nf = NumberFormat.getInstance();

        StandardPieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
                "{0} {2}",                   //获得StandardPieSectionLabelGenerator对象,生成的格式，{0}表示section名，
                //{1}表示section的值，{2}表示百分比。可以自定义   
                nf, df);
        piePlot.setLabelGenerator(generator);// 设置百分比
        piePlot.setLabelFont(new Font("黑体", Font.ITALIC, 20));

        // 当饼状图内额米有数据时，作如下数据中设置
        piePlot.setNoDataMessage("此时并没有任何数据可用");
        piePlot.setCircular(false);
        piePlot.setLabelGap(0.02D);

        piePlot.setIgnoreNullValues(true);// 设置不显示空位
        piePlot.setIgnoreZeroValues(true);// 设置不显示负值或零值

        pieChart = new ChartPanel(chart, true);
        chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
        chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 20));

//        //下面是王章偶然看到的生成图表图片的方法
//        File dir = new File("E:\\Desktop\\");   
//        if (!dir.exists()) {  
//            dir.mkdir();  
//        }  
//        String fName = String.valueOf(System.currentTimeMillis())+"pie.png";  
//        File file = new File("E:\\Desktop\\", fName);  
//        try {
//            ChartUtilities.saveChartAsPNG(file, chart, 400, 250);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }//生成一个png图片  
        
        
        XYDataset xydataset = createDataset(); 
	    JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Legal & General单位信托基金价格", "日期", "价格",xydataset, true, true, true); 
	    XYPlot xyplot = (XYPlot) jfreechart.getPlot(); 
	    DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis(); 
	    dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy")); 
	    lineChart=new ChartPanel(jfreechart,true); 
	    dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));     //水平底部标题 
	    dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12)); //垂直标题 
	    ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状 
	    rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15)); 
	    jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15)); 
	    jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体 

    }

    /**
     * 需要注意的是在向数据集中添加数据的时候调用的是dataset.setvalue()方法，而不是柱状图中的addValue()方法
     * 这一点应该尤其注意一下，以免在使用的时候出现错误
     * @return
     */
    private DefaultPieDataset getDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("郭1", 1);
        dataset.setValue("郭2", 2);
        dataset.setValue("郭3", 3);
        dataset.setValue("郭4", 4);
        dataset.setValue("郭5", 3);
        dataset.setValue("郭6", 2);
        dataset.setValue("郭7", 1);
        return dataset;
    }

    public ChartPanel getPieChartPanel() {
        return pieChart;
    }
    
    private static XYDataset createDataset() { //这个数据集有点多，但都不难理解 
	      TimeSeries timeseries = new TimeSeries("legal & general欧洲指数信任", 
	          org.jfree.data.time.Month.class); 
	      timeseries.add(new Month(2, 2001), 181.80000000000001D); 
	      timeseries.add(new Month(3, 2001), 167.30000000000001D); 
	      timeseries.add(new Month(4, 2001), 153.80000000000001D); 
	      timeseries.add(new Month(5, 2001), 167.59999999999999D); 
	      timeseries.add(new Month(6, 2001), 158.80000000000001D); 
	      timeseries.add(new Month(7, 2001), 148.30000000000001D); 
	      timeseries.add(new Month(8, 2001), 153.90000000000001D); 
	      timeseries.add(new Month(9, 2001), 142.69999999999999D); 
	      timeseries.add(new Month(10, 2001), 123.2D); 
	      timeseries.add(new Month(11, 2001), 131.80000000000001D); 
	      timeseries.add(new Month(12, 2001), 139.59999999999999D); 
	      timeseries.add(new Month(1, 2002), 142.90000000000001D); 
	      timeseries.add(new Month(2, 2002), 138.69999999999999D); 
	      timeseries.add(new Month(3, 2002), 137.30000000000001D); 
	      timeseries.add(new Month(4, 2002), 143.90000000000001D); 
	      timeseries.add(new Month(5, 2002), 139.80000000000001D); 
	      timeseries.add(new Month(6, 2002), 137D); 
	      timeseries.add(new Month(7, 2002), 132.80000000000001D); 
	      TimeSeriesCollection timeseriescollection = new TimeSeriesCollection(); 
	      timeseriescollection.addSeries(timeseries); 
	//      timeseriescollection.addSeries(timeseries1); 
	      return timeseriescollection; 
    } 
    public ChartPanel getChartPanel(){ 
		return lineChart; 
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.add(new PieChartDemo().getPieChartPanel());
        frame.add(new PieChartDemo().getChartPanel());
        
        frame.setSize(1000, 700);
        frame.setVisible(true);
    }

}