package com.smarty.SmartyApp.configuration.converters

import com.mongodb.BasicDBObject
import com.mongodb.DBObject
import com.smarty.SmartyApp.entities.User
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.WritingConverter
import org.springframework.stereotype.Component

@Component
@WritingConverter
class UserWriteConverter implements Converter<User, DBObject>
{
    @Override
    DBObject convert(User source)
    {
        DBObject dbObject = new BasicDBObject()
        dbObject.put("_id", user.userId)
        dbObject.put("login", user.login)
        dbObject.put("password", user.password)
        dbObject.put("subscriptionsIds", user.subscriptionsIds)
        dbObject.put("followersIds", user.followersIds)
        dbObject.put("publishedPostsIds", user.publishedPostsIds)
        dbObject.put("likedPostsIds", user.likedPostsIds)
        dbObject.put("favouritePostsIds", user.favouritePostsIds)
        dbObject.put("commentIds", user.commentIds)
        return dbObject
    }
}
