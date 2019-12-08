package example.jasper.ex5_stretch;

import net.sf.jasperreports.engine.JRException;
import org.junit.Test;

public class ReportGeneratorStretchTest {
    @Test
    public void generatePdf() throws JRException {
        ReportGeneratorStretch.generate();
    }
}
