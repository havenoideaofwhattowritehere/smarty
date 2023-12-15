package com.smarty.SmartyApp.services

import com.smarty.SmartyApp.entities.User

interface UserService
{
    Set<User> getUsers()
    User getUser(Long id)
    User getUser(String userLogin)
    boolean createUser(String login, String password)
    boolean editPassword(String login, String password)
    boolean deleteUser(String login)
}