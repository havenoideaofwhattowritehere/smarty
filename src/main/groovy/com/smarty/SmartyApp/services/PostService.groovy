package com.smarty.SmartyApp.services

import com.smarty.SmartyApp.entities.Post
import com.smarty.SmartyApp.entities.User

interface PostService
{
    List<Post> getPosts(String userLogin)
    Post getPost(Long postId)
    boolean publish(String text, String login)
    boolean remove(Long postId)
    boolean editPost(Long postId, String text, String userLogin)
    boolean addToFavourite(Long postId, String login)
    boolean removeFromFavourite(Long postId, String login)
    Long likesAmount(Long postId)
    List<Post> getFavouritePosts(String userLogin)
    Post getFavouritePost(Long postId, String userLogin)
}