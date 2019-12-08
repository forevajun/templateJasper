package example.jasper.ex4_field_parameter;

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
import java.util.Map;

public class ReportGeneratorFieldParameter {

    public static void generate() throws JRException {

        JasperReport jasperReport;
        JasperPrint jasperPrint;
        jasperReport = JasperCompileManager.compileReport(Constants.PATH_JRXML + "field_parameter.jrxml");

        DataBeanList dataBeanList = new DataBeanList();
        ArrayList<DataBean> dataList = dataBeanList.getDataBeanList();

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("ReportTitle", "List of Contacts");
        parameters.put("Author", "Prepared By Manisha");

        jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, Constants.PATH_PDF + "field_parameter.pdf");
    }

}
