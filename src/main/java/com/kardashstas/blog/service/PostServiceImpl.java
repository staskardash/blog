package com.kardashstas.blog.service;

import com.kardashstas.blog.entity.Post;
import com.kardashstas.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> fetchPostList() {
        return postRepository.findAll();
    }

    @Override
    public void deletePostById(Long id) {
         postRepository.deleteById(id);
    }

    @Override
    public Post updatePost(Long id, Post post) {
        Post postDB = postRepository.findById(id).get();
        if (Objects.nonNull(post.getTitle()) && !"".equalsIgnoreCase(post.getTitle())) {
            postDB.setTitle(post.getTitle());
        }
        if (Objects.nonNull(post.getContent()) && !"".equalsIgnoreCase(post.getContent())) {
            postDB.setContent(post.getContent());
        }
        return postRepository.save(postDB);
    }
}
