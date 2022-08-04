package ua.step.BookShop.BookShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ua.step.BookShop.BookShop.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
