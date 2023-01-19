package web.book;

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

@WebServlet(name = "BookServlet", urlPatterns = {"/books/*"})

public class BookServlet extends HttpServlet implements Controller{
	private static final long serialVersionUID = 1L;

	private Book bookModel;
	private BookManager bookManager;
	ArrayList<Book> panier = new ArrayList<Book>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
		this.bookManager = new BookManager();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("panier", panier);

		this.redirection(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getPart("book-cover") != null) {
			Part filePart = request.getPart("book-cover");
			InputStream fileContent = filePart.getInputStream();

			byte[] imageBytes = new byte[fileContent.available()];
			fileContent.read(imageBytes, 0, imageBytes.length);
			fileContent.close();
			String imageStr = Base64.encodeBase64String(imageBytes);

			request.setAttribute("book-cover", imageStr);
		}

		String idString = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')-1, request.getRequestURI().lastIndexOf('/'));

		long id = Long.valueOf(idString);

        String button = request.getParameter("button");

        if (request.getParameter("ajouterPanier") != null) {
        	try {
				panier.add(bookManager.findOne(id));
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
		
		doGet(request, response);
	}


	private void redirection(HttpServletRequest request, HttpServletResponse response){

		String subUrl = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1);

		switch (subUrl) {
		case "createForm": 
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/book_create.jsp");
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
		case "see": this.findOne(request, response);
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
		HashMap<String, String> bookValues = new HashMap<String, String>();

		bookValues.put("book-title", request.getParameter("book-title"));
		bookValues.put("book-author", request.getParameter("book-author"));
		bookValues.put("book-synopsys", request.getParameter("book-synopsys"));
		bookValues.put("book-price", request.getParameter("book-price"));
		bookValues.put("book-rating", request.getParameter("book-rating"));
		bookValues.put("book-genre", request.getParameter("book-genre"));
		bookValues.put("book-cover", request.getParameter("book-cover"));
		bookValues.put("book-editor", request.getParameter("book-editor"));


		this.bookModel = new Book(bookValues);

		try {
			this.bookManager.create(this.bookModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			response.sendRedirect(request.getContextPath() + "/books/seeAll");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void findOne(HttpServletRequest request, HttpServletResponse response) {

		String idString = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')-1, request.getRequestURI().lastIndexOf('/'));

		long id = Long.valueOf(idString);

		try {
			bookModel = bookManager.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/book_see_one.jsp");
		request.setAttribute("book", bookModel);

		try {
			rd.include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		};

	}

	@Override
	public void findAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Book> booksList = new ArrayList<Book>();

		try {
			booksList = this.bookManager.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/book_see_all.jsp");
		request.setAttribute("booksList", booksList);

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
			bookModel = bookManager.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/book_edit.jsp");
		request.setAttribute("book", bookModel);

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

		bookValues.put("book-id", idString);
		bookValues.put("book-title", request.getParameter("book-title"));
		bookValues.put("book-author", request.getParameter("book-author"));
		bookValues.put("book-synopsys", request.getParameter("book-synopsys"));
		bookValues.put("book-price", request.getParameter("book-price"));
		bookValues.put("book-rating", request.getParameter("book-rating"));
		bookValues.put("book-genre", request.getParameter("book-genre"));
		bookValues.put("book-cover", request.getParameter("book-cover"));
		bookValues.put("book-editor", request.getParameter("book-editor"));

		this.bookModel = new Book(bookValues);

		try {
			this.bookManager.update(this.bookModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			response.sendRedirect(request.getContextPath() + "/books/" + this.bookModel.getId() + "/see");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		
		String idString = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')-1, request.getRequestURI().lastIndexOf('/'));

		long id = Long.valueOf(idString);
		
		try {
			this.bookManager.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			response.sendRedirect(request.getContextPath() + "/books/seeAll");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
