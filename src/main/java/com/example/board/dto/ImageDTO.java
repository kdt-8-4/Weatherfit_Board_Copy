package com.example.board.dto;

import lombok.*;

@Getter
@Builder
public class ImageDTO {
    private int imageId;
    private int boardId;
    private String imageUrl;


}
