package com.peisia.db;

import java.util.ArrayList;

public class BoardListProcessor {
	private Dao dao;
//	public String category;
	public ArrayList<Dto> posts;
	public int totalPage = 0;
	public int currentPage = 0;
	public String word;
	
	int totalBlock = 0;
	int currentBlockNo = 0;
	int blockStartNo = 0;
	int blockEndNo = 0;
	
	int prevPage = 0;
	int nextPage = 0;
	
	boolean hasPrev = true;
	boolean hasNext = true;
	
	public BoardListProcessor(Dao dao,
//			String category ,
			String currentPage, String word) {
		this.dao = dao;
		this.currentPage = Integer.parseInt(currentPage);
		this.word = word;
		if(word==null) {
			this.totalPage = getPageCount();
			getList();
		} else {
			this.totalPage = getPageCount(word);
			getList(word);
		}
		
		totalBlock = (int)Math.ceil((double) totalPage / Board.PAGE_LINK_AMOUNT);
		
		currentBlockNo = (int)Math.ceil((double)this.currentPage / Board.PAGE_LINK_AMOUNT);
		
		blockStartNo = (currentBlockNo - 1) * Board.PAGE_LINK_AMOUNT + 1;
		
		blockEndNo = currentBlockNo * Board.PAGE_LINK_AMOUNT;
		if(blockEndNo > totalPage) {
			blockEndNo = totalPage;
		}
		if(currentBlockNo == 1) {
			hasPrev = false;
		} else {
			hasPrev = true;
			
			prevPage = (currentBlockNo - 1) * Board.PAGE_LINK_AMOUNT;
		}
		if(currentBlockNo < totalBlock) {
			hasNext = true;
			
			nextPage = currentBlockNo * Board.PAGE_LINK_AMOUNT + 1;
		} else {
			hasNext = false;
		}
		
	}
	
	public void getList() {
		int startIndex = (currentPage-1)*Board.LIST_AMOUNT;
		posts = dao.selectList(
//				category,
				startIndex);
	}
	public void getList(String word) {
		int startIndex = (currentPage-1)*Board.LIST_AMOUNT;
		posts = dao.selectList(
//				category,
				startIndex,word);
	}
	public int getPageCount() {
		int totalPageCount = 0;
		int count = dao.selectPostCount();
		if(count % Board.LIST_AMOUNT == 0){		//case1. 나머지가 없이 딱 떨어지는 경우
			totalPageCount = count / Board.LIST_AMOUNT;
		}else{					//case2. 나머지가 있어서 짜투리 페이지가 필요한 경우
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
	}	
	/* <검색> 총 페이지 수 구하기 */
	public int getPageCount(String word) {
		int totalPageCount = 0;
		int count = dao.selectSearchPostCount(word);
		if(count % Board.LIST_AMOUNT == 0){		//case1. 나머지가 없이 딱 떨어지는 경우
			totalPageCount = count / Board.LIST_AMOUNT;
		}else{					//case2. 나머지가 있어서 짜투리 페이지가 필요한 경우
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
	}
	public ArrayList<Dto> getPosts() {
		return posts;
	}
	public String getHtmlPageList() {
		String html="";

		//🐿️🐿️🐿️{블럭 처리 - 7/9}.(이전/다음)의 (이전) 처리🐿️🐿️🐿️
		//🐿️🐿️🐿️: 이전 블럭 이동이 가능하면 미리 계산한 이전 블록 이동 시 이동 할 페이지번호를 랑크에 전달하기🐿️🐿️🐿️//
		if(hasPrev){
			if(word==null) {
				html=html+String.format("<a href='/peisia/list?page=%d'>🐿️이전블럭가기🐿️</a> ",prevPage);
			}else {
				html=html+String.format("<a href='/peisia/list?page=%d&word=%s'>🐿️이전블럭가기🐿️</a> ",prevPage,word);
			}
		}		
		
		//🐿️🐿️🐿️{블럭 처리 - 8/9}.기존의 제한 없던 페이지리스트 나열을 ex.[1][2][3].....[n] 블럭 적용하기🐿️🐿️🐿️
		//🐿️🐿️🐿️현재 블럭의 페이지 시작번호와 끝번호를 이용하여 반복문의 시작값 끝값으로 하고 이 값을 페이지 번호로 출력하기🐿️🐿️🐿️		
		for(int i=blockStartNo;i<=blockEndNo;i++){	// 	<< 이렇게 바꿈
			if(word==null) {
				html = html + String.format("<a href='/peisia/list?page=%d'>%d</a>&nbsp;&nbsp;",i,i);
			}else {
				html = html + String.format("<a href='/peisia/list?page=%d&word=%s'>%d</a>&nbsp;&nbsp;",i,word,i);
			}
		}
		
		//🐿️🐿️🐿️{블럭 처리 - 9/9}.(이전/다음)의 (다음) 처리🐿️🐿️🐿️
		//🐿️🐿️🐿️: 다음 블럭 이동이 가능하면 미리 계산한 이전 블록 이동 시 이동 할 페이지번호를 랑크에 전달하기🐿️🐿️🐿️//
		if(hasNext){
			if(word==null) {
				html=html+String.format("<a href='/peisia/list?page=%d'>🐿️다음블럭가기🐿️</a>",nextPage);
			}else {
				html=html+String.format("<a href='/peisia/list?page=%d&word=%s'>🐿️다음블럭가기🐿️</a>",nextPage,word);
			}			
			
		}		
		return html;
	}
	
}
