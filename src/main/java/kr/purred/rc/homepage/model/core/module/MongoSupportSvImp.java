package kr.purred.rc.homepage.model.core.module;

import com.mongodb.client.result.UpdateResult;
import kr.purred.rc.homepage.model.core.MongoSupportSv;
import kr.purred.rc.homepage.model.core.data.SearchDataForMongo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by RED on 2016-07-06.
 */
@Service
@RequiredArgsConstructor
public class MongoSupportSvImp implements MongoSupportSv
{
	private final MongoTemplate mongoTemplate;

	@Override
	public <T> Integer getCnt(Class<T> entityClass, Query q) {

		return (int)mongoTemplate.count(q,entityClass);
	}

	@Override
	public <T> List<T> getAllList (Class<T> entityClass, Query q)
	{
		return mongoTemplate.find (q, entityClass);
	}

	@Override
	public <T> List<T> getAllList (Class<T> entityClass, Query q, List<Sort.Order> orders)
	{
		q.with (Sort.by (orders));

		System.out.println (q);

		return mongoTemplate.find (q, entityClass);
	}

	@Override
	public <T> List<T> getListLimit(Class<T> entityClass, Query qIn, List<Sort.Order> orders, int endLimit)
	{
		qIn.with (Sort.by (orders));

		if(endLimit > 0)
			qIn.limit(endLimit);

		return mongoTemplate.find(qIn,entityClass);
	}

	@Override
	public <T> List<T> getListLimit(Class<T> entityClass, SearchDataForMongo s)
	{
		Query q = s.makeQuery();

		if(s.getLimitStart()>=1)
		{
			q.skip(s.getLimitStart()-1);
		}

		if(s.getLimitEnd() > 0)
			q.limit(s.getLimitEnd());

		return mongoTemplate.find(q,entityClass);
	}

	@Override
	public <T> UpdateResult update (Class<T> entityClass, Query q, Update u)
	{
		return mongoTemplate.updateMulti (q, u, entityClass);
	}

	/**
	 * 페이징을 만든다
	 * @param entityClass 엔트리 클래스
	 * @param pageable 페이지에이블
	 * @param searchData 검색 데이터
	 * @return 페이지 리스트
	 */
	@Override
	public <T> Page<T> makePaging (Class<T> entityClass, Pageable pageable, SearchDataForMongo searchData)
	{
		Query q = searchData.makeQuery ();

		long totalCnt = mongoTemplate.count (q, entityClass);

		q = q.with (pageable);

		List<Sort.Order> orders = searchData.makeOrder ();

		if (orders != null && orders.size () > 0)
			q.with (Sort.by (orders));
		else if (pageable.getSort () != null)
			q.with (pageable.getSort ());


		return new PageImpl (mongoTemplate.find (q, entityClass), pageable, totalCnt);
	}
}
