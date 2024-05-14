package com.blogapplication.app.respository;

import com.blogapplication.app.entity.Category;
import com.blogapplication.app.entity.Post;
import com.blogapplication.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRespository extends JpaRepository<Post,Long> {
    List<Post> findByCategory(Category category);
    List<Post> findByUser(User user);
}
