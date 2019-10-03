package ru.jasper.example5_stretch;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import java.util.HashMap;

public class Ex5 {
    private static String jrxmlPath = "src\\main\\resources\\jasperreports\\";
    private static String pdfPath = "target\\";

    public static void main(String[] args) {
        createReportWithParameters();
    }

    public static void createReportWithParameters() {
        JasperReport jasperReport;
        JasperPrint jasperPrint;

        PrintForm printForm = getForm();

        try {
            jasperReport = JasperCompileManager.compileReport(
                    jrxmlPath + "stretch.jrxml");

            HashMap<String, Object> params = new HashMap<>();
            params.put("DOC", printForm);

            jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

            JasperExportManager.exportReportToPdfFile(
                    jasperPrint, pdfPath + "stretch.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public static PrintForm getForm() {
        PrintForm printForm = new PrintForm();
        printForm.setParam1("The calculation functions are useful but are also generics and limited to the numeric types. You may have a case where something more specific is needed. Suppose you have a field of type String and you want to concatenate the value read. You can do this by defining a new Incrementer.");
        printForm.setParam2("The two expressions could seem equivalent: they both sum the money gained to the  variable when it is not null (remember that if there isn't a calculation function then the value of the expression is assigned to the variable). The check if the Money Gained has value null it's necessary because");
        printForm.setParam3("the sum of a number with the value null is null. So adding null to Total1 or Total2 will change the variable to null. But even with this check when Money_Gained will became null for the first time even Total1 will be null, instead Total2 will have the correct value.");
        printForm.setParam4("This happens because this two expressions have 2 different interpreters, the first is interpreted by Groovy, the second by Java. The java behavior is to evaluate the condition and then select the correct branch. Instead Groovy compute the two branches, then evaluate the expression and finally it");
        printForm.setParam5("Doing this it will add the null value to Total1 before to do the check, and this will made Total1 to became null.A trick to avoid this is to use the variable only in the main branch, for example Total1 could be rewritten like:  $V{Total1}  + IF(EQUALS($F{Money_Gained}, null),0,F{Money_Gained})");
        return printForm;
    }

}
