package com.peisia.dto;

import lombok.Data;

@Data //게터세터 같은거 자동으로 전부 만들어줌 (실제로는 어노테이션 적재적소에 사용하면 좋겠지만 잘모르니까 Data로 전부 만들어버리는것. 제대로 쓸수있게되면 필요한것만 써도됨)
public class TestDto {
	
		private Long bno;
		private String btext;
	
		private String id;
		private String pw;
		
		private int count;
		private String word;
		private int limitIndex;
		
		private int totalPage;
		private int totalBlock;
		private int currentBlockNo;
		private int blockStartNo;
		private int blockEndNo;
		
		private int prevPage;
		private int nextPage;
		
		private boolean hasPrev;
		private boolean hasNext;
		
//		private String nickName;
 }


