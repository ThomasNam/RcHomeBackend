package kr.purred.rc.homepage.controller.oapi.member;

import kr.purred.rc.homepage.model.exception.ExistDataException;
import kr.purred.rc.homepage.model.exception.NotSetRequiredDataException;
import kr.purred.rc.homepage.model.member.MyMemberSv;
import kr.purred.rc.homepage.model.member.data.RegisterMemberData;
import kr.purred.rc.homepage.model.member.domains.MyMember;
import kr.purred.rc.homepage.model.member.exception.RegisterMemException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
@CrossOrigin
public class OpenMemberCt
{
	private final MyMemberSv myMemberSv;

	@PostMapping("/")
	public MyMember createMember (@RequestBody RegisterMemberData memberData)
			throws NotSetRequiredDataException, ExistDataException, RegisterMemException
	{
		return myMemberSv.registerMember (memberData);
	}
}
