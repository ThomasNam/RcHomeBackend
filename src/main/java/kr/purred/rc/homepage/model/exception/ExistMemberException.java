package kr.purred.rc.homepage.model.exception;

/**
 * 데이터가 존재 하지 않음 Exception
 * @author RED
 *
 */
public class ExistMemberException extends Exception
{
	private static final long	serialVersionUID	= -7044189756706237640L;

	public ExistMemberException ()
	{
	}

	public ExistMemberException (String message)
	{
		super (message);
	}
}
