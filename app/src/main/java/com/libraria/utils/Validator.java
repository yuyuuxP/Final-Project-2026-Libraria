package com.libraria.utils;

public class Validator {
    public boolean isFieldNotEmpty(String text) {
        if (text.isEmpty()) {
            return false;
        }else {
            return true;
        }
    }

    public boolean isPasswordMatch(String newPassword, String confirmPassword) {
        if (newPassword.equals(confirmPassword)) {
            return true;
        }else {
            return false;
        }
    }

    public boolean isPasswordValid(String password) {
        if (password.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }
}