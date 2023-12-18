package com.smarty.SmartyApp.configuration.converters

import com.mongodb.BasicDBObject
import com.mongodb.DBObject
import com.smarty.SmartyApp.entities.Comment
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.WritingConverter
import org.springframework.stereotype.Component

@Component
@WritingConverter
class CommentWriteConverter implements Converter<Comment, DBObject>
{
    @Override
    DBObject convert(Comment source)
    {
        DBObject dbObject = new BasicDBObject()
        dbObject.put("_id", source.commentId)
        dbObject.put("post", source.post)
        dbObject.put("user", source.user)
        dbObject.put("commentText", source.text)
        return dbObject
    }
}
