package ua.step.BookShop.BookShop.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/")
	public String Start(Model model, Pageable pageable) {
		model.addAttribute("books", bookRepository.findAll(pageable));
		model.addAttribute("books_p", bookRepository.findAll(pageable));	
		return "redirect:home?page=0&size=6";
	}
	
	@GetMapping("/home")
	public String ShowAllBook(Model model, Pageable pageable) {
		model.addAttribute("books", bookRepository.findAll(pageable));
		model.addAttribute("books_p", bookRepository.findAll(pageable));

				
		return "home";
	}

	@GetMapping("/home/oneBook/{id}")
	public String editBook(@PathVariable(value="id") Long id,Model model) {
		Optional<Book> book=bookRepository.findById(id);
		ArrayList<Book> arr=new ArrayList<>();
		book.ifPresent(arr::add);
		Iterable<Author> authors=authorRepository.findAll();
		Iterable<Publisher> publishers=publisherRepository.findAll();
		model.addAttribute("authors", authors);
		model.addAttribute("publishers", publishers);
		model.addAttribute("books",arr);
		return "oneBook";
	}
	
	@GetMapping("/home/search")
	public String Search(Model model, Pageable pageable, @RequestParam String search) {	
		Iterable<Book> books=bookRepository.findAll();
		ArrayList<Book> S_books=new ArrayList<>();
		for (Book book : books) {
			if(book.getName().contains(search)) {
				S_books.add(book);
			}
		}
		
		model.addAttribute("books", S_books);
		model.addAttribute("books_p", bookRepository.findAll(pageable));

		return "home";
	}

}