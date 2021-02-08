import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularBufferTest {

    CircularBuffer circularBuffer = new CircularBuffer();

    @Test
    @DisplayName("หลังจากสร้าง buffer แล้ว buffer จะต้องว่างเสมอ")
    public void after_created_should_be_empty() {
        circularBuffer.create();
        boolean status = circularBuffer.isEmpty();
        assertEquals(true, status);
    }

    @Test
    @DisplayName("ขนาด defautl ของ CircularBuffer ต้องมีขนาดเท่ากับ 10")
    public void create_buffer_with_default_size() {
        circularBuffer.create();
        int size = circularBuffer.getSize();

        // Validate/Checking/Assert
        assertEquals(10, size);
    }

    @Test
    @DisplayName("ขนาด defautl ของ CircularBuffer ต้องมีขนาดเท่ากับ 5")
    public void create_buffer_with_specific_size_5() {
        circularBuffer.create(5);
        int size = circularBuffer.getSize();

        // Validate/Checking/Assert
        assertEquals(5, size);
    }

}