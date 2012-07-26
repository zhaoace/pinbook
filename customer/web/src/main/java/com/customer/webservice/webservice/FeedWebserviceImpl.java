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
		bookDetailDTO.setBookname("�׾��� Moby Dick");
		bookDetailDTO.setBookPages(442);
		bookDetailDTO.setDemoReadPagess(new ArrayList<String>());
		bookDetailDTO
				.setDescription("ȫ����442퓣����ֳ�84�£����ƪ���^�����L����һ���J�鲻�m���������x����x����Ӣ���α��˸壬1851����棬�x�߷���ʮ���䵭����һ��ֻ�u��5��������÷���S���tһ��ĬĬ�o��һֱ�������Lӛ����������ʮ�꣨1920�꣩�ᣬ÷���S���������ČW�ĵ�λ�ū@�������u�r�����˼{�f�^�������꡶���Lӛ������һ���뷨��ϣ���@�������Ҍ��ġ��������գ������Lӛ���ѱ�ҕ�������ČWʷ������С�f֮һ��");
		bookDetailDTO.setId("id9527");
		bookDetailDTO.setPicURL("http://img3.douban.com/lpic/s3830735.jpg");
		bookDetailDTO.setType("book");
		bookDetailDTO.setAuthor("÷���S��");
		bookDetailDTO.setWhoRead("zhaoli");
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
		commentDTO.setContent("�Ȿ������̫NB�ˣ��ҿ��˺ö�飡");
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
