package com.smarty.SmartyApp.controllers

import com.smarty.SmartyApp.entities.Comment
import com.smarty.SmartyApp.services.CommentService
import jakarta.annotation.Resource
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comments")
class CommentController
{
    @Resource(name = "commentService")
    CommentService commentService;

    @GetMapping("/{commentId")
    String getComment(@PathVariable Long commentId, Model model)
    {
        return getSingleCommentPage(commentId, model)
    }

    @GetMapping("/{postId}")
    String getComments(@PathVariable Long postId, Model model)
    {
        return getCommentsPage(postId, model)
    }

    @PostMapping("/addComment")
    String addComment(@RequestParam(value = "postId") Long postId,
                      @RequestParam(value = "user") String userLogin,
                      @RequestParam(value = "text") String commentText,
                      Model model)
    {
        commentService.addComment(postId, userLogin, commentText)
        return getCommentsPage(postId, model)
    }

    @PatchMapping("/editComment/{commentId}")
    String editComment(@RequestParam(value = "commentId") Long commentId,
                       @RequestParam(value = "text") String commentText,
                       Model model)
    {
        commentService.editComment(commentId, commentText)
        return getSingleCommentPage(commentId, model)
    }

    String getCommentsPage(Long postId, Model model)
    {
        List<Comment> comments = commentService.getComments(postId)
        model.addAttribute("comments", comments)
        return "postandcomments"
    }


    String getSingleCommentPage(Long commentId, Model model)
    {
        Comment comment = commentService.getComment(commentId)
        model.addAttribute("comment", comment)
        return "commentPage"
    }

}
