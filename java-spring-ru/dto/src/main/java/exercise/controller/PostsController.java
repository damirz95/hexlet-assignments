package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    private PostDTO toDTO(Post post, List<Comment> comments) {
        var postDTO = new PostDTO();
        List<CommentDTO> commentDTO = new ArrayList<>();
        for(var comment: comments) {
            commentDTO.add(toCommentDTO(comment));
        }
        postDTO.setBody(post.getBody());
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setComments(commentDTO);
        return postDTO;
    }
    private CommentDTO toCommentDTO(Comment comment) {
        var dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setBody(comment.getBody());
        return dto;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> index(@RequestParam(defaultValue = "10") Integer limit) {
        var posts = postRepository.findAll();
        return posts.stream()
                .map(v -> toDTO(v, commentRepository.findByPostId(v.getId())))
                .toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO show(@PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id "+ id + " not found"));
        var comments = commentRepository.findByPostId(post.getId());
        return toDTO(post, comments);
    }
}
// END
