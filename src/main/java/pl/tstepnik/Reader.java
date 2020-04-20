package pl.tstepnik;

import pl.tstepnik.domain.Employee;
import pl.tstepnik.reader.ReadCsv;
import pl.tstepnik.logic.EmployeeOperations;
import pl.tstepnik.reader.ReadJSON;

import java.util.List;

public class Reader {

    private final static String pathJSON = "src/main/resources/employees.json";
    private final static String pathCsv = "src/main/resources/employees.csv";

    public static void main(String[] args) {
        ReadJSON readJSON = new ReadJSON();
        ReadCsv readCsv = new ReadCsv();

        List<Employee> employeesFromJSON = readJSON.getEmployeesFromFile(pathJSON);
        List<Employee> employeesFromCsv;
        employeesFromCsv = readCsv.getEmployeesFromFile(pathCsv);

        System.out.println("Dane z pliku JSON:");
        EmployeeOperations.printProfessionSalarySum(employeesFromJSON);

        System.out.println();
        System.out.println("Dane z pliku csv:");
        EmployeeOperations.printProfessionSalarySum(employeesFromCsv);

    }
}
