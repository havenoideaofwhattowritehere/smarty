package com.smarty.SmartyApp.entities

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("User")
class User
{
    @org.springframework.data.annotation.Id
    Long userId

    @Field("login")
    String login

    @Field("password")
    String password

    @Field("subscriptionsIds")
    Set<Long> subscriptionsIds

    @Field("followersIds")
    Set<Long> followersIds

    @Field("publishedPostsIds")
    Set<Long> publishedPostsIds

    @Field("likedPostsIds")
    Set<Long> likedPostsIds

    @Field("favouritePostsIds")
    Set<Long> favouritePostsIds

    @Field("commentIds")
    Set<Long> commentIds
}
