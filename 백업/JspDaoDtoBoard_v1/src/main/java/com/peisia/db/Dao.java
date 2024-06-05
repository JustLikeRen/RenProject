package com.peisia.db;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.peisia.db.Board;
import com.peisia.db.Dto;
public class Dao extends Da {
	
	/* (1/5)삭제 */
	public void del(String no) {
		String sql = String.format("update %s set delNo=1 where b_no=%s"
				,Db.TABLE_PS_BOARD_FREE, no);
		super.connect(sql);	
		
			super.update(sql);
			super.close();
			}
	/* (2/5)쓰기 */
	public void write(Dto d) {
		this.insert(d);
	}
	/* (3/5)글 읽기 */
	public Dto read(String no) {
		Dto post = null;
		
		String sql = String.format(
				"select * from %s where delNo=0 and b_no=%s"
				,Db.TABLE_PS_BOARD_FREE, no);
		super.connect(sql);
		// [고정-3]
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			select * from ps_board_free where b_no=4;
			try {
			ResultSet rs = ps.executeQuery(sql);
			rs.next();
			post = new Dto(
					rs.getString("B_NO"),
					rs.getString("B_TITLE"),
					rs.getString("B_ID"),
					rs.getString("B_DATETIME"),
					rs.getString("B_HIT"),
					rs.getString("B_TEXT"),
					rs.getString("B_REPLY_COUNT"),
					rs.getString("B_REPLY_ORI")
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();
		return post;
	}	
	
	public BoardListProcessor list(String currentPage, String word) {
		if(currentPage==null) {
			currentPage="1";
		}
		BoardListProcessor blp = new BoardListProcessor(this,currentPage,word);
		return blp;
	}
	
	/* (4/5)글 리스트 */
	public ArrayList<Dto> list(String page) {
		int startIndex = ((Integer.parseInt(page))-1)*3;
		int pageOfNum = (Integer.parseInt("3"));
		String sql = String.format(
				"select * from %s limit %s,%s"
				,Db.TABLE_PS_BOARD_FREE+" where delNo=0",startIndex,pageOfNum);
		super.connect(sql);
		ArrayList<Dto> posts = new ArrayList<>();
		try {
				// [고정-3]
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			select * from ps_board_free where b_no=4;
			ResultSet rs = ps.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()) {				
				posts.add(new Dto(
						rs.getString("B_NO"),
						rs.getString("B_TITLE"),
						rs.getString("B_ID"),
						rs.getString("B_DATETIME"),
						rs.getString("B_HIT"),
						rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"),
						rs.getString("B_REPLY_ORI")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();
		return posts;
	}
	/* (5/5)수정 */
	public void edit(Dto d,String no) {
		String sql = String.format(
				"update %s set b_title='%s',b_text='%s' where b_no=%s"
				,Db.TABLE_PS_BOARD_FREE, d.title,d.text,no);
			super.connect(sql);
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			update ps_board_free set b_title='bb',b_text='bbbb' where b_no=4;
			
			
			super.update(sql);
			super.close();// [고정-5]
		
	}	
	
	public void restore(String no) {
		String sql = String.format("update %s set delNo=0 where delNo=1 and b_no=%s"
				,Db.TABLE_PS_BOARD_FREE, no);
			super.connect(sql);
			//코딩하시오:
			super.update(sql);
			////고정 4
			super.close();
}
	public ArrayList<Dto> dellist() {
		String sql = String.format(
				"select * from %s"
				,Db.TABLE_PS_BOARD_FREE+" where delNo=1");
			super.connect(sql);
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			
			
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			select * from ps_board_free where b_no=4;
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {				
				posts.add(new Dto(
						rs.getString("B_NO"),
						rs.getString("B_TITLE"),
						rs.getString("B_ID"),
						rs.getString("B_DATETIME"),
						rs.getString("B_HIT"),
						rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"),
						rs.getString("B_REPLY_ORI")
						));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();
		return posts;
	}
	public Dto delread(String no) {
		Dto post = null;
		String sql = String.format(
				"select * from %s where delNo=1 and b_no=%s"
				,Db.TABLE_PS_BOARD_FREE, no);
		super.connect(sql);
		try {
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			select * from ps_board_free where b_no=4;
			ResultSet rs = ps.executeQuery(sql);
			rs.next();
			post = new Dto(
					rs.getString("B_NO"),
					rs.getString("B_TITLE"),
					rs.getString("B_ID"),
					rs.getString("B_DATETIME"),
					rs.getString("B_HIT"),
					rs.getString("B_TEXT"),
					rs.getString("B_REPLY_COUNT"),
					rs.getString("B_REPLY_ORI")
					);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();
		return post;
	}	
	
	public int getPostCount() {
		int count = 0;
		String sql = String.format("select count(*) from %s",Db.TABLE_PS_BOARD_FREE+" where delNo=0");
		super.connect(sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");
		}catch (Exception e) {
			e.printStackTrace();
		}
		super.close();
		return count;
	}
	public int getSearchPostCount(String word) {
		int count = 0;
		String sql = String.format("select count(*) from %s where delNo=0 and b_title like '%%%s%%'"
				,Db.TABLE_PS_BOARD_FREE,word);
		super.connect(sql);
		try {
			ResultSet rs = ps.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");
		}catch (Exception e) {
			e.printStackTrace();
		}
		super.close();
		return count;
	}
	public ArrayList<Dto> listSearch(String word,String page){
		int startIndex = ((Integer.parseInt(page))-1)*3;
		String sql = String.format("select * from %s where delNo=0 and b_title like '%%%s%%' limit %s,3"
				,Db.TABLE_PS_BOARD_FREE,word,startIndex);
		super.connect(sql);
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {				
				posts.add(new Dto(
						rs.getString("B_NO"),
						rs.getString("B_TITLE"),
						rs.getString("B_ID"),
						rs.getString("B_DATETIME"),
						rs.getString("B_HIT"),
						rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"),
						rs.getString("B_REPLY_ORI")
						));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		super.close();
		return posts;
	}
	public int getTotalPageCount() {
		int totalPageCount = 0;
		int count = getPostCount();
		
		if(count % 3 == 0) {
			totalPageCount = count / 3;
		} else {
			totalPageCount = count / 3 + 1;
		}
		return totalPageCount;
	}
	public int getSearchTotalPageCount(String word) {
		int totalPageCount = 0;
		int count = getSearchPostCount(word);
		
		if(count % 3 == 0) {
			totalPageCount = count / 3;
		} else {
			totalPageCount = count / 3 + 1;
		}
		return totalPageCount;
	}
	public void insert(Dto d) {
		String sql = String.format(
				"insert into %s (b_title,b_id,b_text,delNo) values ('%s','%s','%s','%d')"
				,Db.TABLE_PS_BOARD_FREE, d.title,d.id,d.text,0);
			super.connect(sql);// [고정-3]
			
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			insert into ps_board_free (b_title,b_id,b_text) values ('야옹','cat','aaa');
			super.update(sql);
			super.close();
	}
	public void update(Dto d,String no) {
		String sql = String.format(
				"update %s set b_title='%s',b_text='%s' where b_no=%s"
				,Db.TABLE_PS_BOARD_FREE, d.title,d.text,no);
		super.connect(sql);	//[고정1,2,3]
		super.update(sql);
		super.close();	//[고정4,5]
	}
	public ArrayList<Dto> selectList(int startIndex, String word) {
		ArrayList<Dto> posts = new ArrayList<>();
		String sql = String.format("select b_no,b_title,b_id,b_datetime,b_hit,b_text,b_reply_count,b_reply_ori from %s where delNo=0 and b_title like '%%%s%%' limit %s,%s"
				,Db.TABLE_PS_BOARD_FREE
				,word
				,startIndex
				,Board.LIST_AMOUNT);
		super.connect(sql);
		try {
			System.out.println("sql:"+sql);
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {
				posts.add(new Dto(
						rs.getString("B_NO"),
						rs.getString("B_TITLE"),
						rs.getString("B_ID"),
						rs.getString("B_DATETIME"),
						rs.getString("B_HIT"),
						rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"),
						rs.getString("B_REPLY_ORI")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();
		return posts;
	}
	public ArrayList<Dto> selectList(int startIndex) {
		ArrayList<Dto> posts = new ArrayList<>();
		String sql = String.format("select * from %s where delNo=0 limit %s,%s"
				,Db.TABLE_PS_BOARD_FREE
				,startIndex
				,Board.LIST_AMOUNT);
		super.connect(sql);
		try {
			System.out.println("sql:"+sql);
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {
				posts.add(new Dto(
						rs.getString("B_NO"),
						rs.getString("B_TITLE"),
						rs.getString("B_ID"),
						rs.getString("B_DATETIME"),
						rs.getString("B_HIT"),
						rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"),
						rs.getString("B_REPLY_ORI")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();
		return posts;
	}
	
	public int selectPostCount() {
		int count = 0;
		String sql = String.format(
				"select count(*) from %s where delNo=0"
				,Db.TABLE_PS_BOARD_FREE);
		System.out.println("sql:"+sql);//todo
		super.connect(sql);	//[고정1,2,3]
		try {
			ResultSet rs = ps.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return count;
	}
	
	public int selectSearchPostCount(String word) {
		int count = 0;
		String sql = String.format(
				"select count(*) from %s where delNo=0 and b_title like '%%%s%%'"
				,Db.TABLE_PS_BOARD_FREE,word);
		System.out.println("sql:"+sql);//todo
		super.connect(sql);	//[고정1,2,3]
		try {
			ResultSet rs = ps.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return count;
	}	
}