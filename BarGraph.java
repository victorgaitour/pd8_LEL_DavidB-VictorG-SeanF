
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.*;
import org.jfree.data.general.*;
import org.jfree.data.category.*;
import javax.swing.*;

/************************************
TO COMPILE:
javac -classpath "lib/jfreechart-1.0.17.jar:jcommon-1.0.22/jcommon-1.0.22.jar" PieChart.java

TO RUN:
java -classpath "lib/jfreechart-1.0.17.jar:jcommon-1.0.22/jcommon-1.0.22.jar" PieChart
************************************/

public class BarGraph extends JFrame {

    DefaultCategoryDataset dataset;
    String title;
    String xtitle;
    String ytitle;

    public BarGraph( String t, String xaxis, String yaxis ) {
	dataset = new DefaultCategoryDataset();
	title = t;
	xtitle = xaxis;
	ytitle = yaxis;
    }

    public void addValue( String s ) {
	dataset.addValue( Integer.parseInt( s.substring( s.indexOf(":")+1, s.length() ) ), s.substring(0, s.indexOf(":")), xtitle );
    }

    public ChartPanel createBarGraph() {
	System.out.println( "Creating graph..." );
	JFreeChart chart = ChartFactory.createBarChart( title, xtitle, ytitle, dataset, PlotOrientation.VERTICAL, true, true, false );
	ChartPanel panel = new ChartPanel( chart );
	return panel;
    }
}
