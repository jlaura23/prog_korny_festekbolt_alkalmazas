package festekbolt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FestekEntityTest {

    @Test
    public void testNoArgsConstructor() {
        FestekEntity festek = new FestekEntity();
        assertNull(festek.getId());
        assertNull(festek.getNev());
        assertNull(festek.getSzin());
    }

    @Test
    public void testAllArgsConstructor() {
        FestekEntity festek = new FestekEntity(1L, "Paint Name", "Red");
        assertEquals(1L, festek.getId());
        assertEquals("Paint Name", festek.getNev());
        assertEquals("Red", festek.getSzin());
    }

    @Test
    public void testSettersAndGetters() {
        FestekEntity festek = new FestekEntity();
        festek.setId(2L);
        festek.setNev("Another Paint");
        festek.setSzin("Blue");

        assertEquals(2L, festek.getId());
        assertEquals("Another Paint", festek.getNev());
        assertEquals("Blue", festek.getSzin());
    }
}
