package com.smarty.SmartyApp.services.impl

import com.smarty.SmartyApp.daos.UserDao
import com.smarty.SmartyApp.entities.User
import com.smarty.SmartyApp.services.UserService
import org.springframework.stereotype.Component

@Component("userService")
class UserServiceImpl implements UserService
{
    private UserDao userDao;

    @Override
    Set<User> getUsers()
    {
        return userDao.findAll()
    }

    @Override
    User getUser(Long id)
    {
        return userDao.findById(id) as User
    }

    @Override
    User getUser(String userLogin)
    {
        List<User> userList = userDao.findAll()
        for (i in 0..< userList.size())
        {
            if (userList[i].login == userLogin)
            {
                return userList[i]
            }
        }
        return null
    }

    @Override
    boolean createUser(String login, String password)
    {
        try
        {
            User user = new User(login: login, password: password)
            userDao.insert(user)
            return true
        } catch (Throwable throwable)
        {
            return false;
        }
    }

    @Override
    boolean editPassword(String login, String password)
    {
        try
        {
            def user = getUser(login)
            user.password = password
            userDao.save(user)
            return true
        } catch (Throwable throwable)
        {
            return false
        }
    }

    @Override
    boolean deleteUser(String login)
    {
        try
        {
            def user = getUser(login)
            userDao.delete(user)
            return true
        } catch (Throwable throwable)
        {
            return false
        }
    }
}
