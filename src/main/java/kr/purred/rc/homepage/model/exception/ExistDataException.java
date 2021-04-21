package kr.purred.rc.homepage.model.exception;

/**
 * 데이터 존재 Exception
 * @author RED
 *
 */
public class ExistDataException extends Exception
{
	private static final long	serialVersionUID	= 1689842079703549586L;

	public ExistDataException () {}

	public ExistDataException (String message)
	{
		super (message);
	}
}
