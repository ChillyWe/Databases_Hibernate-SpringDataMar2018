package softuni.user_system.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PasswordValidator implements ConstraintValidator<Password, String> {

    private boolean containsDigit;
    private boolean containsUppercase;
    private boolean containsLowercase;
    private boolean containsSpecialSymbols;
    private int minLength;
    private int maxLength;

    @Override
    public void initialize(Password password) {
        this.containsDigit = password.containsDigit();
        this.containsLowercase = password.containsLowercase();
        this.containsUppercase = password.containsUppercase();
        this.containsSpecialSymbols = password.containsSpecialSymbols();
        this.minLength = password.minLength();
        this.maxLength = password.maxLength();

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (password.length() < this.minLength || password.length() > this.maxLength) {
            return false;
        }
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher regex = pattern.matcher(password);
        if (this.containsLowercase && !regex.find()) {
            return false;
        }
        pattern = Pattern.compile("[A-Z]");
        regex = pattern.matcher(password);
        if (this.containsUppercase && !regex.find()) {
            return false;
        }

        pattern = Pattern.compile("[0-9]");
        regex = pattern.matcher(password);
        if (this.containsDigit && !regex.find()) {
            return false;
        }

        pattern = Pattern.compile("[!@#$%^&*()_+<>?]");
        regex = pattern.matcher(password);
        if (this.containsSpecialSymbols && !regex.find()) {
            return false;
        }

        return true;
    }
}
