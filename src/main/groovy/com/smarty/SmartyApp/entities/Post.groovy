package com.smarty.SmartyApp.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field


@Document("post")
class Post
{
    @Id
    @Field("postId")
    Long postId

    @Field("text")
    String text

    @DBRef(db = "user")
    User author

    @DBRef(db = "user")
    Set<User> likedBy

    @Field("likes")
    Set<Long> likedUsersIds

    @DBRef(db = "comment")
    List<Comment> comments
}
