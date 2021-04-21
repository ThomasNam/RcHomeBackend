package kr.purred.rc.homepage.model.member.domains;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@Document
@Accessors(chain = true)
public class MyMember
{
	/**
	 * ID
	 */
	@Id
	private String id;

	/**
	 * 유디 페이 회원 아이디 - id 와 값이 같다.
	 */
	@Indexed
	private String memberID;

	/**
	 * 이름
	 */
	private String name;

	/**
	 * E-mail
	 */
	private String email;

	/**
	 * 등록일
	 */
	private Date regDate;

}
