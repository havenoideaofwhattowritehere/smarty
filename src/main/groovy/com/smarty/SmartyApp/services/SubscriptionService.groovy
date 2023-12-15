package com.smarty.SmartyApp.services

import com.smarty.SmartyApp.entities.User

interface SubscriptionService
{
    void follow(User from, User to)
    void unfollow(User from, User to)
    boolean like(String userLogin, Long postId)
    boolean isLiked(String userLogin, Long postId)
    boolean removeLike(String userLogin, Long postId)
}