package kr.purred.rc.homepage.model.exception;

/**
 * 데이터가 존재 하지 않음 Exception
 * @author RED
 *
 */
public class NoDataException extends Exception
{
	private static final long	serialVersionUID	= -7044189756706237640L;

	public NoDataException ()
	{
	}

	public NoDataException (String message)
	{
		super (message);
	}
}
