package festekbolt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FestekService {

    private final FestekRepository festekRepository;

    @Autowired
    public FestekService(FestekRepository festekRepository) {
        this.festekRepository = festekRepository;
    }

    public List<FestekEntity> getAllFestek() {
        return festekRepository.findAll();
    }

    public Object getFestekById(Long id) {
        return festekRepository.findById(id).orElse(null);
    }

    public FestekEntity createOrUpdateFestek(FestekEntity festek) {
        return festekRepository.save(festek);
    }

    public void deleteFestek(Long id) {
        festekRepository.deleteById(id);
    }
}
