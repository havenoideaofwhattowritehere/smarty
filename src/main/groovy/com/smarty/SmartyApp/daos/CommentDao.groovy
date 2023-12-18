package com.smarty.SmartyApp.daos

import com.smarty.SmartyApp.entities.Comment
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository("commentDao")
interface CommentDao extends MongoRepository<Comment, Long>
{

}