package com.programacionparaaprender.editor;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.faces.event.NamedEvent;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;

//import javax.annotation.PostConstruct;


@ManagedBean(name = "editor")
public class EditorBean  implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -7610182854303586389L;
	private String value = "This editor is provided by PrimeFaces";
	private java.util.LinkedList<Books> books=new java.util.LinkedList<Books>();
	private Books book = new Books();
	
	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setBooks(java.util.LinkedList<Books> usuarios) {
		
	}
	public String getValue() {
		return value;
	}

	
	public LinkedList<Books> getBooks() {
	        
	        Connection conexion=null; 
	     try {
	          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	          String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
	            "databaseName=QuirkyBookProject;user=sa;password=123;";
	          conexion = DriverManager.getConnection(connectionUrl);
	        } catch (SQLException e) {
	            System.out.println("SQL Exception: "+ e.toString());
	        } catch (ClassNotFoundException cE) {
	            System.out.println("Class Not Found Exception: "+ cE.toString());
	        }
	        String sql = "SELECT TOP (1000) [Id]\n" + 
	        		"      ,[Name]\n" + 
	        		"  FROM [dbo].[Books]";
	        try (PreparedStatement cmd = conexion.prepareStatement(sql)) {
	                ResultSet rs = cmd.executeQuery();
	                
	                while(rs.next())
	                {
	                	String name = rs.getString(2);
	                	Integer id = rs.getInt(1);
	                	Books temp = new Books(id, name);
	                	books.add(temp);
	                }
	                conexion.close();
	                
	            }
	        catch(Exception ex)
	        {
	        	
	        }
	        return books;
	}
	public void onCountryChange() {
        
    }
}