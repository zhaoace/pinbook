package com.customer.webservice.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CommentDTO")
public class CommentDTO {	

	private String colletioinID;
	private String commentID;
	private String content;
	private String author;
	private Date createTime;
	
	public String getCommentID() {
		return commentID;
	}
	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getColletioinID() {
		return colletioinID;
	}
	public void setColletioinID(String colletioinID) {
		this.colletioinID = colletioinID;
	}
	
	@Override
	public String toString() {
		return "CommentDTO [colletioinID=" + colletioinID + ", commentID="
				+ commentID + ", content=" + content + ", author=" + author
				+ ", createTime=" + createTime + "]";
		
	}
	
	
	
	
	
	
}
