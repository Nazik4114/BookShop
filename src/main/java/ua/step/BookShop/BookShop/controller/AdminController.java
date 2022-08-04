package ua.step.BookShop.BookShop.controller;


import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.step.firstWeb.model.Role;
import com.step.firstWeb.model.User;

import ua.step.BookShop.BookShop.models.Author;
import ua.step.BookShop.BookShop.models.Book;
import ua.step.BookShop.BookShop.models.Publisher;
import ua.step.BookShop.BookShop.repository.AuthorRepository;
import ua.step.BookShop.BookShop.repository.BookRepository;
import ua.step.BookShop.BookShop.repository.PublisherRepository;

@Controller
public class AdminController {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	@GetMapping("/admin")
	public String ShowAllBook(Model model) {
		Iterable<Author> authors=authorRepository.findAll();
		Iterable<Book> books=bookRepository.findAll();
		Iterable<Publisher> publisher=publisherRepository.findAll();
		model.addAttribute("authors", authors);
		model.addAttribute("books", books);
		model.addAttribute("publisher", publisher);
				
		return "admin";
	}
	@GetMapping("/admin/addAuthor")
	public String AddAuthor(Model model) {
		return "addAuthor";
	}
	@PostMapping("/admin/addAuthor")
	public String AddAuthorPost(@RequestParam String fio, Model model) {
		Author author=new Author(fio);
		authorRepository.save(author);
		return "redirect:/admin";
	}
	@GetMapping("/admin/deleteAuthor/{id}")
	public String DelAuthor(@PathVariable(value="id") Long id, Model model) {
		Optional<Author> author=authorRepository.findById(id);
		authorRepository.delete(author.get());
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/addPublisher")
	public String AddPublisher(Model model) {
		return "addPublisher";
	}
	@PostMapping("/admin/addPublisher")
	public String AddPublisherPost(@RequestParam String name,@RequestParam String country, Model model) {
		Publisher publisher=new Publisher(name,country);
		publisherRepository.save(publisher);
		return "redirect:/admin";
	}
	
	@PostMapping("/admin/deletePublisher/{id}")
	public String DelPublisher(@PathVariable(value="id") Long id, Model model) {
		Optional<Publisher> publisher=publisherRepository.findById(id);
		publisherRepository.delete(publisher.get());
		return "redirect:/admin";
	}	
	
	@GetMapping("/admin/editPublisher/{id}")
	public String editPublisher(@PathVariable(value="id") Long id,Model model) {
		Optional<Publisher> publisher=publisherRepository.findById(id);
		ArrayList<Publisher> arr=new ArrayList<>();
		publisher.ifPresent(arr::add);
		model.addAttribute("publisher",arr);
		return "editPublisher";
	}
	@PostMapping("/admin/editPublisher/{id}")
	public String editPublisherPost(@PathVariable(value="id") Long id,@RequestParam String name,@RequestParam String country, Model model) {
		Publisher publisher=publisherRepository.findById(id).orElseThrow();
		publisher.setName(name);
		publisher.setCountry(country);
		publisherRepository.save(publisher);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/editAuthor/{id}")
	public String editAuthor(@PathVariable(value="id") Long id,Model model) {
		Optional<Author> publisher=authorRepository.findById(id);
		ArrayList<Author> arr=new ArrayList<>();
		publisher.ifPresent(arr::add);
		model.addAttribute("publisher",arr);
		return "editAuthor";
	}
	@PostMapping("/admin/editAuthor/{id}")
	public String editAuthorPost(@PathVariable(value="id") Long id,@RequestParam String fio,Model model) {
		Author author=authorRepository.findById(id).orElseThrow();
		author.setFio(fio);
		authorRepository.save(author);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/addBook")
	public String addBook(Book book, Model model) {
		Iterable<Author> authors=authorRepository.findAll();
		Iterable<Publisher> publishers=publisherRepository.findAll();
		model.addAttribute("authors", authors);
		model.addAttribute("publishers", publishers);
				
		return "addBook";
	}
	@PostMapping("/admin/addBook")
	public String saveUser(Book book, String[] authorId, String[] publisherId) {
		List<Author> bookAuthors=new ArrayList<>(authorId.length);
		for (String id : authorId) {
			Optional<Author> authors=authorRepository.findById(Long.valueOf(id));
			bookAuthors.add(authors.get()); 
		}
		List<Publisher> publisherAuthors=new ArrayList<>(publisherId.length);
		for (String id : publisherId) {
			Optional<Publisher> publisher=publisherRepository.findById(Long.valueOf(id));
			publisherAuthors.add(publisher.get()); 
		}
		book.setAuthors(bookAuthors);
		book.setPublishers(publisherAuthors);
		bookRepository.save(book);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/editBook/{id}")
	public String editBook(@PathVariable(value="id") Long id,Model model) {
		Optional<Book> book=bookRepository.findById(id);
		ArrayList<Book> arr=new ArrayList<>();
		book.ifPresent(arr::add);
		Iterable<Author> authors=authorRepository.findAll();
		Iterable<Publisher> publishers=publisherRepository.findAll();
		model.addAttribute("authors", authors);
		model.addAttribute("publishers", publishers);
		model.addAttribute("book",arr);
		return "editBook";
	}
	@PostMapping("/admin/editBook/{id}")
	public String editBookPost(@PathVariable(value="id") Long id,Model model,String[] authorId, String[] publisherId,@RequestParam String name,@RequestParam String quantyti,@RequestParam String title,@RequestParam String url_image,@RequestParam String price) {
		List<Author> bookAuthors=new ArrayList<>(authorId.length);
		for (String id1 : authorId) {
			Optional<Author> authors=authorRepository.findById(Long.valueOf(id1));
			bookAuthors.add(authors.get()); 
		}
		List<Publisher> publisherAuthors=new ArrayList<>(publisherId.length);
		for (String id1 : publisherId) {
			Optional<Publisher> publisher=publisherRepository.findById(Long.valueOf(id1));
			publisherAuthors.add(publisher.get()); 
		}

		Book books=bookRepository.findById(id).orElseThrow();
		books.setName(name);
		books.setQuantyti(Integer.valueOf(quantyti));
		books.setTitle(title);
		books.setPrice(Long.valueOf(price));
		books.setUrl_image(url_image);
		books.setAuthors(bookAuthors);
		books.setPublishers(publisherAuthors);
		bookRepository.save(books);
		return "redirect:/admin";
	}
	@GetMapping("/admin/deleteBook/{id}")
	public String DelBook(@PathVariable(value="id") Long id, Model model) {
		Optional<Book> book=bookRepository.findById(id);
		bookRepository.delete(book.get());
		return "redirect:/admin";
	}
}