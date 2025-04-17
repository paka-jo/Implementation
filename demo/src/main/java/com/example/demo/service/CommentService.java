package com.example.demo.service;

import com.example.demo.Model.CommentEntity;
import com.example.demo.dto.CommentDTO;
import com.example.demo.repository.CommentRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.stream.Collectors;

@Service("commentServiceField")
public class CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    public CommentService(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    public CommentEntity saveComment(CommentDTO commentDTO) {

       CommentEntity commentEntity = modelMapper.map(commentDTO, CommentEntity.class);
       return commentRepository.save(commentEntity);
    }

    public List<CommentDTO> findAllComment() {
        logger.info("findAllComment() 호출");
        List<CommentEntity> commentList = commentRepository.findAll();
        List<CommentDTO> commentDTOList = commentList.stream()
                .map(comment -> modelMapper.map(comment, CommentDTO.class))
                .collect(Collectors.toList());
        logger.info("findAllCommet() 반환: {}",commentDTOList);
        return commentDTOList;

    }


}
