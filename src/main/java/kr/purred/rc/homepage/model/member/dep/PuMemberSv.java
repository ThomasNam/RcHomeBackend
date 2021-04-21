package kr.purred.rc.homepage.model.member.dep;

public interface PuMemberSv
{
	/**
	 * 사용자를 등록한다.
	 * @param memberData 회원 정보
	 * @throws Exception 예외
	 */
	PuApiResult registerMember (PuRegMemberData memberData) throws Exception;
}
