package com.praneethpj.department.service.controller;

import com.praneethpj.department.service.entity.Department;
import com.praneethpj.department.service.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("inside saveDepartment ");
        log.info("inside saveDepartment "+department.getDepartmentName());
       return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findByid(@PathVariable("id")Long departmentId){
        return departmentService.findDepartmentById(departmentId);
    }

}
