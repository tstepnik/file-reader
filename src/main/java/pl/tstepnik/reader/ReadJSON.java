package pl.tstepnik.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.tstepnik.domain.Employee;
import pl.tstepnik.domain.Employees;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class ReadJSON implements Reader {

    public List<Employee> getEmployeesFromFile(String path) {

        ObjectMapper mapper = new ObjectMapper();
        Employees employees = new Employees();

        try {

            employees = mapper.readValue(Paths.get(path).toFile(), Employees.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees.getEmployees();
    }
}
