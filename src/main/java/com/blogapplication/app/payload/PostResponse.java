package com.blogapplication.app.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PostResponse {
    private List<PostDto> contents;
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalPages;
    private long totalStrength;
    private boolean lastPage;
}
