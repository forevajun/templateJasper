package ru.jasper.template_field_and_param;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Template {

    private static String jrxmlPath = "src\\main\\resources\\jasperreports\\";
    private static String pdfPath = "target\\";

    public static void template() {

        JasperReport jasperReport;
        JasperPrint jasperPrint;
        try {
            jasperReport = JasperCompileManager.compileReport(
                    jrxmlPath + "jasper_report_template.jrxml");

            DataBeanList DataBeanList = new DataBeanList();
            ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();

            JRBeanCollectionDataSource beanColDataSource =
                    new JRBeanCollectionDataSource(dataList);

            Map<String, Object> parameters = new HashMap<>();

            parameters.put("ReportTitle", "List of Contacts");
            parameters.put("Author", "Prepared By Manisha");

            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);

            JasperExportManager.exportReportToPdfFile(
                    jasperPrint, pdfPath + "jasper_report_template.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

}
