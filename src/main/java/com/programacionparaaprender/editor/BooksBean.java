package com.programacionparaaprender.editor;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
//import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;

@ManagedBean
@ViewScoped
@SessionScoped
public class BooksBean   implements Serializable {
    
   /**
	 * 
	 */
	private static final long serialVersionUID = -8470241778864558955L;
	private List<Books> books;
	private Books book;
	private int tipoAccion = 1;
	@PostConstruct
    public void init() {
    	 Connection conexion=null; 
    	 books = new java.util.LinkedList<Books>();
    	 reinstanciar();
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
    }
	public void procesar() {
		insertar();
		init();
	}
	
	public void insertar() {
		Connection conexion=null; 
		ResultSet resultSet = null;
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
 	        String sql = "INSERT INTO dbo.Books (Name) VALUES "
 	                + "('"+book.getName()+"');";
 	        try (PreparedStatement cmd = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
 	        		cmd.execute();
 	        		// Retrieve the generated key from the insert.
 	        		resultSet = cmd.getGeneratedKeys();

	 	            // Print the ID of the inserted row.
	 	            while (resultSet.next()) {
	 	                System.out.println("Generated: " + resultSet.getString(1));
	 	            }
 	                conexion.close();
 	                
 	            }
 	        catch(Exception ex)
 	        {
 	        	System.out.println(ex.getMessage());
 	        }
	}
	
	public void setBooks(List<Books> books) {
		
	}
	public List<Books> getBooks() {
		return books;
	}
	public void reinstanciar() {
		book = new Books("Libro nuevo");
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public int getTipoAccion() {
		return tipoAccion;
	}

	public void setTipoAccion(int tipoAccion) {
		this.tipoAccion = tipoAccion;
	}
	
}
