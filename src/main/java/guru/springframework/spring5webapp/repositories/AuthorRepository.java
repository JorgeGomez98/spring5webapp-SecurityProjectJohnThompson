package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by jt on 12/23/19.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	Page<Author> findAll(Pageable pageable);
}
