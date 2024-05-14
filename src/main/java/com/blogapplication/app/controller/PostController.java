package com.blogapplication.app.controller;

import com.blogapplication.app.payload.PostDto;
import com.blogapplication.app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/post")
    ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
                                       @PathVariable("userId") Long userId,
                                       @PathVariable("categoryId") Long categoryId){
        PostDto createdPost = postService.createPost(postDto,userId,categoryId);
        return ResponseEntity.ok(createdPost);
    }

    @PutMapping("/user/{userId}/category/{categoryId}/post/{postId}")
    ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
                                       @PathVariable("userId") Long userId,
                                       @PathVariable("categoryId") Long categoryId,
                                       @PathVariable("postId") Long postId){
        PostDto updatedPostDto = postService.updatePost(postDto,postId,userId,categoryId);
        return ResponseEntity.ok(updatedPostDto);
    }

    @GetMapping("/posts")
    ResponseEntity<List<PostDto>> getAllPost(){
        List<PostDto> allPosts = postService.getAllPost();
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }
}
