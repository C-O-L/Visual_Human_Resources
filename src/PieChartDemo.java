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

	ChartPanel pieChart;											// ���ñ�״ͼ
	ChartPanel histogram;											// ������״ͼ
	ChartPanel lineChart;											// ��������ͼ

    /**
     * ������״ͼ�Ĳ������£� 1������һ����״��ʵ����ע�⴫�εĸ�ʽ��������Ҫע����Ǵ�ʱ�����ݼ�Ӧ����defaultPieDataset��
     * ������CategoryDataset��ʽ 2����ñ�״ͼ���������� 3������������ʽ�������ݸ�ʽ��Ϊ����Ĵ��ܱ�״ͼ��ʵ��������
     * 4��ϸ�ڷ����Ƕ������ݡ���ֵ����ֵ������Ĵ��� 5�������������ڳ��ֺ��ֵĵط������������ݵ������ˣ�ͬ���ģ�����Ϊ�˷�ֹ���������״����
     */
    public PieChartDemo() {
        DefaultPieDataset dataset = getDataset();

        JFreeChart chart = ChartFactory.createPieChart("ѧУռ�����", dataset,
                true, false, false);

        PiePlot piePlot = (PiePlot) chart.getPlot();
        DecimalFormat df = new DecimalFormat("0.00%");
        NumberFormat nf = NumberFormat.getInstance();

        StandardPieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
                "{0} {2}",                   //���StandardPieSectionLabelGenerator����,���ɵĸ�ʽ��{0}��ʾsection����
                //{1}��ʾsection��ֵ��{2}��ʾ�ٷֱȡ������Զ���   
                nf, df);
        piePlot.setLabelGenerator(generator);// ���ðٷֱ�
        piePlot.setLabelFont(new Font("����", Font.ITALIC, 20));

        // ����״ͼ�ڶ���������ʱ������������������
        piePlot.setNoDataMessage("��ʱ��û���κ����ݿ���");
        piePlot.setCircular(false);
        piePlot.setLabelGap(0.02D);

        piePlot.setIgnoreNullValues(true);// ���ò���ʾ��λ
        piePlot.setIgnoreZeroValues(true);// ���ò���ʾ��ֵ����ֵ

        pieChart = new ChartPanel(chart, true);
        chart.getTitle().setFont(new Font("����", Font.BOLD, 18));
        chart.getLegend().setItemFont(new Font("����", Font.BOLD, 20));

//        //����������żȻ����������ͼ��ͼƬ�ķ���
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
//        }//����һ��pngͼƬ  
        
        
        XYDataset xydataset = createDataset(); 
	    JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Legal & General��λ���л���۸�", "����", "�۸�",xydataset, true, true, true); 
	    XYPlot xyplot = (XYPlot) jfreechart.getPlot(); 
	    DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis(); 
	    dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy")); 
	    lineChart=new ChartPanel(jfreechart,true); 
	    dateaxis.setLabelFont(new Font("����",Font.BOLD,14));     //ˮƽ�ײ����� 
	    dateaxis.setTickLabelFont(new Font("����",Font.BOLD,12)); //��ֱ���� 
	    ValueAxis rangeAxis=xyplot.getRangeAxis();//��ȡ��״ 
	    rangeAxis.setLabelFont(new Font("����",Font.BOLD,15)); 
	    jfreechart.getLegend().setItemFont(new Font("����", Font.BOLD, 15)); 
	    jfreechart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ������� 

    }

    /**
     * ��Ҫע������������ݼ���������ݵ�ʱ����õ���dataset.setvalue()��������������״ͼ�е�addValue()����
     * ��һ��Ӧ������ע��һ�£�������ʹ�õ�ʱ����ִ���
     * @return
     */
    private DefaultPieDataset getDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("��1", 1);
        dataset.setValue("��2", 2);
        dataset.setValue("��3", 3);
        dataset.setValue("��4", 4);
        dataset.setValue("��5", 3);
        dataset.setValue("��6", 2);
        dataset.setValue("��7", 1);
        return dataset;
    }

    public ChartPanel getPieChartPanel() {
        return pieChart;
    }
    
    private static XYDataset createDataset() { //������ݼ��е�࣬����������� 
	      TimeSeries timeseries = new TimeSeries("legal & generalŷ��ָ������", 
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