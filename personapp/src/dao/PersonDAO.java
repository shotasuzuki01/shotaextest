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

import model.Person;

public class PersonDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	private void connect() throws NamingException, SQLException {
	Context context =new InitialContext();
	DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/jsp");
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
		e.printStackTrace();
	}
}
public List<Person> findAll(){
	List<Person> list=new ArrayList<>();
	try {
		this.connect();
		ps=db.prepareStatement("SELECT * FROM persons");
		rs=ps.executeQuery();
		while(rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			int age=rs.getInt("age");
			Person person=new Person(id,name,age);
			list.add(person);
		}
	} catch (NamingException | SQLException e) {
		e.printStackTrace();
	}finally {
		this.disconnect();
	}
	return list;
}
public Person findOne(int id) {
	Person person=null;
	try {
		this.connect();
	ps=db.prepareStatement("SELECT * FROM persons WHERE id=?");
	ps.setInt(1, id);
	rs=ps.executeQuery();
	if(rs.next()) {
		String name=rs.getString("name");
		int age=rs.getInt("age");
		person=new Person(id,name,age);
	}
	} catch (NamingException | SQLException e) {
		e.printStackTrace();
	}finally {
		this.disconnect();
	}
	return person;
}
}
