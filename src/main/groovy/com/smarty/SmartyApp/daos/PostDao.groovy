package com.smarty.SmartyApp.daos

import com.smarty.SmartyApp.entities.Comment
import com.smarty.SmartyApp.entities.Post
import com.smarty.SmartyApp.entities.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository("postDao")
interface PostDao extends MongoRepository<Post, Long>
{

}