package badcode;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegistrationFeeTest {

    @Test
    public void test_fee( ) {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        assertEquals(500, registerBusiness.getRegistrationFee(1));
        assertEquals(250, registerBusiness.getRegistrationFee(3));
        assertEquals(100, registerBusiness.getRegistrationFee(5));
        assertEquals(50, registerBusiness.getRegistrationFee(9));
        assertEquals(0, registerBusiness.getRegistrationFee(20));
    }


}