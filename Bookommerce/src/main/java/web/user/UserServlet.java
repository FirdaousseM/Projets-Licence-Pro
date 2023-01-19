package web.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import web.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * Servlet implementation class BookServlet
 */

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10,      // 10 MB
		maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)

@WebServlet(name = "UserServlet", urlPatterns = {"/user/*"})

public class UserServlet extends HttpServlet implements Controller{
	private static final long serialVersionUID = 1L;

	private User userModel;
	private UserManager userManager;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		this.userManager = new UserManager();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.redirection(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}


	private void redirection(HttpServletRequest request, HttpServletResponse response){

		String subUrl = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1);

		switch (subUrl) {
		case "register": 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/user_register.jsp");
			try {
				rd.include(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			};
		break;
		case "create": this.create(request, response);	
		break;
		case "edit": this.editForm(request, response);
		break;
		case "update": this.update(request, response);
		break;
		case "dashboard": this.findOne(request, response);
		break;
		case "seeAll": this.findAll(request, response);
		break;
		case "delete": this.delete(request, response);
		break;
		}
	}

	/* CRUD */

	@Override
	public void create(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, String> userValues = new HashMap<String, String>();

		userValues.put("user-username", request.getParameter("user-username"));
		userValues.put("user-email", request.getParameter("user-email"));
		userValues.put("user-password", request.getParameter("user-password"));
		userValues.put("user-firstname", request.getParameter("user-firstname"));
		userValues.put("user-lastname", request.getParameter("user-lastname"));
		userValues.put("user-phone", request.getParameter("user-phone"));
		userValues.put("user-address", request.getParameter("user-address"));


		this.userModel = new User(userValues);

		try {
			this.userManager.create(this.userModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			response.sendRedirect(request.getContextPath() + "/user/seeAll");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void findOne(HttpServletRequest request, HttpServletResponse response) {

		String idString = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')-1, request.getRequestURI().lastIndexOf('/'));

		long id = Long.valueOf(idString);
		System.out.println(id);
		try {
			userModel = userManager.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/user_dashboard.jsp");
		request.setAttribute("user", userModel);

		try {
			rd.include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		};

	}

	@Override
	public void findAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<User> usersList = new ArrayList<User>();

		try {
			usersList = this.userManager.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/user_see_all.jsp");
		request.setAttribute("booksList", usersList);

		try {
			rd.include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		};

	}

	public void editForm(HttpServletRequest request, HttpServletResponse response) {
		
		String idString = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')-1, request.getRequestURI().lastIndexOf('/'));

		long id = Long.valueOf(idString);

		try {
			userModel = userManager.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/user_edit.jsp");
		request.setAttribute("user", userModel);

		try {
			rd.include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		};
	}
	
	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, String> bookValues = new HashMap<String, String>();
		String idString = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')-1, request.getRequestURI().lastIndexOf('/'));

		bookValues.put("user-id", idString);
		bookValues.put("user-username", request.getParameter("user-username"));
		bookValues.put("user-email", request.getParameter("user-email"));
		bookValues.put("user-password", request.getParameter("user-password"));
		bookValues.put("user-firstname", request.getParameter("user-firstname"));
		bookValues.put("user-lastname", request.getParameter("user-lastname"));
		bookValues.put("user-phone", request.getParameter("user-phone"));
		bookValues.put("user-address", request.getParameter("user-address"));


		this.userModel = new User(bookValues);

		try {
			this.userManager.update(this.userModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			response.sendRedirect(request.getContextPath() + "/user/" + this.userModel.getId() + "/see");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		
		String idString = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')-1, request.getRequestURI().lastIndexOf('/'));

		long id = Long.valueOf(idString);
		
		try {
			this.userManager.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			response.sendRedirect(request.getContextPath() + "/user/seeAll");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
