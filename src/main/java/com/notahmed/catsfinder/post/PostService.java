package com.notahmed.catsfinder.post;

import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
