package pro.sky.skyprostreamapiandoptional.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyprostreamapiandoptional.data.Employee;
import pro.sky.skyprostreamapiandoptional.exception.DuplicateEmployeeException;
import pro.sky.skyprostreamapiandoptional.exception.EmployeeNotFoundException;
import pro.sky.skyprostreamapiandoptional.service.EmployeeService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employeeMap = new HashMap<>();
/*
    public EmployeeServiceImpl() {

        addEmployee("Василий", "Иванович", 1, 200);
        addEmployee("Семён", "Михайлович", 1, 150);
        addEmployee("Климент", "Ефремович", 2, 300);
        addEmployee("Григорий", "Иванович", 1, 150);
        addEmployee("Михаил", "Васильевич", 5, 200);
    }

 */

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        String key = getKeyString(firstName, lastName);
        if (!employeeMap.containsKey(key)) {
            Employee employee = new Employee(firstName, lastName, department, salary);
            employeeMap.put(key, employee);
            return employee;
        }
        throw new DuplicateEmployeeException("Такой сотрудник уже есть.");
    }

    @Override
    public Employee getEmployee(String firstName, String lastName) {
        String key = getKeyString(firstName, lastName);
        if (employeeMap.containsKey(key)) {
            return employeeMap.get(key);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String key = getKeyString(firstName, lastName);
        if (employeeMap.containsKey(key)) {
            return employeeMap.remove(key);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employeeMap.values());

    }

    private String getKeyString(String firstName, String lastName) {
        return firstName + " " + lastName;

    }
}