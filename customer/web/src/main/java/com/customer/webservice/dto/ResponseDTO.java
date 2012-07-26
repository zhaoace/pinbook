package com.customer.webservice.dto;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "response")
public class ResponseDTO {	
	private String resultMsg;
	private Response.Status resultCode;
	private String result;
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public Response.Status getResultCode() {
		return resultCode;
	}
	public void setResultCode(Response.Status resultCode) {
		this.resultCode = resultCode;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}	
	
}
