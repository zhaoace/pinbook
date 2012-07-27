package com.customer.webservice.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ws.rs.core.Response.Status;

import com.customer.webservice.dto.BookDetailDTO;
import com.customer.webservice.dto.BookSummaryDTO;
import com.customer.webservice.dto.CommentDTO;
import com.customer.webservice.dto.FeedDTO;
import com.customer.webservice.dto.ResponseDTO;

public class MockData {

	public List<String> names;
	public List<String> comments;
	public List<BookSummaryDTO> books;
	
	public BookSummaryDTO getABook(){		
		return this.books.get(new Random().nextInt(this.books.size()));		
	}
	
	public String getAComment(){
		return this.comments.get(new Random().nextInt(this.comments.size()));
	}
	
	public String getAName(){
		return this.names.get(new Random().nextInt(this.names.size()));
	}

	public MockData() {
		this.names = new ArrayList<String>();
		this.comments = new ArrayList<String>();
		this.books = new ArrayList<BookSummaryDTO>();
		initNames();
		initComments();
		initBooks();
	}

	private void initComments() {
		this.comments.add("Thanks you! Regards, daoyu ");
		this.comments.add("A useful tool");
		this.comments.add("If you have any problem, please let me know.!");
		this.comments.add("Thanks");
		this.comments.add("Fantasy forum");
		this.comments
				.add("Want good books where heroes actually want/enjoy having special powers.");
		this.comments.add("Let's discuss magic");
		this.comments.add("New Books from new people");
		this.comments.add("Good epic fantasy recommendations");
		this.comments.add("Gender-neutral fantasy worlds");
	}

	private void initNames() {
		this.names.add("Yang, Jimmy");
		this.names.add("Wen, John");
		this.names.add("Chen, Fan");
		this.names.add("Hao, Yonny");
		this.names.add("Feng, Alex");
		this.names.add("Feng, Alex");
		this.names.add("Hu, Johann");
		this.names.add("Uzan, Gabriel");
		this.names.add("Wei, Daoyu");
		this.names.add("Dong, Donna");
		this.names.add("Li, Reach");
	}
	
	

	private void initBooks() {
		List<BookSummaryDTO> books = new ArrayList<BookSummaryDTO>();
		
		List<String> tagsList = new ArrayList<String>();
		tagsList.add("War");
		tagsList.add("Love");
		tagsList.add("Tech");
		tagsList.add("NewWorld");

		// book: name , author, url, Description,
		String bookMatrix[][] = {
				{
						"Neverwinter: Neverwinter Nights Trilogy, Book II",
						"R.A. Salvatore",
						"http://ecx.images-amazon.com/images/I/51ziFEgixaL._BO2,204,203,200_PIsitb-sticker-arrow-click,TopRight,35,-76_AA300_SH20_OU01_.jpg",
						"With the last of his trusted companions having fallen, Drizzt is alone--and free--for the first time in almost a hundred years. Guilt mingles with relief, leaving Drizzt uniquely vulnerable to the persuasions of his newest companion--Dahlia, a darkly alluring elf and the only other member of their party to survive the cataclysm at Mount Hotenow. But traveling with Dahlia is challenging in more ways than one. As the two companions seek revenge on the one responsible for leveling Neverwinter--and nearly Luskan as well--Drizzt finds his usual moral certainty swept away by her unconventional views. Forced to see the dark deeds that the common man may be driven to by circumstance, Drizzt begins to find himself on the wrong side of the law in an effort to protect those the law has failed. Making new enemies, as his old enemies acquire deadly allies, Drizzt and Dahlia quickly find themselves embroiled in battle--a state he's coming to enjoy a little too much." },
				{
						"Where We Belong",
						"EMILY GIFFIN",
						"http://ecx.images-amazon.com/images/I/31%2BQnzKF7xL._BO2,204,203,200_PIsitb-sticker-arrow-click,TopRight,35,-76_AA300_SH20_OU01_.jpg",
						"Marian Caldwell is a thirty-six year old television producer, living her dream in New York City. With a fulfilling career and satisfying relationship, she has convinced everyone, including herself, that her life is just as she wants it to be. But one night, Marian answers a knock on the door . . . only to find Kirby Rose, an eighteen-year-old girl with a key to a past that Marian thought she had sealed off forever. From the moment Kirby appears on her doorstep, Marian’s perfectly constructed world—and her very identity—will be shaken to its core, resurrecting ghosts and memories of a passionate young love affair that threaten everything that has come to define her." },
				{
						"To Heaven and Back: A Doctor's Extraordinary Account of Her Death, Heaven, Angels, and Life Again: A True Story",
						"Mary C. Neal, M.D",
						"http://ecx.images-amazon.com/images/I/51JLD4twU5L._BO2,204,203,200_PIsitb-sticker-arrow-click,TopRight,35,-76_AA300_SH20_OU01_.jpg",
						"A kayak accident during a South American adventure takes one woman to heaven — where she experienced God’s peace, joy, and angels — and back to life again. " },
				{
						"Bared to You: A Crossfire Novel",
						"Biography",
						"http://www.amazon.com/gp/reader/0425263908/ref=sib_dp_pt#reader-link",
						"Gideon Cross came into my life like lightning in the darkness... " }, };

		for (int i = 0; i < 4; i++) {
			BookSummaryDTO book = new BookSummaryDTO();
			List<String> tags = new ArrayList<String>();
			for (String tag : tagsList) {
				if (new Random().nextInt(5) > 2) {
					tags.add(tag);
				}
			}
			book.setTags(tags);

			book.setBookname(bookMatrix[i][0]);
			book.setAuthor(bookMatrix[i][1]);
			book.setPicURL(bookMatrix[i][2]);
			book.setDescription(bookMatrix[i][3]);
			book.setType("book");
			book.setBookPages(new Random().nextInt(999));
			book.setWhoRead(this.names.get(new Random().nextInt(11)));
			books.add(book);
		}
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
		bookDetailDTO.setBookname("Moby Dick");
		bookDetailDTO.setBookPages(442);
		bookDetailDTO.setDemoReadPagess(new ArrayList<String>());
		bookDetailDTO
				.setDescription("ȫ����442퓣����ֳ�84�£����ƪ���^�����L����һ���J�鲻�m���������x����x����Ӣ���α��˸壬1851����棬�x�߷���ʮ���䵭����һ��ֻ�u��5��������÷���S���tһ��ĬĬ�o��һֱ�������Lӛ����������ʮ�꣨1920�꣩�ᣬ÷���S���������ČW�ĵ�λ�ū@�������u�r�����˼{�f�^�������꡶���Lӛ������һ���뷨��ϣ���@�������Ҍ��ġ��������գ������Lӛ���ѱ�ҕ�������ČWʷ������С�f֮һ��");
		bookDetailDTO.setId("id9527");
		bookDetailDTO.setPicURL("http://img3.douban.com/lpic/s3830735.jpg");
		bookDetailDTO.setType("book");
		bookDetailDTO.setAuthor("÷���S��");
		bookDetailDTO.setWhoRead("zhaoli");
		bookDetailDTO.setTags(new ArrayList());
		bookDetailDTO.getTags().add("music");
		bookDetailDTO.getTags().add("novel");
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
	

}
