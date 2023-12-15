package com.smarty.SmartyApp.controllers

import com.smarty.SmartyApp.entities.Post
import com.smarty.SmartyApp.services.PostService
import com.smarty.SmartyApp.services.SubscriptionService
import jakarta.annotation.Resource
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostsController
{
    @Resource(name="postService")
    PostService postService

    @Resource(name="subscriptionService")
    SubscriptionService subscriptionService

    @GetMapping("/{userLogin}")
    String showAllPosts(@PathVariable String userLogin, Model model)
    {
        List<Post> posts = postService.getPosts(userLogin)
        model.addAttribute("posts", posts)
        return "posts"
    }
    @GetMapping("/{postId}")
    String showPost(@PathVariable Long postId, Model model)
    {
        Post post = postService.getPost(postId)
        model.addAttribute("post", post)
        return "post"
    }
    @GetMapping("/{userLogin}/publish")
    String addPost(String text, String userLogin)
    {
        postService.publish(text, userLogin)
    }
    @GetMapping("/{userLogin}/{postId}/edit")
    String editPost(String text, @PathVariable Long postId, @PathVariable userLogin)
    {
        postService.editPost(postId, text, userLogin)
        return "postView"
    }

    @DeleteMapping("/{userLogin/{postId}/remove")
    String deletePost(@PathVariable String userLogin, @PathVariable String id)
    {
        postService.remove(postId)
        return "postView"
    }
    @GetMapping("/{userLogin}/favourites")
    String getFavouritePosts(@PathVariable String userLogin, Model model)
    {
        List<Post> favouritePosts = postService.getFavouritePosts(userLogin)
        model.addAttribute("favoutitePosts", favouritePosts)
        return "favouritePostView"
    }

    @GetMapping("/{userLogin}/favourites/{postId}")
    String getFavouritePost(@PathVariable String userLogin, @PathVariable Long postId, Model model)
    {
        Post post = postService.getFavouritePost(postId)
        model.addAttribute("favouritePost", post)
        return "postView"
    }

    @GetMapping("/{userLogin}/{postId}/addToFavourite")
    String addPostToFavourite(@PathVariable String userLogin, @PathVariable Long postId, Model model)
    {
        postService.addToFavourite(postId, userLogin)
        model.addAttribute("favouritePost", post)
        return "favouritePostView"
    }

    @DeleteMapping("/{userLogin}/{postId}/remove")
    String removePostFromFavourites(String userLogin, Long postId)
    {
        postService.removeFromFavourite(postId, userLogin)
        return "favouritePostView"
    }

    @GetMapping("/{userLogin/{postId}/like")
    String likePost(@PathVariable String userLogin, @PathVariable Long postId)
    {
        subscriptionService.like(userLogin, postId)
        return "likedPosts"
    }

    @GetMapping("/{userLogin}/{postId}/unlike")
    String removeLike(@PathVariable String userLogin, @PathVariable Long postId)
    {
        subscriptionService.removeLike(userLogin, postId)
        return "likedPosts"
    }

}
