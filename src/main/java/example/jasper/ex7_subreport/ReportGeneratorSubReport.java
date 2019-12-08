package example.jasper.ex7_subreport;

import example.jasper.Constants;
import example.jasper.ex6_paramToTable.Model;
import example.jasper.ex6_paramToTable.ModelCreator;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import java.util.HashMap;

public class ReportGeneratorSubReport {

    public static void generate() throws JRException {
        JasperReport jasperReport;
        JasperPrint jasperPrint;


        jasperReport = JasperCompileManager.compileReport(Constants.PATH_JRXML + "subreport.jrxml");

        HashMap<String, Object> params = new HashMap<>();
        params.put("SUBREPORT_MAP", Subreport.getSubreports());

        jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint, Constants.PATH_PDF + "subreport.pdf");
    }
}
