package com.smarty.SmartyApp.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field


@Document("Posts")
class Post
{
    @Id
    @Field("postId")
    Long postId

    @Field("text")
    String text

    @DBRef(db = "Users")
    User user

    @DBRef(db = "Users")
    Set<User> likedBy

    @Field("likes")
    Set<Long> likedUsersIds

    @DBRef(db = "comment")
    List<Comment> comments
}
