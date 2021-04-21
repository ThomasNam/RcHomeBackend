package kr.purred.rc.homepage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "rc")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class RcProperties
{
	/**
	 * member API URL
	 */
	private String memberApiUrl;

	/**
	 * member API 토큰
	 */
	private String memberApiToken;
}
