package example.jasper.ex3_parameter;

import net.sf.jasperreports.engine.JRException;
import org.junit.Test;

public class ReportGeneratorParameterTest {
    @Test
    public void generatePdf() throws JRException {
        ReportGeneratorParameter.generate();
    }
}
