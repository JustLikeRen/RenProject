package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void getConnect() {
		String URL="jdbc:mysql://localhost:3306/my_cat";
		String user="root";
		String password="root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(URL,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<Dto> list() {
		String sql="select * from member_list";
		getConnect();
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			ps=con.prepareStatement(sql);
			rs =ps.executeQuery();
			while(rs.next()) {				
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
		Dto dto= new Dto(num,id,pw,name);
		posts.add(dto);
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return posts;
	}
}