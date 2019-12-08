package example.jasper.ex1_helloworld;

import net.sf.jasperreports.engine.JRException;
import org.junit.Test;

public class ReportGeneratorHelloWorldTest {

    @Test
    public void generatePdfFromXml() throws JRException {
        ReportGeneratorHelloWorld.generateFromXml();
    }

    @Test
    public void generatePdfFromBin() throws JRException {
        ReportGeneratorHelloWorld.generateFromBin();
    }
}
