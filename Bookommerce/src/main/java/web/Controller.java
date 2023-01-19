package web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	
	public void create(HttpServletRequest request, HttpServletResponse response);
	
	public void findOne(HttpServletRequest request, HttpServletResponse response);
	
	public void findAll(HttpServletRequest request, HttpServletResponse response);
	
	public void update(HttpServletRequest request, HttpServletResponse response);
	
	public void delete(HttpServletRequest request, HttpServletResponse response);

}
