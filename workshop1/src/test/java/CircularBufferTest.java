import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularBufferTest {

    @Test
    @DisplayName("ขนาด defautl ของ CircularBuffer ต้องมีขนาดเท่ากับ 10")
    public void create_buffer_with_default_size(){
        CircularBuffer circularBuffer = new CircularBuffer();
        circularBuffer.create();
        int size = circularBuffer.getSize();

        // Validate/Checking/Assert
        assertEquals(10, size);
    }

    @Test
    @DisplayName("ขนาด defautl ของ CircularBuffer ต้องมีขนาดเท่ากับ 5")
    public void create_buffer_with_specific_size_5(){
        CircularBuffer circularBuffer = new CircularBuffer();
        circularBuffer.create(5);
        int size = circularBuffer.getSize();

        // Validate/Checking/Assert
        assertEquals(5, size);
    }

}