package Service;
import java.util.ArrayList;
import java.util.List;

import Model.Employee;
import Model.EmployeeRepository;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();
    @Override
    public String addEmployee(Employee employee) {
        employees.add(employee);

        return
                "\nEl empleado "+ employee.getName() + " fue añadido con exito";
    }

    @Override
    public String editEmployee(String name, Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getName().equalsIgnoreCase(name)){
                employees.set(i, updatedEmployee);
            }
        }

        return
                "\nEl empleado "+ updatedEmployee.getName() + " fue editado con exito";
    }

    @Override
    public String deleteEmployee(String name) {
        employees.removeIf(employee -> employee.getName().equalsIgnoreCase(name));
        return
             "\nEl empleado "+ name + " fue eliminado con exito";
    }

    @Override
    public List<Employee> listEmployees() {
        return employees;
    }
}
