package example.jasper.ex7_subreport;

import example.jasper.Constants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

import java.util.HashMap;
import java.util.Map;

public class Subreport {

    public static Map<String, JasperReport> getSubreports() throws JRException {
        Map<String, JasperReport> subReports = new HashMap<>();

        JasperReport subReport1 = JasperCompileManager.compileReport(Constants.PATH_JRXML + "subreport_sub1.jrxml");
        JasperReport subReport2 = JasperCompileManager.compileReport(Constants.PATH_JRXML + "subreport_sub2.jrxml");

        subReports.put("subreport_sub1", subReport1);
        subReports.put("subreport_sub2", subReport2);

        return subReports;
    }
}
