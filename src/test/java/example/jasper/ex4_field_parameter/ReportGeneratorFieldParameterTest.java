package example.jasper.ex4_field_parameter;

import net.sf.jasperreports.engine.JRException;
import org.junit.Test;

public class ReportGeneratorFieldParameterTest {
    @Test
    public void generatePdf() throws JRException {
        ReportGeneratorFieldParameter.generate();
    }
}
