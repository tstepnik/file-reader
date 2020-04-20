package pl.tstepnik.reader;

import pl.tstepnik.domain.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv implements Reader{

    public List<Employee> getEmployeesFromFile(String path) {
        List<Employee> employees = new ArrayList<>();
        try (
                var fileReader = new FileReader(path);
                var reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            int lines = 0;
            while ((nextLine = reader.readLine()) != null) {
                String line = nextLine.replaceAll("\"", "").replaceAll(" ", "");
                String[] employeeData = line.split(";");
                if (lines > 0) {
                    employees.add(createEmployee(employeeData));
                }
                lines++;
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return employees;
    }

    private static Employee createEmployee(String[] employeeData) {
        Long id = Long.decode(employeeData[0]);
        String name = employeeData[1];
        String surName = employeeData[2];
        String job = employeeData[3];
        double salary = Double.parseDouble(employeeData[4].replaceAll(",", "."));
        return new Employee(id, name, surName, job, salary);

    }
}
