package pl.tstepnik.logic;

import pl.tstepnik.domain.Employee;

import java.util.*;

public class EmployeeOperations {

    public static void printProfessionSalarySum(List<Employee> employees) {
        Map<String, Double> professions = countSalaryForProfession(employees);
        professions.forEach((key, value) -> System.out.println(key + " - " + round(value, 2)));
    }

    private static Map<String, Double> countSalaryForProfession(List<Employee> employees) {
        Map<String, Double> professions = new TreeMap<>();
        for (Employee employee : employees) {
            if (!professions.containsKey(employee.getJob())) {
                professions.put(employee.getJob(), employee.getSalary());
            } else {
                Double salary = professions.get(employee.getJob()) + employee.getSalary();
                professions.put(employee.getJob(), salary);
            }
        }
        return professions;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
