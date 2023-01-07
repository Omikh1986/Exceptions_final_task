import custom_exception.WrongLoginException;
import custom_exception.WrongPasswordException;

import java.util.*;

//        1.Создать статический метод который принимает на вход три параметра: login, password и
//        confirmPassword.
//        2. Login должен содержать только латинские буквы, цифры и знак подчеркивания.
//        3. Длина login должна быть меньше 20 символов. Если login не соответствует этим требованиям,
//        необходимо выбросить WrongLoginException.
//        4. Password должен содержать только латинские буквы, цифры и знак подчеркивания.
//        Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны.
//        5. Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
//        6. WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя
//        конструкторами – один по умолчанию, второй принимает сообщение исключения и передает его
//        в конструктор класса Exception.
//        7. Обработка исключений проводится внутри метода.
//        8. Метод возвращает true, если значения верны или false в другом случае.

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        finalCheck();
    }

    private static boolean checkingLogin() throws WrongLoginException {
        System.out.print("Введите логин\n" +
                "(Логин может содержать только латинские буквы, цифры и знак подчеркивания, максимальная длина 19 символов)\n" +
                "ЛОГИН: ");
        String login = scanner.nextLine();
        System.out.println();
        if (login.matches("[A-Za-z0-9_]{1,19}")) {
            return true;
        } else {
            throw new WrongLoginException("Введен некорректный логин.\n" +
                    "Логин может содержать только латинские буквы, цифры и знак подчеркивания, максимальная длина 19 символов.");
        }
    }

    private static boolean checkingPassword() throws WrongPasswordException {
        System.out.print("Введите пароль\n" +
                "Пароль может содержать только латинские буквы, цифры и знак подчеркивания, максимальная длина 19 символов)\n" +
                "ПАРОЛЬ: ");
        String password = scanner.nextLine();
        System.out.println();
        if (password.matches("[A-Za-z0-9_]{1,19}")) {
            System.out.print("Подтвердите пароль, введя его повторно: ");
            String confirmPassword = scanner.nextLine();
            System.out.println();
            if (password.equals(confirmPassword)) {
                return true;
            } else {
                throw new WrongPasswordException("Введенный повторно пароль не совпадает с первоначальным.");
            }
        } else {
            throw new WrongPasswordException("Введен некорректный пароль.\n" +
                    "Пароль может содержать только латинские буквы, цифры и знак подчеркивания, максимальная длина 19 символов.");
        }
    }

    private static void finalCheck() {
        try {
            if (checkingLogin() == true && checkingPassword() == true) {
                System.out.println("true");
            }
        } catch (WrongLoginException | WrongPasswordException exception) {
            System.out.println(exception);
            System.out.println();
            System.out.println("false");
            System.out.println("\nПопробуйте ввести логин и пароль еще раз:\n");
            finalCheck();
        }
    }
}
