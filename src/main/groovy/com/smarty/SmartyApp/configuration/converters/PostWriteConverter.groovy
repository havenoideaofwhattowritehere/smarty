package com.smarty.SmartyApp.configuration.converters

import com.mongodb.BasicDBObject
import com.mongodb.DBObject
import com.smarty.SmartyApp.entities.Post
import org.springframework.core.convert.converter.Converter

class PostWriteConverter implements Converter<Post, DBObject>
{
    @Override
    DBObject convert(Post source)
    {
        DBObject dbObject = new BasicDBObject()
        dbObject.put("_id", source.postId)
        dbObject.put("postText", source.text)
        dbObject.put("user", source.user)
        dbObject.put("likedBy", source.likedBy)
        dbObject.put("likedUsersIds", source.likedUsersIds)
        dbObject.put("comments", source.comments)
        return dbObject
    }
}
