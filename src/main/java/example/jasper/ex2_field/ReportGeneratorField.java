package example.jasper.ex2_field;

import example.jasper.Constants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.HashMap;

public class ReportGeneratorField {

    public static void generate() throws JRException {
        JasperReport jasperReport;
        JasperPrint jasperPrint;

        jasperReport = JasperCompileManager.compileReport(Constants.PATH_JRXML + "field.jrxml");

        PersonList personList = new PersonList();
        ArrayList<Person> persons = personList.getPersons();

        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(persons);

        jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), jrBeanCollectionDataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, Constants.PATH_PDF + "field.pdf");
    }
}
