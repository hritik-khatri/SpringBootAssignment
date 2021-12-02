package com.example.accessingdatamysql.Department;

import com.example.accessingdatamysql.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


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

    public Department updateDep(Long id ,Department department){
        Department department1 = departmentRepository.findById(id).get();
        if(Objects.nonNull(department.getName()) &&
                !"".equalsIgnoreCase(department.getName())) {
            department1.setName(department.getName());
        }
        if(Objects.nonNull(department.getDepHead()) &&
                !"".equalsIgnoreCase(department.getDepHead())) {
            department1.setDepHead(department.getDepHead());
        }
        return  departmentRepository.save(department1);

    }

//    public  Set<Long> getAllEmpsId(Long id) {
//        Set<Long> x = new HashSet<>();
//        if (departmentRepository.findById(id) != null) {
//            Department department = departmentRepository.findById(id).orElse(null);
//            Set<Employee> employees = department.getEmployee();
//            for(Employee z : employees){
//                x.add(z.getId());
//            }}
//
//
//            return x;
//        }


}
