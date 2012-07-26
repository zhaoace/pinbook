package com.customer.webservice.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FeedDTO")
public class FeedDTO {

	private int totalsize;
	private int nextcursor;
	private String platform;
	//private List<CollectionDTO> collections;
	private List<BookSummaryDTO> collections;
	public int getTotalsize() {
		return totalsize;
	}
	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}
	public int getNextcursor() {
		return nextcursor;
	}
	public void setNextcursor(int nextcursor) {
		this.nextcursor = nextcursor;
	}
	public List<BookSummaryDTO> getCollections() {
		return collections;
	}
	public void setCollections(List<BookSummaryDTO> collections) {
		this.collections = collections;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
}
