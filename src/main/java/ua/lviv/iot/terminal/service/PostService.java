package ua.lviv.iot.terminal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.terminal.domain.Post;
import ua.lviv.iot.terminal.repository.PostRepository;

@Service
public class PostService extends AbstractService<Post> {
  @Autowired
  public PostService(final PostRepository postRepository) {
    super(postRepository);
  }
}
