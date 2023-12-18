package com.smarty.SmartyApp.daos


import com.smarty.SmartyApp.entities.Post
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository("postDao")
interface PostDao extends MongoRepository<Post, Long>
{

}