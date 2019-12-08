package example.jasper.ex5_stretch;

import example.jasper.Constants;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import java.util.HashMap;

public class ReportGeneratorStretch {

    public static void generate() throws JRException {
        JasperReport jasperReport;
        JasperPrint jasperPrint;

        Model model = getForm();

        jasperReport = JasperCompileManager.compileReport(Constants.PATH_JRXML + "stretch.jrxml");

        HashMap<String, Object> params = new HashMap<>();
        params.put("DOC", model);

        jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, Constants.PATH_PDF + "stretch.pdf");
    }

    private static Model getForm() {
        Model model = new Model();
        model.setParam1("text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text");
        model.setParam2("text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text");
        model.setParam3("text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text");
        model.setParam4("text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text");
        model.setParam5("text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text text");
        return model;
    }

}
