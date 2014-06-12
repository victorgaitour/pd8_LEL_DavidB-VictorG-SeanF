
import org.jfree.*;
import javax.swing.*;

public class PieChart extends JFrame {

    DefaultPieDataset data;
    String title;

    public PieChart( String t ) {
	data = new DefaultPieDataset();
	title = t;
    }

    public void addValue( String s ) {
	pieDataset.setValue( s, Integer.parseInt(s) );
    }

    public ChartPanel createChart() {
	System.out.println( "Creating chart..." );
	PiePlot plot = new PiePlot( data );
	JFreeChart chartFree = new JFreeChart( plot );
	ChartPanel chart = new ChartPanel(chartFree);
	return chart;
    }
}
