package com.kardashstas.blog.service;

import com.kardashstas.blog.entity.Post;

import java.util.List;

public interface PostService {

    public Post savePost(Post post);

    public List<Post> fetchPostList();

    public void deletePostById(Long Id);

    public Post updatePost(Long Id, Post post);

}
