
import org.jfree.*;

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

    public JFreeChart createChart() {
	System.out.println( "Creating chart..." );
	PiePlot plot = new PiePlot( data );
	JFreeChart chart = new JFreeChart( plot );
	return chart;
    }
}
