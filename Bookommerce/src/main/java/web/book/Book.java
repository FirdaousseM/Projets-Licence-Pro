package web.book;

import java.util.HashMap;

import web.Model;


public class Book extends Model{

	private String title; // varchar : 64
	private String author; // varchar : 64 
	private String synopsys; // text : 1000
	private double price; // Decimal : 4
	private int rating; // int : 1
	private String genre; // varchar : 64
	private String cover; // varchar : 500
	private String editor; // varchar : 64
	
	public Book() {
		super();
	}
	
	public Book(HashMap<String, String> values) {
		super(values.get("book-id"));
		
		this.title = values.get("book-title");	
		this.author = values.get("book-author");	
		this.synopsys = values.get("book-synopsys");	
		this.price = Double.valueOf(values.get("book-price"));	
		this.rating = Integer.valueOf(values.get("book-rating"));	
		this.genre = values.get("book-genre");	
		this.cover = values.get("book-cover");	
		this.editor = values.get("book-editor");	
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSynopsys() {
		return synopsys;
	}

	public void setSynopsys(String synopsys) {
		this.synopsys = synopsys;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}
	
	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}
	
}
