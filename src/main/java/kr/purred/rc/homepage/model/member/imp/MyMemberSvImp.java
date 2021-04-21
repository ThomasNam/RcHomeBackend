package kr.purred.rc.homepage.model.member.imp;

import kr.purred.rc.homepage.lib.StrLib;
import kr.purred.rc.homepage.model.core.MongoSupportSv;
import kr.purred.rc.homepage.model.exception.ExistDataException;
import kr.purred.rc.homepage.model.exception.NoDataException;
import kr.purred.rc.homepage.model.exception.NotSetRequiredDataException;
import kr.purred.rc.homepage.model.member.MyMemberSv;
import kr.purred.rc.homepage.model.member.data.RegisterMemberData;
import kr.purred.rc.homepage.model.member.domains.MyMember;
import kr.purred.rc.homepage.model.member.imp.repository.MyMemberRepository;
import kr.purred.rc.homepage.model.member.searchData.MyMemberSearchData;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyMemberSvImp implements MyMemberSv
{
	/**
	 * UDPAY 회원 Repository
	 */
	private final MyMemberRepository myMemberRepository;

	/**
	 * MongoDB Support Sv
	 */
	private final MongoSupportSv mongoSupportSv;

	/**
	 * 이벤트 발행기
	 */
	private final ApplicationEventPublisher eventPublisher;

	@Override
	public MyMember registerMember (RegisterMemberData memberData) throws ExistDataException, NoDataException, NotSetRequiredDataException
	{
		if (StrLib.isEmptyStr (memberData.getMemberID ()))
			throw new NotSetRequiredDataException ("upMemberID");

		return null;
	}

	@Override
	public Optional<MyMember> getMember (String memberID)
	{
		return myMemberRepository.findById (memberID);
	}

	@Override
	public Page<MyMember> pagingMyMember (Pageable pageable, MyMemberSearchData searchData)
	{
		return mongoSupportSv.makePaging (MyMember.class, pageable, searchData);
	}

	@Override
	public List<MyMember> getMyMembers (MyMemberSearchData searchData)
	{
		return mongoSupportSv.getAllList (MyMember.class, searchData.makeQuery ());
	}

	@Override
	public boolean existID (String memberID)
	{
		return myMemberRepository.existsById (memberID);
	}

	@Override
	public MyMember deleteMyMember (String memberID)
	{
		return null;
	}
}
