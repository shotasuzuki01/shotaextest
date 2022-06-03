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

import model.Mutter;

public class MutterDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	private void connect() throws NamingException, SQLException {
		Context context= new InitialContext();
		DataSource ds=(DataSource) context.lookup("java:comp/env/jdbc/jsp");
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
			if(db !=null ) {
				db.close();
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public List<Mutter> findAll(){
		List<Mutter>list=new ArrayList<>();
				try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM docotubuDB");
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String text=rs.getString("text");
				Mutter mutter= new Mutter(id,name,text);
				list.add(mutter);
			}

		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally{
			this.disconnect();
		}
				return list;
	}
	public void insertOne(Mutter mutter) {
		try {
			this.connect();
			ps=db.prepareStatement("INSERT INTO docotubuDB(name,text) VALUES(?,?)");
			ps.setString(1,mutter.getName());
			ps.setString(2,mutter.getText());
			ps.executeUpdate();

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	public Mutter findOne(int id) {
		Mutter mutter=null;
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM docotubuDB WHERE id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				String name=rs.getString("name");
				String text=rs.getString("text");
				mutter=new Mutter(id,name,text);
			}
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return mutter;
	}
}
