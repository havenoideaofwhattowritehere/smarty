package com.smarty.SmartyApp.configuration.converters

import com.mongodb.DBObject
import com.smarty.SmartyApp.entities.User
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import org.springframework.stereotype.Component

@Component
@ReadingConverter
class UserReadConverter implements Converter<DBObject, User>
{
    @Override
    User convert(DBObject source)
    {
        User user = new User()
        user.userId = source.get("_id")
        user.login = source.get("login")
        user.password = source.get("password")
        user.subscriptionsIds = source.get("subscriptionsIds")
        user.followersIds = source.get("followersIds")
        user.publishedPostsIds = source.get("publishedPostsIds")
        user.likedPostsIds = source.get("likedPostsIds")
        user.favouritePostsIds = source.get("favouritePostsIds")
        user.commentIds = source.get("commentIds")
        return user
    }
}
