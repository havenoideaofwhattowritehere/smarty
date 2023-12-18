package com.smarty.SmartyApp.controllers


import com.smarty.SmartyApp.entities.Post
import com.smarty.SmartyApp.entities.User
import com.smarty.SmartyApp.services.CommentService
import com.smarty.SmartyApp.services.PostService
import com.smarty.SmartyApp.services.SubscriptionService
import com.smarty.SmartyApp.services.UserService
import jakarta.annotation.Resource
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/feed")
class SubscriptionController
{
    @Resource(name = "subscriptionService")
    SubscriptionService subscriptionService
    @Resource(name = "userService")
    UserService userService
    @Resource(name = "postService")
    PostService postService
    @Resource(name = "commentService")
    CommentService commentService

    @RequestMapping(value = "/{subscriberLogin}/subscribe/{userLogin}")
    String subscribe(@PathVariable String subscriberLogin, @PathVariable String userLogin, Model model)
    {
        subscriptionService.follow(subscriberLogin, userLogin)
        Set<Post> postSet = getPostsFromSubscribers(subscriberLogin)
        model.addAttribute("subscriberPosts", postSet)
        return "subscribersPosts"
    }

    @RequestMapping(value = "/{subscriberLogin}/removeSubscription/{userLogin}")
    String unSubscribe(@PathVariable String subscriberLogin, @PathVariable String userLogin, Model model)
    {
        subscriptionService.unfollow(subscriberLogin, userLogin)
        Set<Post> postSet = getPostsFromSubscribers(subscriberLogin)
        model.addAttribute("subscriberPosts", postSet)
        return "subscribersPosts"
    }

    @GetMapping(value = "/{userLogin}")
    String showFeed(@PathVariable String userLogin, Model model)
    {
        List<String> subscriptionLogins = getSubscriptionLogins(userService.getUser(userLogin).getSubscriptionsIds())

        model.addAttribute("posts", getPostsFromSubscribers(userLogin))
        model.addAttribute("likes", postService.getFavouritePosts(userLogin))
        model.addAttribute("comments", commentService.getCommentsForUser(userLogin))
        model.addAttribute("subscriptionLogins", subscriptionLogins)

        return "userFeed"
    }

    Set<Post> getPostsFromSubscribers(String subscriberLogin)
    {
        Set<Long> userIds = userService.getUser(subscriberLogin).subscriptionsIds
        Set<Post> posts
        for (i in 0..<userIds.size())
        {
            Set<Long> postIds = userService.getUser(userIds[i]).publishedPostsIds
            for (j in 0..< postIds.size())
            {
                posts.add(postService.getPost(postIds[j]))
            }
        }
        return posts
    }

    List<String> getSubscriptionLogins(Set<Long> subscriptionIds)
    {
        List<String> followedUsers
        for (i in 0..<subscriptionIds.size())
        {
            User user = userService.getUser(subscriptionIds[i])
            followedUsers.add(user.getLogin())
        }
        return followedUsers
    }
}
