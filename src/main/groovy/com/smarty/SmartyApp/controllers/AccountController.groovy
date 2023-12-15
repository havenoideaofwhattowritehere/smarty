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

    @RequestMapping(name = "/{userLogin}", method = RequestMethod.GET)
    String getUser(@PathVariable Long id, Model model)
    {
        User user = userService.getUser(userLogin)
        model.addAttribute("user", user)
        return "userPage"
    }

    @RequestMapping(name = "/create/{userLogin}/{pwd}")
    String createUser(@PathVariable String userLogin, @PathVariable String pwd)
    {
        userService.createUser(userLogin, pwd)
        return "userList"
    }
    @RequestMapping(name = "/{userLogin}/changePwd/{pwd}")
    String editPassword(@PathVariable String userLogin, @PathVariable String pwd)
    {
        User user = userService.getUser(userLogin)
        userService.editPassword(userLogin, pwd)
        model.addAttribute("user", user)
        return "userPage"
    }
    //delete

    @RequestMapping(name = "/delete/{userLogin}")
    String deleteUser(@PathVariable String login)
    {
        try
        {
            userService.deleteUser(userLogin)
        } catch (Throwable throwable)
        {
            return "errorPage"
        }
        return "users"
    }
}
