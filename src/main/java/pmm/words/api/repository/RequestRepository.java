package pmm.words.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pmm.words.api.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
