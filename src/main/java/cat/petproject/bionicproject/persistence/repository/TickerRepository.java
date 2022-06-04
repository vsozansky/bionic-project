package cat.petproject.bionicproject.persistence.repository;

import cat.petproject.bionicproject.persistence.model.TickerEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TickerRepository extends PagingAndSortingRepository<TickerEntity, Integer>{

}
