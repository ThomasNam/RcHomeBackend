package kr.purred.rc.homepage.model.core.data;


import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.purred.rc.homepage.lib.StrLib;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by RED on 2016-07-06.
 */
@Data
@Accessors (chain = true)
public class SearchDataForMongo
{
	/**
	 * 시작일
	 */
	private String startDate;

	/**
	 * 종료일
	 */
	private String endDate;

	/**
	 * 정렬값
	 */
	private String orderVal;

	/**
	 * 정렬항목
	 */
	private boolean orderAsc;

	/**
	 * 시작 순번
	 */
	private int   limitStart;

	/**
	 * 종료 순번
	 */
	private int   limitEnd;

	/**
	 * 정렬 조건
	 */
	@JsonIgnore
	private List<Order> orders;

	public SearchDataForMongo ()
	{
		orders = new ArrayList<> ();
	}

	public Query makeQuery ()
	{
		return makeQuery (null);
	}

	protected Query makeQuery (Criteria criteria)
	{
		return criteria != null ? query (criteria) : new Query ();
	}

	protected Criteria makeCriteria (Criteria initCriteria, String field)
	{
		Criteria criteria;

		if (initCriteria == null)
			criteria = where (field);
		else
			criteria = initCriteria.and (field);

		return criteria;
	}

	protected Criteria makeCriteriaOr (Criteria initCriteria, Criteria... criteriaList)
	{
		Criteria criteria;

		if (initCriteria != null)
			criteria = initCriteria.orOperator (criteriaList);
			//criteria = initCriteria.andOperator (initCriteria.orOperator (criteriaList));
		else
			criteria = new Criteria ().orOperator (criteriaList);
			//criteria = initCriteria;		// TODO 이부분 고민... 예외로 발생시켜야하나 -_-

		return criteria;
	}

	public List<Order> makeOrder ()
	{
		return makeOrder (null);
	}

	public List<Order> makeOrder (Order defaultOrder)
	{
		if (orders.size () > 0)
			return orders;

		if (!StrLib.isEmptyStr (getOrderVal ()))
		{
			if (getOrderVal ().contains (","))
			{
				String [] orderStrs = getOrderVal ().split (",");

				Arrays.stream (orderStrs).forEach ((o) -> {
					if (o.endsWith ("_DESC"))
						orders.add (new Order (Sort.Direction.DESC, o.substring (0, o.length () - 5)));
					else
						orders.add (new Order (Sort.Direction.ASC, o));
				});
			}
			else
			{
				orders.add (new Order (isOrderAsc () ? Sort.Direction.ASC : Sort.Direction.DESC, getOrderVal ()));
			}
		}
		else
		{
			if (defaultOrder != null)
				orders.add (defaultOrder);
		}

		return orders;
	}

	/**
	 * 등록일 검색 로직
	 * @param criteria 검색 조건
	 * @return 설정된 검색 조건
	 */
	protected Criteria regDateWhere(Criteria criteria)
	{
		return regDateWhere (criteria, "regModDate.regDate");
	}

	/**
	 * 해당일 검색 로직
	 * @param criteria 검색 조건
	 * @param fieldName 검색 필드
	 * @return 설정된 검색 조건
	 */
	protected Criteria regDateWhere(Criteria criteria, String fieldName)
	{

		try
		{
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			if (!StrLib.isEmptyStr(getStartDate()) && !StrLib.isEmptyStr(getEndDate()))
			{
				criteria = makeCriteria(criteria, fieldName).gte(df.parse(getStartDate() + " 00:00:00")).lte(df.parse(getEndDate() + " 23:59:59"));
			}
			else if (!StrLib.isEmptyStr(getStartDate()))
			{
				criteria = makeCriteria(criteria, fieldName).gte(df.parse(getStartDate() + " 00:00:00"));
			}
			else if (!StrLib.isEmptyStr(getEndDate()))
			{
				criteria = makeCriteria(criteria, fieldName).lte(df.parse(getEndDate() + " 23:59:59"));
			}

		}catch (ParseException e) {
			e.printStackTrace();
		}

		return criteria;
	}

	protected Criteria dateSearch(Criteria criteria, String fieldName, String startDate, String endDate)
	{

		try
		{
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			if (!StrLib.isEmptyStr (startDate) && !StrLib.isEmptyStr (endDate))
			{
				criteria = makeCriteria(criteria, fieldName).gte(df.parse(startDate + " 00:00:00")).lte(df.parse(endDate + " 23:59:59"));
			}
			else if (!StrLib.isEmptyStr (startDate))
			{
				criteria = makeCriteria(criteria, fieldName).gte(df.parse(startDate + " 00:00:00"));
			}
			else if (!StrLib.isEmptyStr (endDate))
			{
				criteria = makeCriteria(criteria, fieldName).lte(df.parse(endDate + " 23:59:59"));
			}

		}catch (ParseException e) {
			e.printStackTrace();
		}

		return criteria;
	}

	protected Criteria is (Criteria criteria, String fieldName, String val)
	{
		if (!StrLib.isEmptyStr (val))
			criteria = makeCriteria (criteria, fieldName).is (val);

		return criteria;
	}

	protected Criteria regex (Criteria criteria, String fieldName, String val)
	{
		if (!StrLib.isEmptyStr (val))
			criteria = makeCriteria (criteria, fieldName).regex (val);

		return criteria;
	}

	protected Criteria isLike (Criteria criteria, String fieldName, String val, String likeVal)
	{
		if (!StrLib.isEmptyStr (val))
			criteria = makeCriteria (criteria, fieldName).is (val);
		else if (!StrLib.isEmptyStr (likeVal))
			criteria = makeCriteria (criteria, fieldName).regex (likeVal);

		return criteria;
	}

	public int getLimitStart() {
		return limitStart;
	}

	public int getLimitEnd() {
		return limitEnd;
	}

	public SearchDataForMongo setLimitStart(int limitStart) {
		this.limitStart = limitStart;
		return this;
	}

	public SearchDataForMongo setLimitEnd(int limitEnd) {
		this.limitEnd = limitEnd;
		return this;
	}
}
