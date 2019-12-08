package example.jasper.ex6_paramToTable;

import net.sf.jasperreports.engine.JRException;
import org.junit.Test;

public class ReportGeneratorParamToTableTest {
    @Test
    public void generatePdf() throws JRException {
        ReportGeneratorParamToTable.generate();
    }
}
