package kr.purred.rc.homepage.model.exception;

/**
 * 필수 데이터가 셋팅되어 있지 않음
 * 
 * - 필수 데이터가 셋팅되어 있지 않을 때 발생되는 예외이며 셋팅되지 않은 필드 정보는 fieldName에 설정된다.
 * @author RED
 */
public class NotSetRequiredDataException extends Exception
{
	private static final long	serialVersionUID	= -7044189756706237640L;

	private String fieldName;
	
	public NotSetRequiredDataException (String fieldName)
	{
		super(fieldName + " is not set required data!!!");
		this.fieldName = fieldName;
	}

	public String getFieldName ()
	{
		return fieldName;
	}

	public void setFieldName (String fieldName)
	{
		this.fieldName = fieldName;
	}
}
