package com.example.board.repository;

import com.example.board.domain.BoardEntity;
import java.util.List;

public interface BoardCustomRepository {
    List<BoardEntity> findBoardEntitiesWithCategoriesAndHashtags(List<String> categories, List<String> hashtags);
}
