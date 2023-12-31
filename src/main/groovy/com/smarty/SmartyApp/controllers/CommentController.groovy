package com.smarty.SmartyApp.controllers

import com.smarty.SmartyApp.entities.Comment
import com.smarty.SmartyApp.services.CommentService
import jakarta.annotation.Resource
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/comments")
class CommentController
{
    @Resource(name = "commentService")
    CommentService commentService;

    @GetMapping(value = "/{commentId}")
    String getComment(@PathVariable Long commentId, Model model)
    {
        return getSingleCommentPage(commentId, model)
    }

    @GetMapping(value = "/{postId}")
    String getComments(@PathVariable Long postId, Model model)
    {
        return getCommentsPage(postId, model)
    }

    @PostMapping(value = "/addComment")
    String addComment(@RequestParam(value = "postId") Long postId,
                      @RequestParam(value = "user") String userLogin,
                      @RequestParam(value = "text") String commentText,
                      Model model)
    {
        commentService.addComment(postId, userLogin, commentText)
        return getCommentsPage(postId, model)
    }

    @PatchMapping(value = "/editComment/{commentId}")
    String editComment(@RequestParam(value = "commentId") Long commentId,
                       @RequestParam(value = "text") String commentText,
                       Model model)
    {
        commentService.editComment(commentId, commentText)
        return getSingleCommentPage(commentId, model)
    }

    String getCommentsPage(Long postId, Model model)
    {
        List<Comment> comments = commentService.getCommentsForPost(postId)
        model.addAttribute("comments", comments)
        return "post"
    }


    String getSingleCommentPage(Long commentId, Model model)
    {
        Comment comment = commentService.getComment(commentId)
        model.addAttribute("comment", comment)
        return "commentPage"
    }

}
