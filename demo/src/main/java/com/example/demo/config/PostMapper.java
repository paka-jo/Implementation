package com.example.demo.config;

import com.example.demo.dto.PostDTO;
import com.example.demo.Model.PostEntity;

import java.time.LocalDateTime;

public class PostMapper {

    // Entity → DTO 변환
    public static PostDTO toDto(PostEntity entity) {
        PostDTO dto = new PostDTO();
        dto.setId(entity.getPostCode());
        dto.setTitle(entity.getPostTitle());
        dto.setContent(entity.getPostContent());
        dto.setNickname(entity.getPageNickname());
        dto.setCreatedAt(entity.getPostCreatedAt());
        return dto;
    }

    // DTO → Entity 변환
    public static PostEntity toEntity(PostDTO dto) {
        PostEntity entity = new PostEntity();
        entity.setPostCode(dto.getId() != null ? dto.getId() : 0L);  // 새 게시물일 경우 0 또는 null로 처리
        entity.setPostTitle(dto.getTitle());
        entity.setPostContent(dto.getContent());
        entity.setPageNickname(dto.getNickname());
        entity.setPostCreatedAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : LocalDateTime.now());
        return entity;
    }
}
