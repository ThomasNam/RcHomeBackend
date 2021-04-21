package kr.purred.rc.homepage.model.exception;

/**
 * 로그인 예외 처리
 *
 * Created by RED on 2015-10-29.
 */
public class LoginException extends Exception
{
	public enum LoginExceptionType
	{
		NO_DATA,

		NOT_MATCHING_MEMBER_TYPE,

		PASSWD_ERROR,
	}

	public LoginException (LoginExceptionType exceptionType)
	{
		this.exceptionType = exceptionType;
	}

	private LoginExceptionType exceptionType;

	public LoginExceptionType getExceptionType ()
	{
		return exceptionType;
	}
}
