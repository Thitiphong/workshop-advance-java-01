package badcode;

import java.util.Arrays;
import java.util.List;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        validate(speaker);

        int exp = speaker.getExp();
        speaker.setRegistrationFee(getRegistrationFee(exp));

        return save(repository, speaker);
    }

    private Integer save(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId;
        try {
            speakerId = repository.saveSpeaker(speaker);
        } catch (Exception exception) {
            throw new SaveSpeakerException("Can't save a speaker.");
        }
        return speakerId;
    }

    private void validate(Speaker speaker) {
        String[] domains = {"gmail.com", "live.com"};

        if (!isNotEmpty(speaker.getFirstName())) {
            throw new ArgumentNullException("First name is required.");
        }
        if (!isNotEmpty(speaker.getLastName())) {
            throw new ArgumentNullException("Last name is required.");
        }
        if (!isNotEmpty(speaker.getEmail())) {
            throw new ArgumentNullException("Email is required.");
        }
        String emailDomain = getEmailDomain(speaker.getEmail()); // ArrayIndexOutOfBound
        if (Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() != 1) {
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
        }
    }

    private boolean isNotEmpty(String input) {
        return input != null && !input.trim().equals("");
    }

    int getRegistrationFee(int exp) {
        int fee = 0;
        if (exp <= 1) {
            fee = 500;
        } else if (exp <= 3) {
            fee = 250;
        } else if (exp <= 5) {
            fee = 100;
        } else if (exp <= 9) {
            fee = 50;
        }
        return fee;
    }

    String getEmailDomain(String email) {
        String[] splitedEmail = email.split("@");
        if (splitedEmail.length == 2) {
            return splitedEmail[1];
        }
        throw new DomainEmailInvalidException();
    }

}
