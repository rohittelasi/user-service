package com.javaian.userservice.service;

import com.javaian.userservice.entity.User;
import com.javaian.userservice.repository.UserRepository;
import com.javaian.userservice.valueobject.Department;
import com.javaian.userservice.valueobject.ResponseTemplateValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateValueObject getUserDepartment(Long userId) {
        ResponseTemplateValueObject obj = new ResponseTemplateValueObject();
        User user = userRepository.findByUserId(userId) ;
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" + user.getDepartmentId(),
                Department.class);
        obj.setUser(user);
        obj.setDepartment(department);
        return obj;
    }
}
