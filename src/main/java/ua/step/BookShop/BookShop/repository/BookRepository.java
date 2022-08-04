package ua.step.BookShop.BookShop.repository;

import org.springframework.data.repository.CrudRepository;

import ua.step.BookShop.BookShop.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
