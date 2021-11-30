package com.example.accessingdatamysql.Employee;

import com.example.accessingdatamysql.Department.Department;
import com.example.accessingdatamysql.Department.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;


    public Iterable<Employee> getAllEmps() {
        return employeeRepository.findAll();
    }


    public Employee getEmpById(long id) {
        return employeeRepository.findById(id).get();
    }

    public void deleteById(long id) {

        employeeRepository.deleteById(id);
    }

    public String createEmployee(Employee employee) {


        if (employee.getDepartments().isEmpty()) {
            return "employee name = " + employee.getName() + " " + employee.getL_name() + "department is empty";
        }
        Employee newEmployee = new Employee();
        newEmployee.setName(employee.getName());
        newEmployee.setL_name(employee.getL_name());


        Department department = new Department();
        Set<Department> departments = new HashSet<>();


        for (Department x : employee.getDepartments()) {
            if (departmentRepository.findById(x.getId()).orElse(null) != null) {
                department = departmentRepository.findById(x.getId()).orElse(null);
                departments.add(department);
            }
        }


        if (!departments.isEmpty()) {
            newEmployee.setDepartments(departments);
            employeeRepository.save(newEmployee);
            return "Employee Added successfully";
        } else {
            return "Please enter valid Department/s";
        }
    }






}
