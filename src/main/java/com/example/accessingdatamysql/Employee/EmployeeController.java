package com.example.accessingdatamysql.Employee;

import com.example.accessingdatamysql.Department.Department;
import com.example.accessingdatamysql.Department.DepartmentRepository;
import com.example.accessingdatamysql.Department.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static java.lang.Long.parseLong;


@RestController
@RequestMapping(path = "/employee")
public class EmployeeController
{
    @Autowired
    EmployeeServices employeeServices;

    @Autowired
    DepartmentServices departmentServices;

    @Autowired
    private EmployeeRepository employeeRepository;




    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Employee> getAllEmployee()
    {
        return employeeRepository.findAll();
    }

    @PostMapping(path = "/addEmp")
    private @ResponseBody String saveEmp(@RequestBody Employee employee ) {
        return employeeServices.createEmployee(employee);

    }

      @GetMapping(path = "/{id}")
        private Employee empById(@PathVariable("id") long id) {
        return employeeServices.getEmpById(id);
       }

      @DeleteMapping("/{id}")
      private @ResponseBody String DeleteEmp(@PathVariable("id") String id) {
        employeeServices.deleteById(parseLong(id));
        return "Deleted!";

    }

    @PutMapping("/{id}")
    private  @ResponseBody Employee UpdateEmp(@PathVariable("id") String id,
                                            @RequestBody Employee employee)
    {

        return  employeeServices.updateEmployee(parseLong(id),employee);
    }


}
