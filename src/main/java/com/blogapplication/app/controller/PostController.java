package com.blogapplication.app.controller;

import com.blogapplication.app.payload.PostDto;
import com.blogapplication.app.payload.PostResponse;
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
    ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,
                                       @PathVariable("userId") Long userId,
                                       @PathVariable("categoryId") Long categoryId,
                                       @PathVariable("postId") Long postId){
        PostDto updatedPostDto = postService.updatePost(postDto,postId,userId,categoryId);
        return ResponseEntity.ok(updatedPostDto);
    }

    @GetMapping("/posts")
    ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value="pageNumber",defaultValue = "0",required = false) Integer pageNumber,
            @RequestParam(value="pageSize",defaultValue = "5",required = false) Integer pageSize
    ){
        PostResponse postData = postService.getAllPost(pageNumber,pageSize);
        return new ResponseEntity<>(postData, HttpStatus.OK);
    }

    @DeleteMapping("/post/{id}")
    ResponseEntity<PostDto> deletePost(@PathVariable("id") Long id){
        PostDto postDto = postService.deletePost(id);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    ResponseEntity<PostDto> getPostById(@PathVariable("id") Long id){
        PostDto postDto = postService.getPostById(id);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable("categoryId") Long categoryId){
        List<PostDto> allPostDto = postService.getPostByCategory(categoryId);
        return new ResponseEntity<>(allPostDto,HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/posts")
    ResponseEntity<List<PostDto>> getPostByUser(@PathVariable("userId") Long userId){
        List<PostDto> allPostDto = postService.getPostByUser(userId);
        return new ResponseEntity<>(allPostDto,HttpStatus.OK);
    }


}
