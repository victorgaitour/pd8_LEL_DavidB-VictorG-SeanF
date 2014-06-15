
import org.jfree.chart.*;
import org.jfree.data.*;
import org.jfree.data.general.*;
import javax.swing.*;

/************************************
TO COMPILE:
javac -classpath "lib/jfreechart-1.0.17.jar:jcommon-1.0.22/jcommon-1.0.22.jar" PieChart.java

TO RUN:
java -classpath "lib/jfreechart-1.0.17.jar:jcommon-1.0.22/jcommon-1.0.22.jar" PieChart
************************************/

public class PieChart extends JFrame {

    DefaultPieDataset data;
    String title;

    public PieChart( String t ) {
	data = new DefaultPieDataset();
	title = t;
    }

    public void addValue( String s ) {
	data.setValue( s, Integer.parseInt( s.substring( s.indexOf(":")+1, s.length() ) ) );
    }

    public ChartPanel createChart() {
	System.out.println( "Creating chart..." );
	//PiePlot plot = new PiePlot( data );
	//plot.setLabelFont( new Font("SansSerif", Font.PLAIN, 12) );
	//plot.setNoDataMessage("No data available");
	//plot.setLabelGap(0.02);
	JFreeChart chartFree = ChartFactory.createPieChart( title, data, true, true, false );
	ChartPanel chart = new ChartPanel(chartFree);
	return chart;
    }
}
