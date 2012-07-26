package com.customer.webservice.dto;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "CollectionDTO")
public abstract class CollectionDTO {
	
	private String id;
	private String type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
