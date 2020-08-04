package am.abm.abm.repositories;

import am.abm.abm.enities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface BaseRepository<T extends Base> extends JpaRepository<T, Long> {
}
