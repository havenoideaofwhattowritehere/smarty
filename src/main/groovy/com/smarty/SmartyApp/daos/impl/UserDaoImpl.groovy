package com.smarty.SmartyApp.daos.impl

import com.smarty.SmartyApp.daos.UserDao
import com.smarty.SmartyApp.entities.User
import org.springframework.stereotype.Component

@Component("userDao")
class UserDaoImpl implements UserDao
{
    @Override
    Set<User> getUsers() {
        return null
    }

    @Override
    User getUser(Long id) {
        return null
    }

    @Override
    User getUser(String userLogin) {
        return null
    }

    @Override
    boolean createUser(String login, String password) {
        return false
    }

    @Override
    boolean editPassword(String login, String password) {
        return false
    }

    @Override
    boolean deleteUser(String login) {
        return false
    }

}
