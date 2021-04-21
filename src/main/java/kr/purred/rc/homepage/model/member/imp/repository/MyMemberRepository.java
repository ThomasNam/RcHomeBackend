package kr.purred.rc.homepage.model.member.imp.repository;

import kr.purred.rc.homepage.model.member.domains.MyMember;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyMemberRepository extends MongoRepository<MyMember, String>
{
}
