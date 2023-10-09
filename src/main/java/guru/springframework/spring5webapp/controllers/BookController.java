package guru.springframework.spring5webapp.controllers;
import org.springframework.security.access.prepost.PreAuthorize;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 12/24/19.
 */
@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/books")
    public String getBooks(Model model){
    	try {
    		model.addAttribute("books", bookRepository.findAll());
    		return "books/list";
    	} catch (Exception e){
    		model.addAttribute("error","ha ocurrido un error al crear el autor");
    		return "error";
    	}               
    }
}
