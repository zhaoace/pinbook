package com.customer.webservice.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BookDetailDTO")
public class BookDetailDTO extends BookSummaryDTO {

	private List<String> demoReadPagess;
	public List<String> getDemoReadPagess() {
		return demoReadPagess;
	}

	public void setDemoReadPagess(List<String> demoReadPagess) {
		this.demoReadPagess = demoReadPagess;
	}
	
	
	
	
	
}
