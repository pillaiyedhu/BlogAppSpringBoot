package com.blogapplication.app.respository;

import com.blogapplication.app.entity.Category;
import com.blogapplication.app.entity.Post;
import com.blogapplication.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRespository extends JpaRepository<Post,Long> {
    List<Post> findByCategory(Category category);
    List<Post> findByUser(User user);

    //doing this using query .. even we can do this using above method
    @Query("SELECT p FROM Post p WHERE p.title LIKE :keyword")
    List<Post> searchPostByTitle(@Param("keyword") String keyword);
}
