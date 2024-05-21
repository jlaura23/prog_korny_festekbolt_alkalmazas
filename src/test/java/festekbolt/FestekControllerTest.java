package festekbolt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FestekControllerTest {

    @Mock
    private FestekService festekService;

    @InjectMocks
    private FestekController festekController;

    @Autowired
    private MockMvc mockMvc;

    private FestekEntity festek;

    @BeforeEach
    public void setUp() {
        festek = new FestekEntity();
        festek.setId(1L);
        festek.setNev("Test Festek");
        festek.setSzin("Red");
    }

    @Test
    public void testGetAllFestek() throws Exception {
        List<FestekEntity> festekList = new ArrayList<>();
        festekList.add(festek);

        when(festekService.getAllFestek()).thenReturn(festekList);

        mockMvc.perform(MockMvcRequestBuilders.get("/festek/"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(festekService, times(1)).getAllFestek();
    }

    @Test
    public void testGetFestekById() throws Exception {
        when(festekService.getFestekById(1L)).thenReturn(festek);

        mockMvc.perform(MockMvcRequestBuilders.get("/festek/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(festekService, times(1)).getFestekById(1L);
    }

    @Test
    public void testCreateFestek() throws Exception {
        when(festekService.createOrUpdateFestek(any(FestekEntity.class))).thenReturn(festek);

        mockMvc.perform(MockMvcRequestBuilders.post("/festek/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(festekService, times(1)).createOrUpdateFestek(any(FestekEntity.class));
    }

    @Test
    public void testUpdateFestek() throws Exception {
        when(festekService.createOrUpdateFestek(any(FestekEntity.class))).thenReturn(festek);

        mockMvc.perform(MockMvcRequestBuilders.put("/festek/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(festekService, times(1)).createOrUpdateFestek(any(FestekEntity.class));
    }

    @Test
    public void testDeleteFestek() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/festek/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(festekService, times(1)).deleteFestek(1L);
    }
}
