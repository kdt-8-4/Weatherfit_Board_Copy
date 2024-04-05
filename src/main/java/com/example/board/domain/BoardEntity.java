package com.example.board.domain;

import com.example.board.dto.LikeDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.example.board.dto.ImageDTO;
import com.example.board.repository.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "board")
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardId;

    @Builder.Default
    @Column(name = "nickName", nullable = false)
    private String nickName = "";

    @Builder.Default
    @Column(name = "content", nullable = false)
    private String content = "";

    @Builder.Default
    @Column(name = "temperature", nullable = false)
    private double temperature = 0;

    @ElementCollection
    @Column(name = "category", nullable = false)
    private List<String> category = new ArrayList<>();

    @ElementCollection
    @Builder.Default
    @Column(name = "hashTag")
    private List<String> hashTag = new ArrayList<>();

    @Column(name = "status")
    @Builder.Default
    private boolean status = true;

    @OneToMany(mappedBy = "boardId", cascade = CascadeType.ALL)
    private List<ImageEntity> images;

    @JsonManagedReference
    @OneToMany(mappedBy = "boardId", cascade = CascadeType.REMOVE)
    private List<LikeEntity> likelist;

    @Column(name = "weatherIcon")
    private String weatherIcon;

    public ImageDTO entityToDTO(ImageEntity imageEntity) {
        return ImageDTO.builder()
                .boardId(imageEntity.getBoardId().getBoardId())
                .imageId(imageEntity.getImageId())
                .imageUrl(imageEntity.getImageUrl())
                .build();
    }

    public List<LikeDTO> likeEntityToDTO(List<LikeEntity> likeEntityList) {
        List<LikeDTO> list = new ArrayList<>();
        for(LikeEntity entity : likeEntityList) {
            list.add(LikeDTO.builder()
                    .likeId(entity.getLikeId())
                    .nickName(entity.getNickName())
                    .build()
            );
        }
        return list;
    }
}
