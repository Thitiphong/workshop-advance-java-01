package badcode;

import java.util.Arrays;
import java.util.List;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId;
        String[] domains = {"gmail.com", "live.com"};

        if (isNotEmpty(speaker.getFirstName())) {
            if (isNotEmpty(speaker.getLastName())) {
                if (isNotEmpty(speaker.getEmail())) {
                    String emailDomain = getEmailDomain(speaker.getEmail()); // ArrayIndexOutOfBound
                    if (Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() == 1) {
                        int exp = speaker.getExp();
                        speaker.setRegistrationFee(getRegistrationFee(exp));
                        try {
                            speakerId = repository.saveSpeaker(speaker);
                        } catch (Exception exception) {
                            throw new SaveSpeakerException("Can't save a speaker.");
                        }
                    } else {
                        throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
                    }
                } else {
                    throw new ArgumentNullException("Email is required.");
                }
            } else {
                throw new ArgumentNullException("Last name is required.");
            }
        } else {
            throw new ArgumentNullException("First name is required.");
        }

        return speakerId;
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
