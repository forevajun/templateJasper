package example.jasper.ex2_field;

import net.sf.jasperreports.engine.JRException;
import org.junit.Test;

public class ReportGeneratorFieldTest {
    @Test
    public void generatePdf() throws JRException {
        ReportGeneratorField.generate();
    }
}
