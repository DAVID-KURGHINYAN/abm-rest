package am.abm.abm.repositories;

import am.abm.abm.models.enities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends Base> extends JpaRepository<T, Long> {
}
