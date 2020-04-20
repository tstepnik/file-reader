package pl.tstepnik.reader;

import pl.tstepnik.domain.Employee;

import java.util.List;

public interface Reader {
    public List<Employee> getEmployeesFromFile(String path);
}
