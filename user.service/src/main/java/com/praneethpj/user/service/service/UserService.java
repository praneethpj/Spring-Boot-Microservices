package com.praneethpj.user.service.service;


import com.praneethpj.user.service.VO.Department;
import com.praneethpj.user.service.VO.ResponseTemplateVO;
import com.praneethpj.user.service.entity.Users;
import com.praneethpj.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Users saveDepartment(Users department) {
        return userRepository.save(department);
    }

    public Users findDepartmentById(Long departmentId) {
        return userRepository.findById(departmentId).get();
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {

            ResponseTemplateVO responseTemplateVO=new ResponseTemplateVO();
            Users user=userRepository.findById(userId).get();

            Department department=restTemplate.getForObject("http://localhost:9001/department/"+user.getDepartmentId(), Department.class);

            responseTemplateVO.setUser(user);
            responseTemplateVO.setDepartment(department);

            return responseTemplateVO;


    }
}
