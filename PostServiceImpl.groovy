package com.smarty.SmartyApp.services.impl

import com.smarty.SmartyApp.daos.PostDao
import com.smarty.SmartyApp.entities.Post
import com.smarty.SmartyApp.entities.User
import com.smarty.SmartyApp.services.PostService
import com.smarty.SmartyApp.services.UserService
import org.springframework.stereotype.Component

@Component("postService")
class PostServiceImpl implements PostService
{
    UserService userService
    PostDao postDao
    PostService postService

    @Override
    List<Post> getPosts(String userLogin)
    {
        Long userId = userService.getUser(userLogin).userId
        List<Post> posts = postDao.findAll()
        List<Post> userPosts
        for (i in 0..<posts.size())
        {
            if (posts[i].user.userId == userId)
            {
                userPosts.add(posts[i])
            }
        }
        return userPosts
    }

    @Override
    Post getPost(Long postId)
    {
        return postDao.findById(postId) as Post
    }

    @Override
    boolean publish(String text, String login)
    {
        try
        {
            User user = userService.getUser(login)
            Post post = new Post(text: text, user: user)
            postDao.insert(post)
        } catch (Throwable throwable)
        {
            return false
        }
        return true
    }

    @Override
    boolean remove(Long postId)
    {
        try
        {
            postDao.deleteById(postId)
            return true
        } catch (Throwable throwable)
        {
            return false
        }
    }

    @Override
    boolean editPost(Long postId, String text, String userLogin)
    {
        try
        {
            User user = userService.getUser(userLogin)
            Post post = postDao.findById(postId) as Post
            if (user.userId == post.user.userId)
            {
                post.text = text
                postDao.save(post)
                return true
            }
            else
            {
                throw Exception as Throwable
            }
        } catch (Throwable throwable)
        {
            return false
        }
    }

    @Override
    boolean addToFavourite(Long postId, String login)
    {
        try
        {
            User user = userService.getUser(login)
            user.favouritePostsIds.add(postId)
            Post post = postService.getPost(postId)
            post.likedUsersIds.add(user.userId)
            post.likedBy.add(user)
            return true
        } catch (Throwable throwable)
        {
            return false
        }
    }

    @Override
    boolean removeFromFavourite(Long postId, String login)
    {
        try
        {
            User user = userService.getUser(login)
            Post post = postDao.findById(postId) as Post
            user.favouritePostsIds.remove(post.postId)
            post.likedUsersIds.add(user.userId)
            post.likedBy.add(user)
            return true
        } catch (Throwable throwable) {
            return false
        }
    }


    @Override
    Long likesAmount(Long postId)
    {
        def post = postDao.findById(postId) as Post
        return post.likedBy.size()
    }

    @Override
    List<Post> getFavouritePosts(String userLogin)
    {
        def user = userService.getUser(userLogin)
        List<Long> favouritePostsIds = user.favouritePostsIds
        List<Post> favouritePosts
        for (i in 0..<favouritePostsIds.size()) {
            favouritePosts.add(postDao.findById(favouritePostsIds[i]) as Post)
        }
        return favouritePosts
    }

    @Override
    Post getFavouritePost(Long postId, String userLogin)
    {
        def user = userService.getUser(userLogin)
        List<Long> favouritePostsIds = user.favouritePostsIds
        for (i in 0..<favouritePostsIds.size()) {
            if (postId == favouritePostsIds[i])
            {
                return postDao.findById(postId) as Post
            }
        }
    }
}

