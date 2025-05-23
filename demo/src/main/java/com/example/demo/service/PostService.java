package com.example.demo.service;

import com.example.demo.Model.PostEntity;
import com.example.demo.dto.PostDTO;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import org.modelmapper.ModelMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service("postServiceField")
public class PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    ;

    public PostService(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    public PostEntity savePost(PostDTO postDTO) {

        PostEntity postEntity = modelMapper.map(postDTO, PostEntity.class);
        return postRepository.save(postEntity);
    }


    public List<PostDTO> findAllPost() {
        logger.info("findAllPost() 호출");
        List<PostEntity> postList = postRepository.findAll();
        List<PostDTO> postDTOList = postList.stream()
                .map(post -> modelMapper.map(post, PostDTO.class))
                .collect(Collectors.toList());
        logger.info("findAllPost() 반환: {}", postDTOList);
        return postDTOList;
    }

    public List<PostDTO> findAllPostForList() {
        List<PostEntity> postList = postRepository.findAll();
        return postList.stream()
                .map(post -> modelMapper.map(post, PostDTO.class))
                        .collect(Collectors.toList());
    }

    public PostDTO findPostById(Long id) {
        // 예시. 실제로는 Repository에서 데이터 가져오는 코드가 필요
        return postRepository.findById(id)
                .map(post -> modelMapper.map(post, PostDTO.class))
                .orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다."));
    }



}


