package com.sparta.springcore.model;


import com.sparta.springcore.dto.BlogRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Entity
public class Blog extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;


    public Blog(String username, String pw, String contents, String title) {
        this.username = username;
        this.pw = pw;
        this.contents = contents;
        this.title = title;
    }

    public Blog(BlogRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.pw = requestDto.getPw();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }

    public void update(BlogRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.pw = requestDto.getPw();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }

}