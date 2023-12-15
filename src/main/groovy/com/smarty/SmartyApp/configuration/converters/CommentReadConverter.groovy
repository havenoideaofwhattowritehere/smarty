package com.smarty.SmartyApp.configuration.converters

import com.mongodb.DBObject
import com.smarty.SmartyApp.entities.Comment
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import org.springframework.stereotype.Component

@Component
@ReadingConverter
class CommentReadConverter implements Converter<DBObject, Comment>
{
    @Override
    Comment convert(DBObject source)
    {
        Comment comment = new Comment()
        comment.commentId = source.get("_id")
        comment.postId = source.get("postId")
        comment.authorId = source.get("authorId")
        comment.text = source.get("commentText")
        return null
    }
}
