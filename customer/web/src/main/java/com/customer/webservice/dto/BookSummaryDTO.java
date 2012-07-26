package com.customer.webservice.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BookSummaryDTO")
public class BookSummaryDTO extends CollectionDTO {	
		
	private String bookname;
	private String picURL;
	private String author;
	private int bookPages;
	private String whoRead;
	private String description;
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPicURL() {
		return picURL;
	}
	public void setPicURL(String picURL) {
		this.picURL = picURL;
	}
	public int getBookPages() {
		return bookPages;
	}
	public void setBookPages(int bookPages) {
		this.bookPages = bookPages;
	}
	public String getWhoRead() {
		return whoRead;
	}
	public void setWhoRead(String whoRead) {
		this.whoRead = whoRead;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	

}
