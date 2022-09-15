import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class AuthorizationChecker {
    public static void authorization(String login, String password, String confirmPassword) {

        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Login должен быть равен или меньше 20 символов");
        } catch (WrongPasswordException e) {
            System.out.println("Пароли не совпадают");
        }
    }

    private static void checkLogin(String login) throws WrongLoginException {
        int loginMaxLength = 20;
        if (isStringsContentValid(login)) {
            if (!(login.length() <= loginMaxLength)) {
                throw new WrongLoginException();
            }
        } else {
            System.out.println("Логин должен содержать только латинские буквы, цифры и знак подчеркивания");
        }
    }

    private static void checkPassword(String password, String confirm) throws WrongPasswordException {
        int passwordMaxLength = 20;
        if (isStringsContentValid(password)) {
            if (password.length() < passwordMaxLength && confirm.length() < passwordMaxLength) {
                if (!(password.equals(confirm))) {
                    throw new WrongPasswordException();
                }
            } else {
                System.out.println("Длина пароля должна быть меньше 20 символов");
            }
        } else {
            System.out.println("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания");
        }
    }

    private static boolean isStringsContentValid(String content) {
        boolean result = false;
        try {
            if (content != null) {
                final String PATTERN = "^*[A-Za-z0-9+_]+$";
                result = content.matches(PATTERN);
            }
        } catch (Exception e) {
            System.out.println("Поймали Exc в isStringsContentValid");
            result = false;
        }
        return result;
    }
}

