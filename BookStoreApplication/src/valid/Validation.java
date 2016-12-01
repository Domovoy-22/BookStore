/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Validation {

    public String isLetter(String s) {
        String message;
        Pattern pattern = Pattern.compile("^[А-Яа-яЁё\\s]+$");
        Matcher m = pattern.matcher(s);
        if (m.matches() == false) {
            message = "*Неверный ввод. Введите буквы";
        } else {
            message = "";
        }

        return message;
    }

    public String isLetterNospace(String s) {
        String message;
        Pattern pattern = Pattern.compile("^[А-Яа-яЁё]+$");
        Matcher m = pattern.matcher(s);
        if (m.matches() == false) {
            message = "*Неверный ввод. Введите буквы";
        } else {
            message = "";
        }

        return message;
    }

    public String isNumber(String s) {
        String message;
        Pattern pattern = Pattern.compile("^\\d+(?:\\.\\d+)?$");
        Matcher m = pattern.matcher(s);
        if (m.matches() == false) {
            message = "*Неверный ввод. Введите цифры";
        } else {
            message = "";
        }

        return message;
    }

    public String isInteger(String s) {
        String message;
        Pattern pattern = Pattern.compile("^\\d+?$");
        Matcher m = pattern.matcher(s);
        if (m.matches() == false) {
            message = "*Неверный ввод. Введите цифры";
        } else {
            message = "";
        }

        return message;
    }

    public String isEmail(String s) {
        String message;

        Pattern pattern = Pattern.compile("^[a-z0-9_]+\\@[a-z]+\\.[a-z]+$");
        Matcher m = pattern.matcher(s);
        if (m.matches() == false) {
            message = "*Адрес электронной почты был введен неправильно";
        } else {
            message = "";
        }

        return message;
    }


}
