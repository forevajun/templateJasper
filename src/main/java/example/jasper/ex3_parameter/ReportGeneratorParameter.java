package example.jasper.ex3_parameter;

import example.jasper.Constants;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import java.util.HashMap;

public class ReportGeneratorParameter {

    public static void generate() throws JRException {
        JasperReport jasperReport;
        JasperPrint jasperPrint;

        Model model = ModelCreater.getModel();

        jasperReport = JasperCompileManager.compileReport(Constants.PATH_JRXML + "parameter.jrxml");

        HashMap<String, Object> params = new HashMap<>();
        params.put("DOC", model);

        jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint, Constants.PATH_PDF + "parameter.pdf");
    }

}
