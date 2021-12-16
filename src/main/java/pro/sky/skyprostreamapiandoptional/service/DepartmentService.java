package pro.sky.skyprostreamapiandoptional.service;

import pro.sky.skyprostreamapiandoptional.data.Employee;

import java.util.List;

public interface DepartmentService {
    Employee getMaxSalaryEmployee(Integer department);

    Employee getMinSalaryEmployee(Integer department);

    List<Employee> getAllEmployees(Integer department);
}
