package com.sparta.springcore.controller;

import com.sparta.springcore.model.Blog;
import com.sparta.springcore.dto.BlogRequestDto;
import com.sparta.springcore.service.BlogService;
import com.sparta.springcore.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BlogController {
    private final BlogRepository blogRepository;
    private final BlogService blogService;

//    @GetMapping("/api/hello")
//    public ResponseEntity<String> hello(){
//        return ResponseEntity.ok("hello");
//    }

    @GetMapping("/api/blogs")
    public List<Blog> getBlogs() {
        return blogRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/blogs")
    public Blog createBlog(@RequestBody BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);
        return blogRepository.save(blog);
    }

    @GetMapping("/api/blogs/{id}")
    public Optional<Blog> findBlog(@PathVariable Long id) {
        return blogRepository.findById(id);
    }

    @DeleteMapping("/api/blogs/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        blogRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/blogs/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody BlogRequestDto requestDto){
        return blogService.update(id, requestDto);
    }

}