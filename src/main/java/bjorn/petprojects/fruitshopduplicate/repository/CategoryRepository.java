package bjorn.petprojects.fruitshopduplicate.repository;

import bjorn.petprojects.fruitshopduplicate.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
