package com.customer.webservice.webservice;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.customer.webservice.dto.BookDetailDTO;
import com.customer.webservice.dto.BookSummaryDTO;
import com.customer.webservice.dto.CommentDTO;
import com.customer.webservice.dto.FeedDTO;
import com.customer.webservice.dto.ResponseDTO;

public class FeedWebserviceImpl implements IFeedWebservice {

	public FeedWebserviceImpl() {
	}


	public ResponseDTO getFeedByUserID(String platform, String userID,
			int startCursor, int size) {
		
		if(null==userID){
			return getFeed(platform, startCursor, size);
		}
		
		System.out.println("ResponseDTO  getFeedsByUserID,platform=" + platform
				+ ", startCursor=" + startCursor + ", size=" + size);
		
		String result = this.BusinessObjectToResponseResultJSON(this
				.mockFeedDTO(platform, startCursor, size));
		ResponseDTO response = this.moceResponseDTO(result);

		return response;
	}

	public ResponseDTO getFeed(String platform, int startCursor, int size) {
		System.out.println("ResponseDTO  getFeeds,platform=" + platform
				+ ", startCursor=" + startCursor + ", size=" + size);

		String result = this.BusinessObjectToResponseResultJSON(this.mockFeedDTO(platform, startCursor, size));
		ResponseDTO response = this.moceResponseDTO(result);
		
		return response;
	}

	public ResponseDTO getCollectionDetailByCollectionID(String platform,
			String collectionID) {
		System.out.println("ResponseDTO getMyFeedsByUserID ,platform="
				+ platform + ", collectionID=" + collectionID);

		String result = this.BusinessObjectToResponseResultJSON(this.mockBookDetailDTO());
		ResponseDTO response = this.moceResponseDTO(result);
		
		return response;
	}

	public ResponseDTO getComments(String platform, String collectionID,
			int startCursor, int size) {
		System.out.println("ResponseDTO getComments ,platform=" + platform
				+ ", collectionID=" + collectionID);

		String result = this.BusinessObjectToResponseResultJSON(this.mockCommentDTOList(size));
		ResponseDTO response = this.moceResponseDTO(result);

		return response;

	}
	
	

	/***
	 * Mock!
	 * 
	 * @param resultJSON
	 * @return responseDTO
	 */
	private ResponseDTO moceResponseDTO(String resultJSON) {
		ResponseDTO response = new ResponseDTO();
		response.setResultCode(Status.OK);
		response.setResultMsg("Success!");
		response.setResult(resultJSON);
		return response;
	}

	private FeedDTO mockFeedDTO(String platform, int startCursor, int size) {
		FeedDTO feedDTO = new FeedDTO();
		feedDTO.setCollections(this.mockBookSummaryDTOList(size));
		feedDTO.setNextcursor(startCursor + size);
		feedDTO.setPlatform(platform);
		feedDTO.setTotalsize(startCursor + size + new Random().nextInt(size)*2);
		return feedDTO;
	}

	private List<BookSummaryDTO> mockBookSummaryDTOList(int size) {
		List<BookSummaryDTO> books = new ArrayList<BookSummaryDTO>();
		for (int i = 0; i < size; i++) {
			books.add(this.mockBookDetailDTO());
		}
		return books;
	}

	private BookDetailDTO mockBookDetailDTO() {
		BookDetailDTO bookDetailDTO = new BookDetailDTO();
		bookDetailDTO.setBookname("白鲸记");
		bookDetailDTO.setBookPages(442);
		bookDetailDTO.setDemoReadPagess(new ArrayList<String>());
		bookDetailDTO
				.setDescription("全書有442頁，共分成84章，因為篇幅過度冗長，曾一度認為不適合青少年讀者閱讀，在英國多次被退稿，1851年出版，讀者反應十分冷淡，第一年只賣出5本，作者梅爾維爾則一生默默無聞；一直到《白鯨記》出版了七十年（1920年）後，梅爾維爾在美國文學的地位才獲得重新評價，福克納說過：「看完《白鯨記》，第一個想法是希望這本書是我寫的。」至今日，《白鯨記》已被視為美國文學史上最偉大的小說之一。");
		bookDetailDTO.setId("id9527");
		bookDetailDTO.setPicURL("http://img3.douban.com/lpic/s3830735.jpg");
		bookDetailDTO.setType("book");
		bookDetailDTO.setAuthor("梅爾維爾");
		bookDetailDTO.setWhoRead("zhaoli");
		bookDetailDTO.setTags(new ArrayList<String>());
		bookDetailDTO.getTags().add("music");
		bookDetailDTO.getTags().add("novel");
		bookDetailDTO.getTags().add("love");
		bookDetailDTO.getTags().add("animal");
		bookDetailDTO.getTags().add("war");
		bookDetailDTO.getTags().add("craft");
		return bookDetailDTO;
	}

	private List<CommentDTO> mockCommentDTOList(int size) {
		List<CommentDTO> comments = new ArrayList<CommentDTO>();
		for (int i = 0; i < size; i++) {
			comments.add(this.mockComment());
		}
		return comments;
	}

	private CommentDTO mockComment() {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setAuthor("zhaoli");
		commentDTO.setColletioinID("colletioinID=5967");
		commentDTO.setCommentID("commentID=1598");
		commentDTO.setContent("这本书真是太NB了，我看了好多遍！");
		commentDTO.setCreateTime(new Date());
		return commentDTO;
	}
	

	

	private String BusinessObjectToResponseResultJSON(List<CommentDTO> businessObject) {
		StringWriter sw = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();		
		
		try {
			mapper.writeValue(sw, businessObject);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sw.toString();
	}

	

	private String BusinessObjectToResponseResultJSON(BookDetailDTO businessObject) {
		StringWriter sw = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();		
		
		try {
			mapper.writeValue(sw, businessObject);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sw.toString();
	}

	

	private String BusinessObjectToResponseResultJSON(FeedDTO businessObject) {
		StringWriter sw = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();		
		
		try {
			mapper.writeValue(sw, businessObject);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sw.toString();
	}


}
