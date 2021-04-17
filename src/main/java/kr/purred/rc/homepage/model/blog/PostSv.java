package kr.purred.rc.homepage.model.blog;

import kr.purred.rc.homepage.model.blog.domains.Post;

import java.util.List;

public interface PostSv
{
	Post addPost (Post post);

	List<Post> getPosts ();

	Post getPost (String id);
}
