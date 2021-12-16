package pro.sky.skyprostreamapiandoptional.service;

import pro.sky.skyprostreamapiandoptional.data.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int department, int salary);

    Employee getEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Collection<Employee> getEmployees();
}
