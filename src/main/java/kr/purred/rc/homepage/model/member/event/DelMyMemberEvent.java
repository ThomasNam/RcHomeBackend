package kr.purred.rc.homepage.model.member.event;

import org.springframework.context.ApplicationEvent;

public class DelMyMemberEvent extends ApplicationEvent
{
	public DelMyMemberEvent (Object source)
	{
		super (source);
	}
}
