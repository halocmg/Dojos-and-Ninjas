package carter.g.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import carter.g.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{

}
