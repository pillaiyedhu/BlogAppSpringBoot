package com.blogapplication.app.payload;

import com.blogapplication.app.entity.Category;
import com.blogapplication.app.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String caption;
    private Date createdDate;
    private CategoryDto category;
    private UserDto user;
}
