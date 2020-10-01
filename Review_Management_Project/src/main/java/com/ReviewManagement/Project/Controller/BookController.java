package com.ReviewManagement.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ReviewManagement.Project.DAO.BookRepo;
import com.ReviewManagement.Project.DAO.ReviewRepo;
import com.ReviewManagement.Project.DAO.UserRepo;
import com.ReviewManagement.Project.Entitites.BookEntity;
import com.ReviewManagement.Project.Entitites.ReviewEntity;
import com.ReviewManagement.Project.Entitites.UserEntity;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired 
	BookRepo bookRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	ReviewRepo reviewRepo;
	
	@GetMapping("/addbook")
	public String addBook(Model model) {
		BookEntity bookEntity = new BookEntity();
		model.addAttribute("bookDetails", bookEntity);
		List<UserEntity> userList = userRepo.findAll();
		model.addAttribute("userObj", userList);
		return "AddBook";
	}
	@PostMapping("/save")
	public String saveBook(BookEntity bookEntity) {
		bookRepo.save(bookEntity);
		return "redirect:/ ";
	}
	@GetMapping("/bookReview")
	public String addBookReview(Model model) {
		ReviewEntity reviewEntity = new ReviewEntity();
		model.addAttribute("reviewObj" , reviewEntity);
		List<UserEntity> userList = userRepo.findAll();
		model.addAttribute("userList" , userList);
		List<BookEntity> bookList = bookRepo.findAll();
		model.addAttribute("bookList", bookList);
		return "AddBookReview";
	}
	@PostMapping("/bookreviewsave")
	public String bookReviewSave(ReviewEntity reviewEntity) {
		reviewRepo.save(reviewEntity);
		return "redirect:/ ";
	}
	@GetMapping("/viewbooks")
	public String viewBooks(Model model) {
		List<BookEntity> bookList =  bookRepo.findAll();
		model.addAttribute("bookObj",bookList);
		return "ViewBooks";
	}

}
