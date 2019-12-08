package example.jasper.ex1_helloworld;

import example.jasper.Constants;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.util.HashMap;

public class ReportGeneratorHelloWorld {

    // Before calling the method run 'mvn jasperreports:jasper'
    public static void generateFromBin() throws JRException {
        JasperPrint jasperPrint;
        jasperPrint = JasperFillManager.fillReport(Constants.PATH_JASPER + "helloworld.jasper", new HashMap<>(), new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, Constants.PATH_PDF + "helloworld_fromBin.pdf");
    }

    public static void generateFromXml() throws JRException {
        JasperReport jasperReport;
        JasperPrint jasperPrint;
//        JasperDesign jasperDesign = JRXmlLoader.load(Constants.PATH_JRXML + "helloworld.jrxml");
//        jasperReport = JasperCompileManager.compileReport(jasperDesign);
        jasperReport = JasperCompileManager.compileReport(Constants.PATH_JRXML + "helloworld.jrxml");
        jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, Constants.PATH_PDF + "helloworld_fromXml.pdf");

    }
}
