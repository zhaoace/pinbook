package com.customer.webservice.webservice;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.apache.abdera.model.Feed;

import com.customer.webservice.dto.ResponseDTO;

@Path("/")
public interface IFeedWebservice {

	@GET
	@Path("/feeds/getFeeds")
	ResponseDTO getFeed(@QueryParam("platform") String platform,
			@DefaultValue("0") @QueryParam("startCursor") int startCursor,
			@DefaultValue("15") @QueryParam("size") int size);
	
	@GET
	@Path("/feeds/getFeeds")
	ResponseDTO getFeedByUserID(@QueryParam("platform") String platform,
			@QueryParam("userid") String userID,
			@DefaultValue("0") @QueryParam("startCursor") int startCursor,
			@DefaultValue("15") @QueryParam("size") int size);


	@GET
	@Path("/feeds/getCollectionDetail")
	ResponseDTO getCollectionDetailByCollectionID(@QueryParam("platform") String platform,
			@QueryParam("collectionID") String collectionID);

	@GET
	@Path("/feeds/getComments")
	ResponseDTO getComments(@QueryParam("platform") String platform,
			@QueryParam("collectionID") String collectionID,
			@DefaultValue("0") @QueryParam("startCursor") int startCursor,
			@DefaultValue("15") @QueryParam("size") int size);
	
	
	

}
