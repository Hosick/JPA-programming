package net.skhu.service;

import net.skhu.domain.Department;
import net.skhu.domain.User;
import net.skhu.model.UserRegistrationModel;
import net.skhu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User createEntity(UserRegistrationModel userModel){
        User user = new User();
        user.setUserId(userModel.getUserid());
        user.setPassword(userModel.getPasswd1());
        user.setName(userModel.getName());
        user.setEmail(userModel.getEmail());
        user.setDepartment(new Department());
        user.getDepartment().setId(userModel.getDepartmentId());
        user.setEnabled(true);
        user.setUserType("학생");
        return user;
    }

    public void save(UserRegistrationModel userModel){
        User user = createEntity(userModel);
        userRepository.save(user);
    }

}