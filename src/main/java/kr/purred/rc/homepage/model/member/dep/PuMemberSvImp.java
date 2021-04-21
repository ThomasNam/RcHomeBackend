package kr.purred.rc.homepage.model.member.dep;

import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kr.purred.rc.homepage.RcProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PuMemberSvImp implements PuMemberSv
{
	private final RcProperties rcProperties;

	@Override
	public PuApiResult registerMember (PuRegMemberData memberData) throws Exception
	{
		try
		{
			var response = Unirest.post (rcProperties.getMemberApiUrl () + "/mapi/member/")
					.header ("accept", "application/json")
					.header ("Content-Type", "application/json")
					.header ("globalToken", rcProperties.getMemberApiToken ()) // 토큰
					.body (memberData)
					.asObject (PuApiResult.class);

			return response.getBody ();
		}
		catch (UnirestException e)
		{
			throw new Exception (e.getMessage ());
		}

	}
}
