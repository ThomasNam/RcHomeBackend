package kr.purred.rc.homepage.model.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberNotExistException extends Exception
{
	final private String memberID;
}
