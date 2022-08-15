package ua.step.BookShop.BookShop.models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.step.firstWeb.model.Role;

@Entity 
public class Book {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  private String name;
  
@Column(nullable = false, name = "title", columnDefinition = "TEXT")
  private String title;
  
  private String url_image;
  
  private long price;

  
  @ManyToMany
	private List<Author> authors;
  
  @ManyToMany
	private List<Publisher> publishers;  
  
  private Integer quantyti;
  
  

public long getPrice() {
	return price;
}

public void setPrice(long price) {
	this.price = price;
}

public List<Author> getAuthors() {
	return authors;
}

public void setAuthors(List<Author> authors) {
	this.authors = authors;
}

public List<Publisher> getPublishers() {
	return publishers;
}

public void setPublishers(List<Publisher> publishers) {
	this.publishers = publishers;
}

public Integer getQuantyti() {
	return quantyti;
}

public void setQuantyti(Integer quantyti) {
	this.quantyti = quantyti;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getUrl_image() {
	return url_image;
}

public void setUrl_image(String url_image) {
	this.url_image = url_image;
}

public Book(Long id, String name, String title, String url_image,Integer quantyti, long price) {
	this.id = id;
	this.name = name;
	this.title = title;
	this.price=price;
	this.url_image = url_image;
	this.quantyti=quantyti;
}
public Book() {
}

}
