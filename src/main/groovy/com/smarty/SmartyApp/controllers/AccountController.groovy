package com.smarty.SmartyApp.controllers


import com.smarty.SmartyApp.entities.User
import com.smarty.SmartyApp.services.UserService
import jakarta.annotation.Resource
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class AccountController
{
    @Resource(name = "userService")
    UserService userService

    @RequestMapping("/")
    List<User> getUsers(Model model)
    {
        Set<User> users = userService.getUsers();
        model.addAttribute("users", users)
        return "userList"
    }

    @RequestMapping(value = "/{userLogin}", method = RequestMethod.GET)
    String getUser(@PathVariable String userLogin, Model model)
    {
        User user = userService.getUser(userLogin)
        model.addAttribute("user", user)
        return "userPage"
    }

    @RequestMapping(value = "/create/{userLogin}/{pwd}")
    String createUser(@PathVariable String userLogin, @PathVariable String pwd, Model model)
    {
        userService.createUser(userLogin, pwd)
        Set<User> users = userService.getUsers()
        model.addAttribute("users", users)
        return "userList"
    }

    @RequestMapping(value = "/{userLogin}/changePwd/{pwd}")
    String editPassword(@PathVariable String userLogin, @PathVariable String pwd)
    {
        userService.editPassword(userLogin, pwd)
        User user = userService.getUser(userLogin)
        model.addAttribute("user", user)
        return "userPage"
    }

    @RequestMapping(value = "/delete/{userLogin}")
    String deleteUser(@PathVariable String login)
    {
        try
        {
            userService.deleteUser(userLogin)
            return "userList"
        } catch (Throwable throwable)
        {
            return "errorPage"
        }
    }
}
