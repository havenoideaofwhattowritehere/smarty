package com.smarty.SmartyApp.daos

import com.smarty.SmartyApp.entities.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository("userDao")
interface UserDao extends MongoRepository<User, Long>
{
}