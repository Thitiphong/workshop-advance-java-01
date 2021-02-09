package badcode;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterBusinessTest {

    //=============== Failure cases
    @Test
    public void register_with_empty_firstname_should_throw_ArgumentNullException() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("");

        // Act
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            registerBusiness.register(null, newSpeaker);
        });

        // Assert
        assertEquals("First name is required.", exception.getMessage());
    }

    @Test
    public void register_with_empty_lastname_should_throw_ArgumentNullException() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("");

        // Act
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            registerBusiness.register(null, newSpeaker);
        });

        // Assert
        assertEquals("Last name is required.", exception.getMessage());
    }

    @Test
    public void register_with_empty_email_should_throw_ArgumentNullException() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("");

        // Act
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            registerBusiness.register(null, newSpeaker);
        });

        // Assert
        assertEquals("Email is required.", exception.getMessage());
    }

    @Test
    @Disabled
    public void register_with_no_domain_email_should_throw_ArgumentNullException() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo");

        // Act & Assert
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            registerBusiness.register(null, newSpeaker);
        });

        // Assert
//        assertEquals("Email is required.", exception.getMessage());
    }

    @Test
    public void register_with_invalid_domain_of_email_should_throw_SpeakerDoesntMeetRequirementsException() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@invalid.com");

        // Act
        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
            registerBusiness.register(null, newSpeaker);
        });

        // Assert
        assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
    }

    @Test
    public void can_not_save_speaker_throw_SaveSpeakerException() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");

        // Act
        Exception exception = assertThrows(SaveSpeakerException.class, () -> {
            registerBusiness.register(null, newSpeaker);
        });

        // Assert
        assertEquals("Can't save a speaker.", exception.getMessage());
    }

    //=============== Success cases

    @Test
    public void register_success() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");

        // Stub dependency
        SpeakerRepository stub = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return new Integer(100);
            }
        };

        // Act
        Integer speakerId = registerBusiness.register(stub, newSpeaker);

        // Assert
        assertNotNull(speakerId);
        assertEquals(100, speakerId);
    }


    @Test
    public void register_exp_0_registration_fee_500() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(0);

        // Stub dependency
        SpeakerRepository stub = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return new Integer(100);
            }
        };

        // Act
        Integer speakerId = registerBusiness.register(stub, newSpeaker);

        // Assert
        assertNotNull(speakerId);
        assertEquals(100, speakerId);
        assertEquals(500, newSpeaker.getRegistrationFee());
    }

    @Test
    public void register_exp_1_registration_fee_500() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(1);

        // Stub dependency
        SpeakerRepository stub = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return new Integer(100);
            }
        };

        // Act
        Integer speakerId = registerBusiness.register(stub, newSpeaker);

        // Assert
        assertNotNull(speakerId);
        assertEquals(100, speakerId);
        assertEquals(500, newSpeaker.getRegistrationFee());
    }

    @Test
    public void register_exp_2_registration_fee_250() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(2);

        // Stub dependency
        SpeakerRepository stub = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return new Integer(100);
            }
        };

        // Act
        Integer speakerId = registerBusiness.register(stub, newSpeaker);

        // Assert
        assertNotNull(speakerId);
        assertEquals(100, speakerId);
        assertEquals(250, newSpeaker.getRegistrationFee());
    }

    @Test
    public void register_exp_3_registration_fee_250() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(3);

        // Stub dependency
        SpeakerRepository stub = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return new Integer(100);
            }
        };

        // Act
        Integer speakerId = registerBusiness.register(stub, newSpeaker);

        // Assert
        assertNotNull(speakerId);
        assertEquals(100, speakerId);
        assertEquals(250, newSpeaker.getRegistrationFee());
    }

    @Test
    public void register_exp_4_registration_fee_100() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(4);

        // Stub dependency
        SpeakerRepository stub = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return new Integer(100);
            }
        };

        // Act
        Integer speakerId = registerBusiness.register(stub, newSpeaker);

        // Assert
        assertNotNull(speakerId);
        assertEquals(100, speakerId);
        assertEquals(100, newSpeaker.getRegistrationFee());
    }

    @Test
    public void register_exp_5_registration_fee_100() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(5);

        // Stub dependency
        SpeakerRepository stub = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return new Integer(100);
            }
        };

        // Act
        Integer speakerId = registerBusiness.register(stub, newSpeaker);

        // Assert
        assertNotNull(speakerId);
        assertEquals(100, speakerId);
        assertEquals(100, newSpeaker.getRegistrationFee());
    }

    @Test
    public void register_exp_6_registration_fee_50() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(6);

        // Stub dependency
        SpeakerRepository stub = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return new Integer(100);
            }
        };

        // Act
        Integer speakerId = registerBusiness.register(stub, newSpeaker);

        // Assert
        assertNotNull(speakerId);
        assertEquals(100, speakerId);
        assertEquals(50, newSpeaker.getRegistrationFee());
    }

    @Test
    public void register_exp_7_registration_fee_50() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(7);

        // Stub dependency
        SpeakerRepository stub = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return new Integer(100);
            }
        };

        // Act
        Integer speakerId = registerBusiness.register(stub, newSpeaker);

        // Assert
        assertNotNull(speakerId);
        assertEquals(100, speakerId);
        assertEquals(50, newSpeaker.getRegistrationFee());
    }

    @Test
    public void register_exp_8_registration_fee_50() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(8);

        // Stub dependency
        SpeakerRepository stub = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return new Integer(100);
            }
        };

        // Act
        Integer speakerId = registerBusiness.register(stub, newSpeaker);

        // Assert
        assertNotNull(speakerId);
        assertEquals(100, speakerId);
        assertEquals(50, newSpeaker.getRegistrationFee());
    }

    @Test
    public void register_exp_9_registration_fee_50() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(9);

        // Stub dependency
        SpeakerRepository stub = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return new Integer(100);
            }
        };

        // Act
        Integer speakerId = registerBusiness.register(stub, newSpeaker);

        // Assert
        assertNotNull(speakerId);
        assertEquals(100, speakerId);
        assertEquals(50, newSpeaker.getRegistrationFee());
    }

    @Test
    public void register_exp_10_registration_fee_50() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(10);

        // Stub dependency
        SpeakerRepository stub = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return new Integer(100);
            }
        };

        // Act
        Integer speakerId = registerBusiness.register(stub, newSpeaker);

        // Assert
        assertNotNull(speakerId);
        assertEquals(100, speakerId);
        assertEquals(0, newSpeaker.getRegistrationFee());
    }

}