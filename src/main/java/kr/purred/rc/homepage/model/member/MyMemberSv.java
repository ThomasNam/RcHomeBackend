package kr.purred.rc.homepage.model.member;

import kr.purred.rc.homepage.model.exception.ExistDataException;
import kr.purred.rc.homepage.model.exception.NoDataException;
import kr.purred.rc.homepage.model.exception.NotSetRequiredDataException;
import kr.purred.rc.homepage.model.member.data.RegisterMemberData;
import kr.purred.rc.homepage.model.member.searchData.MyMemberSearchData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.purred.rc.homepage.model.member.domains.MyMember;

import java.util.List;
import java.util.Optional;

/**
 * UDPAY 회원 Sv
 */
public interface MyMemberSv
{
	/**
	 * UDPAY 회원을 등록한다.
	 * @param upMemberData 회원 등록 정보
	 * @return 등록된 회원 정보
	 */
	MyMember registerMember (RegisterMemberData upMemberData) throws ExistDataException,
			NoDataException,
			NotSetRequiredDataException;


	/**
	 * 회원 정보를 리턴한다.
	 * @param memberID 회원 아이디
	 * @return 회원 정보
	 */
	Optional<MyMember> getMember (String memberID);

	/**
	 * 회원 정보를 페이징한다.
	 * @param pageable 페이지 정보
	 * @return 회원 페이지 리스트
	 */
	Page<MyMember> pagingMyMember (Pageable pageable, MyMemberSearchData searchData);

	/**
	 * 회원 정보를 검색한다.
	 * @param searchData 검색 데이터
	 * @return 회원 리스트 정보
	 */
	List<MyMember> getMyMembers (MyMemberSearchData searchData);

	/**
	 * 아이디 존재 여부
	 * @param memberID 아이디
	 * @return 아이디 존재 여부
	 */
	boolean existID (String memberID);

	/**
	 * 회원을 삭제한다.
	 * @param memberID 회원 아이디
	 * @return 삭제된 회원 정보
	 */
	MyMember deleteMyMember (String memberID);
}
