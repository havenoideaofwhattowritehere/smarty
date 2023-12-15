package com.smarty.SmartyApp.daos.impl

import com.smarty.SmartyApp.daos.PostDao
import com.smarty.SmartyApp.entities.Comment
import com.smarty.SmartyApp.entities.Post
import com.smarty.SmartyApp.entities.User
import org.springframework.stereotype.Component

@Component
class PostDaoImpl implements PostDao
{

    @Override
    Post getPost(Long id) {
        return null
    }

    @Override
    List<Post> getPosts() {
        return null
    }

    @Override
    User getAuthor(Long id) {
        return null
    }

    @Override
    Set<Post> getSetLikesUsers(Long id) {
        return null
    }

    @Override
    List<Comment> getComments(Long id) {
        return null
    }
}
