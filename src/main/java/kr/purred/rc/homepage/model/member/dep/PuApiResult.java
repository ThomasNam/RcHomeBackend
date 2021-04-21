package kr.purred.rc.homepage.model.member.dep;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PuApiResult
{
	/**
	 * 성공 여부
	 */
	private boolean success;

	/**
	 * 메시지
	 */
	private String message;
}
