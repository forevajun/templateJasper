package ru.jasper.example4_objParam;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import java.util.HashMap;

public class Ex4 {

    private static String jrxmlPath = "src\\main\\resources\\jasperreports\\";
    private static String pdfPath = "target\\";

    public static void createReportWithParameters() {
        JasperReport jasperReport;
        JasperPrint jasperPrint;

        Form form = getForm();

        try {
            jasperReport = JasperCompileManager.compileReport(
                    jrxmlPath + "objParam.jrxml");

            HashMap<String, Object> params = new HashMap<>();
            params.put("DOC", form);

            jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

            JasperExportManager.exportReportToPdfFile(
                    jasperPrint, pdfPath + "objParam.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public static Form getForm() {
        Form form = new Form();
        form.setName("LOL");
        form.setSurname("KEK");
        return form;
    }
}
