package me.hosick.web;

import lombok.RequiredArgsConstructor;
import me.hosick.service.posts.PostsService;
import me.hosick.web.dto.PostsSaveRequestDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PutMapping("/api/v1/posts")
    public Long Save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
