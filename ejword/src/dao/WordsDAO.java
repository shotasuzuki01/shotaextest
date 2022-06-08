package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Words;

public class WordsDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	public void connect() throws NamingException, SQLException {
		Context context=new InitialContext();
		DataSource ds=(DataSource)context.lookup("java:comp/env/ejword");
		this.db=ds.getConnection();
	}
	private void disconnect() {
		try {
			if(rs !=null) {
				rs.close();
			}
			if(ps !=null) {
				ps.close();
			}
			if(db !=null) {
				db.close();
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public List<Words> getListBySearchWord(String searchWord,String mode){
		List<Words> list=new ArrayList<>();
		switch(mode) {
		case "startsWith":
			searchWord=searchWord+"%";
			break;
		case "contains":
			searchWord="%"+searchWord+"%";
			break;
		case "endWith":
			searchWord="%"+searchWord;
		}
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM words WHERE title LIKE ?");
			ps.setString(1, searchWord);
			rs=ps.executeQuery();
			while(rs.next()) {
				String title=rs.getString("title");
				String body=rs.getString("body");
				Words words=new Words(title,body);
				list.add(words);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return list;
	}
	public List<Words> getListBySearchWord(String searchWord,String mode,int limit){
		List<Words> list=new ArrayList<>();
		switch(mode) {
		case "startsWith":
			searchWord=searchWord+"%";
			break;
		case "contains":
			searchWord="%"+searchWord+"%";
			break;
		case "endWith":
			searchWord="%"+searchWord;
		}
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM words WHERE title LIKE ? LIMIT ?");
			ps.setString(1, searchWord);
			ps.setInt(2, limit);
			rs=ps.executeQuery();
			while(rs.next()) {
				String title=rs.getString("title");
				String body=rs.getString("body");
				Words words=new Words(title,body);
				list.add(words);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return list;
	}
	public int getCount(String searchWord,String mode) {
		int total=0;
		switch(mode) {
		case "startsWith":
			searchWord=searchWord+"%";
			break;
		case "contains":
			searchWord="%"+searchWord+"%";
			break;
		case "endWith":
			searchWord="%"+searchWord;
		}
		try {
			this.connect();
			ps=db.prepareStatement("SELECT count(*)AS total FROM words WHERE title LIKE ?");
			ps.setString(1, searchWord);
			rs=ps.executeQuery();
			if(rs.next()) {
				total=rs.getInt("total");
			}
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}

		return total;
	}
	public List<Words> getListBySearchWord(String searchWord,String mode,int limit ,int offset){
		List<Words> list=new ArrayList<>();
		switch(mode) {
		case "startsWith":
			searchWord=searchWord+"%";
			break;
		case "contains":
			searchWord="%"+searchWord+"%";
			break;
		case "endWith":
			searchWord="%"+searchWord;
		}
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM words WHERE title LIKE ? LIMIT ? OFFSET ?");
			ps.setString(1, searchWord);
			ps.setInt(2, limit);
			ps.setInt(3, offset);
			rs=ps.executeQuery();
			while(rs.next()) {
				String title=rs.getString("title");
				String body=rs.getString("body");
				Words words=new Words(title,body);
				list.add(words);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return list;
	}
}