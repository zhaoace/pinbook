package com.customer.webservice.webservice;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.customer.webservice.dto.ResponseDTO;


public interface IFeedWebservice {

	@GET
	@Path("/getFeeds")
	ResponseDTO getFeed(@QueryParam("platform") String platform,
			@DefaultValue("0") @QueryParam("startCursor") int startCursor,
			@DefaultValue("15") @QueryParam("size") int size);
	
	@GET
	@Path("/getFeeds")
	ResponseDTO getFeedByUserID(@QueryParam("platform") String platform,
			@QueryParam("userid") String userID,
			@DefaultValue("0") @QueryParam("startCursor") int startCursor,
			@DefaultValue("15") @QueryParam("size") int size);


	@GET
	@Path("/getCollectionDetail")
	ResponseDTO getCollectionDetailByCollectionID(@QueryParam("platform") String platform,
			@QueryParam("collectionID") String collectionID);

	@GET
	@Path("/getComments")
	ResponseDTO getComments(@QueryParam("platform") String platform,
			@QueryParam("collectionID") String collectionID,
			@DefaultValue("0") @QueryParam("startCursor") int startCursor,
			@DefaultValue("15") @QueryParam("size") int size);
	
	
	

}
