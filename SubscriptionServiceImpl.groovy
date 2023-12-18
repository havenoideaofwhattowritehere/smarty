package com.smarty.SmartyApp.services.impl


import com.smarty.SmartyApp.entities.User
import com.smarty.SmartyApp.services.PostService
import com.smarty.SmartyApp.services.SubscriptionService
import com.smarty.SmartyApp.services.UserService
import org.springframework.stereotype.Component

@Component("subscriptionService")
class SubscriptionServiceImpl implements SubscriptionService
{
    PostService postService
    UserService userService

    @Override
    void follow(String from, String to)
    {
        User subscriptionUser = userService.getUser(to)
        User subscriptedUser = userService.getUser(from)
        subscriptionUser.subscriptionsIds.add(subscriptedUser.userId)
        subscriptionUser.followersIds.add(subscriptedUser.userId)
    }

    @Override
    void unfollow(String from, String to)
    {
        User subscriptionUser = userService.getUser(to)
        User subscriptedUser = userService.getUser(from)
        subscriptedUser.subscriptionsIds.remove(subscriptionUser.userId)
        subscriptionUser.followersIds.add(subscriptedUser.userId)
    }

    @Override
    boolean like(String userLogin, Long postId)
    {
        try
        {
            postService.addToFavourite(postId, userLogin)
        } catch (Throwable throwable)
        {
            return false
        }
        return true
    }

    @Override
    boolean isLiked(String userLogin, Long postId)
    {
        try
        {
            def user = userService.getUser(userLogin)
            if (user.favouritePostsIds.contains(postId))
            {
                return true
            }
        } catch (Throwable throwable)
        {
            return false
        }
    }

    @Override
    boolean removeLike(String userLogin, Long postId)
    {
        try
        {
            postService.removeFromFavourite(postId, userLogin)
        } catch (Throwable throwable)
        {
            return false
        }
        return true
    }
}
