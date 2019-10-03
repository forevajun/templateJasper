package ru.jasper.example1_simple;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import java.util.HashMap;

public class Ex1 {

    private static String jrxmlPath = "src\\main\\resources\\jasperreports\\";
    private static String pdfPath = "target\\";
    private static String jasperPath = "target\\jasperreports\\";

    // Before calling the method run 'mvn jasperreports:jasper'
    public static void printWithoutCompile() {
        JasperPrint jasperPrint;
        try {
            jasperPrint = JasperFillManager.fillReport(
                    jasperPath + "helloworld.jasper", new HashMap<>(), new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(
                    jasperPrint, pdfPath + "helloworld1.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public static void printWithCompile() {
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        try {
//            JasperDesign design = JRXmlLoader.load(jrxmlPath + "helloworld.jrxml");
//            jasperReport = JasperCompileManager.compileReport(design);

            jasperReport = JasperCompileManager.compileReport(
                    jrxmlPath + "helloworld.jrxml");

            jasperPrint = JasperFillManager.fillReport(
                    jasperReport, new HashMap<>(), new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(
                    jasperPrint, pdfPath + "helloworld2.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
