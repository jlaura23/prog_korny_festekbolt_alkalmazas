package festekbolt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FestekServiceTest {

    @Mock
    private FestekRepository festekRepository;

    @InjectMocks
    private FestekService festekService;

    private FestekEntity festek;

    @BeforeEach
    public void setUp() {
        festek = new FestekEntity();
        festek.setId(1L);
        festek.setNev("Test Festek");
        // Set other properties if needed
    }

    @Test
    public void testGetAllFestek() {
        List<FestekEntity> festekList = new ArrayList<>();
        festekList.add(festek);

        when(festekRepository.findAll()).thenReturn(festekList);

        List<FestekEntity> result = festekService.getAllFestek();

        assertEquals(1, result.size());
        assertEquals("Test Festek", result.get(0).getNev());
        // Assert other properties if needed

        verify(festekRepository, times(1)).findAll();
    }

    @Test
    public void testGetFestekById() {
        when(festekRepository.findById(1L)).thenReturn(Optional.of(festek));

        FestekEntity result = (FestekEntity) festekService.getFestekById(1L);

        assertEquals("Test Festek", result.getNev());
        // Assert other properties if needed

        verify(festekRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreateOrUpdateFestek() {
        when(festekRepository.save(festek)).thenReturn(festek);

        FestekEntity result = festekService.createOrUpdateFestek(festek);

        assertEquals("Test Festek", result.getNev());
        // Assert other properties if needed

        verify(festekRepository, times(1)).save(festek);
    }

    @Test
    public void testDeleteFestek() {
        festekService.deleteFestek(1L);

        verify(festekRepository, times(1)).deleteById(1L);
    }
}
