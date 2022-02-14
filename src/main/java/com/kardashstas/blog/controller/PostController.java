package com.kardashstas.blog.controller;

import com.kardashstas.blog.entity.Post;
import com.kardashstas.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post savePost (@RequestBody Post post) {
        return postService.savePost(post);
    }

    @GetMapping
    public List<Post> fetchPostList() {
        return postService.fetchPostList();
    }

    @DeleteMapping("/{id}")
    public String deletePostById(@PathVariable("id") Long Id) {
        postService.deletePostById(Id);
        return "Post deleted successfully!";
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable("id") Long Id,@RequestBody Post post) {
        return postService.updatePost(Id, post);
    }

}
