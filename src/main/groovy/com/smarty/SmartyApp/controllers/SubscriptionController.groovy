package com.smarty.SmartyApp.controllers


import com.smarty.SmartyApp.entities.Post
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
@RequestMapping("/feed")
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

    @RequestMapping("/{subscriberLogin}/subscribe/{userLogin}")
    String subscribe(@PathVariable String subscriberLogin, @PathVariable String userLogin, Model model)
    {
        subscriptionService.follow(subscriberLogin, userLogin)
        model.addAttribute("subscriberPosts", getPostsFromSubscribers(subscriberLogin))
        return "subscribersPosts"
    }

    @RequestMapping("/{subscriberLogin}/removeSubscription/{userLogin}")
    String unSubscribe(@PathVariable String subscriberLogin, @PathVariable String userLogin, Model model)
    {
        subscriptionService.unfollow(subscriberLogin, userLogin)
        model.addAttribute("subscriberPosts", getPostsFromSubscribers(subscriberLogin))
        return "subscribersPosts"
    }

    @GetMapping("/{userLogin}")
    String showFeed(@PathVariable String userLogin, Model model)
    {
        model.addAttribute("posts", getPostsFromSubscribers(userLogin))
        model.addAttribute("likes", postService.getFavouritePosts(userLogin))
        model.addAttribute("comments", commentService.getComments(userLogin))

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

}
