package ru.jasper.example2_parameter;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import java.util.HashMap;

public class Ex2 {

    private static String jrxmlPath = "src\\main\\resources\\jasperreports\\";
    private static String pdfPath = "target\\";

    public static void createReportWithParameters() {
        JasperReport jasperReport;
        JasperPrint jasperPrint;

        try {
            jasperReport = JasperCompileManager.compileReport(
                    jrxmlPath + "param.jrxml");

            HashMap<String, Object> params = new HashMap<>();
            params.put("name", "Ivan");
            params.put("surname", "Ivanov");

            jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

            JasperExportManager.exportReportToPdfFile(
                    jasperPrint, pdfPath + "param.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
