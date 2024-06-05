package com.peisia.dto;

import lombok.Data;

@Data //게터세터 같은거 자동으로 전부 만들어줌 (실제로는 어노테이션 적재적소에 사용하면 좋겠지만 잘모르니까 Data로 전부 만들어버리는것. 제대로 쓸수있게되면 필요한것만 써도됨)
public class GuestDto {
	private Long bno;
	private String btext;
}
