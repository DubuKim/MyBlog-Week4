package com.sparta.springcore.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BlogRequestDto {
    private final String username;
    private final String pw;
    private final String title;
    private final String contents;
}
