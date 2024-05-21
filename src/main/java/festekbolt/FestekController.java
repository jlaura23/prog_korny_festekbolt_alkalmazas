package festekbolt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/festek")
public class FestekController {

    @Autowired
    private FestekService festekService;

    @GetMapping("/")
    public List<FestekEntity> getAllFestek() {
        return festekService.getAllFestek();
    }

    @GetMapping("/{id}")
    public Object getFestekById(@PathVariable Long id) {
        return festekService.getFestekById(id);
    }

    @PostMapping("/")
    public FestekEntity createFestek(@RequestBody FestekEntity festek) {
        return festekService.createOrUpdateFestek(festek);
    }

    @PutMapping("/{id}")
    public FestekEntity updateFestek(@PathVariable Long id, @RequestBody FestekEntity festek) {
        festek.setId(id);
        return festekService.createOrUpdateFestek(festek);
    }

    @DeleteMapping("/{id}")
    public void deleteFestek(@PathVariable Long id) {
        festekService.deleteFestek(id);
    }
}
