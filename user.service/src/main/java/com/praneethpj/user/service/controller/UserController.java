package com.praneethpj.user.service.controller;


import com.praneethpj.user.service.VO.ResponseTemplateVO;
import com.praneethpj.user.service.entity.Users;
import com.praneethpj.user.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Users saveDepartment(@RequestBody Users department){
        log.info("inside saveUser");
       return userService.saveDepartment(department);
    }

    @PostMapping("/{id}")
    public Users findByid(Long departmentId){
        return userService.findDepartmentById(departmentId);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("inside getUserWithDepartment of userController");
        return userService.getUserWithDepartment(userId);
    }

}
