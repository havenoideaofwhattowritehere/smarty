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
    void follow(User from, User to)
    {
        from.subscriptionsIds.add(to.userId)
    }

    @Override
    void unfollow(User from, User to)
    {
        from.subscriptionsIds.remove(to.userId)
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
