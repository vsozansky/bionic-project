package cat.petproject.bionicproject.persistence.services;

import cat.petproject.bionicproject.persistence.model.TickerEntity;
import cat.petproject.bionicproject.persistence.repository.TickerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TickerService {
    private final TickerRepository tickerRepository;

    @Autowired
    public TickerService(TickerRepository tickerRepository) {
        this.tickerRepository = tickerRepository;
    }

    public List<TickerEntity> findAll(){
        return (List<TickerEntity>) tickerRepository.findAll();
    }

    public TickerEntity findOne(Integer id){
        return tickerRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(TickerEntity tickerEntity){
        tickerRepository.save(tickerEntity);
    }

    @Transactional
    public void update(Integer id, TickerEntity tickerEntity){
        tickerEntity.setId(id);
        tickerRepository.save(tickerEntity);
    }

    @Transactional
    public void delete(Integer id){
        tickerRepository.deleteById(id);
    }
}
