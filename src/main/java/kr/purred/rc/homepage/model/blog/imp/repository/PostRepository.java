package kr.purred.rc.homepage.model.blog.imp.repository;

import kr.purred.rc.homepage.model.blog.domains.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String>
{
}
