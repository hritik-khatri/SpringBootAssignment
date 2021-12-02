package com.example.accessingdatamysql.Department;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.accessingdatamysql.Department.DepartmentServices;

import java.util.Set;
import java.util.logging.LoggingPermission;

@Controller
@RequestMapping(path="/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    DepartmentServices departmentServices;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @PostMapping(path = "/addDep")
    private @ResponseBody  String saveDep(@RequestBody Department department) {
        departmentServices.saveOrUpdate(department);
        return "Saved";
    }

    @GetMapping(path = "/{id}")
    private @ResponseBody  Department depById(@PathVariable("id") Long id)
    {
        return departmentServices.getDepById(id);
    }

    @DeleteMapping("/{id}")
    private @ResponseBody String DeleteDep(@PathVariable("id") Long id)
    {
        departmentServices.deleteById(id);
        return "Deleted!" ;
    }

//    @GetMapping("/getEmpIdsInDep/{id}")
//    private @ResponseBody String getAllEmpsIds(@PathVariable("id") Long id)
//    {
//        Set<Long> empids;
//        empids = departmentServices.getAllEmpsId(id);
//        if(!empids.isEmpty())
//        {
//                return "total Employees in department : "+empids.toString() + empids.toArray(new Long[empids.size()]); //replaceAll("\\[|\\]|' '", "");
//        }
//
//        else
//            return  "Could not fetch any employee on this department Id";
//    }

    @PutMapping("/{id}")
    private @ResponseBody Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department)
    {
        return departmentServices.updateDep(id,department);
    }








}
