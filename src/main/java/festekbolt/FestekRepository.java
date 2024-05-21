package festekbolt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FestekRepository extends JpaRepository<FestekEntity, Long> {
}
