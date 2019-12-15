package net.skhu.controller;

import net.skhu.domain.User;
import net.skhu.model.UserRegistrationModel;
import net.skhu.service.DepartmentService;
import net.skhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("register")
    public String register(Model model, UserRegistrationModel userModel) {
        model.addAttribute("departments", departmentService.findAll());
        return "user/register";
    }

    @PostMapping("register")
    public String register(@Valid UserRegistrationModel userModel, BindingResult bindingResult, Model model) {
        if (userService.hasErrors(userModel, bindingResult)) {
            model.addAttribute("departments", departmentService.findAll());
            return "user/register";
        }
        userService.save(userModel);
        return "redirect:registerSuccess";
    }

    @RequestMapping("registerSuccess")
    public String registerSuccess() {
        return "user/registerSuccess";
    }
}
