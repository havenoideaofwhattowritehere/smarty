package com.smarty.SmartyApp.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field


@Document
class Comment
{
    @Id
    @Field("commentId")
    Long commentId

    @DBRef(db = "Post")
    Post postId

    @DBRef(db = "Post")
    User authorId

    @Field("commentText")
    String text

}
