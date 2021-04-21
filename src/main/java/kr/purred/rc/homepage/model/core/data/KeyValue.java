package kr.purred.rc.homepage.model.core.data;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * KEY, VALUE 쌍
 *
 * Created by RED on 2015-06-09.
 */
@Data
@Accessors (chain = true)
public class KeyValue
{
	/**
	 * 키
	 */
	private String key;

	/**
	 * 값
	 */
	private String value;

	public KeyValue ()
	{
	}

	public KeyValue (String key, String value)
	{
		this.key = key;
		this.value = value;
	}
}
