package com.blogapplication.app.service;

import com.blogapplication.app.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto,Long userId,Long categoryId);
    PostDto updatePost(PostDto postDto,Long postId, Long userId, Long categoryId);
    PostDto deletePost(Long postId);
    List<PostDto> getAllPost();
    PostDto getPostById(Long postId);
    List<PostDto> getPostByCategory(Long categoryId);
    List<PostDto> getPostByUser(Long userId);
}
