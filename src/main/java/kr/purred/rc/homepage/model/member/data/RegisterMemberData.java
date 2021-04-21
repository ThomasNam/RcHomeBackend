package kr.purred.rc.homepage.model.member.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 회원 등록 정보
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class RegisterMemberData
{
	/**
	 * 회원 아이디
	 */
	private String memberID;

	/**
	 * 패스워드
	 */
	private String passwd;

	/**
	 * 이름
	 */
	private String name;

	/**
	 * E-mail
	 */
	private String email;
}
