package example.jasper.ex7_subreport;

import net.sf.jasperreports.engine.JRException;
import org.junit.Test;

public class ReportGeneratorSubreportTest {
    @Test
    public void generatePdf() throws JRException {
        ReportGeneratorSubReport.generate();
    }
}
