package com.example.demo.repository;

import com.example.demo.Model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
} // JPAdb를  조작하기 위한 메서드들 제공
