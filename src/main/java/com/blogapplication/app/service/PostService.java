package com.blogapplication.app.service;

import com.blogapplication.app.payload.PostDto;
import com.blogapplication.app.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto,Long userId,Long categoryId);
    PostDto updatePost(PostDto postDto,Long postId, Long userId, Long categoryId);
    PostDto deletePost(Long postId);
    PostResponse getAllPost(Integer pageNumber, Integer pageSize);
    PostDto getPostById(Long postId);
    List<PostDto> getPostByCategory(Long categoryId);
    List<PostDto> getPostByUser(Long userId);
}
