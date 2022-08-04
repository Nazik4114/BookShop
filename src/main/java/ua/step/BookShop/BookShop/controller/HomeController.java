package ua.step.BookShop.BookShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.step.BookShop.BookShop.models.Author;
import ua.step.BookShop.BookShop.models.Book;
import ua.step.BookShop.BookShop.models.Publisher;
import ua.step.BookShop.BookShop.repository.AuthorRepository;
import ua.step.BookShop.BookShop.repository.BookRepository;
import ua.step.BookShop.BookShop.repository.PublisherRepository;

@Controller
public class HomeController {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	@GetMapping("/home")
	public String ShowAllBook(Model model) {
		Iterable<Author> authors=authorRepository.findAll();
		Iterable<Book> books=bookRepository.findAll();
		Iterable<Publisher> publisher=publisherRepository.findAll();
		model.addAttribute("authors", authors);
		model.addAttribute("books", books);
		model.addAttribute("publisher", publisher);
				
		return "home";
	}

}