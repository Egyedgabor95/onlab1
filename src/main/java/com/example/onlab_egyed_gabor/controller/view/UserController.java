package com.example.onlab_egyed_gabor.controller.view;

import com.example.onlab_egyed_gabor.controller.dto.UserDTO;
import com.example.onlab_egyed_gabor.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String showAdmin(Model model) {
        model.addAttribute("users", userService.read());
        return "admin";
    }

    @GetMapping("/login")
    public String getMyLogin() {
        return "login";
    }

    @GetMapping("/loginError")
    public String getLoginError() {
        return "error";
    }


    @GetMapping("/admin/delete/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/createUser")
    public String createUser(Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "createUser";
    }

    @PostMapping("/admin/createUser")
    public String createUserSubmit(UserDTO user) {
        userService.create(user);
        return "redirect:/admin";
    }


    @GetMapping("admin/edit/{id}")
    public String datasheet(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PostMapping("admin/edit/{id}")
    public String datasheetSubmit(UserDTO editedUser, @PathVariable Long id) {
        userService.update(id, editedUser);
        return "redirect:/admin";
    }
}
