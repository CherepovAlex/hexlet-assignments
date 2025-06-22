package exercise.controller.users;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {

    @Setter
    private static List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public List<Post> index(@PathVariable int id) {
        return posts.stream()
                .filter(post -> post.getUserId() == id)
                .collect(Collectors.toList());
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@PathVariable int id, @RequestBody Post postData) {
        Post newPost = new Post();
        newPost.setUserId(id);
        newPost.setSlug(postData.getSlug());
        newPost.setTitle(postData.getTitle());
        newPost.setBody(postData.getBody());

        posts.add(newPost);
        return newPost;
    }

}
// END
