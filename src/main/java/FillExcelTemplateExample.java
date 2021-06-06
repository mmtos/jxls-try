import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.text.DateFormat;
import java.util.*;

public class FillExcelTemplateExample {
    public static void main(String[] args) throws Exception {
        List<Employee> employees = new ArrayList<>();

        long now = System.currentTimeMillis();
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR)-1,cal.get(Calendar.MONTH),cal.get(Calendar.DATE));
        long oneYear = now - cal.getTimeInMillis();

        employees.add(new Employee("mm", new Date((long) (System.currentTimeMillis() - oneYear) ), 10));
        employees.add(new Employee("to", new Date((long) (System.currentTimeMillis() - oneYear * 3)), 20));
        employees.add(new Employee("s", new Date((long) (System.currentTimeMillis() - oneYear * 5)), 30));

        Map<String,List> beans = new HashMap<>();
        beans.put("employees",employees);

        try(InputStream is = new FileInputStream("src/main/resources/employeeListExample.xlsx") ) {
            XLSTransformer transformer = new XLSTransformer();
            Workbook workbook = transformer.transformXLS(is,beans);



            try (OutputStream os = new FileOutputStream("employeeListExampleOutput.xlsx")) {
                workbook.write(os);
            }
        }
    }
}
