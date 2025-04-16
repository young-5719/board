package restapi.board.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import restapi.board.entity.Post;
import restapi.board.repository.PostRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Page<Post> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> updatePost(Long id, Post updatePost) {
        return postRepository.findById(id).map(post->{
            post.setTitle(updatePost.getTitle());
            post.setContent(updatePost.getContent());
            return postRepository.save(post);
        });
    }

    public boolean deletePost(Long id) {
        return postRepository.findById(id).map(post->{
            postRepository.delete(post);
            return true;
        }).orElse(false);
    }

}
