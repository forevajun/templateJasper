package ru.jasper.example3_field;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.HashMap;

public class Ex3 {
    private static String jrxmlPath = "src\\main\\resources\\jasperreports\\";
    private static String pdfPath = "target\\";

    public static void createReportWithFields() {
        JasperReport jasperReport;
        JasperPrint jasperPrint;

        try {
            jasperReport = JasperCompileManager.compileReport(
                    jrxmlPath + "field.jrxml");

            PersonList personList = new PersonList();
            ArrayList<Person> persons = personList.getPersons();

            JRBeanCollectionDataSource jrBeanCollectionDataSource =
                    new JRBeanCollectionDataSource(persons);

            jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), jrBeanCollectionDataSource);

            JasperExportManager.exportReportToPdfFile(
                    jasperPrint, pdfPath + "field.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
