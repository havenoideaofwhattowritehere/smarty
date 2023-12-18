package com.smarty.SmartyApp.services

import com.smarty.SmartyApp.entities.User

interface SubscriptionService
{
    void follow(String from, String to)
    void unfollow(String from, String to)
    boolean like(String userLogin, Long postId)
    boolean isLiked(String userLogin, Long postId)
    boolean removeLike(String userLogin, Long postId)
}