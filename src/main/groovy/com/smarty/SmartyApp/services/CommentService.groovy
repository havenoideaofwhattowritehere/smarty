package com.smarty.SmartyApp.services

import com.smarty.SmartyApp.entities.Comment

interface CommentService
{
    List<Comment> getCommentsForUser(String userLogin)
    List<Comment> getCommentsForPost(Long postId)
    Comment getComment(Long commentId)
    boolean addComment(Long postId, String login, String text)
    boolean removeComment(Long postId, String login)
    boolean editComment(Long commentId, String text)
}