package com.smarty.SmartyApp.controllers

import com.smarty.SmartyApp.entities.Post
import com.smarty.SmartyApp.services.PostService
import com.smarty.SmartyApp.services.SubscriptionService
import com.smarty.SmartyApp.services.UserService
import jakarta.annotation.Resource
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/posts")
class PostsController
{
    @Resource(name = "userService")
    UserService userService
    @Resource(name = "postService")
    PostService postService

    @Resource(name="subscriptionService")
    SubscriptionService subscriptionService

    @GetMapping(value = "/{userLogin}")
    String showAllPosts(@PathVariable String userLogin, Model model)
    {
        List<Post> posts = postService.getPosts(userLogin)
        model.addAttribute("posts", posts)
        return "posts"
    }
    @GetMapping(value = "/{postId}")
    String showPost(@PathVariable Long postId, Model model)
    {
        Post post = postService.getPost(postId)
        model.addAttribute("post", post)
        return "post"
    }
    @GetMapping(value = "/{userLogin}/publish")
    String addPost(String text, String userLogin, Model model)
    {
        postService.publish(text, userLogin)
        List<Post> posts = postService.getPosts(userLogin)
        model.addAttribute("posts", posts)
        return "posts"
    }
    @GetMapping(value = "/{userLogin}/edit/{postId}")
    String editPost(String text, @PathVariable Long postId, @PathVariable userLogin, Model model)
    {
        postService.editPost(postId, text, userLogin)
        model.addAttribute("post", postService.getPost(postId))
        return "post"
    }

    @DeleteMapping(value = "/{userLogin}/remove/{postId}")
    String deletePost(@PathVariable String userLogin, @PathVariable String , Model model)
    {
        postService.remove(postId)
        List<Post> posts = postService.getPosts(userLogin)
        model.addAttribute("posts", posts)
        return "posts"
    }
    @GetMapping(value = "/{userLogin}/favourites")
    String getFavouritePosts(@PathVariable String userLogin, Model model)
    {
        List<Post> favouritePosts = postService.getFavouritePosts(userLogin)
        model.addAttribute("favouritePosts", favouritePosts)
        return "favouritePosts"
    }

    @GetMapping(value = "/{userLogin}/favourites/{postId}")
    String getFavouritePost(@PathVariable String userLogin, @PathVariable Long postId, Model model)
    {
        Post post = postService.getFavouritePost(postId)
        model.addAttribute("favouritePost", post)
        return "favouritePost"
    }

    @GetMapping(value = "/{userLogin}/addToFavourite/{postId}")
    String addPostToFavourite(@PathVariable String userLogin, @PathVariable Long postId, Model model)
    {
        postService.addToFavourite(postId, userLogin)
        List<Post> favouritePosts = postService.getFavouritePosts(userLogin)
        model.addAttribute("favouritePosts", favouritePosts)
        return "favouritePosts"
    }

    @DeleteMapping(value = "/{userLogin}/removefavourite/{postId}")
    String removePostFromFavourites(String userLogin, Long postId, Model model)
    {
        postService.removeFromFavourite(postId, userLogin)
        List<Post> favouritePosts = postService.getFavouritePosts(userLogin)
        model.addAttribute("favouritePosts", favouritePosts)
        return "favouritePosts"
    }

    @GetMapping(value = "/{userLogin}/like/{postId}")
    String likePost(@PathVariable String userLogin, @PathVariable Long postId, Model model)
    {
        subscriptionService.like(userLogin, postId)
        List<Post> favouritePosts = postService.getFavouritePosts(userLogin)
        model.addAttribute("likedPosts", favouritePosts)
        return "likedPosts"
    }

    @GetMapping(value = "/{userLogin}/unlike/{postId}")
    String removeLike(@PathVariable String userLogin, @PathVariable Long postId, Model model)
    {
        subscriptionService.removeLike(userLogin, postId)
        List<Post> favouritePosts = postService.getFavouritePosts(userLogin)
        model.addAttribute("likedPosts", favouritePosts)
        return "likedPosts"
    }
}
