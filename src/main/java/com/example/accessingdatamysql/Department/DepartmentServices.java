package com.example.accessingdatamysql.Department;

import com.example.accessingdatamysql.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class DepartmentServices {

    @Autowired
    DepartmentRepository departmentRepository;

    public Set<Department> getAllDeps()
    {
        Set<Department> deps = new HashSet<>();
        departmentRepository.findAll().forEach(department -> deps.add(department));
        return deps;
    }

    public Department getDepById(long id)

    {
        return departmentRepository.findById(id).get();
    }

    public void deleteById(long id)
    {
        departmentRepository.deleteById(id);
    }

    public void saveOrUpdate(Department department)
    {
        departmentRepository.save(department);
    }

    public  Set<Long> getAllEmpsId(Long id) {
        Set<Long> x = new HashSet<>();
        if (departmentRepository.findById(id) != null) {
            Department department = departmentRepository.findById(id).orElse(null);
            Set<Employee> employees = department.getEmployee();
            for(Employee z : employees){
                x.add(z.getId());
            }}


            return x;
        }

}
