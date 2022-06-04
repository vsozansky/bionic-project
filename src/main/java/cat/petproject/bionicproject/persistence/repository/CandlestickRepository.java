package cat.petproject.bionicproject.persistence.repository;

import cat.petproject.bionicproject.persistence.model.CandlestickEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandlestickRepository extends PagingAndSortingRepository<CandlestickEntity, Integer>{

}
