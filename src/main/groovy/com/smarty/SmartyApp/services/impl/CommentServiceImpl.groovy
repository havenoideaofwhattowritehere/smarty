package com.smarty.SmartyApp.services.impl

import com.smarty.SmartyApp.daos.CommentDao
import com.smarty.SmartyApp.daos.PostDao
import com.smarty.SmartyApp.entities.Comment
import com.smarty.SmartyApp.entities.Post
import com.smarty.SmartyApp.services.CommentService
import com.smarty.SmartyApp.services.UserService
import org.springframework.stereotype.Component

@Component("commentService")
class CommentServiceImpl implements CommentService
{
    PostDao postDao
    CommentDao commentDao
    UserService userService

    @Override
    List<Comment> getComments(String userLogin)
    {
        def userId = userService.getUser(userLogin).userId
        List<Comment> commentList = commentDao.findAll()
        List<Comment> userComments
        for (i in 0..<commentList.size())
        {
            def userInListId = commentList[i].authorId.userId
            if (userId == userInListId)
            {
                userComments.add(commentList[i])
            }
        }
        return userComments
    }

    @Override
    boolean editComment(Long commentId, String text)
    {
        try
        {
            Comment comment = commentDao.findById(commentId) as Comment
            comment.text = text
            commentDao.save(comment)
        } catch (Throwable throwable)
        {
            return false
        }
        return true
    }

    @Override
    Comment getComment(Long commentId)
    {
        return commentDao.findById(commentId) as Comment
    }

    @Override
    boolean addComment(Long postId, String login, String text)
    {
        try
        {
            Comment comment = new Comment(postId:postDao.findById(postId) as Post,
                                          authorId: userService.getUser(login),
                                          text: text)
            commentDao.insert(comment)
        } catch (Throwable throwable)
        {
            return false
        }
        return true
    }

    @Override
    boolean removeComment(Long commentId, String login)
    {
        try
        {
            def comment = commentDao.findById(commentId) as Comment
            Long userId = userService.getUser(login).userId
            if (comment.authorId.userId == userId) {
                commentDao.delete(comment as Comment)
                return true
            }
        } catch (Throwable throwable)
        {
            return false
        }
    }
}