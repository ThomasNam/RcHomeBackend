package kr.purred.rc.homepage.model.blog.imp;

import kr.purred.rc.homepage.lib.Util;
import kr.purred.rc.homepage.model.blog.PostSv;
import kr.purred.rc.homepage.model.blog.domains.Post;
import kr.purred.rc.homepage.model.blog.imp.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostSvImp implements PostSv
{
	private final PostRepository postRepository;

	@Override
	public Post addPost (Post post)
	{
		return postRepository.insert (post);
	}

	@Override
	public List<Post> getPosts ()
	{
		return postRepository.findAll ();
	}

	@Override
	public Post getPost (String id)
	{
		return postRepository.findById (id).orElseGet (Post::new);
	}

	@Override
	public Post updatePost (String id, Post updatePost)
	{
		Optional<Post> byId = postRepository.findById (id);

		if (byId.isPresent ())
		{
			var sourcePost = byId.get ();

			Util.myCopyProperties (updatePost, sourcePost);

			return postRepository.save (sourcePost);
		}

		return null;


	}
}
