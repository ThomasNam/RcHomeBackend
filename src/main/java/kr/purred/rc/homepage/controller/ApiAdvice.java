package kr.purred.rc.homepage.controller;

import kr.purred.rc.homepage.controller.response.ApiResult;
import kr.purred.rc.homepage.model.exception.ExistDataException;
import kr.purred.rc.homepage.model.exception.NotSetRequiredDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(value = "kr.purred.rc.homepage.controller")
@RequiredArgsConstructor
public class ApiAdvice
{
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiResult errorAuthException (IllegalArgumentException e)
	{
		return ApiResult.fail (e.getMessage ());
	}

	@ExceptionHandler(NotSetRequiredDataException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiResult errorNotSetRequiredDataException (NotSetRequiredDataException e)
	{
		return ApiResult.fail (e.getMessage ());
	}

	@ExceptionHandler(ExistDataException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiResult errorExistDataException (ExistDataException e)
	{
		return ApiResult.fail ("데이터가 존재합니다.");
	}
}
