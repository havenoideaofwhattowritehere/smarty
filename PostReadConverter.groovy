package com.smarty.SmartyApp.configuration.converters

import com.mongodb.DBObject
import com.smarty.SmartyApp.entities.Post
import org.springframework.core.convert.converter.Converter

class PostReadConverter implements Converter<DBObject, Post>
{
    @Override
    Post convert(DBObject source)
    {
        Post post = new Post()
        post.postId = source.get("_id")
        post.text = source.get("text")
        post.user = source.get("user")
        post.likedBy = source.get("likedBy")
        post.likedUsersIds = source.get("likedUsersIds")
        post.comments = source.get("comments")
        return post
    }
}
