package Model;

import Model.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeRepository {
    public String addEmployee(Employee employee);
    public String editEmployee(String name, Employee UpdatedEmployee);
    public String deleteEmployee(String name);

    List<Employee> listEmployees();

}
