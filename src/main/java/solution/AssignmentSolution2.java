package solution;

import Utils.Constants;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;
import pojo.Employee;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AssignmentSolution2 {

    final private static String employeesFilePath="src\\main\\resources\\employees.csv";
    final private static String rndManagersFilePath="src\\main\\resources\\managers.csv";
    final private static String singleNameEmployeesFilePath="src\\main\\resources\\single_name_employees.csv";

    public static void solution(){

        List<Employee> rndManagers=new ArrayList<>();
        List<Employee> singleNameEmployees=new ArrayList<>();

        try {
            CSVReader csvReader=new CSVReaderBuilder(new FileReader(employeesFilePath)).withSkipLines(1).build();;
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                Employee employee = new Employee();
                employee.setName(nextRecord[0]);
                employee.setRole(nextRecord[1]);
                employee.setDivision(nextRecord[2]);
                if(Constants.MANAGER.equalsIgnoreCase(employee.getRole())&&Constants.RND.equalsIgnoreCase(employee.getDivision())){
                    rndManagers.add(employee);
                }
                if(employee.getName().trim().split(" ").length == 1){
                    singleNameEmployees.add(employee);
                }
            }

            FileWriter rndManagersFile = new FileWriter(rndManagersFilePath);
            CSVWriter csvWriter1= new CSVWriter(rndManagersFile);
            FileWriter singleNameEmployeesFile = new FileWriter(singleNameEmployeesFilePath);
            CSVWriter csvWriter2= new CSVWriter(singleNameEmployeesFile);

            rndManagers.forEach(rndManager->{
                csvWriter1.writeNext(new String[]{rndManager.getName(), rndManager.getRole(), rndManager.getDivision()});
            });

            singleNameEmployees.forEach(singleNameEmployee->{
                csvWriter2.writeNext(new String[]{singleNameEmployee.getName(), singleNameEmployee.getRole(), singleNameEmployee.getDivision()});
            });

            csvWriter1.close();
            csvWriter2.close();

        } catch (Exception e){
            log.error("Error occurred read of CSV file",e);
        }

    }

}
