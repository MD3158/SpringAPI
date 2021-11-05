package com.example.springcrud.controller;

import com.example.springcrud.entity.User;
import com.example.springcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = {"/" ,"/index"})
    public String index(Model model){
        List<User> users = userService.getAllUser();
        model.addAttribute("user", users);
        return "index";
    }
    @RequestMapping("user/new")
    public String addUser(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("pageTitle", "Add New User");

        return "UserForm";
    }
    @RequestMapping(value = "/user/edit", method = RequestMethod.GET)
    public String editUser(@RequestParam("id") Integer userId, Model model){
        Optional<User> userEdit = userService.findUserById(userId);
        userEdit.ifPresent(user -> model.addAttribute("user", user));
        model.addAttribute("pageTitle", "Edit User");

        return "UserForm";
    }
    @RequestMapping(value ="/user/delete")
    public String deleteUser(@RequestParam("id") Integer userId, Model model){
        userService.deleteUser(userId);
        return "redirect:/";
    }
    @PostMapping(value = "user/save")
    public String saveUser(User user, RedirectAttributes ra){
        userService.saveUser(user);
        ra.addFlashAttribute("message", "The user has been saved sucessfully!");
        return "redirect:/";
    }
}
