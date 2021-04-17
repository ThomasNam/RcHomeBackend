package kr.purred.rc.homepage.model.blog.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
@Setter
@ToString
public class Post
{
	@Id
	private String id;

	/**
	 * 작성자
	 */
	private String author;

	/**
	 * 타이틀
	 */
	private String title;

	/**
	 * 썸네일 링크
	 */
	private String thumbnail;

	/**
	 * 미리 보기
	 */
	private String previewText;

	/**
	 * 내용
	 */
	private String content;

	/**
	 * 등록일
	 */
	private Date updateDate;
}
