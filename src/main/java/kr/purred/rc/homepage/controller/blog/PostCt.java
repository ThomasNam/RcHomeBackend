package kr.purred.rc.homepage.controller.blog;

import kr.purred.rc.homepage.model.blog.PostSv;
import kr.purred.rc.homepage.model.blog.domains.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blog")
@CrossOrigin
public class PostCt
{
	private final PostSv postSv;

	@PostMapping("/post")
	public Post createPost (@RequestBody Post post)
	{
		return postSv.addPost (post);
	}

	@GetMapping("/posts")
	public List<Post> getPosts ()
	{
		return postSv.getPosts ();
	}

	@GetMapping("/post/{id}")
	public Post getPost (@PathVariable("id") String id)
	{
		return postSv.getPost (id);
	}
}
