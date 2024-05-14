package com.blogapplication.app.service.impl;

import com.blogapplication.app.entity.Category;
import com.blogapplication.app.entity.Post;
import com.blogapplication.app.entity.User;
import com.blogapplication.app.exception.ResourceNotFoundException;
import com.blogapplication.app.payload.PostDto;
import com.blogapplication.app.respository.CategoryRepository;
import com.blogapplication.app.respository.PostRespository;
import com.blogapplication.app.respository.UserRepository;
import com.blogapplication.app.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRespository postRespository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public PostDto createPost(PostDto postDto, Long userId, Long categoryId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","userId",userId));
        Category category = categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        Post post = modelMapper.map(postDto,Post.class);
        post.setCreatedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post createdPost = postRespository.save(post);
        PostDto createdPostDto = modelMapper.map(createdPost,PostDto.class);
        return createdPostDto;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long postId, Long userId, Long categoryId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","userId",userId));
        Category category = categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        Post post = postRespository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post","PostId",postId));
        if(postDto.getTitle()!=null && postDto.getTitle()!=""){
            post.setTitle(postDto.getTitle());
        }
        if(postDto.getCaption()!=null && postDto.getCaption()!=""){
            post.setCaption(postDto.getCaption());
        }
        post.setCreatedDate(new Date());
        postRespository.save(post);
        PostDto updatedPostDto = modelMapper.map(post,PostDto.class);
//        updatedPostDto.setCategoryDto(modelMapper.map(category, CategoryDto.class));
//        updatedPostDto.setUserDto(modelMapper.map(user, UserDto.class));
        return updatedPostDto;
    }

    @Override
    public PostDto deletePost(Long postId) {

        Post post = postRespository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","PostId",postId));
        postRespository.delete(post);
        PostDto postDto = modelMapper.map(post,PostDto.class);
        return postDto;
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> allPost = postRespository.findAll();
        List<PostDto> allPostDto = allPost.stream().map(post -> modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return allPostDto;
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = postRespository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","postId",postId));
        PostDto postDto = modelMapper.map(post,PostDto.class);
        return postDto;
    }

    @Override
    public List<PostDto> getPostByCategory(Long categoryId) {
        return null;
    }

    @Override
    public List<PostDto> getPostByUser(Long userId) {
        return null;
    }
}
