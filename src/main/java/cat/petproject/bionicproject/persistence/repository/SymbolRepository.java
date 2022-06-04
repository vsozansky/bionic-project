package cat.petproject.bionicproject.persistence.repository;

import cat.petproject.bionicproject.persistence.model.SymbolEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymbolRepository extends PagingAndSortingRepository<SymbolEntity, Integer>{

}
