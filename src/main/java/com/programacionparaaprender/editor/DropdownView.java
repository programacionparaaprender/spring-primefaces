package com.programacionparaaprender.editor;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

//tutorial
//https://www.youtube.com/watch?v=VkCKl6zgCDI

@ManagedBean
@SessionScoped
public class DropdownView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = -8470241778864558951L;
	private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String country;  
    private String city;
    private Map<String,String> countries;
    private Map<String,String> cities;
    
    
    private Map<String, String> books;
	private String book;
    
     
    @PostConstruct
    public void init() {
    	 Connection conexion=null; 
    	 books = new HashMap<String, String>();
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
  	                	//Integer id = rs.getInt(1);
  	                	//Books temp = new Books(id, name);
  	                	books.put(name, name);
  	                }
  	                conexion.close();
  	                
  	            }
  	        catch(Exception ex)
  	        {
  	        	
  	        }
    	
        countries  = new HashMap<String, String>();
        countries.put("USA", "USA");
        countries.put("Germany", "Germany");
        countries.put("Brazil", "Brazil");
         
        Map<String,String> map = new HashMap<String, String>();
        map.put("New York", "New York");
        map.put("San Francisco", "San Francisco");
        map.put("Denver", "Denver");
        data.put("USA", map);
         
        map = new HashMap<String, String>();
        map.put("Berlin", "Berlin");
        map.put("Munich", "Munich");
        map.put("Frankfurt", "Frankfurt");
        data.put("Germany", map);
         
        map = new HashMap<String, String>();
        map.put("Sao Paulo", "Sao Paulo");
        map.put("Rio de Janerio", "Rio de Janerio");
        map.put("Salvador", "Salvador");
        data.put("Brazil", map);
    }
    
    public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public void setBooks(Map<String, String> usuarios) {
		
	}
	public Map<String, String> getBooks() {
		return books;
	}
    public Map<String, Map<String, String>> getData() {
        return data;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public Map<String, String> getCountries() {
        return countries;
    }
 
    public Map<String, String> getCities() {
        return cities;
    }
 
    public void onCountryChange() {
        if(country !=null && !country.equals(""))
            cities = data.get(country);
        else
            cities = new HashMap<String, String>();
    }
     
    public void displayLocation() {
        FacesMessage msg;
        if(city != null && country != null)
            msg = new FacesMessage("Selected", city + " of " + country);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected."); 
             
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
}
