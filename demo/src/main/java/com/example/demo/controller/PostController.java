package com.example.demo.controller;


import com.example.demo.dto.PostDTO;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/sub")
@RequiredArgsConstructor
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    private final PostService postService;

    @GetMapping("/list") // 게시물 목록
    public String findPostList(Model model) {
        try {
            List<PostDTO> postList = postService.findAllPost();
            model.addAttribute("postList", postList);
            logger.info("Fetched {} posts for the post list page", postList.size());
            return "sub/list";
        } catch (Exception e) {
            logger.error("Error fetching post list", e);
            model.addAttribute("errorMessage", "Error fetching post list");
            return "error";
        }
    }

    @GetMapping("/posts") //게시물 작성 페이지 생성
    public String createPostForm(Model model, PostDTO post) {
        try {
            model.addAttribute("postDTO", new PostDTO());
            return "sub/posts";
        } catch (Exception e) {
            logger.error("Error in createPostForm", e);
            model.addAttribute("errorMessage", "Error in creating post form");
            return "error";
        }
    }

    @PostMapping("/posts") //작성 글 생성
    public String createPost(@ModelAttribute PostDTO postDTO, Model model) {
        try {
            postService.savePost(postDTO);
            logger.info("postCreatedAt: {}", postDTO.getPostCreatedAt());
            return "redirect:/sub/list";
        } catch (Exception e) {
            logger.error("Error in createPost", e);
            model.addAttribute("errorMessage", "Error in creating post");
            return "error";
        }
    }

    @GetMapping("/detail/{PostId}") //작성한 글 조회
    public String findPostById(@PathVariable("PostId") Long id, Model model) {
        try {
            PostDTO post = postService.findPostById(id);
            model.addAttribute("post", post);
            return "sub/detail";
        } catch (Exception e) {
            logger.error("Error fetching post", e);
            model.addAttribute("errorMessage", "게시물을 불러오는 데 실패했습니다.");
            return "error";
        }

    }


    }





