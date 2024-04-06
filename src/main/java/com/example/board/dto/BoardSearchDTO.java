package com.example.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class BoardSearchDTO {
    private int boardId;
    private String nickName;
    private double temperature;
    private int likeCount;
    private ImageDTO images;
    private List<String> category;
    private List<String> hashTag;
    private LocalDateTime createData;
    private List<LikeDTO> likelist;
    private String weatherIcon;
}
