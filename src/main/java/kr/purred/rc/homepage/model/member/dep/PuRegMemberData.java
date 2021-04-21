package kr.purred.rc.homepage.model.member.dep;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PuRegMemberData
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
	 * 회원 타입
	 */
	private String memberType;
}
