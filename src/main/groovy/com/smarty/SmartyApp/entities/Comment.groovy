package com.smarty.SmartyApp.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field


@Document("Comments")
class Comment
{
    @Id
    @Field("commentId")
    Long commentId

    @DBRef(db = "Posts")
    Post post

    @DBRef(db = "Users")
    User user

    @Field("commentText")
    String text

}