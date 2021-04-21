package kr.purred.rc.homepage.model.member.event;

import org.springframework.context.ApplicationEvent;

public class AddMyMemberEvent extends ApplicationEvent
{
	public AddMyMemberEvent (Object source)
	{
		super (source);
	}
}
