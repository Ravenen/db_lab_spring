package ua.lviv.iot.terminal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.terminal.domain.Post;
import ua.lviv.iot.terminal.service.PostService;

@RestController
@RequestMapping(value = "api/post", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController extends AbstractController<Post> {

  @Autowired
  public PostController(PostService postService) {
    super(postService);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<Post> updateObject(@PathVariable final Integer id,
                                           @RequestBody final Post post) {
    post.setId(id);
    Post oldPost = service.updateObject(id, post, new Post());
    return oldPost == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(oldPost, HttpStatus.OK);
  }
}
