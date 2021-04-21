package kr.purred.rc.homepage.model.member.searchData;

import kr.purred.rc.homepage.lib.StrLib;
import kr.purred.rc.homepage.model.core.data.SearchDataForMongo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * 회원 검색 데이터
 */
@Getter
@Setter
@Accessors (chain = true)
@EqualsAndHashCode (callSuper=true)
public class MyMemberSearchData extends SearchDataForMongo
{
	/**
	 * 회원 아이디
	 */
	private String myMemberIDLike;

	/**
	 * 판매자명
	 */
	private String name;

	/**
	 * 이메일
	 */
	private String email;

	@Override
	public Query makeQuery ()
	{
		Criteria criteria = null;

		if (!StrLib.isEmptyStr (myMemberIDLike))
			criteria = makeCriteria (criteria, "memberID").regex (myMemberIDLike);

		if (!StrLib.isEmptyStr (name))
			criteria = makeCriteria (criteria, "name").regex (name);

		if (!StrLib.isEmptyStr (email))
			criteria = makeCriteria (criteria, "email").regex (email);

		criteria = regDateWhere (criteria);

		return makeQuery (criteria);
	}
}
